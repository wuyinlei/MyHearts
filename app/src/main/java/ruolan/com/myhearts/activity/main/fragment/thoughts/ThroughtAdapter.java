package ruolan.com.myhearts.activity.main.fragment.thoughts;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import ruolan.com.myhearts.R;
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


    }

    @Override
    public int getItemCount() {
        return mResultsBeen == null ? 0 : mResultsBeen.size();
    }

    class ThroughtViewHolder extends RecyclerView.ViewHolder{

        private ImageView mIvTour;
        private TextView mTvName,mTvTime,mTvContent,mTvCommentCount,mTvViewCount;
        private RecyclerView mPhotoRecycler,mCommentRecycler;
        private RelativeLayout mCommentRe;


        public ThroughtViewHolder(View view) {
            super(view);
            mIvTour  = (ImageView) view.findViewById(R.id.iv_tour);
            mTvName = (TextView) view.findViewById(R.id.tv_name);
            mTvTime = (TextView) view.findViewById(R.id.tv_time);
            mTvContent = (TextView) view.findViewById(R.id.tv_content);
            mTvCommentCount = (TextView) view.findViewById(R.id.tv_comment_count);
            mTvViewCount = (TextView) view.findViewById(R.id.tv_view_count);
            mPhotoRecycler = (RecyclerView) view.findViewById(R.id.recycler_view_photo);
            mCommentRecycler = (RecyclerView) view.findViewById(R.id.recycler_view);
            mCommentRe = (RelativeLayout) view.findViewById(R.id.re_comment);
        }
    }
}
