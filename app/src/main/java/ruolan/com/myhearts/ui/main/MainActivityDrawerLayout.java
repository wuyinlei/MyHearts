package ruolan.com.myhearts.ui.main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.nineoldandroids.view.ViewHelper;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.update.BmobUpdateAgent;
import cn.jpush.android.api.JPushInterface;
import ruolan.com.myhearts.R;
import ruolan.com.myhearts.contant.Contants;
import ruolan.com.myhearts.entity.MyUser;
import ruolan.com.myhearts.event.LoginEvent;
import ruolan.com.myhearts.ui.base.BaseActivity;
import ruolan.com.myhearts.ui.fragment.live.LiveFragment;
import ruolan.com.myhearts.ui.fragment.advisory.AdvisoryFragment;
import ruolan.com.myhearts.ui.fragment.home.HomeFragment;
import ruolan.com.myhearts.ui.fragment.lord.LordFragment;
import ruolan.com.myhearts.ui.fragment.thoughts.ThoughtsFragment;
import ruolan.com.myhearts.ui.left.LeftFragment;
import ruolan.com.myhearts.utils.ExampleUtil;
import ruolan.com.myhearts.utils.PreferencesUtils;
import ruolan.com.myhearts.widget.left.DragLayout;

public class MainActivityDrawerLayout extends BaseActivity implements View.OnClickListener {

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

    private DrawerLayout mDrawerLayout;

    private DragLayout mDragLayout;


    @Override
    protected int getResultId() {
        return R.layout.activity_main_drawer_layout;
    }

    @Override
    protected void initListener() {
        mDrawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                View mContent = mDrawerLayout.getChildAt(0);
                View mMenu = drawerView;
                float scale = 1 - slideOffset;
                float rightScale = 0.8f + scale * 0.2f;

                if (drawerView.getTag().equals("LEFT")) {

                    float leftScale = 1 - 0.3f * scale;

                    ViewHelper.setScaleX(mMenu, leftScale);
                    ViewHelper.setScaleY(mMenu, leftScale);
                    ViewHelper.setAlpha(mMenu, 0.6f + 0.4f * (1 - scale));
                    ViewHelper.setTranslationX(mContent,
                            mMenu.getMeasuredWidth() * (1 - scale));
                    ViewHelper.setPivotX(mContent, 0);
                    ViewHelper.setPivotY(mContent,
                            mContent.getMeasuredHeight() / 2);
                    mContent.invalidate();
                    ViewHelper.setScaleX(mContent, rightScale);
                    ViewHelper.setScaleY(mContent, rightScale);
                } else {
                    ViewHelper.setTranslationX(mContent,
                            -mMenu.getMeasuredWidth() * slideOffset);
                    ViewHelper.setPivotX(mContent, mContent.getMeasuredWidth());
                    ViewHelper.setPivotY(mContent,
                            mContent.getMeasuredHeight() / 2);
                    mContent.invalidate();
                    ViewHelper.setScaleX(mContent, rightScale);
                    ViewHelper.setScaleY(mContent, rightScale);
                }
            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                mDrawerLayout.setDrawerLockMode(
                        DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.RIGHT);
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }


    // 初始化 JPush。如果已经初始化，但没有登录成功，则执行重新登录。
    private void init() {
        JPushInterface.init(getApplicationContext());
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

    public DrawerLayout getDragLayout() {
        return mDrawerLayout;
    }

    /**
     * 初始化布局控件
     */
    public void initView() {
        ButterKnife.bind(this);

        BmobUpdateAgent.setUpdateOnlyWifi(false);  //判断是否是wifi网络
        BmobUpdateAgent.update(this); //检测是否有更新

        MyUser myUser = BmobUser.getCurrentUser(MyUser.class);

        //  EventBus.getDefault().register(this);
        if (myUser != null) {
            EventBus.getDefault().post(new LoginEvent(myUser));
            Log.d("SplashActivity", "myUser:" + myUser);
        }

        boolean isLogin = getIntent().getBooleanExtra(Contants.IS_COME_FROM_LOGIN, false);
        if (isLogin) {  //登录状态
            PreferencesUtils.putBoolean(this, Contants.IS_LOGIN, true);
        }

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


        //  mDragLayout = (MyDragLayout) findViewById(R.id.qq_slidding);

        mIvLive = (ImageView) findViewById(R.id.img_live);

        mFrameLayout = (FrameLayout) findViewById(R.id.container);

        mRadioHome = (RadioButton) findViewById(R.id.rbTabHome);
        mRadioAdvisory = (RadioButton) findViewById(R.id.rbTabAdvisory);
        mRadioLord = (RadioButton) findViewById(R.id.rbTabLord);
        mRadioThoughts = (RadioButton) findViewById(R.id.rbTabThoughts);
        mRadioLive = (RadioButton) findViewById(R.id.rbTabMall);
        mRadioHome.setChecked(true);

        initLeftDrawer();

        initAnimation();


        initFragment();

        addFragment();
        initRadio();

        mIvImg.setOnClickListener(this);

        registerMessageReceiver();  // used for receive msg

    }

    /**
     * 左侧菜单栏逻辑
     */
    private void initLeftDrawer() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, null, R.string.open, R.string.close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        //替换左侧布局 填充成fragment
        getSupportFragmentManager().beginTransaction().add(R.id.framlayout, new LeftFragment()).commit();
    }

//    /*左侧menu事件控件*/
//    RelativeLayout mReLogin;
//    LinearLayout mLiReserve;
//    LinearLayout mLiFollow;
//
//    LinearLayout mLiContact;
//
//    LinearLayout mLiMoney;
//
//    LinearLayout mLiGift;
//
//    LinearLayout mLiWorry;
//
//    RelativeLayout mReSetting;
//


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
        mRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
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

        Intent intent = new Intent();
        // boolean isLogin = true;
        boolean isLogin = PreferencesUtils.getBoolean(this, Contants.IS_LOGIN, false);

        switch (v.getId()) {
            case R.id.img_img:

                changeTab(TAB_LIVE);
             //   intent.setClass(MainActivityDrawerLayout.this, LiveFragment.class);
                // Toast.makeText(this, "live", Toast.LENGTH_SHORT).show();
                break;

        }
//
    }


    //for receive customer msg from jpush server
    private MessageReceiver mMessageReceiver;
    public static final String MESSAGE_RECEIVED_ACTION = "com.example.jpushdemo.MESSAGE_RECEIVED_ACTION";
    public static final String KEY_TITLE = "title";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_EXTRAS = "extras";
    public static boolean isForeground = false;


    public void registerMessageReceiver() {
        mMessageReceiver = new MessageReceiver();
        IntentFilter filter = new IntentFilter();
        filter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
        filter.addAction(MESSAGE_RECEIVED_ACTION);
        registerReceiver(mMessageReceiver, filter);
    }

    public class MessageReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (MESSAGE_RECEIVED_ACTION.equals(intent.getAction())) {
                String messge = intent.getStringExtra(KEY_MESSAGE);
                String extras = intent.getStringExtra(KEY_EXTRAS);
                StringBuilder showMsg = new StringBuilder();
                showMsg.append(KEY_MESSAGE + " : " + messge + "\n");
                if (!ExampleUtil.isEmpty(extras)) {
                    showMsg.append(KEY_EXTRAS + " : " + extras + "\n");
                }
                //  setCostomMsg(showMsg.toString());
            }
        }
    }


    @Override
    protected void onResume() {
        isForeground = true;
        super.onResume();
    }


    @Override
    protected void onPause() {
        isForeground = false;
        super.onPause();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mMessageReceiver);
        EventBus.getDefault().unregister(this);
    }
}
