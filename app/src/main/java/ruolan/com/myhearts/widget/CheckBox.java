package ruolan.com.myhearts.widget;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Checkable;

import ruolan.com.myhearts.R;


/**
 * Created by bigmercu on 16/7/23.
 * Email:bigmercu@gmail.com
 */

public class CheckBox extends View implements Checkable{

    private static final String TAG = CheckBox.class.getSimpleName();
    private int hSize = dp2px(15);
    private int wSize = dp2px(15);
    private int textSize = dp2px(15);
    private int wStart = dp2px(1);
    private int hStart = dp2px(1);
    private int Duration = 300;
    private int strokeWidth = dp2px(2);
    private int mPaintColor;
    private String boxText = "CheckBox";
    private Paint mPaint;
    private Paint mPaintAfter;
    private Paint mPaintText;
    private Path mPath;
    private Path mDst;
    private PathMeasure pathMeasure;
    //用于外圆边框动画
    private float pathLenthBorder;
    private Path mPathBorder;
    private Path mDstBorder;
    private PathMeasure pathMeasureBorder;

    private float pathLenth;
    private int AnimationValue = 255;
    private int AnimationValueBorder;
    private int AnimationValue1;
    private float AnimationValue2;
    private float AnimationValue3;
    private float AnimationValue4;
    private ValueAnimator valueAnimator;
    private ValueAnimator valueAnimatorBorder;
    private ValueAnimator valueAnimator1;
    private ValueAnimator valueAnimator2;
    private ValueAnimator valueAnimator3;
    private ValueAnimator valueAnimator4;
    private float cAnimationValue = 0;
    private float cAnimationValue1 = 0;
    private int cAnimationValue2 = 255;
    private ValueAnimator cValueAnimator;
    private ValueAnimator cValueAnimator1;
    private ValueAnimator cValueAnimator2;
    private boolean checked = false;
    private boolean isHook = true;
    private boolean isShowBorder = false;
    private int mScreenWidth,mSreenHeight;
    private OnCheckedChangeListener mOnCheckedChangeListener;
    private int redAfter ;
    private int greenAfter ;
    private int blueAfter ;
    private int redBefore ;
    private int greenBefore;
    private int blueBefore ;
    private boolean isCircle;


    public CheckBox(Context context) {
        super(context);
    }

    public CheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        int textColor = 0;
        if(attrs != null){
            TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.BBox);
            int colorAfter = array.getColor(R.styleable.BBox_color_after,Color.GRAY);
            int colorBefore = array.getColor(R.styleable.BBox_color_before,Color.GRAY);
            textColor = array.getColor(R.styleable.BBox_text_color,Color.BLUE);
            redAfter = (colorAfter & 0xff0000) >> 16;
            greenAfter = (colorAfter & 0x00ff00) >> 8;
            blueAfter = (colorAfter & 0x0000ff);


            redBefore = (colorBefore & 0xff0000) >> 16;
            greenBefore = (colorBefore & 0x00ff00) >> 8;
            blueBefore = (colorBefore & 0x0000ff);

            boxText = array.getString(R.styleable.BBox_check_text);
            isHook = array.getInt(R.styleable.BBox_check_style, 1) == 1;
            isShowBorder = array.getBoolean(R.styleable.BBox_show_border,false);
            isCircle = array.getBoolean(R.styleable.BBox_is_circle_border,true);

            if(boxText == null){
                boxText = "CheckBox";
            }
            array.recycle();
        }

        mPaint.setStrokeWidth(strokeWidth);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeCap(Paint.Cap.SQUARE);
        mPaint.setDither(true);

        mPaintText = new Paint();

        if (textColor==0){
            mPaintText.setColor(Color.WHITE);
        } else {
            mPaintText.setColor(textColor);
        }

//        mPaintText.setStrokeWidth(strokeWidth);
        mPaintText.setAntiAlias(true);
        mPaintText.setStyle(Paint.Style.STROKE);
        mPaintText.setTextSize(textSize);
        mPaintText.setAntiAlias(true);

        mPath = new Path();
        mPathBorder = new Path();
        pathMeasure = new PathMeasure();
        pathMeasureBorder = new PathMeasure();

        mPath.addRect(wStart,hStart,wSize + wStart,hSize + hStart, Path.Direction.CW);
        pathMeasure.setPath(mPath,true);
        pathLenth = pathMeasure.getLength();

        mPathBorder.addCircle(wStart + wSize/2,hStart + hSize/2,(float) Math.sqrt((wSize/2)*(wSize/2) + (hSize/2) *(hSize/2)), Path.Direction.CCW);
        pathMeasureBorder.setPath(mPathBorder,true);
        pathLenthBorder = pathMeasureBorder.getLength();

        mDst = new Path();
        mDstBorder = new Path();

        valueAnimator = ValueAnimator.ofInt(255, 0);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                AnimationValue = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });

        valueAnimatorBorder = ValueAnimator.ofInt(0,(int) pathLenthBorder);
        valueAnimatorBorder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                AnimationValueBorder = (int) animation.getAnimatedValue();
            }
        });

        if(isHook) {

            valueAnimator1 = ValueAnimator.ofInt(180, 225);
            valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    AnimationValue1 = (int) animation.getAnimatedValue();
                }
            });

            valueAnimator2 = ValueAnimator.ofFloat(hSize + wSize, wSize * 2 / 5);
            valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    AnimationValue2 = (float) animation.getAnimatedValue();
                }
            });

            valueAnimator3 = ValueAnimator.ofFloat(hSize + wSize, hSize + wSize * 2);
            valueAnimator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    AnimationValue3 = (float) animation.getAnimatedValue();
                }
            });

            valueAnimator4 = ValueAnimator.ofFloat((float) 0.0, (float) 0.207555);
            valueAnimator4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    AnimationValue4 = (float) animation.getAnimatedValue();
                }
            });

        }else {
            cValueAnimator = ValueAnimator.ofFloat(0,(int)(hSize * 0.4));
            cValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    cAnimationValue = (float) animation.getAnimatedValue();
                }
            });


            cValueAnimator1 = ValueAnimator.ofFloat(0,wSize/2);
            cValueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    cAnimationValue1 = (float) animation.getAnimatedValue();
                }
            });

        }
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setChecked(!checked);
            }
        });
    }

    public CheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int paddingLeft = getPaddingLeft() + 10;
        int paddingRight = getPaddingRight() + 10;
        int paddingTop = getPaddingTop() + 10;
        int paddingBottom = getPaddingBottom() + 10;


        if(widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(2* strokeWidth +  wStart + wSize  + 20 + paddingLeft + textSize * boxText.length(),hStart + hSize + paddingTop + paddingBottom + 2 * strokeWidth);
            Log.d(TAG, wStart+" "+ wSize +" "+ textSize * boxText.length() + "   " +boxText.length());
        }else if(widthSpecMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(2* strokeWidth +wStart + wSize + paddingLeft + 20 +  textSize * boxText.length(),widthSpecSize);
        }else if(heightSpecMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(heightSpecSize,hStart + hSize + paddingTop + paddingBottom+ 2 * strokeWidth);
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    public void setChecked(boolean set){
        if(checked == set){
            return;
        }else {
            if(checked){
                animationReverse();
            }else {
                animationStart();
            }
            checked = set;
        }
        if(mOnCheckedChangeListener != null){
            mOnCheckedChangeListener.onChange(checked);
        }
        postInvalidate();
    }

    public boolean isChecked(){
        return checked;
    }

    @Override
    public void toggle() {
        setChecked(!checked);
    }


    public void setText(String text){
        boxText = text;
        postInvalidate();
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mScreenWidth = w;
        mSreenHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mDst.reset();
        mDstBorder.reset();
        mDstBorder.lineTo(0,0);
        mDst.lineTo(0,0);

        int paddingLeft = getPaddingLeft() + 10;
        int paddingRight = getPaddingRight() + 10;
        int paddingTop = getPaddingTop() + 10;
        int paddingBottom = getPaddingBottom() + 10;

        int r = (int) ((1 - (float) AnimationValue / 255) * redBefore + (float) AnimationValue / 255 * redAfter);
        int g = (int) ((1 - (float) AnimationValue / 255) * greenBefore + (float) AnimationValue / 255 * greenAfter);
        int b = (int) ((1 - (float) AnimationValue / 255) * blueBefore + (float) AnimationValue / 255 * blueAfter);
        mPaintColor = Color.rgb(r, g, b);
        mPaint.setColor(mPaintColor);

        if(isHook) {

            canvas.translate(wStart + paddingLeft, hStart + paddingTop);
            if(isShowBorder) {
                canvas.save();
            }

            canvas.drawText(boxText, wStart  + wSize + 18, (hSize + textSize )/2, mPaintText);
            //确保图形在正中
            canvas.translate(-AnimationValue4 * wSize, (float) (-AnimationValue4 * hSize * 1.5));
            /**
             * 如果 startWithMoveTo 为 true, 则被截取出来到Path片段保持原状，如果 startWithMoveTo 为 false，
             * 则会将截取出来的 Path 片段的起始点移动到 dst 的最后一个点，以保证 dst 的连续性。
             * */

            pathMeasure.getSegment(AnimationValue3, pathLenth, mDst, true);
            pathMeasure.getSegment(0, wSize * 2 / 5, mDst, true);
            pathMeasure.getSegment(wSize * 2 / 5, AnimationValue2, mDst, true);

            canvas.rotate(AnimationValue1, wStart  + wSize / 2, hStart  + hSize / 2);

            canvas.drawPath(mDst, mPaint);

            if(isShowBorder) {
                canvas.restore();
                if(isCircle) {
                    pathMeasureBorder.getSegment(0, AnimationValueBorder, mDstBorder, true);
                    canvas.drawPath(mDstBorder, mPaintText);
                }else {
                    canvas.drawRect(wStart, hStart, wStart + wSize, hSize + hStart, mPaintText);
                }
            }

        }else {
            canvas.translate(wStart+ paddingLeft , hStart + paddingTop );
            if(isShowBorder) {
                canvas.save();
            }
            canvas.drawText(boxText, wStart  + wSize + 18, (hSize + textSize )/2, mPaintText);
            mDst.moveTo((float) (wStart + cAnimationValue * 0.3), (float) (hStart + cAnimationValue * 0.3));

            mDst.lineTo(wStart + wSize/2, (float) (hStart + cAnimationValue + cAnimationValue * 0.2));
            mDst.lineTo((float) (wStart+ wSize - cAnimationValue * 0.2), (float) (hStart + cAnimationValue * 0.2));
            mDst.lineTo((float) (wStart+ wSize -cAnimationValue - cAnimationValue * 0.2),hSize/2 + hStart );
            mDst.lineTo((float) (wStart+ wSize - cAnimationValue * 0.2), (float) (hStart  + hSize - cAnimationValue * 0.2));
            mDst.lineTo(wStart+ wSize/2, (float) (hStart  + hSize - cAnimationValue - cAnimationValue * 0.2));
            mDst.lineTo((float) (wStart + cAnimationValue * 0.2), (float) (hStart  + hSize - cAnimationValue * 0.2));
            mDst.lineTo((float) (wStart + cAnimationValue + cAnimationValue * 0.2),hStart  + hSize/2);
            mDst.lineTo((float) (wStart + cAnimationValue * 0.3), (float) (hStart + cAnimationValue * 0.3));
            canvas.drawPath(mDst,mPaint);
            if(isShowBorder) {
                canvas.restore();
                if(isCircle) {
                    pathMeasureBorder.getSegment(0, AnimationValueBorder, mDstBorder, true);
                    canvas.drawPath(mDstBorder, mPaintText);
                }else {
                    canvas.drawRect(wStart, hStart, wStart + wSize, hSize + hStart, mPaintText);
                }
            }
        }

    }



    private void animationStart(){
        if(isHook) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(valueAnimator1,valueAnimator2,valueAnimator3,valueAnimator4,valueAnimatorBorder,valueAnimator);
            animatorSet.setInterpolator(new DecelerateInterpolator());
            valueAnimatorBorder.setInterpolator(new AccelerateInterpolator());
            animatorSet.setDuration(Duration);
            animatorSet.start();

        }else {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(cValueAnimator,cValueAnimator1,valueAnimatorBorder,valueAnimator);
            animatorSet.setInterpolator(new DecelerateInterpolator());
            valueAnimatorBorder.setInterpolator(new AccelerateInterpolator());
            animatorSet.setDuration(Duration);
            animatorSet.start();
        }
    }

    private void animationReverse(){
        if(isHook) {
            valueAnimator1.reverse();
            valueAnimator2.reverse();
            valueAnimator3.reverse();
            valueAnimator4.reverse();
        }else {
            cValueAnimator.reverse();
            cValueAnimator1.reverse();
        }
        valueAnimatorBorder.reverse();
        valueAnimator.reverse();
    }



    public int dp2px(float value) {
        float density = getResources().getDisplayMetrics().density;
        return (int) (value * density + 0.5f);
    }


    public interface  OnCheckedChangeListener{
        void onChange(boolean checked);
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        this.mOnCheckedChangeListener = listener;
    }
}