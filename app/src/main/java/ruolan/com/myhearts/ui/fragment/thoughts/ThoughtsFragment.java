package ruolan.com.myhearts.ui.fragment.thoughts;


import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.adapter.TabViewPagerAdapter;
import ruolan.com.myhearts.event.CatgidEvent;
import ruolan.com.myhearts.widget.ThoughtViewPager;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThoughtsFragment extends Fragment implements View.OnClickListener {


    private ThoughtViewPager mViewPager;
    private TabLayout mTabLayout;
    private ImageView mIvRemind, mIvNote;
    private TextView mTvTitle;

    private PopupWindow mPopupWindow;

    private RecyclerView mPopupRecylerView;

//    <string name="all_thought">全部</string>
//    <string name="parenting_thought">亲子教育</string>
//    <string name="youth_growth_thought">青春成长</string>
//    <string name="emotional_disturbance_thought">情绪困扰</string>
//    <string name="romantic_attachment_thought">婚恋情感</string>
//    <string name="friends_pay_thought">社交职场</string>
//    <string name="psychological_disorders_thought">心里障碍</string>
//    <string name="my_thought">我的想法</string>
//    <string name="other_thought">其他</string>

    private String[] mDatas;

    private List<String> mPopDatas = new ArrayList<>();
    private MyPopupAdapter mPopupAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_thoughts, container, false);
        initPopDatas();
        initView(inflate);
        initTabs();
        initListener();
        for (String data : mDatas) {
            mPopDatas.add(data);
        }
        initPopup();
        // initData();


        return inflate;
    }

    /**
     * 初始化Pop
     */
    private void initPopDatas() {
        mDatas = new String[]{
                getActivity().getResources().getString(R.string.all_thought),
                getActivity().getResources().getString(R.string.parenting_thought),
                getActivity().getResources().getString(R.string.youth_growth_thought),
                getActivity().getResources().getString(R.string.emotional_disturbance_thought),
                getActivity().getResources().getString(R.string.romantic_attachment_thought),
                getActivity().getResources().getString(R.string.friends_pay_thought),
                getActivity().getResources().getString(R.string.psychological_disorders_thought),
                //  getActivity().getResources().getString(R.string.my_thought),
                getActivity().getResources().getString(R.string.other_thought)
        };
    }


    private void initListener() {
        mTvTitle.setOnClickListener(this);
        mIvRemind.setOnClickListener(this);
        mIvNote.setOnClickListener(this);
    }


    private void initView(View inflate) {
        mIvNote = (ImageView) inflate.findViewById(R.id.img_note);
        mIvRemind = (ImageView) inflate.findViewById(R.id.iv_remind);
        mTvTitle = (TextView) inflate.findViewById(R.id.tv_title);
        mViewPager = (ThoughtViewPager) inflate.findViewById(R.id.viewpager);
        mTabLayout = (TabLayout) inflate.findViewById(R.id.tab_layout);
    }


    /**
     * 初始化TabLayout
     */
    private void initTabs() {
        TabViewPagerAdapter viewPagerAdapter = new TabViewPagerAdapter(getChildFragmentManager());

        NewFragment noteFragment = new NewFragment();
        HotFragment questionFragment = new HotFragment();
        //DiscoverFragment discoverFragment = new DiscoverFragment();


        viewPagerAdapter.addFragment(questionFragment,
                getActivity()
                        .getResources()
                        .getString(R.string.time_fragment));
        viewPagerAdapter.addFragment(noteFragment, getActivity()
                .getResources()
                .getString(R.string.hot_fragment));
        // viewPagerAdapter.addFragment(discoverFragment, getId(R.string.fragment_discover));
        mViewPager.setAdapter(viewPagerAdapter);

        //布局
        mTabLayout.addTab(mTabLayout.newTab().setText(getActivity()
                .getResources()
                .getString(R.string.time_fragment)));
        mTabLayout.addTab(mTabLayout.newTab().setText(getActivity()
                .getResources()
                .getString(R.string.hot_fragment)));

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        //mTabLayout.addTab(mTabLayout.newTab().setText(R.string.fragment_discover));
        mTabLayout.setupWithViewPager(mViewPager);  //把Tablayout和viewpager绑定到一起

    }


    private void initPopup() {
        View popupWindow = LayoutInflater.from(getContext())
                .inflate(R.layout.throught_frament_recycler_view_layout, null);
        mPopupRecylerView = (RecyclerView) popupWindow.findViewById(R.id.recycler_view);
        mPopupRecylerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        mPopupRecylerView.setItemAnimator(new DefaultItemAnimator());

        mPopupAdapter = new MyPopupAdapter();
        mPopupAdapter.setOnItemClick((v, i, data) -> {
            mPopupAdapter.setPosition(i);
            mPopupAdapter.notifyDataSetChanged();
            EventBus.getDefault().post(new CatgidEvent(i));
            mPopupWindow.dismiss();
            //Toast.makeText(getContext(), data, Toast.LENGTH_SHORT).show();
        });
        mPopupRecylerView.setAdapter(mPopupAdapter);

        // mReAddGroup = (RelativeLayout) popupWindow.findViewById(R.id.re_add_group);
        //  mReAddGroup.setOnClickListener(this);
        // mReSearchGroup = (RelativeLayout) popupWindow.findViewById(R.id.re_search_group);
        // mReSearchGroup.setOnClickListener(this);
        mPopupWindow = new PopupWindow(popupWindow,
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getContext().getResources()));


//        // 设置背景颜色变暗
//        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
//        lp.alpha = 0.7f;
//        getActivity().getWindow().setAttributes(lp);
//        mPopupWindow.setOnDismissListener(() -> {
//            WindowManager.LayoutParams lp1 = getActivity().getWindow().getAttributes();
//            lp1.alpha = 1f;
//            getActivity().getWindow().setAttributes(lp1);
//        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_title:
                //initPopup();
                mPopupWindow.showAsDropDown(v);
                break;
            case R.id.img_note:

                break;
            case R.id.iv_remind:

                break;
            default:
                break;
        }
    }


    class MyPopupAdapter extends RecyclerView.Adapter<MyPopupAdapter.MyViewHolder> {


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext())
                    .inflate(R.layout.through_fragment_popup_window_layout,
                            parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            if (mPosition == position) {
//                holder.mReResponse.setBackgroundColor(getContext()
//                        .getResources()
//                        .getColor(R.color.home_title_color));
                if (position == 1) {
                    holder.mTvTitle.setBackgroundResource(R.drawable.home_look_more_bg_press_1);
                    holder.mTvTitle.setTextColor(getActivity().getResources().getColor(R.color.white));
                }
                if (position == 2) {
                    holder.mTvTitle.setBackgroundResource(R.drawable.home_look_more_bg_press_2);
                    holder.mTvTitle.setTextColor(getActivity().getResources().getColor(R.color.white));
                }
                if (position == 3) {
                    holder.mTvTitle.setBackgroundResource(R.drawable.home_look_more_bg_press_3);
                    holder.mTvTitle.setTextColor(getActivity().getResources().getColor(R.color.white));
                }
                if (position == 4) {
                    holder.mTvTitle.setBackgroundResource(R.drawable.home_look_more_bg_press_4);
                    holder.mTvTitle.setTextColor(getActivity().getResources().getColor(R.color.white));
                }
                if (position == 5) {
                    holder.mTvTitle.setBackgroundResource(R.drawable.home_look_more_bg_press_5);
                    holder.mTvTitle.setTextColor(getActivity().getResources().getColor(R.color.white));
                }
                if (position == 6) {
                    holder.mTvTitle.setBackgroundResource(R.drawable.home_look_more_bg_press_6);
                    holder.mTvTitle.setTextColor(getActivity().getResources().getColor(R.color.white));
                }
                if (position == 7) {
                    holder.mTvTitle.setBackgroundResource(R.drawable.home_look_more_bg_press_7);
                    holder.mTvTitle.setTextColor(getActivity().getResources().getColor(R.color.white));
                }
            } else {
                holder.mTvTitle.setBackgroundResource(R.drawable.home_look_more_bg);
                holder.mTvTitle.setTextColor(getActivity().getResources().getColor(R.color.home_title_color));
            }
            holder.mTvTitle.setText(mDatas[position]);
        }

        private int mPosition = 0;

        public void setPosition(int position) {
            mPosition = position;
        }

        @Override
        public int getItemCount() {
            return mDatas.length;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            private RelativeLayout mReResponse;
            private TextView mTvTitle;

            public MyViewHolder(View itemView) {
                super(itemView);
                mReResponse = (RelativeLayout) itemView.findViewById(R.id.re_popup_item);
                mTvTitle = (TextView) itemView.findViewById(R.id.tv_popup_title);

                mReResponse.setOnClickListener(v -> {
                    if (mOnItemClick != null) {
                        mOnItemClick.OnItemClickListener(v,
                                getLayoutPosition(),
                                mDatas[getLayoutPosition()]);
                    }
                });
            }
        }

        OnItemClick mOnItemClick;

        public void setOnItemClick(OnItemClick onItemClick) {
            mOnItemClick = onItemClick;
        }
    }


    public interface OnItemClick {
        void OnItemClickListener(View v, int i, String data);
    }
}
