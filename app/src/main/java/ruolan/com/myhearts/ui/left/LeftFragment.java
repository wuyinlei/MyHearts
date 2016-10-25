package ruolan.com.myhearts.ui.left;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.ui.login.LoginActivity;
import ruolan.com.myhearts.ui.main.MainActivityDrawerLayout;
import ruolan.com.myhearts.ui.left.setting.SettingActivity;

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


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mReLogin = (RelativeLayout) view.findViewById(R.id.rl_login);
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
        }
        ((MainActivityDrawerLayout)getActivity())
                .getDragLayout()
                .closeDrawer(GravityCompat.START);
        startActivity(intent);
    }
}
