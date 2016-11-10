package ruolan.com.myhearts.ui.fragment.live;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.adapter.TabViewPagerAdapter;
import ruolan.com.myhearts.ui.left.setting.WebActivity;
import ruolan.com.myhearts.widget.ThoughtViewPager;

/**
 * A simple {@link Fragment} subclass.
 */
public class LiveFragment extends Fragment implements View.OnClickListener {


    private static final float TINT_FACTOR_50_PERCENT = 0.5f;
    private TabLayout mTablayout;
    private ThoughtViewPager mViewPager;


    private String[] strings;

    private TabViewPagerAdapter pagerAdapter;

    private List<String> mTitles = new ArrayList<>();
    private List<Fragment> mFragments = new ArrayList<>();

    private FloatingActionButton mFab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_live, container, false);
        initView(view);
        initTitles();
        initFragments();
        initTabs();
        initListener();

        //setUpViewPager();
        return view;
    }

    private void initListener() {

        mFab.setOnClickListener(this);
    }


    private void initFragments() {
        mFragments.add(new LivingFragment());
        mFragments.add(new NewsFragment());

    }

    private void initTitles() {
        strings = new String[]{
                getActivity().getResources().getString(R.string.living),
                getActivity().getResources().getString(R.string.attention),
        };

        for (String s : strings) {
            mTitles.add(s);
        }
    }

    private void initView(View view) {
        this.mViewPager = (ThoughtViewPager) view.findViewById(R.id.viewpager);
        this.mTablayout = (TabLayout) view.findViewById(R.id.tab_layout);
        mFab = (FloatingActionButton) view.findViewById(R.id.fab);
    }

    private void initTabs() {
        pagerAdapter = new TabViewPagerAdapter(getChildFragmentManager(), mFragments, mTitles);
        mViewPager.setAdapter(pagerAdapter);
        mTablayout.setupWithViewPager(mViewPager);
        mTablayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fab) {
            jumpToGit();
        }
    }

    private void jumpToGit() {
        WebActivity.runActivity(getContext(), "My Github,Welcome star", "https://github.com/wuyinlei");
    }
}
