package ruolan.com.myhearts.ui.login;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.tencent.connect.UserInfo;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import ruolan.com.myhearts.R;
import ruolan.com.myhearts.contant.Contants;
import ruolan.com.myhearts.entity.MyUser;
import ruolan.com.myhearts.event.LoginEvent;
import ruolan.com.myhearts.ui.base.BaseActivity;
import ruolan.com.myhearts.ui.main.MainActivityDrawerLayout;
import ruolan.com.myhearts.ui.register.RegisterActivity;
import ruolan.com.myhearts.utils.PreferencesUtils;
import ruolan.com.myhearts.utils.Util;
import ruolan.com.myhearts.widget.CheckBox;
import ruolan.com.myhearts.widget.dialog.CustomPrograss;
import rx.Subscriber;

import static ruolan.com.myhearts.R.id.re_login;

public class LoginActivity extends BaseActivity implements View.OnClickListener {


    EditText mEtPhone;  //手机号
    EditText mEtPassword;  //密码
    CheckBox mIsPasswordMemory;  //是否记住密码
    TextView mTvForgetPassword; //忘记密码

    TextView mRegisterAccount;  //注册账号
    TextView mApplicationConsultant;  //申请咨询师
    ImageView mQqLogin;  //qq登录
    ImageView mSinaLogin;  //新浪登录
    ImageView mWxLogin;  //微信登录
    private String mUserName;
    private String mPassWord;

    private RelativeLayout mReLogin;
    private String mName;
    private String mPwd;
    private static Tencent mTencent;
    private BaseUiListener mUiListener;

    private UserInfo mInfo = null;


    @Override
    protected int getResultId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initListener() {
        mQqLogin.setOnClickListener(this);
        mRegisterAccount.setOnClickListener(this);
        mTvForgetPassword.setOnClickListener(this);
        mReLogin.setOnClickListener(this);
    }

    @Override
    public void initData() {

        mName = mEtPhone.getText().toString().trim();
//        if (!RegularUtils.isMobileExact(name)){
//            Toast.makeText(this, getResources().getString(R.string.is_not_phone), Toast.LENGTH_SHORT).show();
//            return;
//        }

        mPwd = mEtPassword.getText().toString().trim();

        // toLogin(name,pwd);

    }

    /**
     * 登录账户
     *
     * @param name 用户名
     * @param pwd  密码
     */
    private void toLogin(String name, String pwd) {

        CustomPrograss.show(this, getResources().getString(R.string.loading), false, null);
        final BmobUser bmobUser = new BmobUser();
        bmobUser.setUsername(name);
        bmobUser.setPassword(pwd);

        bmobUser.loginObservable(BmobUser.class).subscribe(new Subscriber<BmobUser>() {
            @Override
            public void onCompleted() {
                CustomPrograss.disMiss();
                Toast.makeText(LoginActivity.this,
                        getResources().getString(R.string.login_success),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {
                CustomPrograss.disMiss();
            }

            @Override
            public void onNext(BmobUser bmobUser) {


                if (!mIsPasswordMemory.isChecked()) {  //如果用户没有点击记住密码  那就清除密码
                    PreferencesUtils.putBoolean(LoginActivity.this, "is_select", false);
                    PreferencesUtils.putString(LoginActivity.this, "pwd", "");
                    PreferencesUtils.putString(LoginActivity.this,"user","");
                } else { //否则就保存密码
                    PreferencesUtils.putBoolean(LoginActivity.this, "is_select", true);
                    PreferencesUtils.putString(LoginActivity.this, "pwd", pwd);
                    PreferencesUtils.putString(LoginActivity.this,"user",name);
                }


                MyUser myUser = BmobUser.getCurrentUser(MyUser.class);
             //   myUser.setUsername(name);
                EventBus.getDefault().post(new LoginEvent(myUser));

               // Intent intent = new Intent(LoginActivity.this, MainActivityDrawerLayout.class);
              //  intent.putExtra(Contants.IS_COME_FROM_LOGIN, true);
               // startActivity(intent);
                finish();
            }

        });


    }

    @Override
    public void initView() {

        //QQ的初始化
        mTencent = Tencent.createInstance("1105704769", this.getApplicationContext());
        mInfo = new UserInfo(this, mTencent.getQQToken());

        mReLogin = (RelativeLayout) findViewById(re_login);

        mEtPhone = (EditText) findViewById(R.id.et_phone);
        mEtPassword = (EditText) findViewById(R.id.et_password);
        mIsPasswordMemory = (CheckBox) findViewById(R.id.is_password_memory);
        boolean isSelect = PreferencesUtils.getBoolean(LoginActivity.this, "is_select");
        mIsPasswordMemory.setChecked(isSelect);
        mTvForgetPassword = (TextView) findViewById(R.id.tv_forget_password);
        mRegisterAccount = (TextView) findViewById(R.id.register_account);
        mApplicationConsultant = (TextView) findViewById(R.id.application_consultant);
        mQqLogin = (ImageView) findViewById(R.id.qq_login);
        mSinaLogin = (ImageView) findViewById(R.id.sina_login);
        mWxLogin = (ImageView) findViewById(R.id.wx_login);

        String username = PreferencesUtils.getString(this, "user");
        String password = PreferencesUtils.getString(this, "pwd");
        if (!TextUtils.isEmpty(username)) {
            mEtPhone.setText(username);
        }
        if (!TextUtils.isEmpty(password)) {
            mEtPassword.setText(password);
        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_account:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;

            case re_login:
                mName = mEtPhone.getText().toString().trim();
                mPwd = mEtPassword.getText().toString().trim();
                if (!TextUtils.isEmpty(mName) && !TextUtils.isEmpty(mPwd))
                    toLogin(mName, mPwd);
                break;

            case R.id.tv_forget_password:
                changePassword();
                break;

            case R.id.qq_login:
                //onClickLogin();

                mTencent.login(this, "all", loginListener);

                break;

        }
    }

    /**
     * 忘记密码之后修改密码
     * <p>
     * 只对于注册用户，如果是第三方登录的用户，可以自己去修改第三方
     * 密码之后再进行登录
     */
    private void changePassword() {
        new MaterialDialog.Builder(this)
                .title(getResources().getString(R.string.change_password))
                .items(R.array.password)
                .backgroundColor(getResources().getColor(R.color.dialog_bg))
                .itemsCallback((dialog, itemView, position, text) -> {
                    if (position == 0) {
                        Intent intent = new Intent(LoginActivity.this, CorrectPasswordFirst.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this,
                                getResources().getString(R.string.new_function),
                                Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }

    private void updateUserInfo() {
        if (mTencent != null && mTencent.isSessionValid()) {
            IUiListener listener = new IUiListener() {

                @Override
                public void onError(UiError e) {

                }

                @Override
                public void onComplete(final Object response) {
                    Message msg = new Message();
                    msg.obj = response;
                    msg.what = 0;
                    mHandler.sendMessage(msg);
                    new Thread() {

                        @Override
                        public void run() {
                            JSONObject json = (JSONObject) response;
                            if (json.has("figureurl")) {
                                Bitmap bitmap = null;
                                try {
                                    bitmap = Util.getbitmap(json.getString("figureurl_qq_2"));
                                } catch (JSONException e) {

                                }
                                Message msg = new Message();
                                msg.obj = bitmap;
                                msg.what = 1;
                                mHandler.sendMessage(msg);
                            }
                        }

                    }.start();
                    finish();
                }

                @Override
                public void onCancel() {

                }
            };
            mInfo = new UserInfo(this, mTencent.getQQToken());
            mInfo.getUserInfo(listener);

        } else {
//            mUserInfo.setText("");
//            mUserInfo.setVisibility(android.view.View.GONE);
//            mUserLogo.setVisibility(android.view.View.GONE);
        }
    }

    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                //SharedPreferencesUtils.setParam(LoginActivity.this,"isLogin",true);
                JSONObject response = (JSONObject) msg.obj;
//                if (response.has("nickname")) {
//                    try {
//                        mUserInfo.setVisibility(android.view.View.VISIBLE);
//                        mUserInfo.setText(response.getString("nickname"));
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
                String nickname = null;
                boolean sex = false;
                String imgurl = null;
                String location = null;
                try {
                    Log.d("ruolanmingyue", "response:" + response);
                    nickname = response.getString("nickname");
                    imgurl = response.getString("figureurl_qq_2");
                    sex = response.getString("gender").equals("男") ? true : false;
                    location = response.getString("city");
                    MyUser user = new MyUser();
                    user.setUsername(nickname);
                    user.setImgurl(imgurl);
                    user.setInstance(location);
                    user.setSex(sex);


//                    ThirdPartUser thirdPartUser = new ThirdPartUser();
//                    thirdPartUser.setUsername(nickname);
//                    thirdPartUser.setCity(location);
//                    thirdPartUser.setSex(sex == false ? "1" : "0");
//                    thirdPartUser.setImgUrl(imgurl);
//
//                    BmobQuery<ThirdPartUser> query = new BmobQuery<>();
//                   // query.
//                    thirdPartUser.

                    user.setPassword("123456asd");  //如果是第三方进入的，默认密码123456asd
                    user.signUp(new SaveListener<MyUser>() {
                        @Override
                        public void done(MyUser o, BmobException e) {
                            if (e == null) {

                            } else {

                                //Toast.makeText(LoginActivity.this, getResources().getString(R.string.register_failed), Toast.LENGTH_SHORT).show();
                            }
                        }


                    });

                    PreferencesUtils.putString(LoginActivity.this,
                            Contants.USER_NAME, nickname);
                    PreferencesUtils.putString(LoginActivity.this,
                            Contants.USER_PASSWORD, "123456asd");


//                    addSubscription(user.signUp(new SaveListener<MyUser>() {
//                        @Override
//                        public void done(MyUser myUser, BmobException e) {
//                            if (e == null) {
//    //                            Toast.makeText(LoginActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
//  //                              PreferencesUtils.putString(LoginActivity.this,Contants.USER_NAME,userName);
////                                startActivity(new Intent(LoginActivity.this, LoginActivity.class));
//                            } else {
//                                //注册失败
//                            }
//                        }
//                    }));

                    Log.d("ruolanmingyue", nickname);
                    PreferencesUtils.putBoolean(LoginActivity.this, Contants.IS_LOGIN, true);
                    EventBus.getDefault().post(new LoginEvent(user));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } else if (msg.what == 1) {
                Bitmap bitmap = (Bitmap) msg.obj;
                Log.d("ruolan", "msg.obj:" + msg.obj);
                // EventBus.getDefault().post(bitmap);
//                mUserLogo.setImageBitmap(bitmap);
//                mUserLogo.setVisibility(android.view.View.VISIBLE);
            }
        }
    };


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("ruolan", "-->onActivityResult " + requestCode + " resultCode=" + resultCode);
        if (requestCode == Constants.REQUEST_LOGIN ||
                requestCode == Constants.REQUEST_APPBAR) {
            Tencent.onActivityResultData(requestCode, resultCode, data, loginListener);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }


    IUiListener loginListener = new BaseUiListener() {
        @Override
        protected void doComplete(JSONObject values) {
            Log.d(TAG, "ruolanmingyue:" + values);
            Log.d("SDKQQAgentPref", "AuthorSwitch_SDK:" + SystemClock.elapsedRealtime());
            initOpenidAndToken(values);

            //下面的这个必须放到这个地方，要不然就会出错   哎，，，，，调整了近一个小时，，，，我是服我自己了
            updateUserInfo();
        }
    };


    public static void initOpenidAndToken(JSONObject jsonObject) {
        try {
            String token = jsonObject.getString(Constants.PARAM_ACCESS_TOKEN);
            String expires = jsonObject.getString(Constants.PARAM_EXPIRES_IN);
            String openId = jsonObject.getString(Constants.PARAM_OPEN_ID);
            if (!TextUtils.isEmpty(token) && !TextUtils.isEmpty(expires)
                    && !TextUtils.isEmpty(openId)) {
                mTencent.setAccessToken(token, expires);
                mTencent.setOpenId(openId);
            }
        } catch (Exception e) {
        }
    }

    private class BaseUiListener implements IUiListener {

        @Override
        public void onComplete(Object response) {
            if (null == response) {
                // Util.showResultDialog(LoginActivity.this, "返回为空", "登录失败");
                return;
            }
            JSONObject jsonResponse = (JSONObject) response;
            if (null != jsonResponse && jsonResponse.length() == 0) {
                //  Util.showResultDialog(LoginActivity.this, "返回为空", "登录失败");
                return;
            }
            doComplete((JSONObject) response);
        }

        @Override
        public void onError(UiError e) {
            Util.toastMessage(LoginActivity.this, "onError: " + e.errorDetail);

        }

        @Override
        public void onCancel() {
            Util.toastMessage(LoginActivity.this, "onCancel: ");

        }

        protected void doComplete(JSONObject values) {

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //进行反注册
        EventBus.getDefault().unregister(this);
    }


}
