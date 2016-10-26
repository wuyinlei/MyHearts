package ruolan.com.myhearts.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页tab的适配
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: TabViewPagerAdapter.java
 * @author: 若兰明月
 * @date: 2016-06-19 15:40
 */

public class TabViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragments = new ArrayList<>();
    private final List<String> mFragmentTitles = new ArrayList<>();

    public TabViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     *
     * @param fragment   添加的fragment
     * @param fragmentTitle   fragment的标题
     */
    public void addFragment(Fragment fragment, String fragmentTitle){
        mFragments.add(fragment);
        mFragmentTitles.add(fragmentTitle);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitles.get(position);
    }
}
