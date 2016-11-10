package ruolan.com.myhearts.ui.fragment.live;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.contant.Contants;
import ruolan.com.myhearts.contant.HttpUrlPaths;

/**
 * Created by Administrator on 2016/11/10.
 * 新闻fragment
 */

public class ComputerNewsFragment extends Fragment {

    //新闻类型
    private String mType;
    //新闻url
    private String newsUrl;
    //轮播图
    private String bannerUrl;

    private int startIndex = 0;
    private int endIndex = 19;

    //上拉加载更多的时候请求数量
    private int count = 20;
    //总共页数
    private int totalPage;
    //当前页数
    private int currentPage = 1;


    public static ComputerNewsFragment newInstance(String index) {
        // Required empty public constructor
        Bundle bundle = new Bundle();
        bundle.putString(Contants.INDEX, index);
        ComputerNewsFragment fragment = new ComputerNewsFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_computer_news_layout, container, false);
        mType = getArguments().getString(Contants.INDEX);
        bannerUrl = HttpUrlPaths.getNewBanner(mType);
        newsUrl = HttpUrlPaths.getNewsData(mType,startIndex,endIndex);
        return view;
    }
}
