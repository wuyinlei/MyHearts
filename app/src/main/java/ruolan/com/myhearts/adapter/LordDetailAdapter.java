package ruolan.com.myhearts.adapter;

import android.content.Context;

import com.bumptech.glide.Glide;

import java.util.List;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.entity.LordDetailBean;
import ruolan.com.myhearts.ui.base.BaseViewHolder;
import ruolan.com.myhearts.ui.base.SimpleAdapter;
import ruolan.com.myhearts.widget.GlideCircleTransform;

/**
 * Created by wuyinlei on 2016/10/22.
 */

public class LordDetailAdapter extends SimpleAdapter<LordDetailBean.ResultsBean> {
    public LordDetailAdapter(Context context ,List<LordDetailBean.ResultsBean> datas) {
        super(context, R.layout.fragment_lord_detail_item_layout, datas);
    }

    @Override
    protected void convert(BaseViewHolder viewHoder, LordDetailBean.ResultsBean item) {

        viewHoder.getTextView(R.id.tv_name).setText(item.getName());
        viewHoder.getTextView(R.id.tv_like_count).setText(item.getMember());
        viewHoder.getTextView(R.id.tv_location).setText(item.getLocation());
        viewHoder.getTextView(R.id.tv_distance).setText("10.0km");
        viewHoder.getTextView(R.id.tv_des).setText(item.getSlogan());
        Glide.with(context).load(item.getOwnerAvatar())
                .asBitmap().transform(new GlideCircleTransform(context))
                .into(viewHoder.getImageView(R.id.iv_tour));
    }
}
