package ruolan.com.myhearts.widget;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import ruolan.com.myhearts.R;

/**
 * Created by 若兰 on 2016/2/13.
 * 一个懂得了编程乐趣的小白，希望自己
 * 能够在这个道路上走的很远，也希望自己学习到的
 * 知识可以帮助更多的人,分享就是学习的一种乐趣
 * QQ:1069584784
 * csdn:http://blog.csdn.net/wuyinlei
 */
public class CircleImageView extends ImageView {

    //外圆的宽度
    private int outCircleWidth;

    //外圆的颜色
    private int outCircleColor = Color.WHITE;

    //画笔
    private Paint paint;

    private int viewWidth;
    private int viewHeigth;

    private Bitmap mBitmap;
    private Bitmap image;

    public CircleImageView(Context context) {
        this(context, null);
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initAttrs(context, attrs, defStyleAttr);
    }

    /**
     * 初始化资源文件
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    private void initAttrs(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray array = null;
        if (attrs != null) {
            array = context.obtainStyledAttributes(attrs, R.styleable.CircleImageView);

            int len = array.length();

            for (int i = 0; i < len; i++) {
                int attr = array.getIndex(i);
                switch (attr) {
                    //获取到外圆的颜色
                    case R.styleable.CircleImageView_outCircleColor:
                        this.outCircleColor = array.getColor(attr, Color.WHITE);
                        break;
                    //获取到外圆的半径
                    case R.styleable.CircleImageView_outCircleWidth:
                        this.outCircleWidth = (int) array.getDimension(attr, 5);
                        break;
                }
            }
        }
        paint = new Paint();
        paint.setColor(outCircleColor);//颜色
        paint.setAntiAlias(true);//设置抗锯齿
        array.recycle();  //回收

    }

    /**
     * view的测量
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int width = measureWith(widthMeasureSpec);
        int height = measureWith(heightMeasureSpec);

        viewWidth = width - outCircleWidth * 2;
        viewHeigth = height - outCircleWidth * 2;

        setMeasuredDimension(width, height);
    }

    private int measureWith(int widthMeasureSpec) {
        int result = 0;
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);
        if (mode == MeasureSpec.EXACTLY) {
            result = size;
        } else {
            result = viewWidth;
        }
        return result;
    }

    /**
     * 绘制
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        //加载图片
        loadImage();

        if (image != null) {
            //拿到最小的值
            int min = Math.min(viewWidth, viewHeigth);

            int circleCenter = min / 2;

            image = Bitmap.createScaledBitmap(image, min, min, false);

            canvas.drawCircle(circleCenter + outCircleWidth, circleCenter + outCircleWidth, circleCenter + outCircleColor, paint);

            canvas.drawBitmap(createCircleBitmap(image, min), outCircleWidth, outCircleWidth, null);
        }


    }

    private Bitmap createCircleBitmap(Bitmap image, int min) {

        Bitmap bitmap = null;


        Paint paint = new Paint();
        paint.setAntiAlias(true);
        bitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);

        //画一个和图片大小相等的画布
        canvas.drawCircle(min / 2, min / 2, min / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        canvas.drawBitmap(image, 0, 0, paint);


        return bitmap;
    }

    private void loadImage() {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) this.getDrawable();

        if (bitmapDrawable != null) {
            image = bitmapDrawable.getBitmap();
        }
    }

    public void setOutCircleColor(int outCircleColor) {
        if (null != paint) {
            paint.setColor(outCircleColor);
        }
        this.invalidate();
    }

    public void setOutCircleWidth(int outCircleWidth) {
        this.outCircleWidth = outCircleWidth;
        this.invalidate();
    }
}
