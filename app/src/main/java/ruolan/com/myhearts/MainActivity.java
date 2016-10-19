package ruolan.com.myhearts;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private DragLayout mDragLayout;
    private ImageView mIvLive,mIvImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDragLayout = (DragLayout) findViewById(R.id.qq_slidding);

        mIvLive = (ImageView) findViewById(R.id.img_live);
        // 获取ImageView上的动画背景
        AnimationDrawable spinnerLive = (AnimationDrawable) mIvLive.getBackground();



        // 开始动画
        spinnerLive.start();

        mIvImg = (ImageView) findViewById(R.id.img_img);

        // 获取ImageView上的动画背景
        AnimationDrawable spinnerImg = (AnimationDrawable) mIvImg.getBackground();
        // 开始动画
        spinnerImg.start();




    }
}
