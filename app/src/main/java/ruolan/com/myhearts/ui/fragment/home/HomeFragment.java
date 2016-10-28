package ruolan.com.myhearts.ui.fragment.home;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okrx.RxAdapter;
import com.sunfusheng.marqueeview.MarqueeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.adapter.OrationAdapter;
import ruolan.com.myhearts.entity.AdvisoryBean;
import ruolan.com.myhearts.entity.AdvisoryBean.ResultsBean;
import ruolan.com.myhearts.entity.HomeBannerBean;
import ruolan.com.myhearts.entity.HomeBannerOne;
import ruolan.com.myhearts.entity.HomeBannerTwo;
import ruolan.com.myhearts.entity.HomeNewsBean;
import ruolan.com.myhearts.entity.MarqueeBean;
import ruolan.com.myhearts.event.LoginEvent;
import ruolan.com.myhearts.event.LoginOut;
import ruolan.com.myhearts.contant.HttpUrlPaths;
import ruolan.com.myhearts.ui.base.BaseAdapter;
import ruolan.com.myhearts.ui.main.MainActivityDrawerLayout;
import ruolan.com.myhearts.utils.Utils;
import ruolan.com.myhearts.widget.CircleImageView;
import ruolan.com.myhearts.widget.FlyBanner;
import ruolan.com.myhearts.widget.FullyLinearLayoutManager;
import rx.android.schedulers.AndroidSchedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    ScrollView mScrollView;


    CircleImageView mAvatorImg;
    TextView mCustomerServiceTv;
    FlyBanner mFlyBanner;
    ImageView mImgTall;
    RelativeLayout mMyReTalk;
    ImageView mImgContact;
    RelativeLayout mMyReCall;
    ImageView mImgFree;
    RelativeLayout mMyReFree;
    ImageView mImgExam;
    RelativeLayout mMyReExam;
    ImageView mMarqueeImg;
    MarqueeView mMarqueeView;
    TextView mRecommentMasterTv;


    ImageView mImgOne;
    TextView mTvNameOne;
    TextView mTvLevelOne;
    TextView mTvDesOne;
    TextView mTvNameSecond;
    TextView mTvLevelTwo;
    TextView mTvDesTwo;
    ImageView mImgTwo;
    ImageView mImgThree;
    TextView mTvNameThree;
    TextView mTvDesThree;
    ImageView mImgFour;
    TextView mTvNameFour;
    TextView mTvDesFour;
    ImageView mRecommentImgOne;
    TextView mTvTitleRecomment;
    ImageView mImageView;
    TextView mTvDesTrecomment;
    ImageView mHotImg;
    RecyclerView mHotRecyclerView;
    RelativeLayout mReLookMore;
    private OrationAdapter mHomeNewAdapter;

    /**
     * 初始化布局控件
     *
     * @param view
     */
    private void initView(View view) {
        mScrollView = (ScrollView) view.findViewById(R.id.scrollView);
        mAvatorImg = (CircleImageView) view.findViewById(R.id.avator_img);
        mCustomerServiceTv = (TextView) view.findViewById(R.id.customer_service_tv);
        mFlyBanner = (FlyBanner) view.findViewById(R.id.fly_banner);
        mImgTall = (ImageView) view.findViewById(R.id.img_tall);
        mMyReTalk = (RelativeLayout) view.findViewById(R.id.my_re_talk);
        mImgContact = (ImageView) view.findViewById(R.id.img_contact);
        mMyReCall = (RelativeLayout) view.findViewById(R.id.my_re_call);
        mImgFree = (ImageView) view.findViewById(R.id.img_free);
        mMyReFree = (RelativeLayout) view.findViewById(R.id.my_re_free);
        mImgExam = (ImageView) view.findViewById(R.id.img_exam);
        mMyReExam = (RelativeLayout) view.findViewById(R.id.my_re_exam);
        mMarqueeImg = (ImageView) view.findViewById(R.id.marquee_img);
        mMarqueeView = (MarqueeView) view.findViewById(R.id.marquee_view);
        mRecommentMasterTv = (TextView) view.findViewById(R.id.recomment_master_tv);
        mImgOne = (ImageView) view.findViewById(R.id.img_one);
        mTvNameOne = (TextView) view.findViewById(R.id.tv_name_one);
        mTvLevelOne = (TextView) view.findViewById(R.id.tv_level_one);
        mTvDesOne = (TextView) view.findViewById(R.id.tv_des_one);
        mTvNameSecond = (TextView) view.findViewById(R.id.tv_name_second);
        mTvLevelTwo = (TextView) view.findViewById(R.id.tv_level_two);
        mTvDesTwo = (TextView) view.findViewById(R.id.tv_des_two);
        mImgTwo = (ImageView) view.findViewById(R.id.img_two);
        mImgThree = (ImageView) view.findViewById(R.id.img_three);
        mTvNameThree = (TextView) view.findViewById(R.id.tv_name_three);
        mTvDesThree = (TextView) view.findViewById(R.id.tv_des_three);
        mTvNameFour = (TextView) view.findViewById(R.id.tv_name_four);
        mTvDesFour = (TextView) view.findViewById(R.id.tv_des_four);
        mTvTitleRecomment = (TextView) view.findViewById(R.id.tv_title_recomment);
        mTvDesTrecomment = (TextView) view.findViewById(R.id.tv_des_trecomment);
        mImgFour = (ImageView) view.findViewById(R.id.img_four);
        mRecommentImgOne = (ImageView) view.findViewById(R.id.recomment_img_one);
        mImageView = (ImageView) view.findViewById(R.id.imageView);
        mHotImg = (ImageView) view.findViewById(R.id.hot_img);
        mHotRecyclerView = (RecyclerView) view.findViewById(R.id.hot_recycler_view);
        mReLookMore = (RelativeLayout) view.findViewById(R.id.re_look_more);
        mHotRecyclerView.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        mHotRecyclerView.setLayoutManager(layoutManager);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        EventBus.getDefault().register(this);

        initView(view);
        initListener();

        //刚开始进入界面的时候显示开头
        mScrollView.smoothScrollTo(0, 0);
        initBanner();
        initMarqueeData();
        initAdvisoryData();
        initRecommentOne();
        initRecommentTwo();
        initData();


        return view;
    }

    /**
     * 设置事件监听
     */
    private void initListener() {

        mAvatorImg.setOnClickListener(this);
        mReLookMore.setOnClickListener(this);
    }

    List<HomeNewsBean.ResultsBean> mHomeNewsData = new ArrayList<>();

    /**
     * 请求文档类型数据
     */
    private void initData() {
        OkGo.post(HttpUrlPaths.SCAN_MORE)
                .params("userid", "54442")
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
                        mHomeNewsData = bean.getResults();
                        mHomeNewAdapter = new OrationAdapter(getContext(), mHomeNewsData);
                        mHotRecyclerView.setAdapter(mHomeNewAdapter);
                        mHomeNewAdapter.setOnItemClickListener((view, position) -> {
                            HomeNewsBean.ResultsBean resultsBean = mHomeNewsData.get(position);
                            Intent intent = new Intent(getActivity(),NewsActivity.class);
                            intent.putExtra("id",resultsBean.getId());
                            intent.putExtra("userid","54442");
                            startActivity(intent);
                        });
                    }
                }, throwable -> {

                });
    }


    /**
     * 请求首页下面展示的图片的第一个banner
     */
    private void initRecommentOne() {
        OkGo.post(HttpUrlPaths.HOME_RECOMMENT_ONE_BANNER)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(() -> {

                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Type type = new TypeToken<HomeBannerOne>() {
                    }.getType();
                    HomeBannerOne homeBannerOne = new Gson().fromJson(s, type);
                    if (homeBannerOne.getErrorStr().equals("success")
                            && homeBannerOne.getErrorCode() == 0) {
                        Glide.with(getContext())
                                .load(homeBannerOne.getResults().getBanner())
                                .asBitmap()
                                .into(mRecommentImgOne);
                    }
                }, throwable -> {

                });

    }

    /**
     * 请求首页下面展示的图片的第一个banner
     */
    private void initRecommentTwo() {
        OkGo.post(HttpUrlPaths.HOME_RECOMMENT_TWO_BANNER)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(() -> {

                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Type type = new TypeToken<HomeBannerTwo>() {
                    }.getType();
                    HomeBannerTwo homeBannerTwo = new Gson().fromJson(s, type);
                    if (homeBannerTwo.getErrorStr().equals("success")
                            && homeBannerTwo.getErrorCode() == 0) {
                        Glide.with(getContext())
                                .load(homeBannerTwo.getResults().getImage())
                                .asBitmap()
                                .into(mImageView);

                        mTvDesTrecomment.setText(homeBannerTwo.getResults().getTitle());
                    }
                }, throwable -> {

                });

    }

    List<ResultsBean> mAdvisoryBean = new ArrayList<>();

    /**
     * 请求推荐咨询师数据
     */
    private void initAdvisoryData() {
        OkGo.post(HttpUrlPaths.HOME_RECOMMENT)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(() -> {

                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Type type = new TypeToken<AdvisoryBean>() {
                    }.getType();
                    AdvisoryBean bean = new Gson().fromJson(s, type);
                    if (bean != null
                            && bean.getErrorCode() == 0
                            && bean.getErrorStr().equals("success")) {
                        mAdvisoryBean = bean.getResults();
                        if (mAdvisoryBean != null && mAdvisoryBean.size() > 0) {
                            initAdvisory(mAdvisoryBean);
                        }
                    }
                }, throwable -> {

                });
    }


    private void initAdvisory(List<ResultsBean> been) {
        ResultsBean one = new ResultsBean(), two = new ResultsBean(),
                three = new ResultsBean(),
                four = new ResultsBean();

        for (int i = 0; i < been.size(); i++) {
            if (i == 0) {
                one = been.get(i);
            } else if (i == 1) {
                two = been.get(1);
            } else if (i == 2) {
                three = been.get(i);
            } else if (i == 3) {
                four = been.get(i);
            }
        }

        Glide.with(getContext()).load(one.getAvatar()).asBitmap().into(mImgOne);
        mTvNameOne.setText(one.getNickname());
        mTvLevelOne.setText(one.getQualification());
        mTvDesOne.setText(one.getTitle());

        Glide.with(getContext()).load(two.getAvatar()).asBitmap().into(mImgTwo);
        mTvNameSecond.setText(two.getNickname());
        mTvLevelTwo.setText(two.getQualification());
        mTvDesTwo.setText(two.getTitle());

        Glide.with(getContext()).load(three.getAvatar()).asBitmap().into(mImgThree);
        mTvNameThree.setText(three.getNickname());
        mTvDesThree.setText(three.getQualification());

        Glide.with(getContext()).load(four.getAvatar()).asBitmap().into(mImgFour);
        mTvNameFour.setText(four.getNickname());
        mTvDesFour.setText(four.getQualification());

    }


    /**
     * 请求首页顶部轮播图
     */
    private void initBanner() {

        MyThread thread = new MyThread();
        thread.run();

    }

    @Override
    public void onResume() {
        super.onResume();
       // boolean isLogin = PreferencesUtils.getBoolean(getContext(), Contants.IS_LOGIN);
      //  if (isLogin) {
            // String name = PreferencesUtils.getString(getContext(), Contants.USER_NAME);
            //  updateUi(name);
           // if (mAvatorImg != null) {
           //     Glide.with(getContext())
            //            .load(R.drawable.user_avatour)
            //            .asBitmap().into(mAvatorImg);
           // }
      //  }
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mHomeBanner = (List<HomeBannerBean.ResultsBean>) msg.obj;
            List<String> imgBanner = new ArrayList<>();
            for (HomeBannerBean.ResultsBean resultsBean : mHomeBanner) {
                imgBanner.add(resultsBean.getPic());
            }
            mFlyBanner.setImagesUrl(imgBanner);
            mFlyBanner.setOnItemClickListener(position -> {
                mHomeBanner.get(position);  //  根据这个来进行跳转
            });

        }
    };

    List<HomeBannerBean.ResultsBean> mHomeBanner = new ArrayList<>();



    @Subscribe(threadMode = ThreadMode.MAIN )
    public void LoginOut(LoginOut loginOut){
            if (loginOut.isLogin){
                if (mAvatorImg != null) {
                    Glide.with(getContext())
                            .load(R.drawable.login_out)
                            .asBitmap().into(mAvatorImg);
                }
            }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void LoginInEvent(LoginEvent loginEvent){
        if (loginEvent.mMyUser.getImgurl()==null){
            if (mAvatorImg != null) {
                Glide.with(getContext())
                        .load(R.drawable.user_avatour)
                        .asBitmap().into(mAvatorImg);
            }
        } else {
            if (mAvatorImg != null) {
                Glide.with(getContext())
                        .load(loginEvent.mMyUser.getImgurl())
                        .asBitmap().into(mAvatorImg);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.re_look_more:
                Intent intent = new Intent(getActivity(), OrationActivity.class);
                getActivity().startActivity(intent);
                break;

            case R.id.avator_img:
                ((MainActivityDrawerLayout) getActivity())
                        .getDragLayout()
                        .openDrawer(GravityCompat.START);
                break;

            default:
                break;
        }

    }

    /**
     * 解析本地json文件
     */
    class MyThread implements Runnable {
        @Override
        public void run() {
            String result = Utils.getJson(getActivity(), "HomeBanner.json");
            Gson gson = new Gson();
            HomeBannerBean bannerBean = null;
            bannerBean = gson.fromJson(result, new TypeToken<HomeBannerBean>() {
            }.getType());
            if (bannerBean.getErrorStr().equals("success") && bannerBean.getErrorCode() == 0) {
                Message message = Message.obtain();
                message.obj = bannerBean.getResults();
                mHandler.sendMessage(message);
            }
        }
    }


    List<MarqueeBean.ResultsBean> mResultsBeen = new ArrayList<>();

    /**
     * 请求跑马灯数据
     */
    private void initMarqueeData() {
        OkGo.post(HttpUrlPaths.HOME_MARQUEE)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(() -> {  //可以显示dialog

                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Type type = new TypeToken<MarqueeBean>() {
                    }.getType();
                    MarqueeBean bean = new Gson().fromJson(s, type);
                    if (bean.getErrorCode() == 0 && bean.getErrorStr().equals("success")) {
                        mResultsBeen = bean.getResults();
                        if (mResultsBeen != null && mResultsBeen.size() > 0) {
                            List<String> info = new ArrayList<>();
                            for (MarqueeBean.ResultsBean resultsBean : mResultsBeen) {
                                info.add(resultsBean.getLabel());
                            }
                            mMarqueeView.startWithList(info);
                        }
                    }
                }, throwable -> {  //出现错误的时候调用

                });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
