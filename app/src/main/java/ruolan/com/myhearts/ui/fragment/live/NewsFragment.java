package ruolan.com.myhearts.ui.fragment.live;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.adapter.TabViewPagerAdapter;
import ruolan.com.myhearts.widget.ThoughtViewPager;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    private TabLayout mTablayout;
    private ThoughtViewPager mViewPager;
    private String[] type = new String[]{"higo","player","indoorsfun","look"};
    private List<String> mTitles;
    private List<Fragment> mFragments;
    private TabViewPagerAdapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_attentation, container, false);
        initView(view);
        initFragments();
        initTitles();
        initTabs();
        return view;
    }

    private void initView(View view) {
        mViewPager = (ThoughtViewPager) view.findViewById(R.id.viewpager);
        mTablayout = (TabLayout) view.findViewById(R.id.tab_layout);
    }

    /**
     * 初始化标题
     */
    private void initTitles() {
        mTitles = new ArrayList<>();
        mTitles.add(getActivity().getResources().getString(R.string.higo));
        mTitles.add(getActivity().getResources().getString(R.string.player));
        mTitles.add(getActivity().getResources().getString(R.string.indoorsfun));
        mTitles.add(getActivity().getResources().getString(R.string.look));
    }

    private void initTabs() {
        mAdapter = new TabViewPagerAdapter(getChildFragmentManager(),mFragments,mTitles);
        mViewPager.setAdapter(mAdapter);
        mTablayout.setupWithViewPager(mViewPager);
        mTablayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }

    private void initFragments() {
        mFragments = new ArrayList<>();
        for (int i = 0; i < type.length; i++) {
            mFragments.add(ComputerNewsFragment.newInstance(type[i]));
        }

    }

}
