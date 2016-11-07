package ruolan.com.myhearts.adapter;

import android.content.Context;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.List;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.entity.CircleFriendsCommentBean;
import ruolan.com.myhearts.ui.base.BaseViewHolder;
import ruolan.com.myhearts.ui.base.SimpleAdapter;
import ruolan.com.myhearts.widget.GlideCircleTransform;

/**
 * Created by Administrator on 2016/11/7.
 */

public class CircleFriendsCommentAdapter extends SimpleAdapter<CircleFriendsCommentBean.ResultsEntity>{
    public CircleFriendsCommentAdapter(Context context, List<CircleFriendsCommentBean.ResultsEntity> datas) {
        super(context, R.layout.circle_friends_comments_layout, datas);
    }

    @Override
    protected void convert(BaseViewHolder viewHoder, CircleFriendsCommentBean.ResultsEntity item) {
        viewHoder.getTextView(R.id.tv_name).setText(item.getName());
        viewHoder.getTextView(R.id.tv_content).setText(item.getContent());

        Long addtime = (long) item.getCreatedDate();
        Long result_time = addtime * 1000;
        String date = new SimpleDateFormat("MM-dd HH:mm").format(result_time);
        viewHoder.getTextView(R.id.tv_time).setText(date);
        Glide.with(context)
                .load(item.getAvatar())
                .asBitmap()
                .transform(new GlideCircleTransform(context))
                .error(R.drawable.img_default_head_pic)
                .placeholder(R.drawable.img_default_head_pic)
                .into(viewHoder.getImageView(R.id.img_avatar));

    }
}
