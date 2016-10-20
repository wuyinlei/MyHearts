package ruolan.com.myhearts.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sunfusheng.marqueeview.MarqueeView;

import butterknife.Bind;
import butterknife.ButterKnife;
import ruolan.com.myhearts.R;
import ruolan.com.myhearts.widget.CircleImageView;
import ruolan.com.myhearts.widget.FlyBanner;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    @Bind(R.id.avator_img)
    CircleImageView mAvatorImg;
    @Bind(R.id.customer_service_tv)
    TextView mCustomerServiceTv;
    @Bind(R.id.fly_banner)
    FlyBanner mFlyBanner;
    @Bind(R.id.img_tall)
    ImageView mImgTall;
    @Bind(R.id.my_re_talk)
    RelativeLayout mMyReTalk;
    @Bind(R.id.img_contact)
    ImageView mImgContact;
    @Bind(R.id.my_re_call)
    RelativeLayout mMyReCall;
    @Bind(R.id.img_free)
    ImageView mImgFree;
    @Bind(R.id.my_re_free)
    RelativeLayout mMyReFree;
    @Bind(R.id.img_exam)
    ImageView mImgExam;
    @Bind(R.id.my_re_exam)
    RelativeLayout mMyReExam;
    @Bind(R.id.marquee_img)
    ImageView mMarqueeImg;
    @Bind(R.id.marquee_view)
    MarqueeView mMarqueeView;
    @Bind(R.id.recomment_master_tv)
    TextView mRecommentMasterTv;
    @Bind(R.id.img_one)
    ImageView mImgOne;
    @Bind(R.id.tv_name_one)
    TextView mTvNameOne;
    @Bind(R.id.tv_level_one)
    TextView mTvLevelOne;
    @Bind(R.id.tv_des_one)
    TextView mTvDesOne;
    @Bind(R.id.tv_name_second)
    TextView mTvNameSecond;
    @Bind(R.id.tv_level_two)
    TextView mTvLevelTwo;
    @Bind(R.id.tv_des_two)
    TextView mTvDesTwo;
    @Bind(R.id.img_two)
    ImageView mImgTwo;
    @Bind(R.id.img_three)
    ImageView mImgThree;
    @Bind(R.id.tv_name_three)
    TextView mTvNameThree;
    @Bind(R.id.tv_des_three)
    TextView mTvDesThree;
    @Bind(R.id.img_four)
    ImageView mImgFour;
    @Bind(R.id.tv_name_four)
    TextView mTvNameFour;
    @Bind(R.id.tv_des_four)
    TextView mTvDesFour;
    @Bind(R.id.recomment_img_one)
    ImageView mRecommentImgOne;
    @Bind(R.id.tv_title_recomment)
    TextView mTvTitleRecomment;
    @Bind(R.id.imageView)
    ImageView mImageView;
    @Bind(R.id.tv_des_trecomment)
    TextView mTvDesTrecomment;
    @Bind(R.id.hot_img)
    ImageView mHotImg;
    @Bind(R.id.hot_recycler_view)
    RecyclerView mHotRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
