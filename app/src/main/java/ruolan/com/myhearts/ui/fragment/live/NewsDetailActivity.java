package ruolan.com.myhearts.ui.fragment.live;

import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okrx.RxAdapter;

import java.lang.reflect.Type;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.contant.Contants;
import ruolan.com.myhearts.contant.HttpUrlPaths;
import ruolan.com.myhearts.entity.NewsDetailBean;
import ruolan.com.myhearts.ui.base.BaseActivity;
import rx.android.schedulers.AndroidSchedulers;

public class NewsDetailActivity extends BaseActivity {

    private TextView mTvtitle;
    private TextView mTvname;
    private TextView mTvauthor;
    private TextView mTvpublishtime;
    private WebView mWebview;
    private ImageView mIcBack;
    private android.widget.LinearLayout activitynewsdetail;


    @Override
    protected int getResultId() {
        return R.layout.activity_news_detail;
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void initData() {
        super.initData();

        if (!TextUtils.isEmpty(id)) {
            String url = HttpUrlPaths.getNewsDetailUrl(id);
            OkGo.get(url)
                    .getCall(StringConvert.create(), RxAdapter.<String>create())
                    .doOnSubscribe(() -> {
                    })
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(s -> {
                        Type type = new TypeToken<NewsDetailBean>() {
                        }.getType();
                        NewsDetailBean bean = new Gson().fromJson(s, type);
                        String htmlData = bean.getContent()
                                .replace("<img", "<img style='max-width:100%;height:auto;'");
                        mTvname.setText(bean.getTitle());
                        if (bean.getEditorName() != null) {
                            mTvauthor.setText(bean.getEditorName() + "");
                        }
                        mTvpublishtime.setText(bean.getPublishTime());
                        mWebview.loadData(htmlData, "text/html; charset=UTF-8", null);

                    }, throwable -> {
                    });
        }
    }

    String id;
    String title;

    @Override
    public void initView() {
        id = getIntent().getStringExtra("id");
        title = getIntent().getStringExtra(Contants.TITLE);
        this.activitynewsdetail = (LinearLayout) findViewById(R.id.activity_news_detail);
        this.mWebview = (WebView) findViewById(R.id.web_view);
        this.mTvpublishtime = (TextView) findViewById(R.id.tv_publish_time);
        this.mTvauthor = (TextView) findViewById(R.id.tv_author);
        this.mTvname = (TextView) findViewById(R.id.tv_name);
        this.mTvtitle = (TextView) findViewById(R.id.tv_title);
        mIcBack = (ImageView) findViewById(R.id.img_back);
        mIcBack.setOnClickListener(v->finish());

        if (!TextUtils.isEmpty(title)) {
            mTvtitle.setText(title);
        }
    }
}
