package ruolan.com.myhearts.ui.fragment.home;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.entity.HomeBannerBean;
import ruolan.com.myhearts.ui.base.BaseActivity;
import ruolan.com.myhearts.utils.TranslucentUtils;

/**
 * 首页banner图的详情界面
 */
public class BannerDetailActivity extends BaseActivity {

    ImageView mImgBg;
    Toolbar mToolbar;
    TextView mTvTitle;
    TextView mTvCategory;
    TextView mTvViewCount;
    CollapsingToolbarLayout mCollapsingToolbar;
    WebView mWebView;


    @Override
    protected int getResultId() {
        return R.layout.activity_banner_detail;
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void initData() {
        super.initData();

        mTvTitle.setText(title);
        mTvCategory.setText(subtitle);
        requestWebViewUrl(url);

    }


    private void requestWebViewUrl(String url) {
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(url);
                return true;
            }
        });

        mWebView.loadUrl(url);
    }

    String url,title,subtitle;

    HomeBannerBean.ResultsBean mResultsBean;

    @Override
    public void initView() {
        TranslucentUtils.setColor(this, getResources().getColor(R.color.colorPrimary), 1);
       // id = getIntent().getStringExtra("id");
       // userid = getIntent().getStringExtra("userid");

        mResultsBean = (HomeBannerBean.ResultsBean) getIntent().getSerializableExtra("result");

        if (mResultsBean != null){
            url = mResultsBean.getUrl();
            title = mResultsBean.getTitle();
            subtitle = mResultsBean.getSubtitle();
        }
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(getResources().getString(R.string.news_detail));
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvCategory = (TextView) findViewById(R.id.tv_category);
       // mTvViewCount = (TextView) findViewById(R.id.tv_view_count);
        mCollapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        mWebView = (WebView) findViewById(R.id.web_view);
        mImgBg = (ImageView) findViewById(R.id.img_bg);
        setSupportActionBar(mToolbar);

        //        设置返回箭头
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
