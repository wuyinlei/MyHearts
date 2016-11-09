package ruolan.com.myhearts.adapter;

import android.content.Context;

import com.bumptech.glide.Glide;

import java.util.List;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.ui.base.BaseViewHolder;
import ruolan.com.myhearts.ui.base.SimpleAdapter;
import ruolan.com.myhearts.widget.transform.GlideCircleTransform;

/**
 * Created by Administrator on 2016/11/7.
 *
 */

public class GroupMemberRecommentAdapter extends SimpleAdapter<String> {
    public GroupMemberRecommentAdapter(Context context, List<String> datas) {
        super(context, R.layout.group_member_tour_layout, datas);
    }

    @Override
    protected void convert(BaseViewHolder viewHoder, String item) {
        Glide.with(context)
                .load(item).asBitmap().transform(new GlideCircleTransform(context))
                .error(R.drawable.img_default_head_pic)
                .placeholder(R.drawable.img_default_head_pic)
                .into(viewHoder.getImageView(R.id.img_avatar));
    }
}
