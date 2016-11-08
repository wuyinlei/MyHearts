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
import ruolan.com.myhearts.entity.LivingBean.ResultsEntity;
import ruolan.com.myhearts.widget.GlideCircleTransform;

/**
 * Created by Administrator on 2016/11/8.
 */

public class LivingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ResultsEntity> mEntities = new ArrayList<>();
    private Context mContext;

    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;
    private static final int TYPE_FOOTER = 2;

    private View mHeaderView;

    public View getHeaderView() {
        return mHeaderView;
    }

    public LivingAdapter(Context context) {
        this.mContext = context;
    }

    public void setEntities(List<ResultsEntity> entities) {
        mEntities = entities;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (mHeaderView == null) return TYPE_NORMAL;
        if (position == 0) return TYPE_HEADER;
        if (mHeaderView != null && position +1 == getItemCount()) return TYPE_FOOTER;
        if (mHeaderView == null && position  == getItemCount()) return TYPE_FOOTER;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.radio_live_list_item_record, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_HEADER) return;
        final int pos = getRealPosition(holder);
        if (holder instanceof ViewHolder){
            ViewHolder viewHolder = (ViewHolder) holder;
            ResultsEntity entity = mEntities.get(pos);
            Glide.with(mContext)
                    .load(entity.getBanner())
                    .asBitmap().placeholder(R.drawable.group_detail_default)
                    .error(R.drawable.group_detail_default)
                    .into(viewHolder.mRadioLiveBanner);
            Glide.with(mContext)
                    .load(entity.getAvatar())
                    .asBitmap().placeholder(R.drawable.img_default_head_pic)
                    .error(R.drawable.img_default_head_pic)
                    .transform(new GlideCircleTransform(mContext))
                    .into(viewHolder.mRadioLiveAvatar);
            viewHolder.mRadioLiveTitle.setText(entity.getTitle());
            viewHolder.mRadioLiveNickname.setText(entity.getNickname());
        }
    }

    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mRadioLiveAvatar,mRadioLiveBanner;
        private TextView mRadioLiveNickname,mRadioLiveTitle;


        public ViewHolder(View itemView) {
            super(itemView);

            mRadioLiveAvatar = (ImageView) itemView.findViewById(R.id.radio_live_avatar_l);
            mRadioLiveBanner = (ImageView) itemView.findViewById(R.id.radio_live_banner_l);
            mRadioLiveNickname = (TextView) itemView.findViewById(R.id.radio_live_nickname_l);
            mRadioLiveTitle = (TextView) itemView.findViewById(R.id.radio_live_title_l);

        }
    }


    class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    interface OnItemClickListener {
        void OnItemClick(View view, int position, ResultsEntity categoryBean);
    }

}
