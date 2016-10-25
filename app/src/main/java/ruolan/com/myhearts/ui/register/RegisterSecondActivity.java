package ruolan.com.myhearts.ui.register;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.HashMap;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.utils.SMSLog;
import ruolan.com.myhearts.R;
import ruolan.com.myhearts.ui.base.BaseActivity;
import ruolan.com.myhearts.utils.CountTimerView;
import ruolan.com.myhearts.utils.ManifestUtil;
import ruolan.com.myhearts.utils.ToastUtils;
import ruolan.com.myhearts.widget.ClearEditText;

public class RegisterSecondActivity extends BaseActivity implements View.OnClickListener {


    ImageView mIvBack;
    TextView mFinish;
    TextView mTxtTip;
    ClearEditText mEdittxtCode;
    Button mBtnReSend;

    private String phone;
    private String pwd;
    private String countryCode;

    private CountTimerView countTimerView;

    @Override
    protected int getResultId() {
        return R.layout.activity_register_second;
    }

    @Override
    protected void initListener() {
        mBtnReSend.setOnClickListener(this);
        mIvBack.setOnClickListener(this);
        mFinish.setOnClickListener(this);
    }

    @Override
    public void initView() {
        mIvBack = (ImageView) findViewById(R.id.ic_back);
        mFinish = (TextView) findViewById(R.id.tv_finish);
        mTxtTip = (TextView) findViewById(R.id.txtTip);
        mEdittxtCode = (ClearEditText) findViewById(R.id.edittxt_code);
        mBtnReSend = (Button) findViewById(R.id.btn_reSend);
    }

    @Override
    public void initData() {
        super.initData();

        phone = getIntent().getStringExtra("phone");
        pwd = getIntent().getStringExtra("pwd");
        countryCode = getIntent().getStringExtra("countryCode");

        String formatedPhone = "+" + countryCode + " " + splitPhoneNum(phone);


        String text = getString(R.string.smssdk_send_mobile_detail) + formatedPhone;
        mTxtTip.setText(Html.fromHtml(text));


        CountTimerView timerView = new CountTimerView(mBtnReSend);
        timerView.start();


//        SMSSDK.initSDK(this, ManifestUtil.getMetaDataValue(this, "mob_sms_appKey"),
//                ManifestUtil.getMetaDataValue(this, "mob_sms_appSecrect"));

        evenHanlder = new SMSEvenHanlder();
        SMSSDK.registerEventHandler(evenHanlder);

    }

    private SMSEvenHanlder evenHanlder;


    /** 分割电话号码 */
    private String splitPhoneNum(String phone) {
        StringBuilder builder = new StringBuilder(phone);
        builder.reverse();
        for (int i = 4, len = builder.length(); i < len; i += 5) {
            builder.insert(i, ' ');
        }
        builder.reverse();
        return builder.toString();
    }


    /**
     * 提交验证码验证
     */
    private  void submitCode(){

        String vCode = mEdittxtCode.getText().toString().trim();

        if (TextUtils.isEmpty(vCode)) {
            ToastUtils.show(this, R.string.smssdk_write_identify_code);
            return;
        }
        SMSSDK.submitVerificationCode(countryCode,phone,vCode);
        //dialog.show();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ic_back:
                finish();
                break;

            case R.id.tv_finish:
                submitCode();
                break;
            case R.id.btn_reSend:
                reSendCode();
                break;
            default:
                break;
        }
    }


    class SMSEvenHanlder extends EventHandler {


        @Override
        public void afterEvent(final int event, final int result,
                               final Object data) {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if (result == SMSSDK.RESULT_COMPLETE) {
                        if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {

                             HashMap<String,Object> phoneMap = (HashMap<String, Object>) data;
                             String country = (String) phoneMap.get("country");
                             String phone = (String) phoneMap.get("phone");

                            doRegister();
                           // dialog.setMessage("正在提交注册信息");
                           // dialog.show();;
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
//                                ToastUtils.show(RegActivity.this, des);
                                return;
                            }
                        } catch (Exception e) {
                            SMSLog.getInstance().w(e);
                        }

                    }
                }
            });
        }
    }

    private void doRegister() {


    }


    /**
     * 重新发送验证码
     */
    public void reSendCode() {

        SMSSDK.getVerificationCode("+" + countryCode, phone);
        countTimerView = new CountTimerView(mBtnReSend, R.string.smssdk_resend_identify_code);
        countTimerView.start();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterEventHandler(evenHanlder);
    }


}
