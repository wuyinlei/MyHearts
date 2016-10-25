package ruolan.com.myhearts.ui.login;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import cn.bmob.v3.BmobUser;
import ruolan.com.myhearts.R;
import ruolan.com.myhearts.contant.Contants;
import ruolan.com.myhearts.ui.base.BaseActivity;
import ruolan.com.myhearts.ui.main.MainActivityDrawerLayout;
import ruolan.com.myhearts.ui.register.RegisterActivity;
import ruolan.com.myhearts.utils.PreferencesUtils;
import ruolan.com.myhearts.utils.RegularUtils;
import ruolan.com.myhearts.widget.CheckBox;
import rx.Subscriber;
import rx.subjects.Subject;

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


    @Override
    protected int getResultId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initListener() {
        mQqLogin.setOnClickListener(this);
        mRegisterAccount.setOnClickListener(this);
    }

    @Override
    public void initData() {
        mUserName = PreferencesUtils.getString(this, Contants.USER_NAME);
        mPassWord = PreferencesUtils.getString(this, Contants.USER_PASSWORD);
        if (!TextUtils.isEmpty(mUserName)) {
            mEtPhone.setText(mUserName);
        }
        if (!TextUtils.isEmpty(mPassWord)) {
            mEtPassword.setText(mPassWord);
        }

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
        final BmobUser bmobUser = new BmobUser();
        bmobUser.setUsername(name);
        bmobUser.setPassword(pwd);

        bmobUser.loginObservable(BmobUser.class).subscribe(new Subscriber<BmobUser>() {
            @Override
            public void onCompleted() {
                Toast.makeText(LoginActivity.this,
                        getResources().getString(R.string.login_success),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BmobUser bmobUser) {
                if (!mIsPasswordMemory.isChecked()) {  //如果用户没有点击记住密码  那就清除密码
                    PreferencesUtils.putString(LoginActivity.this, Contants.USER_PASSWORD, "");
                } else { //否则就保存密码
                    PreferencesUtils.putString(LoginActivity.this, Contants.USER_PASSWORD, pwd);
                }
                Intent intent = new Intent(LoginActivity.this, MainActivityDrawerLayout.class);
                intent.putExtra(Contants.IS_COME_FROM_LOGIN, true);
                startActivity(intent);
                finish();
            }

        });

    }

    @Override
    public void initView() {
        mReLogin = (RelativeLayout) findViewById(R.id.re_login);
        mReLogin.setOnClickListener(this);
        mEtPhone = (EditText) findViewById(R.id.et_phone);
        mEtPassword = (EditText) findViewById(R.id.et_password);
        mIsPasswordMemory = (CheckBox) findViewById(R.id.is_password_memory);
        mTvForgetPassword = (TextView) findViewById(R.id.tv_forget_password);
        mRegisterAccount = (TextView) findViewById(R.id.register_account);
        mApplicationConsultant = (TextView) findViewById(R.id.application_consultant);
        mQqLogin = (ImageView) findViewById(R.id.qq_login);
        mSinaLogin = (ImageView) findViewById(R.id.sina_login);
        mWxLogin = (ImageView) findViewById(R.id.wx_login);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_account:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;

            case R.id.re_login:
                if (!TextUtils.isEmpty(mName) && !TextUtils.isEmpty(mPwd))
                    toLogin(mName, mPwd);
                break;
        }
    }
}
