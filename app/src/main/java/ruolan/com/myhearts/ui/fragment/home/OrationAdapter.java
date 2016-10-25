package ruolan.com.myhearts.ui.fragment.home;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.ui.base.BaseViewHolder;
import ruolan.com.myhearts.ui.base.SimpleAdapter;

/**
 * Created by Administrator on 2016/10/21.
 */

public class OrationAdapter extends SimpleAdapter<HomeNewsBean.ResultsBean> {


    public OrationAdapter(Context context, List<HomeNewsBean.ResultsBean> datas) {
        super(context, R.layout.home_news_item, datas);
    }

    @Override
    protected void convert(BaseViewHolder viewHoder, HomeNewsBean.ResultsBean item) {
        viewHoder.getTextView(R.id.tv_title).setText(item.getTitle());
        viewHoder.getTextView(R.id.tv_subtitle).setText(item.getCatg());
        viewHoder.getTextView(R.id.tv_count_like).setText(item.getLikeCnt());
        viewHoder.getTextView(R.id.tv_count_see).setText(item.getViewCnt());
        Glide.with(context)
                .load(item.getIcon()).asBitmap().into((ImageView) viewHoder.getView(R.id.iv_pic));

    }


}
