package ruolan.com.myhearts;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    //图片资源
    int [] images = new int[]{
            R.mipmap.welcome_1,
            R.mipmap.welcome_2,
            R.mipmap.welcome_3,
            R.mipmap.welcome_4
    };

    private List<View> mViews = new ArrayList<>();

    private ViewPager mViewPager;
    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        initData();
        MyViewPagerAdapter adapter = new MyViewPagerAdapter();
        mViewPager.setAdapter(adapter);
        mViewPager.setOnPageChangeListener(this);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GuideActivity.this,MainActivity.class));
                finish();
            }
        });
    }

    private void initData() {
        for (int i = 0; i < images.length; i++) {
            View inflate = getLayoutInflater().inflate(R.layout.guide_item, null);
            ImageView ivGuide = (ImageView) inflate.findViewById(R.id.iv_guide);
            ivGuide.setBackgroundResource(images[i]);
            mViews.add(inflate);
        }
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        btnStart = (Button) findViewById(R.id.btn_start);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == images.length - 1){
            btnStart.setVisibility(View.VISIBLE);
            Animation animation = AnimationUtils.loadAnimation(GuideActivity.this, R.anim.anim_guide_btn_start);
            btnStart.startAnimation(animation);
        } else {
            btnStart.setVisibility(View.GONE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    class MyViewPagerAdapter extends PagerAdapter {
        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            View view = mViews.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViews.get(position));
        }


        @Override
        public int getCount() {
            return mViews== null?0:mViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;//官方推荐的写法
        }
    }
}
