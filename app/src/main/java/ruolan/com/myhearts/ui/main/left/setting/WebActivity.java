package ruolan.com.myhearts.ui.main.left.setting;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.ui.base.BaseActivity;

public class WebActivity extends BaseActivity {


    public final static String URL = "url";
    public final static String TITLE = "title";

    Toolbar toolbar;
    ProgressBar pb;
    WebView webView;

    @Override
    protected int getResultId() {
        return R.layout.activity_web;
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        pb = (ProgressBar) findViewById(R.id.pb);
        webView = (WebView) findViewById(R.id.webView);
    }

    @Override
    public void initData() {
        super.initData();
        String url = getIntent().getStringExtra(URL);
        String title = getIntent().getStringExtra(TITLE);
        initToolBar(toolbar, true, title);

        pb.setMax(100);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                pb.setProgress(newProgress);
                if (newProgress >= 100) {
                    pb.setVisibility(View.GONE);
                }
            }
        });
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl(url);
    }

    public static void runActivity(Context context, String title, String url) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra(URL, url);
        intent.putExtra(TITLE, title);
        context.startActivity(intent);
    }
}
