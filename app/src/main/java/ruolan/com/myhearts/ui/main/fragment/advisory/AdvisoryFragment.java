package ruolan.com.myhearts.ui.main.fragment.advisory;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cjj.MaterialRefreshLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okrx.RxAdapter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.contant.Contants;
import ruolan.com.myhearts.contant.HttpUrlPaths;
import ruolan.com.myhearts.ui.base.BaseAdapter;
import ruolan.com.myhearts.ui.main.fragment.advisory.AdvisoryBannerBean.ResultsBean;
import ruolan.com.myhearts.utils.Utils;
import ruolan.com.myhearts.widget.DividerItemDecoration;
import ruolan.com.myhearts.widget.FlyBanner;
import ruolan.com.myhearts.widget.itemanimator.SlideInOutTopItemAnimator;
import rx.android.schedulers.AndroidSchedulers;

public class AdvisoryFragment extends Fragment {


    //@Bind(R.id.action_consultant_tittle)
    //TextView mActionConsultantTittle;
    // @Bind(R.id.action_search_view)

    ImageButton mActionSearchView;
    // @Bind(R.id.action_consultant_layout)
    // RelativeLayout mActionConsultantLayout;
    TextView mSortAllTxt;
    LinearLayout mSortAllLayout;
    TextView mSortConsultantCntTxt;
    LinearLayout mSortConsultantCntLayout;
    TextView mSortPriceTxt;
    ImageView mSortPriceIcon;

    RelativeLayout mSortPriceLayout;
    TextView mSortContinuedPercentTxt;
    LinearLayout mSortContinuedPercentLayout;
    TextView mSortCommentRatingTxt;
    LinearLayout mSortCommentRatingLayout;
    LinearLayout mSortHeaderLayout;

    TextView mNoticeTxt;
    View mNoticeDivider2;
    FlyBanner mFlyBanner;
    RecyclerView mDataList;
    MaterialRefreshLayout mRefreshLayout;

    private List<ResultsBean> mAdvisoryDatas = new ArrayList<>();
    private List<AdvisoryBean.ResultsBean> mDatas = new ArrayList<>();
    private AdvisoryAdapter mAdvisoryAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_advisory, container, false);

        initView(view);
        initBanner();
        initListener();
        initAdvisoryDatas();


        return view;
    }

    private void initListener() {
        mDataList.setLayoutManager(new LinearLayoutManager(getContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        mDataList.setItemAnimator(new SlideInOutTopItemAnimator(mDataList));
        mDataList.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL_LIST));
        mAdvisoryAdapter = new AdvisoryAdapter(getContext(), mDatas);
        mAdvisoryAdapter.setOnItemClickListener((view, position) -> {
            int index = mDatas.size()-position-1;  //不太明白，为什么显示的是倒叙
            AdvisoryBean.ResultsBean resultsBean = mDatas.get(index);
            String userid = resultsBean.getUserid();
            Intent intent = new Intent(getActivity(), UserDetailActivity.class);
            intent.putExtra(Contants.USER_ID, userid);
            intent.putExtra(Contants.C_USER_ID, userid);
            startActivity(intent);
        });
        mDataList.setAdapter(mAdvisoryAdapter);
    }

    private void initAdvisoryDatas() {
//        OkGo.post(HttpUrlPaths.SERACH_LIST)
//                .params("userid", 54442)
//                .getCall(StringConvert.create(), RxAdapter.<String>create())
//                .doOnSubscribe(() -> {
//                })
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(s -> {
//                    Type type = new TypeToken<AdvisoryBean>() {
//                    }.getType();
//                    AdvisoryBean bean = new Gson().fromJson(s, type);
//                    if (bean.getErrorCode() == 0
//                            && bean.getResultCount() > 0
//                            && bean.getErrorStr().equals("success")) {
//                        mDatas = bean.getResults();
//                        mAdvisoryAdapter.addData(mDatas);
//                    }
//                }, throwable -> {
//                });

        //把他们的数据抓取出来，放到本地
        new MyUserThread().run();
    }


    Handler mUserHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
           // mUserDatas = (UserDetailBean.ResultsBean) msg.obj;
           // updateUi(mUserDatas);
            mDatas = (List<AdvisoryBean.ResultsBean>) msg.obj;
            //mDatas = bean.getResults();
            mAdvisoryAdapter.addData(mDatas);
        }
    };


    /**
     * 解析本地json文件
     */
    class MyUserThread implements Runnable {
        @Override
        public void run() {
            String result = Utils.getJson(getContext(), "UserList.json");
            Gson gson = new Gson();
            AdvisoryBean bannerBean = null;
            bannerBean = gson.fromJson(result, new TypeToken<AdvisoryBean>() {
            }.getType());
            if (bannerBean.getErrorStr().equals("success") && bannerBean.getErrorCode() == 0) {
                Message message = Message.obtain();
                message.obj = bannerBean.getResults();
                mUserHandler.sendMessage(message);
            }
        }
    }


    /**
     * 请求轮播图数据
     */
    private void initBanner() {
        MyThread thread = new MyThread();
        thread.run();
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mAdvisoryDatas = (List<ResultsBean>) msg.obj;
            List<String> imgBanner = new ArrayList<>();
            for (ResultsBean resultsBean : mAdvisoryDatas) {
                imgBanner.add(resultsBean.getPic());
            }
            mFlyBanner.setImagesUrl(imgBanner);
            mFlyBanner.setOnItemClickListener(position -> {
                mAdvisoryDatas.get(position);  //  根据这个来进行跳转
            });

        }
    };


    /**
     * 解析本地json文件
     */
    class MyThread implements Runnable {
        @Override
        public void run() {
            String result = Utils.getJson(getActivity(), "AdvisoryBanner.json");
            Gson gson = new Gson();
            AdvisoryBannerBean bannerBean = null;
            bannerBean = gson.fromJson(result, new TypeToken<AdvisoryBannerBean>() {
            }.getType());
            if (bannerBean.getErrorStr().equals("success") && bannerBean.getErrorCode() == 0) {
                Message message = Message.obtain();
                message.obj = bannerBean.getResults();
                mHandler.sendMessage(message);
            }
        }
    }


    /**
     * 初始化View
     *
     * @param view
     */
    private void initView(View view) {
        mActionSearchView = (ImageButton) view.findViewById(R.id.action_search_view);
        mSortAllTxt = (TextView) view.findViewById(R.id.sort_all_txt);
        mSortAllLayout = (LinearLayout) view.findViewById(R.id.sort_all_layout);
        mSortConsultantCntTxt = (TextView) view.findViewById(R.id.sort_consultant_cnt_txt);
        mSortConsultantCntLayout = (LinearLayout) view.findViewById(R.id.sort_consultant_cnt_layout);
        mSortPriceTxt = (TextView) view.findViewById(R.id.sort_price_txt);
        mSortPriceIcon = (ImageView) view.findViewById(R.id.sort_price_icon);
        mSortAllTxt = (TextView) view.findViewById(R.id.sort_all_txt);

        mSortPriceLayout = (RelativeLayout) view.findViewById(R.id.sort_price_layout);
        mSortContinuedPercentTxt = (TextView) view.findViewById(R.id.sort_continued_percent_txt);

        mSortContinuedPercentLayout = (LinearLayout) view.findViewById(R.id.sort_continued_percent_layout);
        mFlyBanner = (FlyBanner) view.findViewById(R.id.fly_banner);

        mSortCommentRatingLayout = (LinearLayout) view.findViewById(R.id.sort_comment_rating_layout);
        mSortHeaderLayout = (LinearLayout) view.findViewById(R.id.sort_header_layout);

        mDataList = (RecyclerView) view.findViewById(R.id.data_list);

        mRefreshLayout = (MaterialRefreshLayout) view.findViewById(R.id.refresh_layout);


    }


}
