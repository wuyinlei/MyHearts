package ruolan.com.myhearts.ui.fragment.live;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
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
public class LiveFragment extends Fragment {


    private TabLayout mTablayout;
    private ThoughtViewPager mViewPager;


    private String[] strings;

    private TabViewPagerAdapter pagerAdapter;

    private List<String> mTitles = new ArrayList<>();
    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_live, container, false);
        initView(view);
        initTitles();
        initFragments();
        initTabs();
        return view;
    }

    private void initFragments() {

        mFragments = new ArrayList<>();
        for (int i = 0; i < mTitles.size(); i++) {
            mFragments.add(CategoryFragment.newInstance(i));
        }
    }

    private void initTitles() {
        strings = new String[]{
                getActivity().getResources().getString(R.string.recomment),
                getActivity().getResources().getString(R.string.dota2),
                getActivity().getResources().getString(R.string.lol),
                getActivity().getResources().getString(R.string.lushi)
        };

        for (String s : strings) {
            mTitles.add(s);
        }
    }

    private void initView(View view) {
        this.mViewPager = (ThoughtViewPager) view.findViewById(R.id.viewpager);
        this.mTablayout = (TabLayout) view.findViewById(R.id.tab_layout);
    }

    private void initTabs() {
        pagerAdapter = new TabViewPagerAdapter(getChildFragmentManager(),mFragments,mTitles);

        mViewPager.setAdapter(pagerAdapter);

        mViewPager.setAdapter(pagerAdapter);
        mTablayout.setupWithViewPager(mViewPager);
        mTablayout.setTabGravity(TabLayout.GRAVITY_FILL);
        mTablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.d("LiveFragment", "tab.getText():" + tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }

}
