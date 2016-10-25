package ruolan.com.myhearts.ui.left;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.contant.Contants;
import ruolan.com.myhearts.ui.login.LoginActivity;
import ruolan.com.myhearts.ui.main.MainActivityDrawerLayout;
import ruolan.com.myhearts.ui.left.setting.SettingActivity;
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

    private TextView mTvName,mBtLogin;
    private ImageView mIvTour;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onResume() {
        super.onResume();

        boolean isLogin = PreferencesUtils.getBoolean(getContext(), Contants.IS_LOGIN);
        if (isLogin){
            String name = PreferencesUtils.getString(getContext(),Contants.USER_NAME);
            updateUi(name);
        }
    }

    private void updateUi(String name) {
        if (mTvName!=null){
            mTvName.setText(name);
        }
        if (mBtLogin != null){
            String loginOut = getContext().getResources()
                    .getString(R.string.login_out);
            mBtLogin.setText(loginOut);
        }
        if (mIvTour!=null){
            Glide.with(getContext()).load(R.drawable.user_avatour)
                    .asBitmap().transform(new GlideCircleTransform(getContext()))
                    .into(mIvTour);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mReLogin = (RelativeLayout) view.findViewById(R.id.rl_login);
        mTvName = (TextView) view.findViewById(R.id.tv_name);
        mBtLogin = (TextView) view.findViewById(R.id.tv_login);
        mIvTour = (ImageView) view.findViewById(R.id.img_avatar);
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
