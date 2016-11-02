package ruolan.com.myhearts.ui.left.setting;

import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.contant.Contants;
import ruolan.com.myhearts.entity.MyUser;
import ruolan.com.myhearts.ui.base.BaseActivity;
import ruolan.com.myhearts.ui.login.LoginActivity;
import ruolan.com.myhearts.utils.DataCleanManager;

public class SettingActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mIvBack;
    private TextView mCurrentCache;
    private LinearLayout mClearCache,
            mSettingOpinion,
            mSettingShare,
            mVersionCheck,
            mSettingByMe;

    private CheckBox mCheckboxIsShareHomepage;
    private String mTotalCacheSize;

    @Override
    protected int getResultId() {
        return R.layout.activity_setting_layout;
    }

    @Override
    protected void initListener() {
        mIvBack.setOnClickListener(this);
        // mCurrentCache.setOnClickListener(this);
        mSettingOpinion.setOnClickListener(this);
        mSettingShare.setOnClickListener(this);
        mVersionCheck.setOnClickListener(this);
        mClearCache.setOnClickListener(this);
        mSettingByMe.setOnClickListener(this);
        mCheckboxIsShareHomepage.setOnClickListener(this);
    }

    @Override
    public void initData() {
        super.initData();
        try {
            mTotalCacheSize = DataCleanManager.getTotalCacheSize(this);
            if (mTotalCacheSize != null) {
                mCurrentCache.setText(mTotalCacheSize);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initView() {
        mIvBack = (ImageView) findViewById(R.id.img_back);
        mCurrentCache = (TextView) findViewById(R.id.current_cache);
        mSettingOpinion = (LinearLayout) findViewById(R.id.setting_opinion);
        mSettingShare = (LinearLayout) findViewById(R.id.setting_share);
        mVersionCheck = (LinearLayout) findViewById(R.id.version_check);
        mClearCache = (LinearLayout) findViewById(R.id.clear_cache);
        mSettingByMe = (LinearLayout) findViewById(R.id.setting_byme);
        mCheckboxIsShareHomepage = (CheckBox) findViewById(R.id.checkbox_isshare_homepage);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ic_back:
                finish();
                break;


            case R.id.setting_opinion:
                Intent intent = new Intent();
                MyUser myUser = MyUser.getCurrentUser(MyUser.class);
                if (myUser==null){
                    intent.setClass(this, LoginActivity.class);
                } else {
                    intent.setClass(this,FeedActivity.class);
                    intent.putExtra(Contants.USER_NAME,myUser.getUsername());
                }
                startActivity(intent);
                break;

            case R.id.setting_share:

                break;

            case R.id.version_check:

                break;

            case R.id.clear_cache:
                DataCleanManager.clearAllCache(this);
                mCurrentCache.setText("0 KB");
                break;

            case R.id.setting_byme:
               // StringBuffer sb = new StringBuffer();

                WebActivity.runActivity(this, "My Github,Welcome star", "https://github.com/wuyinlei");
                break;

            case R.id.checkbox_isshare_homepage:

                break;
            default:
                break;

        }
    }
}
