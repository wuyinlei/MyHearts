package ruolan.com.myhearts.ui.fragment.home;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okrx.RxAdapter;

import java.lang.reflect.Type;

import butterknife.BindView;
import butterknife.ButterKnife;
import ruolan.com.myhearts.R;
import ruolan.com.myhearts.contant.HttpUrlPaths;
import ruolan.com.myhearts.entity.NewTitleBean;
import ruolan.com.myhearts.ui.base.BaseActivity;
import ruolan.com.myhearts.utils.TranslucentUtils;
import rx.android.schedulers.AndroidSchedulers;

public class NewsActivity extends BaseActivity {



    @Override
    protected int getResultId() {
        return R.layout.activity_news;
    }

    @Override
    public void initData() {
        super.initData();
        requestTitleData();

        //requestWebViewUrl();

    }

    private void requestWebViewUrl(String url) {
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(url);
                return true;
            }

        });

        //在这里可以设置加载进度条
        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
               // mProgressBar.setProgress(newProgress);
                if (newProgress>=100){
                   // mProgressBar.setVisibility(View.GONE);
                }
            }
        });

        mWebView.loadUrl(url);
    }


    private void requestTitleData() {
        OkGo.post(HttpUrlPaths.NEWS_USER_DETAIL)
                .params("id", id)
                .params("userid", userid)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(() -> {

                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Type type = new TypeToken<NewTitleBean>() {
                    }.getType();
                    NewTitleBean bean = new Gson().fromJson(s, type);
                    if (bean.getErrorCode() == 0 && bean.getErrorStr().equals("success")
                            && bean.getResultCount() > 0) {

                        mTvCategory.setText(bean.getResults().getCatg());
                        mTvViewCount.setText(bean.getResults().getViewCnt());
//                        Glide.with(NewsActivity.this)
//                                .load(bean.getResults().getIcon())
//                                .asBitmap()
//                                .error(R.mipmap.login_bg)
//                                .placeholder(R.mipmap.login_bg)
//                                .into(mImgBg);

                        mTvTitle.setText(bean.getResults().getTitle());
                        url = HttpUrlPaths.NEWS_DETAIL + "?id=" + bean.getResults().getId();
                        requestWebViewUrl(url);
                    }
                }, throwable -> {
                });
    }

    @Override
    protected void initListener() {

        mToolbar.setNavigationOnClickListener(v -> {
            onBackPressed();
        });
    }

    String id;
    String userid;
    String url;

    @Override
    public void initView() {

        TranslucentUtils.setColor(this, getResources().getColor(R.color.colorPrimary), 1);
        id = getIntent().getStringExtra("id");
        userid = getIntent().getStringExtra("userid");

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(getResources().getString(R.string.news_detail));
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvCategory = (TextView) findViewById(R.id.tv_category);
        mTvViewCount = (TextView) findViewById(R.id.tv_view_count);
        mCollapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        mWebView = (WebView) findViewById(R.id.web_view);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mImgBg = (ImageView) findViewById(R.id.img_bg);
        setSupportActionBar(mToolbar);

        //        设置返回箭头
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mProgressBar = (ProgressBar) findViewById(R.id.index_progressBar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    ImageView mImgBg;
    Toolbar mToolbar;
    TextView mTvTitle;
    TextView mTvCategory;
    TextView mTvViewCount;
    CollapsingToolbarLayout mCollapsingToolbar;
    WebView mWebView;
    ProgressBar mProgressBar;
}
