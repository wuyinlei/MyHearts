package ruolan.com.myhearts.ui.push;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import cn.jpush.android.api.JPushInterface;
import ruolan.com.myhearts.R;
import ruolan.com.myhearts.ui.base.BaseActivity;

public class PushActivity extends BaseActivity {

    TextView mTvTitle,mTvContent;

    @Override
    protected int getResultId() {
        return R.layout.activity_push;
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void initData() {
        super.initData();
        Intent intent = getIntent();
        if (null != intent) {  //如果接受过来的数据不为空
            Bundle bundle = intent.getExtras();
            String title = bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE);
            String content = bundle.getString(JPushInterface.EXTRA_ALERT);
            mTvTitle.setText(title);
            mTvContent.setText(content);
        }
    }

    @Override
    public void initView() {
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvContent = (TextView) findViewById(R.id.tv_content);
    }
}
