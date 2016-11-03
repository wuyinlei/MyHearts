package ruolan.com.myhearts.ui.left;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.contant.Contants;
import ruolan.com.myhearts.entity.MyUser;
import ruolan.com.myhearts.event.LoginEvent;
import ruolan.com.myhearts.event.LoginOut;
import ruolan.com.myhearts.ui.login.LoginActivity;
import ruolan.com.myhearts.ui.main.MainActivityDrawerLayout;
import ruolan.com.myhearts.ui.left.setting.SettingActivity;
import ruolan.com.myhearts.ui.user.UserActivity;
import ruolan.com.myhearts.utils.PreferencesUtils;
import ruolan.com.myhearts.widget.GlideCircleTransform;

/**
 * Created by Administrator on 2016/10/24.
 */

public class LeftFragment extends Fragment implements View.OnClickListener {


    /*左侧menu事件控件*/
    RelativeLayout mReLogin;
    LinearLayout mLiReserve;
    LinearLayout mLiFollow;

    LinearLayout mLiContact;

    LinearLayout mLiMoney;

    LinearLayout mLiGift;

    LinearLayout mLiWorry;

    RelativeLayout mReSetting;

    private TextView mTvName, mBtLogin;
    private ImageView mIvTour;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onResume() {
        super.onResume();

        boolean isLogin = PreferencesUtils.getBoolean(getContext(), Contants.IS_LOGIN);
        if (isLogin) {
            String name = PreferencesUtils.getString(getContext(), Contants.USER_NAME);
            // updateUi(name);
        } else {
            //loginOutUi();
        }
    }

    private void loginOutUi() {
        PreferencesUtils.putBoolean(getContext(), Contants.IS_LOGIN, false);
        mReLogin.setClickable(true);
        if (mTvName != null) {
            mTvName.setText("");
        }
        if (mBtLogin != null) {
            String loginOut = getContext().getResources()
                    .getString(R.string.login_in);
            mBtLogin.setText(loginOut);
        }
        if (mIvTour != null) {
            Glide.with(getContext()).load(R.drawable.login_out)
                    .asBitmap().transform(new GlideCircleTransform(getContext()))
                    .into(mIvTour);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void LoginInEvent(LoginEvent event) {

        if (event != null) {
            mReLogin.setClickable(false);
        }

        mTvName.setText(event.mMyUser.getUsername());
        mTvName.setClickable(true);
        mTvName.setOnClickListener(this);
        if (event.mMyUser.getImgurl() == null) {
            Glide.with(getContext()).load(R.drawable.user_avatour)
                    .asBitmap().transform(new GlideCircleTransform(getContext()))
                    .into(mIvTour);

        } else {
            Log.d("LeftFragment", "imgurl" + event.mMyUser.getImgurl());
            Glide.with(getContext()).load(event.mMyUser.getImgurl())
                    .asBitmap().transform(new GlideCircleTransform(getContext()))
                    .into(mIvTour);


        }
        mIvTour.setClickable(true);
        mIvTour.setOnClickListener(this);
        if (mBtLogin != null) {
            String loginOut = getContext().getResources()
                    .getString(R.string.login_out);
            mBtLogin.setText(loginOut);
        }

    }

    private void updateUi(String name) {
        if (mTvName != null) {
            mTvName.setText(name);
        }
        if (mBtLogin != null) {
            String loginOut = getContext().getResources()
                    .getString(R.string.login_out);
            mBtLogin.setText(loginOut);
        }
        if (mIvTour != null) {
            Glide.with(getContext()).load(R.drawable.user_avatour)
                    .asBitmap().transform(new GlideCircleTransform(getContext()))
                    .into(mIvTour);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left, container, false);
        EventBus.getDefault().register(this);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mReLogin = (RelativeLayout) view.findViewById(R.id.rl_login);
        mTvName = (TextView) view.findViewById(R.id.tv_name);
        mTvName.setClickable(false);
        mBtLogin = (TextView) view.findViewById(R.id.tv_login);
        mBtLogin.setOnClickListener(this);
        mIvTour = (ImageView) view.findViewById(R.id.img_avatar);
        mIvTour.setClickable(false);
        mReLogin.setOnClickListener(this);
        mLiReserve = (LinearLayout) view.findViewById(R.id.my_message);
        mLiReserve.setOnClickListener(this);
        mLiFollow = (LinearLayout) view.findViewById(R.id.my_follow);
        mLiFollow.setOnClickListener(this);
        mLiContact = (LinearLayout) view.findViewById(R.id.my_contact);
        mLiContact.setOnClickListener(this);
        mLiMoney = (LinearLayout) view.findViewById(R.id.my_money);
        mLiMoney.setOnClickListener(this);
        mLiGift = (LinearLayout) view.findViewById(R.id.my_gift);
        mLiGift.setOnClickListener(this);
        mLiWorry = (LinearLayout) view.findViewById(R.id.my_worry);
        mLiWorry.setOnClickListener(this);
        mReSetting = (RelativeLayout) view.findViewById(R.id.re_setting);
        mReSetting.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        boolean isTologin = false;
        switch (v.getId()) {

            case R.id.rl_login:
                intent.setClass(getActivity(), LoginActivity.class);
                //isLogin = false;
                break;
            case R.id.my_message:
                intent.setClass(getContext(), MessageActivity.class);
                break;
            case R.id.my_contact:
                intent.setClass(getContext(), ContactActivity.class);
                break;
            case R.id.my_follow:
                intent.setClass(getContext(), FollowActivity.class);
                break;
            case R.id.my_money:
                intent.setClass(getContext(), MoneyActivity.class);
                break;
            case R.id.my_gift:
                intent.setClass(getContext(), GiftActivity.class);
                break;
            case R.id.my_reserve:
                intent.setClass(getContext(), ReserveActivity.class);
                break;
            case R.id.my_worry:
                intent.setClass(getContext(), WorryActivity.class);
                break;
            case R.id.re_setting:
                intent.setClass(getContext(), SettingActivity.class);
                break;

            case R.id.tv_login:
                //退出登录
                if (mBtLogin.getText().equals(getContext().getResources()
                        .getString(R.string.login_out))) {
                    loginOutUi();
                    MyUser.logOut();
                    PreferencesUtils.putString(getActivity(),
                            Contants.USER_NAME, "");
                    PreferencesUtils.putString(getContext(),
                            Contants.USER_PASSWORD, "");
                    mTvName.setText(getActivity().getResources().getString(R.string.login_in));
                    EventBus.getDefault().post(new LoginOut(true));
                    isTologin = true;
                } else if (mBtLogin.getText().equals(getContext().getResources()
                        .getString(R.string.login_in))) {
                    intent.setClass(getActivity(), LoginActivity.class);
                }
                break;
            case R.id.img_avatar:
            case R.id.tv_name:
                if (mBtLogin.getText().equals(getContext().getResources()
                        .getString(R.string.login_in))) {
                    intent.setClass(getActivity(), LoginActivity.class);
                } else if (mBtLogin.getText().equals(getContext().getResources()
                        .getString(R.string.login_out))) {
                    intent.setClass(getActivity(), UserActivity.class);
                }
                break;


        }
        ((MainActivityDrawerLayout) getActivity())
                .getDragLayout()
                .closeDrawer(GravityCompat.START);
        if (!isTologin) {
            startActivity(intent);
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
