package ruolan.com.myhearts.activity.main.fragment.home;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

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
import ruolan.com.myhearts.activity.base.BaseActivity;
import ruolan.com.myhearts.contant.Contants;
import ruolan.com.myhearts.widget.FullyLinearLayoutManager;
import ruolan.com.myhearts.widget.itemanimator.SlideInOutLeftItemAnimator;
import rx.android.schedulers.AndroidSchedulers;

public class OrationActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mIcBack;
    private RecyclerView mOrationRecyclerView;
    private OrationAdapter mOrationAdapter;
    private List<HomeNewsBean.ResultsBean> mOrationDatas = new ArrayList<>();
    private int page = 1;
    private MaterialRefreshLayout mMaterialRefreshLayout;


    @Override
    protected void initListener() {
        mIcBack.setOnClickListener(this);
    }

    @Override
    protected int getResultId() {
        return R.layout.activity_oration;
    }

    @Override
    public void initData() {
        super.initData();
        OkGo.post(Contants.SCAN_MORE)
                .params("userid", "54442")
                .params("page", page + "")
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(() -> {

                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Type type = new TypeToken<HomeNewsBean>() {
                    }.getType();
                    HomeNewsBean bean = new Gson().fromJson(s, type);
                    if (bean.getErrorCode() == 0
                            && bean.getErrorStr().equals("success")
                            && bean.getResults().size() > 0) {
                        mOrationDatas = bean.getResults();
                        mOrationAdapter.addData(mOrationDatas);

                        // page++;


                    }
                }, throwable -> {

                });
    }


    @Override
    public void initView() {
        mIcBack = (ImageView) findViewById(R.id.ic_back);
        mOrationRecyclerView = (RecyclerView) findViewById(R.id.oration_recycler_view);

        SlideInOutLeftItemAnimator animation = new SlideInOutLeftItemAnimator(mOrationRecyclerView);
        mOrationRecyclerView.setItemAnimator(animation);
        mOrationRecyclerView.setLayoutManager(new FullyLinearLayoutManager(this));
        mOrationAdapter = new OrationAdapter(this, mOrationDatas);
        mOrationRecyclerView.setAdapter(mOrationAdapter);
        mMaterialRefreshLayout = (MaterialRefreshLayout) findViewById(R.id.refresh);

        mMaterialRefreshLayout.setLoadMore(isLoadMore);

        mMaterialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {

                //一般加载数据都是在子线程中，这里我用到了handler
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Toast.makeText(MainActivity.this, "已经没有更多数据了", Toast.LENGTH_SHORT).show();
                        /**
                         * 刷新完成后调用此方法，要不然刷新效果不消失
                         */
                        initRefresh(materialRefreshLayout);

                    }
                }, 3000);

            }

            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                super.onRefreshLoadMore(materialRefreshLayout);

                new Handler().postDelayed(() -> {
                    isLoadMore = false;
                    /**
                     * 完成加载数据后，调用此方法，要不然刷新的效果不会消失
                     */
                    loadMoreData();

                }, 3000);

            }
        });

    }

    private void loadMoreData() {
        OkGo.post(Contants.SCAN_MORE)
                .params("userid", "54442")
                .params("page", ++page)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(() -> {

                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Type type = new TypeToken<HomeNewsBean>() {
                    }.getType();
                    HomeNewsBean bean = new Gson().fromJson(s, type);
                    if (bean.getErrorCode() == 0
                            && bean.getErrorStr().equals("success")
                            && bean.getResults().size() > 0) {
                        List<HomeNewsBean.ResultsBean> resultData = bean.getResults();

                       // mOrationDatas.addAll(resultData);
                        mOrationAdapter.addData(mOrationAdapter.getDatas().size(),resultData);
                        mOrationAdapter.notifyDataSetChanged();
                        mMaterialRefreshLayout.finishRefreshLoadMore();
                    }
                }, throwable -> {

                });

    }

    private void initRefresh(MaterialRefreshLayout materialRefreshLayout) {
        page = 1;
        OkGo.post(Contants.SCAN_MORE)
                .params("userid", "54442")
                .params("page", page + "")
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(() -> {

                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Type type = new TypeToken<HomeNewsBean>() {
                    }.getType();
                    HomeNewsBean bean = new Gson().fromJson(s, type);
                    if (bean.getErrorCode() == 0
                            && bean.getErrorStr().equals("success")
                            && bean.getResults().size() > 0) {
                        mOrationDatas.clear();
                        mOrationDatas = bean.getResults();
                        mOrationAdapter.addData(mOrationDatas);
                        materialRefreshLayout.finishRefresh();

                    }
                }, throwable -> {

                });
    }

    /**
     * 在上拉刷新的时候，判断，是否处于上拉刷新，如果是的话，就禁止在一次刷新，保障在数据加载完成之前
     * 避免重复和多次加载
     */
    private boolean isLoadMore = true;

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ic_back) {
            finish();
        }
    }

}
