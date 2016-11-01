package ruolan.com.myhearts.ui.fragment.thoughts;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
import ruolan.com.myhearts.adapter.ThroughtAdapter;
import ruolan.com.myhearts.contant.HttpUrlPaths;
import ruolan.com.myhearts.entity.ThoughtsBean;
import ruolan.com.myhearts.widget.DividerItemDecoration;
import ruolan.com.myhearts.widget.itemanimator.ScaleInOutItemAnimator;
import rx.android.schedulers.AndroidSchedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewFragment extends Fragment {


    private MaterialRefreshLayout mRefreshLayout;
    private RecyclerView mRecyclerView;

    private List<ThoughtsBean.ResultsBean> mThroughtDatas = new ArrayList<>();
    private ThroughtAdapter mThroughtAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new, container, false);

        initView(view);
        initData();


        return view;
    }



    /**
     * 请求数据
     */
    private void initData() {
        OkGo.post(HttpUrlPaths.THOUGHTS_URL)
                .params("userid",54442)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(()->{})
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s->{
                    Type type = new TypeToken<ThoughtsBean>(){}.getType();
                    ThoughtsBean bean = new Gson().fromJson(s,type);
                    if (bean.getErrorCode()==0
                            &&bean.getResultCount()>0
                            &&bean.getErrorStr().equals("success")){
                        mThroughtDatas = bean.getResults();
                        mThroughtAdapter.setResultsBeen(mThroughtDatas);
                    }
                },throwable -> {});
    }

    /**
     * 初始化布局控件
     *
     * @param view
     */
    private void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setItemAnimator(new ScaleInOutItemAnimator(mRecyclerView));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL_LIST));
        mThroughtAdapter = new ThroughtAdapter(getContext(), mThroughtDatas);
        mRecyclerView.setAdapter(mThroughtAdapter);
        mRefreshLayout = (MaterialRefreshLayout) view.findViewById(R.id.refresh);
        mRefreshLayout.setLoadMore(true);
        mRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                refreshData();
            }

            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                super.onRefreshLoadMore(materialRefreshLayout);
                new Handler().postDelayed(() -> lordMoreData(materialRefreshLayout),3000);
            }
        });

    }

    /**
     * 上拉加载更多数据
     * @param materialRefreshLayout
     */
    private void lordMoreData(MaterialRefreshLayout materialRefreshLayout) {
        materialRefreshLayout.finishRefreshLoadMore();
        Toast.makeText(getContext(), getActivity().getResources().getString(R.string.has_not_more_data), Toast.LENGTH_SHORT).show();
    }

    /**
     * 刷新数据
     */
    private void refreshData() {
        OkGo.post(HttpUrlPaths.THOUGHTS_URL)
                .params("userid",54442)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(()->{})
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s->{
                    Type type = new TypeToken<ThoughtsBean>(){}.getType();
                    ThoughtsBean bean = new Gson().fromJson(s,type);
                    if (bean.getErrorCode()==0
                            &&bean.getResultCount()>0
                            &&bean.getErrorStr().equals("success")){
                        mThroughtDatas.clear();
                        mRefreshLayout.finishRefresh();
                        mThroughtDatas = bean.getResults();
                        //mThroughtAdapter.notifyDataSetChanged();
                        mThroughtAdapter.setResultsBeen(mThroughtDatas);
                    }
                },throwable -> {});
    }

}
