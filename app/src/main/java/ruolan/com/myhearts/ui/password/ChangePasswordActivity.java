package ruolan.com.myhearts.ui.password;

import android.text.TextUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;
import ruolan.com.myhearts.R;
import ruolan.com.myhearts.contant.Contants;
import ruolan.com.myhearts.entity.MyUser;
import ruolan.com.myhearts.ui.base.BaseActivity;
import ruolan.com.myhearts.utils.RegularUtils;
import ruolan.com.myhearts.widget.ClearEditText;

public class ChangePasswordActivity extends BaseActivity {

    private ImageView mImgback;
    private ClearEditText mClearEditText;
    private Button mSubmitBtn;

    String objectId;
    String newPassword;

    @Override
    protected int getResultId() {
        return R.layout.activity_change_password;
    }

    @Override
    public void initData() {
        super.initData();
        if (!TextUtils.isEmpty(objectId)){
            newPassword = mClearEditText.getText().toString();
            if (RegularUtils.isPassword(newPassword)){
                MyUser user = new MyUser();
                user.setPassword(newPassword);
                user.update(objectId, new UpdateListener() {
                    @Override
                    public void done(BmobException e) {
                        if (e==null){
                            Toast.makeText(ChangePasswordActivity.this,
                                    getResources().getString(R.string.change_success),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            } else {

            }
        }
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void initView() {
        this.mClearEditText = (ClearEditText) findViewById(R.id.edittxt_name);
        this.mImgback = (ImageView) findViewById(R.id.img_back);
        mSubmitBtn = (Button) findViewById(R.id.btn_submit);
        objectId = getIntent().getStringExtra(Contants.OBJECT_ID);
    }
}
