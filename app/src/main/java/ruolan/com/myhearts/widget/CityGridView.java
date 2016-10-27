package ruolan.com.myhearts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * 自定义的网格布局
 * */

public class CityGridView extends GridView {
    public CityGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CityGridView(Context context) {
        super(context);
    }

    public CityGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

}