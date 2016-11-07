package ruolan.com.myhearts.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.entity.GroupMemberBean;
import ruolan.com.myhearts.ui.base.BaseViewHolder;
import ruolan.com.myhearts.ui.base.SimpleAdapter;
import ruolan.com.myhearts.widget.GlideCircleTransform;

/**
 * Created by Administrator on 2016/11/7.
 */

public class GroupMemberAdapter extends SimpleAdapter<GroupMemberBean.ResultsEntity> {

    public GroupMemberAdapter(Context context, List<GroupMemberBean.ResultsEntity> datas) {
        super(context, R.layout.group_member_detail_layout, datas);
    }

    @Override
    protected void convert(BaseViewHolder viewHoder, GroupMemberBean.ResultsEntity item) {
        Glide.with(context)
                .load(item.getAvatar())
                .asBitmap()
                .transform(new GlideCircleTransform(context))
                .into(viewHoder.getImageView(R.id.img_avatar));
        viewHoder.getTextView(R.id.tv_name).setText(item.getNickname());
        TextView mTvSex = viewHoder.getTextView(R.id.tv_sex);
        TextView mTvSexMan = viewHoder.getTextView(R.id.tv_sex_man);
        if (item.getGender().equals("0")) {
            mTvSex.setVisibility(View.VISIBLE);
            mTvSexMan.setVisibility(View.GONE);
            mTvSex.setText(item.getAge() + "");
        } else if (item.getGender().equals("1")) {
            mTvSex.setVisibility(View.GONE);
            mTvSexMan.setVisibility(View.VISIBLE);
            mTvSexMan.setText(item.getAge() + "");
        }
    }
}
