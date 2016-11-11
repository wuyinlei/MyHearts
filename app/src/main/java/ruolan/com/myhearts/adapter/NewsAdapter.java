package ruolan.com.myhearts.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.entity.NewsBean;

/**
 * Created by Administrator on 2016/11/10.
 *
 */

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<NewsBean.DatasEntity> mEntities = new ArrayList<>();
    private Context mContext;

    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;
    private static final int TYPE_FOOTER = 2;

    private View mHeaderView;

    public View getHeaderView() {
        return mHeaderView;
    }

    public NewsAdapter(Context context,List<NewsBean.DatasEntity> entities) {
        this.mContext = context;
        mEntities = entities;
    }

    public void setEntities(List<NewsBean.DatasEntity> entities) {
        mEntities = entities;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (mHeaderView == null) return TYPE_NORMAL;
        if (position == 0) return TYPE_HEADER;
        if (mHeaderView != null && position + 1 == getItemCount()) return TYPE_FOOTER;
        if (mHeaderView == null && position == getItemCount()) return TYPE_FOOTER;
        return TYPE_NORMAL;
    }

    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }

    @Override
    public int getItemCount() {
        return mHeaderView == null ? mEntities.size() + 1 : mEntities.size() + 2;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mHeaderView != null && viewType == TYPE_HEADER) return new ViewHolder(mHeaderView);
        if (viewType == TYPE_FOOTER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foot, parent, false);
            return new FooterViewHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_adapter_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_HEADER) return;
        final int pos = getRealPosition(holder);
        if (holder instanceof ViewHolder) {
            ViewHolder viewHolder = (ViewHolder) holder;
            NewsBean.DatasEntity entity = mEntities.get(pos);
            Glide.with(mContext)
                    .load(entity.getListPicUrl())
                    .asBitmap()
                    .error(R.drawable.group_detail_default)
                    .placeholder(R.drawable.group_detail_default)
                    .into(viewHolder.mNewsPic);
            viewHolder.mNewsViewCount.setText(entity.getViews()+"");
            viewHolder.mNewsTitle.setText(entity.getTitle());
            viewHolder.mNewsPublishTime.setText(entity.getPublishTime());
            if (entity.getSummary() !=null){
                viewHolder.mNewsSubTitle.setText(entity.getSummary()+"");
            }
        }
    }

    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mNewsPic;
        private TextView mNewsTitle,mNewsViewCount,mNewsPublishTime,mNewsSubTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            mNewsPic = (ImageView) itemView.findViewById(R.id.news_pic);
            mNewsTitle = (TextView) itemView.findViewById(R.id.news_title);
            mNewsViewCount = (TextView) itemView.findViewById(R.id.news_count_see);
            mNewsPublishTime = (TextView) itemView.findViewById(R.id.publish_time);
            mNewsSubTitle = (TextView) itemView.findViewById(R.id.news_sub_title);
        }
    }

    class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }

    private LivingAdapter.OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(LivingAdapter.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void OnItemClick(View view, int position, NewsBean.DatasEntity newsBean);
    }

}
