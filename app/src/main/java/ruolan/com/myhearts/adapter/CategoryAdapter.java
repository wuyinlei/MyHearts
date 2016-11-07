package ruolan.com.myhearts.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.entity.RoomInfo;

/**
 * Created by renren on 2016/9/20.
 */
public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public static final int TYPE_NORMAL = 1;
    private static final int TYPE_FOOTER = 2;
    private Context mContext;

    private List<RoomInfo.DataEntity> mDataEntities = new ArrayList<>();


    @Override
    public int getItemViewType(int position) {

        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        }
        return TYPE_NORMAL;
    }

    public void clearData(){
        mDataEntities.clear();
    }

    public CategoryAdapter(Context context) {
        mContext = context;
    }

    public void setDataEntities(List<RoomInfo.DataEntity> dataEntities) {
        mDataEntities = dataEntities;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_FOOTER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foot, parent, false);
            return new FooterViewHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_info_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ViewHolder) {
            ViewHolder viewHolder = (ViewHolder) holder;
            RoomInfo.DataEntity entity = mDataEntities.get(position);
            viewHolder.nickname.setText(entity.getNickname());
            String online = entity.getOnline() + mContext.getResources().getString(R.string.num_people);
            viewHolder.online.setText(online);
            Glide.with(mContext)
                    .load(entity.getRoom_src())
                    .asBitmap().into(viewHolder.roomSrc);
            viewHolder.roomSrc.setOnClickListener(v -> {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.OnItemClick(v, position, entity);
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return mDataEntities == null ? 0 : mDataEntities.size() + 1;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView roomSrc;
        TextView nickname;
        TextView online;

        public ViewHolder(View itemView) {
            super(itemView);
            roomSrc = (ImageView) itemView.findViewById(R.id.iv_room);
            nickname = (TextView) itemView.findViewById(R.id.nickname);
            online = (TextView) itemView.findViewById(R.id.online);
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

    public interface OnItemClickListener {
        void OnItemClick(View view, int position, RoomInfo.DataEntity dataEntity);
    }
}
