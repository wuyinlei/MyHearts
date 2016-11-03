package ruolan.com.myhearts.ui.fragment.live;


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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okrx.RxAdapter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.adapter.CategoryAdapter;
import ruolan.com.myhearts.contant.Contants;
import ruolan.com.myhearts.contant.HttpUrlPaths;
import ruolan.com.myhearts.entity.RoomInfo;
import rx.android.schedulers.AndroidSchedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {


    private int mIndex;
    private String url;
    private RecyclerView mRecyclerview;
    private SwipeRefreshLayout mSwipeRefresh;
    private CategoryAdapter mCategoryAdapter;

    private int limit = 21;  //为了好看
    private int offset = 0;

    private int lordMoreNum = 20;

    private List<RoomInfo.DataEntity> mDataEntities = new ArrayList<>();

    public static CategoryFragment newInstance(int index) {
        // Required empty public constructor
        Bundle bundle = new Bundle();
        bundle.putInt(Contants.INDEX, index);
        CategoryFragment fragment = new CategoryFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        initView(view);
        mIndex = getArguments().getInt(Contants.INDEX);
        if (mIndex == 0) {
            url = HttpUrlPaths.getDouyuLiveChannel(limit, offset);
        } else {
            url = HttpUrlPaths.getDouyuSubChannelBaseTag(mIndex, limit, offset);
        }
        //  Log.d("CategoryFragment", url);
        requestData(url);

        return view;
    }

    private Handler mHandler = new Handler();

    private void initView(View view) {
        this.mSwipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefresh);
        mSwipeRefresh.setColorSchemeColors(Color.YELLOW, Color.RED, Color.BLUE, Color.GREEN);
        mSwipeRefresh.setOnRefreshListener(this);
        this.mRecyclerview = (RecyclerView) view.findViewById(R.id.recycler_view);
        mCategoryAdapter = new CategoryAdapter(getContext());
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        //第一列单独占一行
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (position == 0
                        || position == mDataEntities.size())
                        ? gridLayoutManager.getSpanCount() : 1;
            }
        });
        mRecyclerview.setLayoutManager(gridLayoutManager);
        mRecyclerview.setAdapter(mCategoryAdapter);
        mCategoryAdapter.setOnItemClickListener((view1, position, dataEntity) -> {
            // TODO: 2016/11/3 先禁止观看   等优化好之后再次开放 
//            if (position%2==0) {
//                Intent intent = new Intent(getActivity(), VideoViewActivity.class);
//                intent.putExtra(Contants.VIDEO_PATH, "http://125.39.142.86/data2/video09/2016/03/01/3871799-102-1615.mp4");
//                getActivity().startActivity(intent);
//            } else {
//                Intent intent = new Intent(getActivity(), VideoViewLiveActivity.class);
//                intent.putExtra(Contants.VIDEO_PATH,"rtmp://live.hkstv.hk.lxdns.com/live/hks");
//                getActivity().startActivity(intent);
//            }
        });


        mRecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int lastVisiableItemPosition = gridLayoutManager.findLastVisibleItemPosition();
                if (lastVisiableItemPosition + 1 == mCategoryAdapter.getItemCount()) {
                    if (!isLoading) {
                        isLoading = true;
                        mHandler.postDelayed(() -> {
                            getMoreData();
                            isLoading = false;
                            mCategoryAdapter.notifyItemRemoved(mCategoryAdapter.getItemCount());
                        }, 3000);
                    }
                }

            }
        });
    }

    /**
     * 获取到更多数据  上拉刷新
     */
    private void getMoreData() {
        offset += limit;
        limit += lordMoreNum;
        if (mIndex == 0) {
            url = HttpUrlPaths.getDouyuLiveChannel(limit, offset);
        } else {
            url = HttpUrlPaths.getDouyuSubChannelBaseTag(mIndex, limit, offset);
        }
        OkGo.get(url)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(() -> {
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Type type = new TypeToken<RoomInfo>() {
                    }.getType();
                    RoomInfo roomInfo = new Gson().fromJson(s, type);
                    if (roomInfo.getData().size() > 0) {
                        mDataEntities.addAll(roomInfo.getData());
                        mCategoryAdapter.setDataEntities(mDataEntities);
                        mCategoryAdapter.notifyItemRemoved(mCategoryAdapter.getItemCount());
                    }
                }, throwable -> {
                });

    }

    private boolean isLoading;


    /**
     * 下拉刷新数据
     *
     * @param url url
     */
    private void requestData(String url) {
        limit = lordMoreNum;
        offset = 0;
        if (mIndex == 0) {
            url = HttpUrlPaths.getDouyuLiveChannel(limit, offset);
        } else {
            url = HttpUrlPaths.getDouyuSubChannelBaseTag(mIndex, limit, offset);
        }
        OkGo.get(url)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(() -> {
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Type type = new TypeToken<RoomInfo>() {
                    }.getType();
                    RoomInfo roomInfo = new Gson().fromJson(s, type);
                    if (roomInfo.getData().size() > 0) {
                        mDataEntities.addAll(roomInfo.getData());
                        mCategoryAdapter.setDataEntities(mDataEntities);
                    }
                }, throwable -> {
                });
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(() -> {
            refreshData(url);
            mSwipeRefresh.setRefreshing(false);  //结束刷新
        }, 3000);

    }

    private void refreshData(String url) {
        OkGo.get(url)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(() -> {
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Type type = new TypeToken<RoomInfo>() {
                    }.getType();
                    RoomInfo roomInfo = new Gson().fromJson(s, type);
                    if (roomInfo.getData().size() > 0) {
                        mDataEntities.clear();
                        mDataEntities.addAll(roomInfo.getData());
                        mCategoryAdapter.setDataEntities(mDataEntities);
                    }
                }, throwable -> {
                });

    }
}
