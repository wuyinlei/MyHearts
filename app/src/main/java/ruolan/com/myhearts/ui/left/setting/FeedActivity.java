package ruolan.com.myhearts.ui.left.setting;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import ruolan.com.myhearts.R;
import ruolan.com.myhearts.contant.Contants;
import ruolan.com.myhearts.entity.FeedBean;
import ruolan.com.myhearts.ui.base.BaseActivity;
import ruolan.com.myhearts.utils.RegularUtils;

public class FeedActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mImgback;
    private TextView mSubmitbtn;
    private EditText mEditfeedbackcontent;
    private EditText mEditfeedbackphone;
    private String mUserName;

    String mFeedContent,mFeedPhone;


    @Override
    protected int getResultId() {
        return R.layout.activity_feed;
    }

    @Override
    protected void initListener() {
        mSubmitbtn.setOnClickListener(this);
    }

    @Override
    public void initView() {
        mUserName = getIntent().getStringExtra(Contants.USER_NAME);
        this.mEditfeedbackphone = (EditText) findViewById(R.id.edit_feedback_phone);
        this.mEditfeedbackcontent = (EditText) findViewById(R.id.edit_feedback_content);
        this.mSubmitbtn = (TextView) findViewById(R.id.submit_btn);
        this.mImgback = (ImageView) findViewById(R.id.img_back);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.submit_btn:
                submit();
                break;
        }
    }

    /**
     * 提交数据
     */
    private void submit() {
        boolean isMatchSubmit = veryParams();
        if (isMatchSubmit){
            FeedBean bean = new FeedBean();
            bean.setContent(mFeedContent);
            bean.setPhone(mFeedPhone);
            bean.setUsername(mUserName);
            bean.save(new SaveListener<String>() {
                @Override
                public void done(String s, BmobException e) {
                    if (e==null){

                        Toast.makeText(FeedActivity.this,
                                getResources().getString(R.string.submit_success),
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Log.d(TAG, e.toString());
                    }
                }
            });
        }
    }

    /**
     * 验证
     *
     * @return
     */
    private boolean veryParams() {

        mFeedContent = mEditfeedbackcontent.getText().toString();

        if (TextUtils.isEmpty(mFeedContent)) {
            Toast.makeText(this, getResources().getString(R.string.request_not_empty), Toast.LENGTH_SHORT).show();
            return false;
        }

        mFeedPhone = mEditfeedbackphone.getText().toString();
        if (TextUtils.isEmpty(mFeedPhone)) {
            Toast.makeText(this, getResources().getString(R.string.phone_num_is_not_empty), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!RegularUtils.isMobileExact(mFeedPhone)) {
            Toast.makeText(this, getResources().getString(R.string.check_your_phone_format), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
