package ruolan.com.myhearts.activity.main.fragment.thoughts;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lzy.ninegrid.ImageInfo;
import com.lzy.ninegrid.NineGridView;
import com.lzy.ninegrid.preview.NineGridViewClickAdapter;

import java.util.ArrayList;
import java.util.List;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.activity.main.fragment.thoughts.ThoughtsBean.ResultsBean.CommentsBean;
import ruolan.com.myhearts.widget.DividerItemDecoration;
import ruolan.com.myhearts.widget.GlideCircleTransform;


/**
 * Created by wuyinlei on 2016/10/22.
 */

public class ThroughtAdapter extends RecyclerView.Adapter<ThroughtAdapter.ThroughtViewHolder> {

    private List<ThoughtsBean.ResultsBean> mResultsBeen = new ArrayList<>();
    private Context mContext;

    /**
     *
     * @param resultsBeen
     */
    public void setResultsBeen(List<ThoughtsBean.ResultsBean> resultsBeen) {
        mResultsBeen = resultsBeen;
        notifyDataSetChanged();
    }

    public ThroughtAdapter(Context context, List<ThoughtsBean.ResultsBean> bean){
        this.mContext = context;
        this.mResultsBeen = bean;
    }


    @Override
    public ThroughtViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.fragment_thourght_item_layout,parent,false);
        return new ThroughtViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ThroughtViewHolder holder, int position) {
        ThoughtsBean.ResultsBean bean = mResultsBeen.get(position);
        Long addtime = Long.valueOf(bean.getCreatedDateTime());
        Long result_time = addtime * 1000;
        String date = new java.text.SimpleDateFormat("MM-dd HH:mm").format(result_time);
        Glide.with(mContext).load(bean.getAvatar()).asBitmap()
                .transform(new GlideCircleTransform(mContext))
                .into(holder.mIvTour);
        holder.mTvName.setText(bean.getNickname());
        holder.mTvTime.setText(date);
        holder.mTvCommentCount.setText(bean.getCommentCnt());
        holder.mTvViewCount.setText(bean.getViewCnt());
        holder.mTvContent.setText(bean.getContent());
        if (bean.getGender().equals("1")){  //男生
            holder.mIvGender.setBackgroundDrawable(mContext
                    .getResources().getDrawable(R.drawable.sex_man1));
        } else if (bean.getGender().equals("0")){  //女生
            holder.mIvGender.setBackgroundDrawable(mContext
            .getResources().getDrawable(R.drawable.sex_gril1));
        }

        //NineGridView nineGrid = baseViewHolder.getView(R.id.nineGrid);
        ArrayList<ImageInfo> imageInfo = new ArrayList<>();  //获取到图片地址集合
        //也就是用户发朋友圈的那种,添加图片
        List<String> images = bean.getPhotos();
        if (images != null) {
            for (String image : images) {
                ImageInfo info = new ImageInfo();
                info.setThumbnailUrl(image);
                info.setBigImageUrl(image);
                imageInfo.add(info);
            }
        }
        holder.mPhotoRecycler.setAdapter(new NineGridViewClickAdapter(mContext, imageInfo));

        if (images != null && images.size() == 1) {
            //如果用户只发了一张图片的话,就设置图片的宽和高
            holder.mPhotoRecycler.setSingleImageSize(300);
            holder.mPhotoRecycler.setSingleImageRatio(1);
            //holder.mPhotoRecycler.setSingleImageRatio(images.get(0).width * 1.0f / images.get(0).height);
        }

        List<CommentsBean> comments = bean.getComments();
        if (comments!=null&&comments.size()>0) {
            CommentAdapter adapter = new CommentAdapter(comments);
            holder.mCommentRe.setVisibility(View.VISIBLE);
            holder.mCommentRecycler.setLayoutManager(new LinearLayoutManager(mContext));
          //  holder.mCommentRecycler.addItemDecoration(new DividerItemDecoration(mContext
            //,DividerItemDecoration.VERTICAL_LIST));
            holder.mCommentRecycler.setItemAnimator(new DefaultItemAnimator());
            holder.mCommentRecycler.setAdapter(adapter);
        }


    }

    @Override
    public int getItemCount() {
        return mResultsBeen == null ? 0 : mResultsBeen.size();
    }

    class ThroughtViewHolder extends RecyclerView.ViewHolder{

        private ImageView mIvTour,mIvGender;
        private TextView mTvName,mTvTime,mTvContent,mTvCommentCount,mTvViewCount;
        private RecyclerView mCommentRecycler;
        private RelativeLayout mCommentRe;
        private NineGridView mPhotoRecycler;


        public ThroughtViewHolder(View view) {
            super(view);
            mIvTour  = (ImageView) view.findViewById(R.id.iv_tour);
            mIvGender = (ImageView) view.findViewById(R.id.image_gender);
            mTvName = (TextView) view.findViewById(R.id.tv_name);
            mTvTime = (TextView) view.findViewById(R.id.tv_time);
            mTvContent = (TextView) view.findViewById(R.id.tv_content);
            mTvCommentCount = (TextView) view.findViewById(R.id.tv_comment_count);
            mTvViewCount = (TextView) view.findViewById(R.id.tv_view_count);
            mPhotoRecycler = (NineGridView) view.findViewById(R.id.nineGrid);
            mCommentRecycler = (RecyclerView) view.findViewById(R.id.recycler_view);
            mCommentRe = (RelativeLayout) view.findViewById(R.id.re_comment);
        }
    }

    class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder>{


        private List<CommentsBean> mCommentsBeen = new ArrayList<>();

        public CommentAdapter(List<CommentsBean> commentsBeen){
            this.mCommentsBeen = commentsBeen;
        }

        @Override
        public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
           View view = LayoutInflater.from(mContext)
                   .inflate(R.layout.throught_fragment_comment_item_layout,parent,false);
            return new CommentViewHolder(view);
        }

        @Override
        public void onBindViewHolder(CommentViewHolder holder, int position) {
            CommentsBean bean = mCommentsBeen.get(position);
            //评论用户
            String profileName = bean.getName();
            //被回复者  如果为空  默认回复发帖者
            String replayName = bean.getReplyToUserName();

            StringBuffer sb = new StringBuffer();

            SpannableString profileResult = new SpannableString(profileName);
            profileResult.setSpan(new
                            ForegroundColorSpan(mContext
                            .getResources()
                            .getColor(R.color.Blue)),
                    0, profileName.length(),
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


            if (!replayName.equals("")) {  //如果有被回复者
                holder.mTvReplayName.setVisibility(View.VISIBLE);


                sb.append(replayName);
                sb.append(bean.getContent());

                SpannableString replayResult = new SpannableString(sb.toString());
                replayResult.setSpan(new
                                ForegroundColorSpan(mContext
                                .getResources()
                                .getColor(R.color.Blue)),
                        0, replayName.length(),
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                holder.mTvCommentContent.setText(profileResult);
                holder.mTvReplayName.setText(" 回复" + replayResult);

            } else if (replayName.equals("")){
                holder.mTvCommentContent.setText(profileResult);
                String content = bean.getContent();
                holder.mTvReplayName.setVisibility(View.VISIBLE);
                holder.mTvReplayName.setText(" "+content);
            }


//
//            SpannableStringBuilder result = new SpannableStringBuilder();
//
//            result.append(profileResult); //接受评论者
//
//            if (replayResult!=null && !TextUtils.isEmpty(replayResult)){
//                result.append(" "+replayResult);   //如果有回复者,接受回复者
//            }
//            result.append(bean.getContent());  //回复内容
//
//            holder.mTvCommentContent.setText(result.toString());

        }

        @Override
        public int getItemCount() {
            return mCommentsBeen == null ? 0 : mCommentsBeen.size();
        }

        class CommentViewHolder extends RecyclerView.ViewHolder{

            private TextView mTvCommentContent,mTvReplayName;

            public CommentViewHolder(View itemView) {
                super(itemView);
                mTvCommentContent = (TextView) itemView.findViewById(R.id.tv_comment_content);
                mTvReplayName = (TextView) itemView.findViewById(R.id.tv_replay_name);
            }
        }
    }

}
