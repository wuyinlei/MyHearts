package ruolan.com.myhearts.ui.fragment.advisory;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okrx.RxAdapter;

import java.lang.reflect.Type;

import cn.sharesdk.framework.ShareSDK;
import ruolan.com.myhearts.R;
import ruolan.com.myhearts.cn.sharesdk.onekeyshare.OnekeyShare;
import ruolan.com.myhearts.contant.Contants;
import ruolan.com.myhearts.contant.HttpUrlPaths;
import ruolan.com.myhearts.entity.UserDetailBean;
import ruolan.com.myhearts.ui.base.BaseActivity;
import ruolan.com.myhearts.utils.CommemUtils;
import ruolan.com.myhearts.widget.transform.GlideCircleTransform;
import rx.android.schedulers.AndroidSchedulers;

public class UserDetailActivity extends BaseActivity implements View.OnClickListener, ObservableScrollViewCallbacks {


    TextView mActionChatBtn;
    LinearLayout mActionChatLayout;
    TextView mActionWebcallBtn;
    LinearLayout mActionWebcallLayout;
    TextView mActionReserveBtn;
    LinearLayout mActionReserveLayout;
    LinearLayout mCounselorBottomButtonLayout;
    ImageView mCounselorAvatarLayout;
    TextView mCounselorNameTxt;


    TextView mCounselorAddressTxt;
    ImageButton mFollowBtn;
    RelativeLayout mCounselorNameLayout;
    TextView mCounselorSloganTxt;
    TextView mCounselorTag1;
    TextView mCounselorTag2;
    TextView mCounselorTag3;
    LinearLayout mTagsLayout;
    LinearLayout mCounselorHeadLayout;
    ImageView mCounselorAvatar;

    RelativeLayout mCounselorAvatarWrapper;
    TextView mLikeCntTxt;
    TextView mCounselorStudioTxt;
    TextView mCounselorQualificationTxt;
    TextView mCounselorResumeTxt;
    Button mMoreResumeBtn;
    TextView mCounselorLiveCount;
    TextView mCounselorLiveMore;

    RecyclerView mCounselorLiveList;
    LinearLayout mCounselorLiveLayout;
    TextView mUserCommentTxt;
    TextView mMoreCommentsBtnTxt;
    TextView mNoCommentTxt;
    LinearLayout mCounselorDetailCommentLayout;
    TextView mGiftCountTxt;
    TextView mGiftBtnTxt;
    ImageView mGiftLayoutIcon;
    RecyclerView mGiftList;

    RelativeLayout mGiftListLayout;
    ObservableScrollView mContentScrollView;
    SwipeRefreshLayout mRefreshLayout;
    ImageButton mActionBackBtn;
    TextView mActionTitleTxt;
    ImageButton mActionShareBtnTxt;
    RelativeLayout mContentHeadView;
    TextView mNoticeTxt;


    @Override
    protected int getResultId() {
        return R.layout.activity_details_layout;
    }


    UserDetailBean.ResultsBean mUserDatas = new UserDetailBean.ResultsBean();

    @Override
    public void initData() {

        //以下注释的代码是请求网络的数据，但是这个网络的数据请求特别慢，可能他们后台做了手脚(哈哈)
        OkGo.post(HttpUrlPaths.USER_DETAIL_INFO)
                .params("userid", userid)
                .params("cuserid", cuserid)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(() -> {
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                            Type type = new TypeToken<UserDetailBean>() {
                            }.getType();
                            UserDetailBean bean = new Gson().fromJson(s, type);
                            if (bean.getErrorCode() == 0
                                    && bean.getErrorStr().equals("success")
                                    && bean.getResultCount() > 0) {
                                mUserDatas = bean.getResults();

                                updateUi(mUserDatas);
                            }
                        }
                        , throwable -> {
                        });


    }


    private void updateUi(UserDetailBean.ResultsBean user) {
        Glide.with(this).load(user.getAvatar())
                .asBitmap()
                .transform(new GlideCircleTransform(this))
                .into(mCounselorAvatar);

        mLikeCntTxt.setText(user.getLikeCnt());
        mCounselorNameTxt.setText(user.getNickname());
        mCounselorAddressTxt.setText(user.getCity());
        mCounselorSloganTxt.setText(user.getSlogan());
        String userTags = user.getCatgs();

        mCounselorTag1.setVisibility(View.VISIBLE);
        mCounselorTag1.setText(getResources().getString(R.string.tag1));
        mCounselorTag2.setVisibility(View.VISIBLE);
        mCounselorTag2.setText(getResources().getString(R.string.tag2));
        mCounselorTag3.setVisibility(View.VISIBLE);
        mCounselorTag3.setText(getResources().getString(R.string.tag3));
        // String[]tags =userTags.split("、");  //这个暂时分割不出来，用java跑是可以分割出来的，有点，，，，，，

        // mCounselorTag1.setText(tags[0]);
        // mCounselorTag2.setText(tags[1]);
        // mCounselorTag3.setText(tags[2]);
        mCounselorStudioTxt.setText(user.getClinicName());
        mCounselorQualificationTxt.setText(user.getHonor());
        mCounselorResumeTxt.setText(user.getResume());
        //String seeCount = "5";
        //模拟的几个
        String seeCount = CommemUtils.getDirectSedding("5", this);


        mCounselorLiveCount.setText(seeCount);

        String cmtCount = CommemUtils.getUserComment(user.getCmtCnt(), this);
        mUserCommentTxt.setText(cmtCount);
        String gitCount = CommemUtils.getGifCount(user.getGiftNum(), this);

        mGiftCountTxt.setText(gitCount);


    }

    String userid = "54442";
    String cuserid = "54442";

    @Override
    public void initView() {
        userid = getIntent().getStringExtra(Contants.USER_ID);
        cuserid = getIntent().getStringExtra(Contants.C_USER_ID);

        mActionChatBtn = (TextView) findViewById(R.id.action_chat_btn);
        mActionChatLayout = (LinearLayout) findViewById(R.id.action_chat_layout);
        mActionWebcallBtn = (TextView) findViewById(R.id.action_webcall_btn);
        mActionWebcallLayout = (LinearLayout) findViewById(R.id.action_webcall_layout);
        mActionReserveBtn = (TextView) findViewById(R.id.action_reserve_btn);
        mActionReserveLayout = (LinearLayout) findViewById(R.id.action_reserve_layout);
        mCounselorBottomButtonLayout = (LinearLayout) findViewById(R.id.counselor_bottom_button_layout);
        mCounselorAvatarLayout = (ImageView) findViewById(R.id.counselor_avatar_layout);
        mCounselorNameTxt = (TextView) findViewById(R.id.counselor_name_txt);
        mCounselorAddressTxt = (TextView) findViewById(R.id.counselor_address_txt);
        mFollowBtn = (ImageButton) findViewById(R.id.follow_btn);
        mCounselorNameLayout = (RelativeLayout) findViewById(R.id.counselor_name_layout);
        mCounselorSloganTxt = (TextView) findViewById(R.id.counselor_slogan_txt);
        mCounselorTag1 = (TextView) findViewById(R.id.counselor_tag_1);
        mCounselorTag2 = (TextView) findViewById(R.id.counselor_tag_2);
        mCounselorTag3 = (TextView) findViewById(R.id.counselor_tag_3);
        mTagsLayout = (LinearLayout) findViewById(R.id.tags_layout);
        mCounselorHeadLayout = (LinearLayout) findViewById(R.id.counselor_head_layout);
        mCounselorAvatar = (ImageView) findViewById(R.id.counselor_avatar);

        mCounselorAvatarWrapper = (RelativeLayout) findViewById(R.id.counselor_avatar_wrapper);
        mLikeCntTxt = (TextView) findViewById(R.id.like_cnt_txt);
        mCounselorStudioTxt = (TextView) findViewById(R.id.counselor_studio_txt);
        mCounselorQualificationTxt = (TextView) findViewById(R.id.counselor_qualification_txt);
        mCounselorResumeTxt = (TextView) findViewById(R.id.counselor_resume_txt);
        mMoreResumeBtn = (Button) findViewById(R.id.more_resume_btn);
        mCounselorLiveCount = (TextView) findViewById(R.id.counselor_live_count);
        mCounselorLiveMore = (TextView) findViewById(R.id.counselor_live_more);

        mCounselorLiveList = (RecyclerView) findViewById(R.id.counselor_live_list);
        mCounselorLiveLayout = (LinearLayout) findViewById(R.id.counselor_live_layout);
        mUserCommentTxt = (TextView) findViewById(R.id.user_comment_txt);
        mMoreCommentsBtnTxt = (TextView) findViewById(R.id.more_comments_btn_txt);
        mNoCommentTxt = (TextView) findViewById(R.id.no_comment_txt);
        mCounselorDetailCommentLayout = (LinearLayout) findViewById(R.id.counselor_detail_comment_layout);
        mGiftCountTxt = (TextView) findViewById(R.id.gift_count_txt);
        mGiftBtnTxt = (TextView) findViewById(R.id.gift_btn_txt);
        mGiftLayoutIcon = (ImageView) findViewById(R.id.gift_layout_icon);
        mGiftList = (RecyclerView) findViewById(R.id.gift_list);

        mGiftListLayout = (RelativeLayout) findViewById(R.id.gift_list_layout);
        mContentScrollView = (ObservableScrollView) findViewById(R.id.content_scroll_view);
        mRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh_layout);
        mActionBackBtn = (ImageButton) findViewById(R.id.action_back_btn);
        mActionTitleTxt = (TextView) findViewById(R.id.action_title_txt);
        mActionShareBtnTxt = (ImageButton) findViewById(R.id.action_share_btn_txt);
        mActionShareBtnTxt.setOnClickListener(this);
        mContentHeadView = (RelativeLayout) findViewById(R.id.content_head_view);
        mNoticeTxt = (TextView) findViewById(R.id.notice_txt);


    }

    int height;

    @Override
    protected void initListener() {
        mActionBackBtn.setOnClickListener(this);
        mActionShareBtnTxt.setOnClickListener(this);
        mMoreResumeBtn.setOnClickListener(this);
        mCounselorAvatar.getViewTreeObserver().addOnGlobalLayoutListener(() -> {

            height = mCounselorAvatar.getHeight();
            mContentScrollView.setScrollViewCallbacks(UserDetailActivity.this);
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.action_back_btn:
                finish();
                break;
            case R.id.action_share_btn_txt:
                //分享
                showShare();
                break;

            case R.id.more_resume_btn:

                Intent intent = new Intent(this,UserAbstractActivity.class);
                intent.putExtra("img",mUserDatas.getAvatar());
                intent.putExtra("name",mUserDatas.getNickname());
                intent.putExtra("advisory",mUserDatas.getHonor());
                intent.putExtra("abstract",mUserDatas.getResume());
                startActivity(intent);
                //overridePendingTransition(R.anim.slide_right_in,R.anim.push_left_out);
                break;

        }
    }

    private void showShare() {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle(mUserDatas.getNickname());
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("https://github.com/wuyinlei/MyHearts");
        // text是分享文本，所有平台都需要这个字段
        oks.setText(mUserDatas.getHobby());
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        oks.setImageUrl(mUserDatas.getAvatar());
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment(mUserDatas.getHobby());
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite("GitHub");
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("https://github.com/wuyinlei/MyHearts");

// 启动分享GUI
        oks.show(this);

    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        Log.d(TAG, "scrollY:" + scrollY);
        if (scrollY <= 0) {
            mContentHeadView.setBackgroundColor(getResources().getColor(R.color.transparent));
            mActionTitleTxt.setTextColor(Color.WHITE);
            mActionTitleTxt.setBackgroundColor(getResources().getColor(R.color.transparent));
        } else if (scrollY > 0 && scrollY < height) { //当滑动的距离小于图片的高度  设置颜色背景渐变
            float scale = (float) scrollY / height;
            float alpha = (255 * scale);
            mActionTitleTxt.setTextColor(Color.argb((int) alpha, 255, 255, 255));
            // mActionTitleTxt.setBackgroundColor(Color.argb((int) alpha, 144, 155, 180));
            mContentHeadView.setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));
        } else {
            mActionTitleTxt.setTextColor(Color.argb((int) 255, 144, 155, 180));

        }

    }


    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {

    }
}
