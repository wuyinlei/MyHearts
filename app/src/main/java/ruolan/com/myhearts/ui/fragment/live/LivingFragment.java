package ruolan.com.myhearts.ui.fragment.live;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okrx.RxAdapter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.adapter.LivingAdapter;
import ruolan.com.myhearts.contant.Contants;
import ruolan.com.myhearts.contant.HttpUrlPaths;
import ruolan.com.myhearts.entity.LivingBannerBean;
import ruolan.com.myhearts.entity.LivingBean;
import ruolan.com.myhearts.ui.play.VideoViewActivity;
import ruolan.com.myhearts.ui.play.VideoViewLiveActivity;
import rx.android.schedulers.AndroidSchedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class LivingFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mRefreshLayout;
    private List<LivingBean.ResultsEntity> mResultsEntities = new ArrayList<>();
    private int page = 1;
    private LivingAdapter mLivingAdapter;
    private ImageView mHeaderBanner;
    private List<LivingBannerBean.ResultsEntity> beanResults;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        initView(view);

        initData();

        return view;
    }

    /**
     * 请求数据
     */
    private void initData() {
        new Handler().postDelayed(() -> {
            delayInitData();
            initBannerData();
        }, 500);
    }

    /**
     * 进入就刷新
     */
    private void delayInitData() {
        //mRefreshLayout.setRefreshing(true);  //自动刷新

        OkGo.get(HttpUrlPaths.LIVING_STREAMING_URL)
                .params("userid", "54442")
                .params("page", page)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(() -> {
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Type type = new TypeToken<LivingBean>() {
                    }.getType();
                    LivingBean bean = new Gson().fromJson(s, type);
                    if (bean.getErrorCode() == 0
                            && bean.getResultCount() > 0
                            && bean.getErrorStr().equals("success")) {
                        List<LivingBean.ResultsEntity> results = bean.getResults();
                        mRecyclerView.setVisibility(View.VISIBLE);
                        mResultsEntities = results;
                        mLivingAdapter.setEntities(mResultsEntities);
                        mRefreshLayout.setRefreshing(false);
                    }
                }, throwable -> {
                });
    }

    private void initView(View view) {
        this.mRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefresh);
        mRefreshLayout.setColorSchemeColors(Color.YELLOW, Color.RED, Color.BLUE, Color.GREEN);
        //能够模拟进入就刷新
        mRefreshLayout.post(() -> mRefreshLayout.setRefreshing(true));
        mRefreshLayout.setOnRefreshListener(this);

        this.mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);

        //第一列单独占一行
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {

                return (position == 0
                        || position == mResultsEntities.size() + 1)
                        ? gridLayoutManager.getSpanCount() : 1;

            }
        });

        mRecyclerView.setLayoutManager(gridLayoutManager);
        mLivingAdapter = new LivingAdapter(getContext());
        mLivingAdapter.setOnItemClickListener((view1, position, categoryBean) -> {
            Intent intent = new Intent(getActivity(), VideoViewActivity.class);
            intent.putExtra(Contants.VIDEO_PATH, categoryBean.getFiles());
            intent.putExtra(Contants.VIDEO_TITLE, categoryBean.getTitle());
            getActivity().startActivity(intent);
        });

        mRecyclerView.setVisibility(View.INVISIBLE);
        mRecyclerView.setAdapter(mLivingAdapter);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                int lastVisiableItemPosition = gridLayoutManager.findLastVisibleItemPosition();
                if (lastVisiableItemPosition + 1 == mLivingAdapter.getItemCount()) {
                    if (!isLoading) {
                        isLoading = true;
                        new Handler().postDelayed(() -> {
                            getMoreData();
                            isLoading = false;
                            mLivingAdapter.notifyItemRemoved(mLivingAdapter.getItemCount());
                        }, 3000);
                    }
                }
            }
        });

        setHeader(mRecyclerView);
        //mLivingAdapter.setHeaderView();
    }

    boolean isHasMore = false;

    private void getMoreData() {
        if (isHasMore) {
            mLivingAdapter.notifyItemRemoved(mLivingAdapter.getItemCount());
            Toast.makeText(getActivity(), getActivity().getResources()
                    .getString(R.string.loading_finish), Toast.LENGTH_SHORT).show();
            return;
        }
        page++;
        OkGo.get(HttpUrlPaths.LIVING_STREAMING_URL)
                .params("userid", "54442")
                .params("page", page)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(() -> {
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Type type = new TypeToken<LivingBean>() {
                    }.getType();
                    LivingBean bean = new Gson().fromJson(s, type);
                    if (bean.getErrorCode() == 0
                            && bean.getErrorStr().equals("success")) {
                        if (bean.getResultCount() < 30) {  //没有下一页数据了
                            isHasMore = true;
                        }
                        List<LivingBean.ResultsEntity> results = bean.getResults();
                        mRecyclerView.setVisibility(View.VISIBLE);
                        mResultsEntities.addAll(results);
                        mLivingAdapter.setEntities(mResultsEntities);
                        //mRefreshLayout.setRefreshing(false);
                    }
                }, throwable -> {
                });
    }


    private boolean isLoading;


    /**
     * 设置头布局
     *
     * @param recyclerView
     */
    private void setHeader(RecyclerView recyclerView) {
        View view = LayoutInflater.from(getContext())
                .inflate(R.layout.living_header_banner_layout, recyclerView, false);
        mHeaderBanner = (ImageView) view.findViewById(R.id.img_banner);
        mHeaderBanner.setOnClickListener(v -> {
            if (beanResults != null) {
                Intent intent = new Intent(getActivity(), LivingBannerActivity.class);
                intent.putExtra("title", beanResults.get(0).getTitle());
                intent.putExtra("webview", beanResults.get(0).getUrl());
                startActivity(intent);
            }
        });
        mLivingAdapter.setHeaderView(view);
        // initBannerData();

    }

    /**
     * 请求banner图片
     */
    private void initBannerData() {
        OkGo.get(HttpUrlPaths.LIVING_STREAMING_BANNER_URL)
                .params("type", "live")
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(() -> {
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Type type = new TypeToken<LivingBannerBean>() {
                    }.getType();
                    LivingBannerBean bean = new Gson().fromJson(s, type);
                    if (bean.getErrorCode() == 0
                            && bean.getErrorStr().equals("success")
                            && bean.getResultCount() > 0) {
                        beanResults = bean.getResults();
                        updateBannerUI(beanResults);
                    }
                }, throwable -> {
                });
    }

    /**
     * 显示图片
     *
     * @param results
     */
    private void updateBannerUI(List<LivingBannerBean.ResultsEntity> results) {
        Glide.with(getActivity())
                .load(results.get(0).getPic())
                .asBitmap()
                .error(R.drawable.group_detail_default)
                .placeholder(R.drawable.group_detail_default)
                .into(mHeaderBanner);

    }


    @Override
    public void onRefresh() {
        refreshData();
    }

    /**
     * 刷新数据
     */
    private void refreshData() {
        page = 1;  //page从第一页开始
        mResultsEntities.clear();
        initData();

    }


}
