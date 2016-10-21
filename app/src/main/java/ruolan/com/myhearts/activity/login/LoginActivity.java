package ruolan.com.myhearts.activity.login;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.activity.base.BaseActivity;
import ruolan.com.myhearts.widget.CheckBox;

public class LoginActivity extends BaseActivity {


    EditText mEtPhone;  //手机号
    EditText mEtPassword;  //密码
    CheckBox mIsPasswordMemory;  //是否记住密码
    TextView mTvForgetPassword; //忘记密码

    TextView mRegisterAccount;  //注册账号
    TextView mApplicationConsultant;  //申请咨询师
    ImageView mQqLogin;  //qq登录
    ImageView mSinaLogin;  //新浪登录
    ImageView mWxLogin;  //微信登录



    @Override
    protected int getResultId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void initView() {
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






}
