package ruolan.com.myhearts.ui.main.fragment.lord;

import android.content.Context;

import com.bumptech.glide.Glide;

import java.util.List;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.ui.base.BaseViewHolder;
import ruolan.com.myhearts.ui.base.SimpleAdapter;
import ruolan.com.myhearts.widget.GlideCircleTransform;

/**
 * Created by Administrator on 2016/10/21.
 */

public class LordAdapter extends SimpleAdapter<LordBean.ResultsBean> {


    public LordAdapter(Context context, List<LordBean.ResultsBean> datas) {
            super(context, R.layout.lord_item_layout, datas);
    }

    @Override
    protected void convert(BaseViewHolder viewHoder, LordBean.ResultsBean item) {
        Glide.with(context)
                .load(item.getIcon())
                .asBitmap()
                .transform(new GlideCircleTransform(context))
                .into(viewHoder.getImageView(R.id.iv_group));

        viewHoder.getTextView(R.id.tv_group).setText(item.getLabel());
    }
}