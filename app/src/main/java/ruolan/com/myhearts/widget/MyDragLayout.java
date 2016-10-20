package ruolan.com.myhearts.widget;



import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by Administrator on 2016/10/20.
 */

public class MyDragLayout extends FrameLayout{

    private ViewDragHelper mDragHelper;
    private ViewGroup mLeftContent;
    private ViewGroup mMainContent;

    /**
     * 屏幕高度
     */
    private int mHeight;

    /**
     * 屏幕宽度
     */
    private int mWidth;

    /**
     * 左侧拉出来的宽度
     */
    private int mRange;


    /**
     * 定义当前状态  默认是关闭状态
     */
    private Status mStatus = Status.CLOSE;


    public Status getStatus() {
        return mStatus;
    }

    /**
     * 状态枚举
     * 关闭  CLOSE
     * 打开  OPEN
     * 拖拽  DRAGING
     */
    public enum Status {
        CLOSE, OPEN, DRAGING;
    }

    private OnDragStatusListener mListener;


    public void setDragStateListener(OnDragStatusListener listener) {
        mListener = listener;
    }

    public interface OnDragStatusListener {

        /**
         * 关闭逻辑
         */
        void onClose();

        /**
         * 打开逻辑
         */
        void onOpen();

        /**
         * 拖拽逻辑
         *
         * @param percent
         */
        void onDraging(float percent);
    }


    public MyDragLayout(Context context) {
        this(context, null);
    }

    public MyDragLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyDragLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


        //1、通过静态方法初始化操作
        mDragHelper = ViewDragHelper.create(this, mCallback);
    }

    ViewDragHelper.Callback mCallback = new ViewDragHelper.Callback() {

        /**
         * 根据返回结果决定当前child是否可以拖拽
         * 尝试捕获的时候调用，如果返回的是主面板，那么负面版是不能被调用的
         * @param child    当前被拖拽的view
         * @param pointerId    区分多点触摸的id
         * @return 返回true 是都可以拖拽
         *          返回child == mLeftContent   左侧可以移动
         *          返回child == mMainContent   右侧可以移动
         */
        @Override
        public boolean tryCaptureView(View child, int pointerId) {

            return true;
        }

       /* @Override
        public void onViewCaptured(View capturedChild, int activePointerId) {
            Log.d("DragLayout", "onViewCaptured : " + capturedChild);
            //当tryCaptureView被捕获的时候调用
            super.onViewCaptured(capturedChild, activePointerId);
        }
*/

        /**
         * 根据建议值修正将要移动的位置   此时并没有发生真正的移动(左右)
         *
         * @param child    当前拖拽的view
         * @param left     新的位置的建议值  oldLeft + dx
         * @param dx       变化量   和变化之前位置的差值
         * @return
         */
        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            //返回的拖拽的范围，不对拖拽进行真正的限制，仅仅决定了动画执行的速度
            if (child == mMainContent) {
                left = fixLeft(left);
            }
            return left;
        }


        /**
         * 当view位置改变的时候，处理要做的事情，更新状态，伴随动画，重绘界面
         *
         * 此时view已经发生了位置的改变
         *
         * @param changedView   改变的位置view
         * @param left   新的左边值
         * @param top
         * @param dx   水平变化量
         * @param dy
         */
        @Override
        public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
            super.onViewPositionChanged(changedView, left, top, dx, dy);

            int newLeft = left;

            //如果我们拖拽的是左面板
            if (changedView == mLeftContent) {
                //新的左侧位置是我们的主面板的左侧加上水平变化量
                newLeft = mMainContent.getLeft() + dx;
            }

            //进行修正(不能超出我们的规定的范围)
            newLeft = fixLeft(newLeft);

            if (changedView == mLeftContent) {
                //当左面板移动之后，在强制放回去
                mLeftContent.layout(0, 0, 0 + mWidth, 0 + mHeight);
                mMainContent.layout(newLeft, 0, newLeft + mWidth, 0 + mHeight);
            }

            dispatchDragEvent(newLeft);

            //兼容低版本   强制重绘
            invalidate();
        }

        /**
         * 设定水平移动的范围
         *
         * @param child
         * @return
         */
        @Override
        public int getViewHorizontalDragRange(View child) {
            //返回的拖拽的范围，不对拖拽进行真正的限制，仅仅决定了动画执行的速度
            return mRange;
        }

        /**
         * 当view被释放的时候处理的事情（松手）
         *
         * @param releasedChild 被释放的子view
         * @param xvel     水平方向的速度  帧每秒   向右为 +
         * @param yvel     竖直方向的速度  向下为 +
         */
        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            Log.d("DragLayout", "xvel : " + xvel + " yvel :" + yvel);
            super.onViewReleased(releasedChild, xvel, yvel);

            //判断关闭和打开
            //在这里我们首先判断什么时候打开，然后剩下的都是关闭状态
            //首先是我的主面板的左侧具体屏幕左侧已经大于mRange/2的距离并且右滑的速度大于0，此时打开
            if (xvel >= 0 && mMainContent.getLeft() > mRange / 2.0f) {
                open();
            } else if (xvel > 0) {
                //第二种就是我右滑的速度大于0(这里的速度自己定义哈，根据自己想要实现的敏感度)
                open();
            } else {
                //剩余的所有情况都是关闭
                close();
            }

        }

    };

    /**
     * 状态更新方法执行
     *
     * @param newLeft
     */
    private void dispatchDragEvent(int newLeft) {
        //得到的一个百分比
        float percent = newLeft * 1.0f / mRange;

        //0.0f--->1.0f
        Log.d("DragLayout", "percent : " + percent);

        if (mListener != null) {
            mListener.onDraging(percent);
        }

        //跟新状态执行回调
        Status lastStatus = mStatus;

        mStatus = updateStatus(percent);

        if (mStatus != lastStatus) {
            //状态发生变化
            if (mStatus == Status.CLOSE) {
                //当前状态是关闭
                if (mListener != null) {
                    mListener.onClose();
                }
            } else if (mStatus == Status.OPEN) {
                if (mListener != null) {
                    mListener.onOpen();
                }
            }
        }

    }

    /**
     * 状态更新方法
     *
     * @param percent
     * @return
     */
    private Status updateStatus(float percent) {
        if (percent == 0) {
            return Status.CLOSE;
        } else if (percent == 1) {
            return Status.OPEN;
        }
        return Status.DRAGING;
    }

  /*  *//**
     * 更新状态，执行动画
     *
     * @param newLeft
     *//*
    private void dispatchDragEvent(int newLeft) {
        float percent = newLeft * 1.0f / mRange;//得到滑动的百分比
        *//**
     * 伴随动画分析
     * 1、左面板：  平移动画  透明度动画
     *//*
        //mLeftContent.setScaleX(0.5f*percent +0.5f);
        //mLeftContent.setScaleY(0.5f*percent +0.5f);
        //缩放动画
        ViewHelper.setScaleX(mLeftContent, 0.5f * percent + 0.5f);
        ViewHelper.setScaleY(mLeftContent, 0.5f * percent + 0.5f);
        //平移动画 -mWidth / 2.0f  -> 0.0f
        ViewHelper.setTranslationX(mLeftContent, evaluate(percent, -mWidth / 2.0f, 0));
        //透明度 ： 0.5--->1.0f
        ViewHelper.setAlpha(mLeftContent, evaluate(percent, 0.5f, 1.0f));
        ViewHelper.setAlpha(mMainContent,evaluate(percent,1.0f,1.0f));
        *//** 2、主面板    透明度动画
     *//*
        *//**
     * 3、背景   亮度变化
     *//*
    }
*/

    /**
     * 估值器
     *
     * @param fraction
     * @param startValue
     * @param endValue
     * @return
     */
    public Float evaluate(float fraction, Number startValue, Number endValue) {
        float startFloat = startValue.floatValue();
        return startFloat + fraction * (endValue.floatValue() - startFloat);
    }

    /**
     * 持续动画
     */
    @Override
    public void computeScroll() {
        super.computeScroll();

        //如果返回true，动画要继续执行
        if (mDragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void close() {
        close(true);
    }

    /**
     * 关闭
     *
     * @param isSmooth 是否平滑的关闭
     */
    public void close(boolean isSmooth) {
        int finalLeft = 0;

        if (isSmooth) {
            /**
             *  public boolean smoothSlideViewTo(View child, int finalLeft, int finalTop)方法的解释
             *
             * Animate the view <code>child</code> to the given (left, top) position.
             * If this method returns true, the caller should invoke {@link #continueSettling(boolean)}
             * on each subsequent frame to continue the motion until it returns false. If this method
             * returns false there is no further work to do to complete the movement.
             *
             * 返回true  代表还没有移动到指定的位置，需要刷新界面，继续移动
             * 返回false 就停止工作哈
             */
            //1、触发动画
            if (mDragHelper.smoothSlideViewTo(mMainContent, finalLeft, 0)) {
                //参数传this,也就是child所在的viewgroup
                ViewCompat.postInvalidateOnAnimation(this);
            }
        } else {

            //调用layout方法，摆放主布局
            /**
             * @param l Left position, relative to parent
             * @param t Top position, relative to parent
             * @param r Right position, relative to parent
             * @param b Bottom position, relative to parent
             */
            mMainContent.layout(finalLeft, 0, finalLeft + mWidth, finalLeft + mHeight);
        }

    }

    /**
     * 打开
     */
    public void open(boolean isSmooth) {
        int finalLeft = mRange;

        if (isSmooth && mDragHelper.smoothSlideViewTo(mMainContent, finalLeft, 0)) {
            //参数传this,也就是child所在的viewgroup
            ViewCompat.postInvalidateOnAnimation(this);
        } else {
            mMainContent.layout(finalLeft, 0, finalLeft + mWidth, finalLeft + mHeight);
        }
    }

    public void open() {
        open(true);
    }

   // private ItemRecycleAdapter adapter;

    float mDownX ;
    /**
     * 2、传递触摸事件
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        if(getStatus() == Status.CLOSE){
            switch (ev.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    //获取到按压的是否的x坐标
                    mDownX = ev.getRawX();
                    break;
                case MotionEvent.ACTION_MOVE:
                    //如果在移动的时候，item打开的个数大于0，就不拦截事件
                 //   if(adapter.getOpenItems() > 0){
                   //     return false;
                   // }
                    //如果是向左滑，就不拦截事件(不用判断也行)
                    float delta = ev.getRawX() - mDownX;
                    if(delta < 0){
                        return false;
                    }
                    break;
                default:
                    mDownX = 0;
                    break;
            }
        }
        return mDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        try {
            mDragHelper.processTouchEvent(event);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }


    /**
     * Finalize inflating a view from XML.  This is called as the last phase
     * of inflation, after all child views have been added.
     * 当xml填充完的时候去掉用，在这里我们可以找到我们要去操控的那两个布局
     * <p>Even if the subclass overrides onFinishInflate, they should always be
     * sure to call the super method, so that we get called.
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        /**
         * 根据索引来找
         */

        /**
         * 得到左边的布局
         */
        mLeftContent = (ViewGroup) getChildAt(0);

        /**
         * 得到主main布局
         */
        mMainContent = (ViewGroup) getChildAt(1);
    }


    /**
     * 当尺寸变化的时候去调用
     * This is called during layout when the size of this view has changed
     *
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);


        /**
         * 屏幕的宽度和高度
         */
        mHeight = getMeasuredHeight();
        mWidth = getMeasuredWidth();

        /**
         * 自定义左侧view拖拽出来的距离
         */
        mRange = (int) (mWidth * 0.8);
    }

    /**
     * 修正方法
     *
     * @param left
     * @return
     */
    private int fixLeft(int left) {
        if (left < 0) {
            return 0;
        } else if (left > mRange) {
            return mRange;
        }
        return left;
    }



  //  public void setAdapterInterface(ItemRecycleAdapter adapter) {
   //     this.adapter = adapter;
   // }
}
