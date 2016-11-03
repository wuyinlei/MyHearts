package ruolan.com.myhearts.ui.left.setting;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SQLQueryListener;
import ruolan.com.myhearts.R;
import ruolan.com.myhearts.contant.Contants;
import ruolan.com.myhearts.entity.MyUser;
import ruolan.com.myhearts.ui.base.BaseActivity;
import ruolan.com.myhearts.ui.login.LoginActivity;
import ruolan.com.myhearts.ui.password.ChangePasswordActivity;
import ruolan.com.myhearts.utils.DataCleanManager;

public class SettingActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mIvBack;
    private TextView mCurrentCache;
    private LinearLayout mClearCache,
            mSettingOpinion,
            mSettingShare,
            mVersionCheck,
            mSettingByMe,
            mUpdatePassword;

    private CheckBox mCheckboxIsShareHomepage;
    private String mTotalCacheSize;
    private TextView mCurVerName;
    private MyUser mMyUser;

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
        mUpdatePassword.setOnClickListener(this);
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

        try {
            String versionName = getVersionName();
            mCurVerName.setText(versionName);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void initView() {
        mMyUser = MyUser.getCurrentUser(MyUser.class);
        mIvBack = (ImageView) findViewById(R.id.img_back);
        mCurrentCache = (TextView) findViewById(R.id.current_cache);
        mSettingOpinion = (LinearLayout) findViewById(R.id.setting_opinion);
        mSettingShare = (LinearLayout) findViewById(R.id.setting_share);
        mVersionCheck = (LinearLayout) findViewById(R.id.version_check);
        mClearCache = (LinearLayout) findViewById(R.id.clear_cache);
        mSettingByMe = (LinearLayout) findViewById(R.id.setting_byme);
        mCheckboxIsShareHomepage = (CheckBox) findViewById(R.id.checkbox_isshare_homepage);
        mCurVerName = (TextView) findViewById(R.id.version_name);
        mUpdatePassword = (LinearLayout) findViewById(R.id.goupdate_password);
    }

    /**
     * 获取当前版本号码
     *
     * @return 当前版本号
     * @throws Exception
     */
    private String getVersionName() throws Exception {
        // 获取packagemanager的实例
        PackageManager packageManager = getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo = packageManager.getPackageInfo(getPackageName(), 0);
        String version = packInfo.versionName;
        return version;
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.img_back:
                finish();
                break;


            case R.id.setting_opinion:

                if (mMyUser == null) {
                    intent.setClass(this, LoginActivity.class);
                } else {
                    intent.setClass(this, FeedActivity.class);
                    intent.putExtra(Contants.USER_NAME, mMyUser.getUsername());
                }
                startActivity(intent);
                break;

            case R.id.setting_share:

                break;

            case R.id.goupdate_password:
//                BmobQuery<MyUser> bmobQuery = new BmobQuery<>();
//                String phone = "13718989054";
//                String sql = "select * from _User where mobilePhoneNumber = ?";
//                bmobQuery.setSQL(sql);
//                bmobQuery.setPreparedParams(new Object[]{phone});
//                bmobQuery.doSQLQuery( new SQLQueryListener<MyUser>() {
//                    @Override
//                    public void done(BmobQueryResult<MyUser> bmobQueryResult, BmobException e) {
//                        if (e == null){
//                            List<MyUser> results = bmobQueryResult.getResults();
//                            if (results.size()>0){
//                                MyUser myUser1 = results.get(0);
//                                Log.d("wuyinlei", myUser1.getUsername());
//                            }
//                        }
//                    }
//                });

                if (mMyUser == null) {
                    intent.setClass(this, LoginActivity.class);
                } else {
                    intent.setClass(this, ChangePasswordActivity.class);
                    intent.putExtra(Contants.USER_NAME, mMyUser.getUsername());
                    intent.putExtra(Contants.OBJECT_ID, mMyUser.getObjectId());
                }
                startActivity(intent);
                break;

            case R.id.version_check:

                break;

            case R.id.clear_cache:
                DataCleanManager.clearAllCache(this);  //清理app缓存
                new MaterialDialog.Builder(this)
                        .title(getResources().getString(R.string.clear_tip))
                        .content(getResources().getString(R.string.clear_success))
                        .positiveText(getResources().getString(R.string.ok))
                        .onPositive((dialog, which) -> mCurrentCache.setText("0 KB")).show();
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
