package ruolan.com.myhearts.ui.fragment.thoughts;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.ninegrid.ImageInfo;
import com.lzy.ninegrid.NineGridView;
import com.lzy.ninegrid.preview.NineGridViewClickAdapter;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okrx.RxAdapter;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.adapter.CircleFriendsCommentAdapter;
import ruolan.com.myhearts.contant.HttpUrlPaths;
import ruolan.com.myhearts.entity.CircleFriendsCommentBean;
import ruolan.com.myhearts.entity.CircleFriendsUserBean;
import ruolan.com.myhearts.entity.CircleFriendsUserBean.ResultsEntity;
import ruolan.com.myhearts.ui.base.BaseActivity;
import ruolan.com.myhearts.widget.GlideCircleTransform;
import ruolan.com.myhearts.widget.itemanimator.SlideInOutTopItemAnimator;
import rx.android.schedulers.AndroidSchedulers;

public class CircleFriendsActivity extends BaseActivity {

    private ImageView mIvtour;
    private TextView mTvname;
    private TextView mTvtime;
    private ImageView mImagegender;
    private TextView mTvcontent;
    private NineGridView mNineGrid;
    private ImageView mIvtype;
    private TextView mTvcommentcount;
    private ImageView mIvcomment;
    private TextView mTvviewcount;
    private RecyclerView mRecyclerview;
    private LinearLayout mRecomment;
    private LinearLayout mLlrote;

    private int page = 1;


    ResultsEntity mResultsEntity;
    private List<CircleFriendsCommentBean.ResultsEntity> mCircleFriendsComments = new ArrayList<>();
    private CircleFriendsCommentAdapter mCommentAdapter;

    @Override
    protected int getResultId() {
        return R.layout.activity_circle_friends;
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void initData() {
        super.initData();

        OkGo.get(HttpUrlPaths.THOUGHTS_DETAIL_URL)
                .params("userid", 0)
                .params("eventid", eventid)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(() -> {
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Type type = new TypeToken<CircleFriendsUserBean>() {
                    }.getType();
                    CircleFriendsUserBean bean = new Gson().fromJson(s, type);
                    if (bean.getErrorCode() == 0
                            && bean.getErrorStr().equals("success")
                            && bean.getResultCount() > 0) {
                        mResultsEntity = bean.getResults();
                        initUI(mResultsEntity);
                    }
                }, throwable -> {
                });


        OkGo.get(HttpUrlPaths.THOUGHTS_DETAIL_COMMENT_URL)
                .params("type", "user_event")
                .params("eventid", eventid)
                .params("page",page)
                .params("userid", 0)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(() -> {
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Type type = new TypeToken<CircleFriendsCommentBean>() {
                    }.getType();
                    CircleFriendsCommentBean bean = new Gson().fromJson(s, type);
                    if (bean.getErrorCode() == 0
                            && bean.getResultCount() > 0
                            && bean.getErrorStr().equals("success")) {
                        mCircleFriendsComments = bean.getResults();
                        if (mCircleFriendsComments.size()>0){
                            mRecomment.setVisibility(View.VISIBLE);
                            mCommentAdapter.setDatas(mCircleFriendsComments);
                        } else {
                            mRecomment.setVisibility(View.GONE);
                        }
                    }
                }, throwable -> {
                });


    }

    private void initUI(ResultsEntity resultsEntity) {

        mTvviewcount.setText(resultsEntity.getViewCnt());
        mTvcommentcount.setText(resultsEntity.getCommentCnt());
        mTvname.setText(resultsEntity.getNickname());
        Glide.with(this)
                .load(resultsEntity.getAvatar())
                .asBitmap().transform(new GlideCircleTransform(this))
                .into(mIvtour);

        if (resultsEntity.getGender().equals("1")) {  //男生
            mImagegender.setBackgroundDrawable(getResources().getDrawable(R.drawable.sex_man1));
        } else if (resultsEntity.getGender().equals("0")) {  //女生
            mImagegender.setBackgroundDrawable(getResources().getDrawable(R.drawable.sex_gril1));
        }

        Long addtime = (long) resultsEntity.getCreatedDateTime();
        Long result_time = addtime * 1000;
        String date = new SimpleDateFormat("MM-dd HH:mm").format(result_time);
        mTvtime.setText(date);

        mTvcontent.setText(resultsEntity.getContent());

        //NineGridView mNineGrid = baseViewHolder.getView(R.id.mNineGrid);
        ArrayList<ImageInfo> imageInfo = new ArrayList<>();  //获取到图片地址集合
        //也就是用户发朋友圈的那种,添加图片
        List<String> images = resultsEntity.getPhotos();
        if (images != null) {
            for (String image : images) {
                //ImageInfo 是他的实体类,用于image的地址
                ImageInfo info = new ImageInfo();
                info.setThumbnailUrl(image);
                info.setBigImageUrl(image);
                imageInfo.add(info);
            }
        }
        mNineGrid.setAdapter(new NineGridViewClickAdapter(this, imageInfo));

        if (images != null && images.size() == 1) {
            //如果用户只发了一张图片的话,就设置图片的宽和高
            mNineGrid.setSingleImageSize(300);
            mNineGrid.setSingleImageRatio(1);
            //holder.mPhotoRecycler.setSingleImageRatio(images.get(0).width * 1.0f / images.get(0).height);
        }
    }

    String eventid;

    @Override
    public void initView() {
        eventid = getIntent().getStringExtra("eventid");
        this.mLlrote = (LinearLayout) findViewById(R.id.ll_rote);
        this.mRecomment = (LinearLayout) findViewById(R.id.re_comment);
        this.mRecyclerview = (RecyclerView) findViewById(R.id.recycler_view);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerview.setLayoutManager(manager);
        mRecyclerview.setItemAnimator(new SlideInOutTopItemAnimator(mRecyclerview));
        mCommentAdapter = new CircleFriendsCommentAdapter(this, mCircleFriendsComments);
        mRecyclerview.setAdapter(mCommentAdapter);

        this.mTvviewcount = (TextView) findViewById(R.id.tv_view_count);
        this.mIvcomment = (ImageView) findViewById(R.id.iv_comment);
        this.mTvcommentcount = (TextView) findViewById(R.id.tv_comment_count);
        this.mIvtype = (ImageView) findViewById(R.id.iv_type);
        this.mNineGrid = (NineGridView) findViewById(R.id.nineGrid);
        this.mTvcontent = (TextView) findViewById(R.id.tv_content);
        this.mImagegender = (ImageView) findViewById(R.id.image_gender);
        this.mTvtime = (TextView) findViewById(R.id.tv_time);
        this.mTvname = (TextView) findViewById(R.id.tv_name);
        this.mIvtour = (ImageView) findViewById(R.id.iv_tour);
    }
}
