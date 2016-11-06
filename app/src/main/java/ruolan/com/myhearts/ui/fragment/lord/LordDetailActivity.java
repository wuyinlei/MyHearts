package ruolan.com.myhearts.ui.fragment.lord;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okrx.RxAdapter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.adapter.LordDetailAdapter;
import ruolan.com.myhearts.entity.LordDetailBean;
import ruolan.com.myhearts.ui.base.BaseActivity;
import ruolan.com.myhearts.contant.HttpUrlPaths;
import ruolan.com.myhearts.ui.base.BaseAdapter;
import ruolan.com.myhearts.widget.DividerItemDecoration;
import ruolan.com.myhearts.widget.itemanimator.SlideInOutRightItemAnimator;
import rx.android.schedulers.AndroidSchedulers;

public class LordDetailActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView mLordDetailRecyclerView;
    private MaterialRefreshLayout mLordRefresh;
    private ImageView mIcBack;
    private TextView mTvTitle;


    private List<LordDetailBean.ResultsBean> mLordDetailDatas = new ArrayList<>();


    private boolean isLordMore = true;

    String mTitle;

    String catgId;  //分类id
    int page = 1;
    private LordDetailAdapter detailAdapter;


    @Override
    protected int getResultId() {
        return R.layout.activity_lord_detail;
    }

    @Override
    protected void initListener() {
        mIcBack.setOnClickListener(this);
        mLordRefresh.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                //一般加载数据都是在子线程中，这里我用到了handler
                new Handler().postDelayed(() -> {
                    //Toast.makeText(MainActivity.this, "已经没有更多数据了", Toast.LENGTH_SHORT).show();
                    /**
                     * 刷新完成后调用此方法，要不然刷新效果不消失
                     */
                    initRefresh(materialRefreshLayout);
                    //mLordRefresh.finishRefresh();

                }, 3000);

                //Toast.makeText(LordDetailActivity.this, "你好", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                isLordMore = false;
                new Handler().postDelayed(() -> {
                    //mNoData.setVisibility(View.VISIBLE);
                    // mLordRefresh.setLoadMore(false);
                    // detailAdapter.notifyDataSetChanged();
                    // mLordRefresh.finishRefreshLoadMore();
                    loadMoreData();
                    //mLordRefresh.autoRefreshLoadMore();
                }, 3000);
            }
        });
    }

    /**
     * 加载更多的数据
     */
    private void loadMoreData() {

        page++; //重置  在刷新的时候
        OkGo.post(HttpUrlPaths.LORD_DETAIL_URL)
                .params("catgId", catgId)
                .params("page", page)
                .params("userid", 0)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(() -> {
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Type type = new TypeToken<LordDetailBean>() {
                    }.getType();
                    LordDetailBean bean = new Gson().fromJson(s, type);
                    if (bean.getErrorStr().equals("success")
                            && bean.getErrorCode() == 0
                            && bean.getResultCount() > 0) {
                        //mLordDetailDatas.clear();
                        //mLordDetailDatas.addAll(bean.getResults());
                        detailAdapter.addData(mLordDetailDatas.size(),bean.getResults());
                        detailAdapter.notifyDataSetChanged();
                        mLordRefresh.autoRefreshLoadMore();
                    }
                }, throwable -> {
                });
    }

    private void initRefresh(MaterialRefreshLayout materialRefreshLayout) {
        page = 1; //重置  在刷新的时候
        OkGo.post(HttpUrlPaths.LORD_DETAIL_URL)
                .params("catgId", catgId)
                .params("page", page)
                .params("userid", 0)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(() -> {
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Type type = new TypeToken<LordDetailBean>() {
                    }.getType();
                    LordDetailBean bean = new Gson().fromJson(s, type);
                    if (bean.getErrorStr().equals("success")
                            && bean.getErrorCode() == 0
                            && bean.getResultCount() > 0) {
                        mLordDetailDatas.clear();
                        detailAdapter.notifyDataSetChanged();
                        mLordRefresh.finishRefresh();
                    }
                }, throwable -> {
                });


    }

    @Override
    public void initData() {
        super.initData();
        initLordDetailData();
    }

    /**
     * 请求数据
     */
    private void initLordDetailData() {
        OkGo.post(HttpUrlPaths.LORD_DETAIL_URL)
                .params("catgId", catgId)
                .params("page", page)
                .params("userid", 0)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(() -> {
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Type type = new TypeToken<LordDetailBean>() {
                    }.getType();
                    LordDetailBean bean = new Gson().fromJson(s, type);
                    if (bean.getErrorStr().equals("success")
                            && bean.getErrorCode() == 0
                            && bean.getResultCount() > 0) {
                        mLordDetailDatas = bean.getResults();
                        detailAdapter.addData(mLordDetailDatas);
                    }
                }, throwable -> {
                });

    }

    @Override
    public void initView() {

        mLordRefresh = (MaterialRefreshLayout) findViewById(R.id.refresh);
        mLordRefresh.setLoadMore(isLordMore);
        // mLordRefresh.autoRefresh();
//        mLordRefresh.setColorSchemeColors(Color.RED,
//                Color.BLUE, Color.GREEN);
        mIcBack = (ImageView) findViewById(R.id.ic_back);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mLordDetailRecyclerView = (RecyclerView)
                findViewById(R.id.lord_recycler_view);
        mLordDetailRecyclerView.setLayoutManager(new
                LinearLayoutManager(this));
        mLordDetailRecyclerView.setItemAnimator(new
                SlideInOutRightItemAnimator(mLordDetailRecyclerView));
        mLordDetailRecyclerView.addItemDecoration(new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        detailAdapter = new LordDetailAdapter(this, mLordDetailDatas);
        mLordDetailRecyclerView.setAdapter(detailAdapter);

        mTitle = getIntent().getStringExtra("title");
        if (mTitle != null && !TextUtils.isEmpty(mTitle)) {
            mTvTitle.setText(mTitle);
        }

        detailAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                LordDetailBean.ResultsBean bean = mLordDetailDatas.get(position);
                int id = Integer.parseInt(bean.getId());
                Intent intent = new Intent(LordDetailActivity.this,
                        GroupDetailActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("title",mTitle);
                startActivity(intent);
            }
        });




        catgId = getIntent().getStringExtra("catgId");
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ic_back) {
            finish();
        }
    }
}
