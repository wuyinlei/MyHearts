package ruolan.com.myhearts.ui.fragment.live;

import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.ui.base.BaseActivity;

public class LivingBannerActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mImgback;
    private TextView mTvtitle;
    private WebView mWebView;


    @Override
    protected int getResultId() {
        return R.layout.activity_living_banner;
    }

    @Override
    protected void initListener() {
        mImgback.setOnClickListener(this);
    }

    @Override
    public void initData() {
        super.initData();
        if (!TextUtils.isEmpty(mTitle)){
            mTvtitle.setText(mTitle);
        }

        requestWebViewUrl(mWebUrl);
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


    String mTitle;
    String mWebUrl;

    @Override
    public void initView() {

        mTitle = getIntent().getStringExtra("title");
        mWebUrl = getIntent().getStringExtra("webview");

        this.mWebView = (WebView) findViewById(R.id.web_view);
        this.mTvtitle = (TextView) findViewById(R.id.tv_title);
        this.mImgback = (ImageView) findViewById(R.id.img_back);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.img_back){
            finish();
        }
    }
}
