package ruolan.com.myhearts.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by 若兰 on 2016/1/26.
 * 一个懂得了编程乐趣的小白，希望自己
 * 能够在这个道路上走的很远，也希望自己学习到的
 * 知识可以帮助更多的人,分享就是学习的一种乐趣
 * QQ:1069584784
 * csdn:http://blog.csdn.net/wuyinlei
 */

public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    /**
     * 采用系统的内置的分割线风格
     */
    private static final int[] attrs = new int[]{android.R.attr.listDivider};
    private final TypedArray mTypedArray;


    //水平方式
    public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;

    //垂直方式
    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;

    private Drawable mDivider;

    //方向
    private int mOrientation;

    /**
     * 默认方向是垂直的
     */

    public DividerItemDecoration(Context context, int orientation) {
        super();
        //读取系统自定义属性
        // Returns a TypedArray holding an array of the attribute values.
        mTypedArray = context.obtainStyledAttributes(attrs);
        mDivider = mTypedArray.getDrawable(0);

        //回收资源
        mTypedArray.recycle();
        setHorizontal(orientation);
    }

    /**
     * 判断传入的是横向的还是纵向的
     *
     * @param orientation
     */
    private void setHorizontal(int orientation) {
        //如果两种都不是就抛出异常
        if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
            throw new IllegalArgumentException("错误的方式");
        }
        mOrientation = orientation;
    }


    //left  top right bottom

    /**
     * 绘制   根据传入的是水平的还是垂直的
     *
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == VERTICAL_LIST) {
            drawVertical(c, parent);
        } else {
            drawHorizontal(c, parent);
        }
    }

    /**
     * linear  垂直列表
     *
     * @param c
     * @param parent
     */
    private void drawVertical(Canvas c, RecyclerView parent) {
        int left = parent.getPaddingLeft();

        int right = parent.getWidth() - parent.getPaddingRight();

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            //得到布局中的子item
            View childView = parent.getChildAt(i);

            //得到子view的布局泵  LayoutParams相当于一个Layout的信息包，它封装了Layout的位置、高、宽等信息
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childView.getLayoutParams();
            /**
             * top 是子view的底布局加上和他的底margin值
             */
            int top = childView.getBottom() + layoutParams.bottomMargin;
            int bottom = top + mDivider.getIntrinsicHeight();
            //设置四个方向的bounds
            mDivider.setBounds(left, top, right, bottom);
            //然后画线
            mDivider.draw(c);
        }
    }

    /**
     * 横向列表的横线
     *
     * @param c
     * @param parent
     */
    private void drawHorizontal(Canvas c, RecyclerView parent) {
        final int top = parent.getPaddingTop();
        final int bottom = parent.getHeight() - parent.getPaddingBottom();

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int left = child.getRight() + params.rightMargin;
            final int right = left + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == VERTICAL_LIST) {
            outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
        } else {
            outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
        }
    }
}