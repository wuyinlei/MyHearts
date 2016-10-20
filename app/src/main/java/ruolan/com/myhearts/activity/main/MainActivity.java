package ruolan.com.myhearts.activity.main;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ruolan.com.myhearts.widget.DragLayout;
import ruolan.com.myhearts.R;
import ruolan.com.myhearts.activity.base.BaseActivity;
import ruolan.com.myhearts.activity.login.LoginActivity;
import ruolan.com.myhearts.activity.main.left.ContactActivity;
import ruolan.com.myhearts.activity.main.left.FollowActivity;
import ruolan.com.myhearts.activity.main.left.GiftActivity;
import ruolan.com.myhearts.activity.main.left.MessageActivity;
import ruolan.com.myhearts.activity.main.left.MoneyActivity;
import ruolan.com.myhearts.activity.main.left.ReserveActivity;
import ruolan.com.myhearts.activity.main.left.SettingActivity;
import ruolan.com.myhearts.activity.main.left.WorryActivity;
import ruolan.com.myhearts.fragment.AdvisoryFragment;
import ruolan.com.myhearts.fragment.HomeFragment;
import ruolan.com.myhearts.fragment.LiveFragment;
import ruolan.com.myhearts.fragment.LordFragment;
import ruolan.com.myhearts.fragment.ThoughtsFragment;
import ruolan.com.myhearts.utils.TranslucentUtils;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private DragLayout mDragLayout;
    private ImageView mIvLive, mIvImg;

    private RadioButton mRadioHome, mRadioAdvisory, mRadioLord, mRadioThoughts, mRadioLive;
    private RadioGroup mRadioGroup;

    private static final int TAB_HOME = 0X1;
    private static final int TAB_ADVISORY = 0X2;
    private static final int TAB_LIVE = 0X3;
    private static final int TAB_LORD = 0X4;
    private static final int TAB_THOURGHTS = 0X5;

    private static int CURRENT_ITEM = 1;

    //fragment
    private HomeFragment mHomeFragment;
    private AdvisoryFragment mAdvisoryFragment;
    private LiveFragment mLiveFragment;
    private LordFragment mLordFragment;
    private ThoughtsFragment mThoughtsFragment;

    private FrameLayout mFrameLayout;

    /*左侧menu事件控件*/
    @Bind(R.id.rl_login)
     RelativeLayout mReLogin;

    @Bind(R.id.my_message)
     LinearLayout mLiReserve;

    @Bind(R.id.my_follow)
     LinearLayout mLiFollow;

    @Bind(R.id.my_contact)
     LinearLayout mLiContact;

    @Bind(R.id.my_money)
     LinearLayout mLiMoney;

    @Bind(R.id.my_gift)
     LinearLayout mLiGift;

    @Bind(R.id.my_worry)
     LinearLayout mLiWorry;

    @Bind(R.id.re_setting)
     RelativeLayout mReSetting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        TranslucentUtils.setColor(this, getResources().getColor(R.color.divider), 1);

        initView();

        initAnimation();


        initFragment();

        addFragment();


        initRadio();

        mIvImg.setOnClickListener(this);


    }

    /**
     * 自己去调整
     */
    private void initAnimation() {
        // 获取ImageView上的动画背景
        AnimationDrawable spinnerLive = (AnimationDrawable) mIvLive.getBackground();

        // 开始动画
        spinnerLive.start();

        mIvImg = (ImageView) findViewById(R.id.img_img);

        // 获取ImageView上的动画背景
        AnimationDrawable spinnerImg = (AnimationDrawable) mIvImg.getBackground();
        // 开始动画
        spinnerImg.start();

    }

    /**
     * 初始化布局控件
     */
    private void initView() {


        mDragLayout = (DragLayout) findViewById(R.id.qq_slidding);

        mIvLive = (ImageView) findViewById(R.id.img_live);

        mFrameLayout = (FrameLayout) findViewById(R.id.container);

        mRadioHome = (RadioButton) findViewById(R.id.rbTabHome);
        mRadioAdvisory = (RadioButton) findViewById(R.id.rbTabAdvisory);
        mRadioLord = (RadioButton) findViewById(R.id.rbTabLord);
        mRadioThoughts = (RadioButton) findViewById(R.id.rbTabThoughts);
        mRadioLive = (RadioButton) findViewById(R.id.rbTabMall);
        mRadioHome.setChecked(true);

    }

    @OnClick({
            R.id.rl_login,
            R.id.my_message,
            R.id.my_contact,
            R.id.my_follow,
            R.id.my_money,
            R.id.my_gift,
            R.id.my_reserve,
            R.id.my_worry,
            R.id.re_setting})
    public void leftMenuClick(View view) {

        Intent intent = new Intent();
        boolean isLogin = true;

        switch (view.getId()) {
            case R.id.rl_login:
                intent.setClass(MainActivity.this, LoginActivity.class);
                isLogin = false;
                break;
            case R.id.my_message:
                intent.setClass(MainActivity.this, MessageActivity.class);
                break;
            case R.id.my_contact:
                intent.setClass(MainActivity.this, ContactActivity.class);
                break;
            case R.id.my_follow:
                intent.setClass(MainActivity.this, FollowActivity.class);
                break;
            case R.id.my_money:
                intent.setClass(MainActivity.this, MoneyActivity.class);
                break;
            case R.id.my_gift:
                intent.setClass(MainActivity.this, GiftActivity.class);
                break;
            case R.id.my_reserve:
                intent.setClass(MainActivity.this, ReserveActivity.class);
                break;
            case R.id.my_worry:
                intent.setClass(MainActivity.this, WorryActivity.class);
                break;
            case R.id.re_setting:
                intent.setClass(MainActivity.this, SettingActivity.class);
                break;
        }
        startActivity(intent,isLogin);
    }

    /**
     * 添加fragment
     */
    private void addFragment() {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        transaction.add(R.id.container, mHomeFragment);
        transaction.add(R.id.container, mAdvisoryFragment);
        transaction.add(R.id.container, mLiveFragment);
        transaction.add(R.id.container, mLordFragment);
        transaction.add(R.id.container, mThoughtsFragment);
        transaction.commit();

        showFragment(CURRENT_ITEM);
    }


    /**
     * 初始化Fragment
     */
    private void initFragment() {
        mHomeFragment = new HomeFragment();
        mAdvisoryFragment = new AdvisoryFragment();
        mLiveFragment = new LiveFragment();
        mLordFragment = new LordFragment();
        mThoughtsFragment = new ThoughtsFragment();

    }

    /**
     * RadioGroup的点击事件
     */
    private void initRadio() {
        mRadioGroup = (RadioGroup) findViewById(R.id.rgTabBar);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbTabHome:
                        changeTab(TAB_HOME);
                        //Toast.makeText(MainActivity.this, "home", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.rbTabAdvisory:
                        changeTab(TAB_ADVISORY);
                        // Toast.makeText(MainActivity.this, "advistory", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.rbTabLord:
                        changeTab(TAB_LORD);
                        // Toast.makeText(MainActivity.this, "lord", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.rbTabThoughts:
                        changeTab(TAB_THOURGHTS);
                        //  Toast.makeText(MainActivity.this, "thoughts", Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });


    }


    /**
     * 改变Tab
     *
     * @param checkId index
     */
    private void changeTab(int checkId) {
        switch (checkId) {
            case TAB_HOME:
                CURRENT_ITEM = TAB_HOME;
                showFragment(TAB_HOME);
                mRadioHome.setChecked(true);
                break;
            case TAB_ADVISORY:
                CURRENT_ITEM = TAB_ADVISORY;
                showFragment(TAB_ADVISORY);
                mRadioAdvisory.setChecked(true);
                break;
            case TAB_LIVE:
                CURRENT_ITEM = TAB_LIVE;

                //  mRadioHome.setChecked(false);
                //mRadioLord.setChecked(false);
                //mRadioThoughts.setChecked(false);
                //mRadioAdvisory.setChecked(false);
                mRadioLive.setChecked(true);  //虽然这个没有用到，但是为了在点击这个live图片的时候
                //使得其他的处于未点击状态，需要这个为true(RadioGroup的互斥事件)

                showFragment(TAB_LIVE);


                break;
            case TAB_LORD:
                CURRENT_ITEM = TAB_LORD;
                showFragment(TAB_LORD);
                mRadioLord.setChecked(true);
                break;
            case TAB_THOURGHTS:
                CURRENT_ITEM = TAB_THOURGHTS;
                mRadioThoughts.setChecked(true);
                showFragment(TAB_THOURGHTS);
                break;
        }
    }


    /**
     * hide所有的fragment
     */
    private void hideFragment() {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        transaction.hide(mHomeFragment);
        transaction.hide(mAdvisoryFragment);
        transaction.hide(mLiveFragment);
        transaction.hide(mLordFragment);
        transaction.hide(mThoughtsFragment);
        transaction.commit();
    }


    /**
     * 显示Fragment
     *
     * @param tab 当前需要显示的位置
     */
    private void showFragment(int tab) {
        hideFragment();
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        switch (tab) {
            case TAB_HOME:
                transaction.show(mHomeFragment);
                break;
            case TAB_ADVISORY:
                transaction.show(mAdvisoryFragment);
                break;
            case TAB_LIVE:
                transaction.show(mLiveFragment);
                break;
            case TAB_LORD:
                transaction.show(mLordFragment);
                break;
            case TAB_THOURGHTS:
                transaction.show(mThoughtsFragment);
                break;
        }
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_img:
                changeTab(TAB_LIVE);

                // Toast.makeText(this, "live", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
