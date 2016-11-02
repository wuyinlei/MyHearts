package ruolan.com.myhearts.ui.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.utils.SMSLog;
import ruolan.com.myhearts.R;
import ruolan.com.myhearts.ui.base.BaseActivity;
import ruolan.com.myhearts.ui.register.RegisterActivity;
import ruolan.com.myhearts.ui.register.RegisterSecondActivity;
import ruolan.com.myhearts.utils.ToastUtils;
import ruolan.com.myhearts.widget.CheckBox;
import ruolan.com.myhearts.widget.ClearEditText;

public class CorrectPasswordFirst extends BaseActivity implements View.OnClickListener {

    ImageView mIvBack;
    RelativeLayout mTitleRe;
    TextView mTxtCountry;
    TextView mTxtCountryCode;
    TextView mNext;
    ClearEditText mEtPhone;
   // ClearEditText mEtPassword;
   // CheckBox mAgreeUserAgreement;
    // 默认使用中国区号
    private static final String DEFAULT_COUNTRY_ID = "42";

    //private  EvenHanlder evenHanlder;
    private EventHandler eventHandler;

    @Override
    protected int getResultId() {
        return R.layout.activity_correct_password_first;
    }

    @Override
    protected void initListener() {
        mIvBack.setOnClickListener(this);
        mNext.setOnClickListener(this);
    }

    @Override
    public void initView() {
        mIvBack = (ImageView) findViewById(R.id.iv_back);
        mTxtCountry = (TextView) findViewById(R.id.txtCountry);
        mNext = (TextView) findViewById(R.id.tv_next);
        mTxtCountryCode = (TextView) findViewById(R.id.txtCountryCode);
        mEtPhone = (ClearEditText) findViewById(R.id.edittxt_phone);
       // mEtPassword = (ClearEditText) findViewById(R.id.edittxt_pwd);
     //   mAgreeUserAgreement = (CheckBox) findViewById(R.id.agree_user_agreement);
    }

    @Override
    public void initData() {
        eventHandler = new SMSEvenHanlder();
        SMSSDK.registerEventHandler(eventHandler);


        String[] country = SMSSDK.getCountry(DEFAULT_COUNTRY_ID);
        if (country != null) {

            mTxtCountryCode.setText("+" + country[1]);

            mTxtCountry.setText(country[0]);

        }


    }

    class SMSEvenHanlder extends EventHandler {


        @Override
        public void afterEvent(final int event, final int result,
                               final Object data) {

            runOnUiThread(() -> {

                if (result == SMSSDK.RESULT_COMPLETE) {
                    if (event == SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES) {

                        onCountryListGot((ArrayList<HashMap<String, Object>>) data);

                    } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                        // 请求验证码后，跳转到验证码填写页面

                        afterVerificationCodeRequested((Boolean) data);

                    } else if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {

                    }
                } else {

                    // 根据服务器返回的网络错误，给toast提示
                    try {
                        ((Throwable) data).printStackTrace();
                        Throwable throwable = (Throwable) data;

                        JSONObject object = new JSONObject(
                                throwable.getMessage());
                        String des = object.optString("detail");
                        if (!TextUtils.isEmpty(des)) {
                            //ToastUtils.show(RegActivity.this, des);
                            return;
                        }
                    } catch (Exception e) {
                        SMSLog.getInstance().w(e);
                    }
                }

            });
        }
    }


    /**
     * 获取到国家编码
     */
    private void getCode() {

        String phone = mEtPhone.getText().toString().trim().replaceAll("\\s*", "");
        String code = mTxtCountryCode.getText().toString().trim();
     //   String pwd = mEtPassword.getText().toString().trim();

        checkPhoneNum(phone, code);

        //not 86   +86
        SMSSDK.getVerificationCode(code, phone);

    }


    private void onCountryListGot(ArrayList<HashMap<String, Object>> countries) {
        // 解析国家列表
        for (HashMap<String, Object> country : countries) {
            String code = (String) country.get("zone");
            String rule = (String) country.get("rule");
            if (TextUtils.isEmpty(code) || TextUtils.isEmpty(rule)) {
                continue;
            }

            Log.d(TAG, "code=" + code + "rule=" + rule);


        }

    }


    /**
     * 请求验证码后，跳转到验证码填写页面
     */
    private void afterVerificationCodeRequested(boolean smart) {


        String phone = mEtPhone.getText().toString().trim().replaceAll("\\s*", "");
        String code = mTxtCountryCode.getText().toString().trim();
      //  String pwd = mEtPassword.getText().toString().trim();

        if (code.startsWith("+")) {
            code = code.substring(1);
        }

        Intent intent = new Intent(this, RegisterSecondActivity.class);
        intent.putExtra("phone", phone);
       // intent.putExtra("pwd", pwd);
        intent.putExtra("countryCode", code);

        startActivity(intent);
    }


    private String[] getCurrentCountry() {
        String mcc = getMCC();
        String[] country = null;
        if (!TextUtils.isEmpty(mcc)) {
            country = SMSSDK.getCountryByMCC(mcc);
        }

        if (country == null) {
            Log.w("SMSSDK", "no country found by MCC: " + mcc);
            country = SMSSDK.getCountry(DEFAULT_COUNTRY_ID);
        }
        return country;
    }

    private String getMCC() {
        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        // 返回当前手机注册的网络运营商所在国家的MCC+MNC. 如果没注册到网络就为空.
        String networkOperator = tm.getNetworkOperator();
        if (!TextUtils.isEmpty(networkOperator)) {
            return networkOperator;
        }

        // 返回SIM卡运营商所在国家的MCC+MNC. 5位或6位. 如果没有SIM卡返回空
        return tm.getSimOperator();
    }


    /**
     * 检查手机号是否正确
     *
     * @param phone  手机号码
     * @param code  国家号
     */
    private void checkPhoneNum(String phone, String code) {
        if (code.startsWith("+")) {
            code = code.substring(1);
        }

        if (TextUtils.isEmpty(phone)) {
            ToastUtils.show(this, getResources().getString(R.string.phone_num_is_not_empty));
            return;
        }

        if (code == "86") {
            if (phone.length() != 11) {
                ToastUtils.show(this, getResources().getString(R.string.phone_num_length_is_error));
                return;
            }
        }
        String rule = "^1(3|5|7|8|4)\\d{9}";
        Pattern p = Pattern.compile(rule);
        Matcher m = p.matcher(phone);

        if (!m.matches()) {
            ToastUtils.show(this, getResources().getString(R.string.check_your_phone_format));
            return;
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ic_back:
                finish();
                break;

            case R.id.tv_next:
               // if (mAgreeUserAgreement.isChecked()) {
                    getCode();
              //  } else {
              //      Toast.makeText(this, getResources()
             //                       .getString(R.string.agree_user_argument),
              //              Toast.LENGTH_SHORT).show();
             //   }
                break;

        }
    }
}
