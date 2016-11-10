package ruolan.com.myhearts.ui.base;


import android.content.Context;

import java.util.List;
/**
 * Created by Administrator on 2016/10/21.
 */

public abstract class SimpleAdapter <T> extends BaseAdapter<T,BaseViewHolder> {

    public SimpleAdapter(Context context, int layoutResId) {
        super(context, layoutResId);
    }

    public SimpleAdapter(Context context, int layoutResId, List<T> datas) {
        super(context, layoutResId, datas);
    }

}