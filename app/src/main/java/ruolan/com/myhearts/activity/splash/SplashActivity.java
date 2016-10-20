package ruolan.com.myhearts.activity.splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.ObjectAnimator;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.activity.main.MainActivity;
import ruolan.com.myhearts.activity.base.BaseActivity;
import ruolan.com.myhearts.activity.guide.GuideActivity;

public class SplashActivity extends BaseActivity {


    //http://icon.xinliji.me/start_img_1080.jpg
    private String splash_img_url = "http://icon.xinliji.me/start_img_1080.jpg";

    private RelativeLayout mReBg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

          /*set it to be no title*/
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
       /*set it to be full screen*/
        /*全屏显示*/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //mReBg = (RelativeLayout) findViewById(R.id.activity_splash);

        View target = findViewById(R.id.activity_splash);

        ObjectAnimator animator = ObjectAnimator.ofFloat(target,"alpha",0.0f,1.0f);
        animator.setDuration(2000);//动画执行的时间

        animator.start();

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                SharedPreferences sp = getPreferences(MODE_PRIVATE);
                boolean isFirst = sp.getBoolean("isFirst", true);
                Intent intent = new Intent();
                if (isFirst) {
                    sp.edit().putBoolean("isFirst", false).commit();
                    intent.setClass(SplashActivity.this, GuideActivity.class);
                } else {
                    intent.setClass(SplashActivity.this, MainActivity.class);
                }

                startActivity(intent);

                finish();
            }
        });

    }
}
