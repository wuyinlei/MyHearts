package ruolan.com.myhearts.widget;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by 若兰 on 2016/1/17.
 * 一个懂得了编程乐趣的小白，希望自己
 * 能够在这个道路上走的很远，也希望自己学习到的
 * 知识可以帮助更多的人,分享就是学习的一种乐趣
 * QQ:1069584784
 * csdn:http://blog.csdn.net/wuyinlei
 */

public class ThoughtViewPager extends ViewPager {

    private int startX;
    private int startY;

    public ThoughtViewPager(Context context) {
        super(context);
    }

    public ThoughtViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 事件分发，请求父控件是否拦截
     * <p/>
     * 1、右滑，而且是第一个页面，需要父控件拦截
     * <p/>
     * 2、左滑，而且当前的页面是最后一个页面，需要父控件拦截
     * <p/>
     * 3、上下滑动，需要父控件拦截
     *
     * @param ev
     * @return
     */

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        /**
         * 用getParent()去请求，请求父控件是否不要拦截滑动事件
         */

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //先去让父控件不要拦截，这样才可能走到ACTION_MOVE方法调用
                getParent().requestDisallowInterceptTouchEvent(true);
                /**
                 * 拿到刚开始按下的时候的坐标
                 */
                startX = (int) ev.getRawX();
                startY = (int) ev.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:

                /**
                 * 获取到移动之后的坐标
                 */
                int endX = (int) ev.getRawX();
                int endY = (int) ev.getRawY();

                //左右滑动
                if (Math.abs(endX - startX) > Math.abs(endY - startY)) {
                    if (endX > startX) {
                        //右滑
                        //获取到第一个 需要父控件拦截
                        if (getCurrentItem() == 0) {
                            getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    } else if (endX <= startX) {
                        //左滑
                        //获取到最后一个
                        // 需要父控件拦截
                        if (getCurrentItem() == getAdapter().getCount() - 1) {
                            getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    }
                } else {
                    //上下滑动
                    getParent().requestDisallowInterceptTouchEvent(false);
                }

                break;
            default:
                break;
        }

        return super.dispatchTouchEvent(ev);
    }
}