package ruolan.com.myhearts.ui.fragment.lord;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okrx.RxAdapter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.adapter.LordAdapter;
import ruolan.com.myhearts.entity.LordBean;
import ruolan.com.myhearts.ui.base.BaseFragment;
import ruolan.com.myhearts.contant.HttpUrlPaths;
import rx.android.schedulers.AndroidSchedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class LordFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, View.OnClickListener {


    private ImageView mImgGroupList;
    private RecyclerView mLordRecyclerView;
    private SwipeRefreshLayout mLordRefresh;
    private LordAdapter mLordAdapter;

    private PopupWindow mPopupWindow;

    private RelativeLayout mReAddGroup, mReSearchGroup;
    private LinearLayout mLlDismiss;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lord, container, false);

        initView(view);
        initPopup();

        initLordData();

        return view;
    }

    List<LordBean.ResultsBean> mLordDatas = new ArrayList<>();

    private void initLordData() {
        OkGo.post(HttpUrlPaths.LORD_CATEGORY)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(() -> {

                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Type type = new TypeToken<LordBean>() {
                    }.getType();
                    LordBean bean = new Gson().fromJson(s, type);
                    if (bean.getErrorCode() == 0
                            && bean.getErrorStr().equals("success")
                            && bean.getResultCount() > 0) {
                        mLordDatas = bean.getResults();
                        mLordAdapter.setDatas(mLordDatas);
                        mLordAdapter.notifyDataSetChanged();

                    }
                }, throwable -> {

                });

    }

    private void initView(View view) {
        mImgGroupList = (ImageView) view.findViewById(R.id.img_group_list);
        mImgGroupList.setOnClickListener(this);
        mLordRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mLordRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        //mLordRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST));
        mLordRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mLordAdapter = new LordAdapter(getContext(), mLordDatas);
        mLordRecyclerView.setAdapter(mLordAdapter);
        mLordAdapter.setOnItemClickListener((view1, position) -> {
            Intent intent = new Intent(getContext(), LordDetailActivity.class);
            intent.putExtra("catgId", mLordDatas.get(position).getId());
            intent.putExtra("title", mLordDatas.get(position).getLabel());
            startActivity(intent);
            //Toast.makeText(getContext(), mLordDatas.get(position).getLabel(), Toast.LENGTH_SHORT).show();
        });


        mLordRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefresh);
        mLordRefresh.setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN);
        mLordRefresh.setOnRefreshListener(this);


    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(() -> refreshData(), 3000);
    }

    /**
     * 刷新数据
     */
    private void refreshData() {
        OkGo.post(HttpUrlPaths.LORD_CATEGORY)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(() -> {

                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Type type = new TypeToken<LordBean>() {
                    }.getType();
                    LordBean bean = new Gson().fromJson(s, type);
                    if (bean.getErrorCode() == 0
                            && bean.getErrorStr().equals("success")
                            && bean.getResultCount() > 0) {
                        mLordDatas.clear();
                        mLordDatas = bean.getResults();
                        //mLordAdapter.a(mLordDatas);
                        mLordAdapter.setDatas(mLordDatas);
                        mLordRefresh.setRefreshing(false);
                    }
                }, throwable -> {

                });
    }

    boolean isShowing = false;

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.img_group_list) {
            if (!isShowing ) {
                mPopupWindow.showAsDropDown(v);
                isShowing = true;
            } else if (isShowing ){
                mPopupWindow.dismiss();
                isShowing = false;
            }
        } else if (v.getId() == R.id.re_add_group) {
            mPopupWindow.dismiss();
            Toast.makeText(getContext(), getActivity().getResources().getString(R.string.add_lord), Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.re_search_group) {
            mPopupWindow.dismiss();
            Toast.makeText(getContext(), getActivity().getResources().getString(R.string.search_lord), Toast.LENGTH_SHORT).show();
        }
    }

    private void initPopup() {
        View popupWindow = LayoutInflater.from(getContext())
                .inflate(R.layout.lord_popup_window_layout, null);

        mReAddGroup = (RelativeLayout) popupWindow.findViewById(R.id.re_add_group);
        mReAddGroup.setOnClickListener(this);
        mReSearchGroup = (RelativeLayout) popupWindow.findViewById(R.id.re_search_group);
        mReSearchGroup.setOnClickListener(this);
        mPopupWindow = new PopupWindow(popupWindow);
        mPopupWindow.setWidth(ViewGroup.LayoutParams.FILL_PARENT);
        mPopupWindow.setHeight(ViewGroup.LayoutParams.FILL_PARENT);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getContext().getResources()));

        mLlDismiss = (LinearLayout) popupWindow.findViewById(R.id.ll_dismiss);
        mLlDismiss.setOnClickListener(view -> {
            mPopupWindow.dismiss();
        });

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
}
