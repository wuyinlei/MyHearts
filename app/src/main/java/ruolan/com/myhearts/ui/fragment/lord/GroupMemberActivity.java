package ruolan.com.myhearts.ui.fragment.lord;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
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
import ruolan.com.myhearts.adapter.GroupMemberAdapter;
import ruolan.com.myhearts.contant.HttpUrlPaths;
import ruolan.com.myhearts.entity.GroupMemberBean;
import ruolan.com.myhearts.ui.base.BaseActivity;
import ruolan.com.myhearts.widget.CustomPrograss;
import ruolan.com.myhearts.widget.itemanimator.SlideInOutTopItemAnimator;
import rx.android.schedulers.AndroidSchedulers;

public class GroupMemberActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, View.OnClickListener {

    private EditText searchet;
    private RecyclerView mRecyclerView;
    private String groupid;
    private SwipeRefreshLayout mRefreshLayout;
    private ImageView mIcBack;

    private int page = 1;
    private List<GroupMemberBean.ResultsEntity> mMemberDatas = new ArrayList<>();
    private GroupMemberAdapter mMemberAdapter;


    @Override
    protected int getResultId() {
        return R.layout.activity_group_member;
    }

    @Override
    protected void initListener() {
        mIcBack.setOnClickListener(this);
    }

    @Override
    public void initData() {
        super.initData();
        if (!TextUtils.isEmpty(groupid)) {
            OkGo.get(HttpUrlPaths.LORD_MEMBER_DETAILE_URL)
                    .params("page", page)
                    .params("groupid", groupid)
                    .getCall(StringConvert.create(), RxAdapter.<String>create())
                    .doOnSubscribe(() -> {
                    })
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(s -> {
                        Type type = new TypeToken<GroupMemberBean>() {
                        }.getType();
                        GroupMemberBean bean = new Gson().fromJson(s, type);
                        if (bean.getErrorCode() == 0
                                && bean.getErrorStr().equals("success")
                                && bean.getResultCount() > 0) {
                            mMemberDatas = bean.getResults();
                            mMemberAdapter.addData(mMemberDatas);
                        }

                    }, throwable -> {
                    });

        }
    }

    private boolean isLoading;
    int memberNum;
    int totalPage; //总页数

    @Override
    public void initView() {
        groupid = getIntent().getStringExtra("groupid");
        memberNum = Integer.parseInt(getIntent().getStringExtra("member"));
        totalPage = memberNum / 30;
        this.mRecyclerView = (RecyclerView) findViewById(R.id.search_recycler_view);
        this.searchet = (EditText) findViewById(R.id.search_et);
        mIcBack = (ImageView) findViewById(R.id.ic_back);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mMemberAdapter = new GroupMemberAdapter(this, mMemberDatas);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setItemAnimator(new SlideInOutTopItemAnimator(mRecyclerView));
        mRecyclerView.setAdapter(mMemberAdapter);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int lastVisiableItemPosition = manager.findLastVisibleItemPosition();
                int itemNum = manager.getItemCount();
                if (lastVisiableItemPosition+1 == manager.getItemCount()) {
                    if (!isLoading) {
                        isLoading = true;
                        CustomPrograss.show(GroupMemberActivity.this,
                                getResources().getString(R.string.loading),false,null);
                        new Handler().postDelayed(() -> {
                            getMoreData();
                            isLoading = false;
                            CustomPrograss.disMiss();
                           // mMemberAdapter.notifyItemRemoved(mMemberAdapter.getItemCount());
                        }, 3000);
                    }
                }
            }
        });

        mRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh);
        mRefreshLayout.setColorSchemeColors(Color.YELLOW, Color.RED, Color.BLUE, Color.GREEN);
        mRefreshLayout.setOnRefreshListener(this);
    }

    /**
     * 加载下一页数据
     */
    private void getMoreData() {
        page++;
        if (page > totalPage + 1) {
            Toast.makeText(this,
                    getResources()
                            .getString(R.string.loading_finish),
                    Toast.LENGTH_SHORT).show();
            return;
        }
        if (!TextUtils.isEmpty(groupid)) {
            OkGo.get(HttpUrlPaths.LORD_MEMBER_DETAILE_URL)
                    .params("page", page)
                    .params("groupid", groupid)
                    .getCall(StringConvert.create(), RxAdapter.<String>create())
                    .doOnSubscribe(() -> {
                    })
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(s -> {
                        Type type = new TypeToken<GroupMemberBean>() {
                        }.getType();
                        GroupMemberBean bean = new Gson().fromJson(s, type);
                        if (bean.getErrorCode() == 0
                                && bean.getErrorStr().equals("success")
                                && bean.getResultCount() > 0) {
                          //  int index = mMemberDatas.size()-1;
                            mMemberDatas = bean.getResults();
                          //  mRecyclerView.scrollToPosition(index);
                            mMemberAdapter.addData(mMemberDatas.size(),mMemberDatas);
                            mMemberAdapter.notifyDataSetChanged();
                        }

                    }, throwable -> {
                    });

        }

    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(() -> {
            refreshData();
        }, 3000);
    }

    /**
     * 刷新数据
     */
    private void refreshData() {
        page = 1;
        if (!TextUtils.isEmpty(groupid)) {
            OkGo.get(HttpUrlPaths.LORD_MEMBER_DETAILE_URL)
                    .params("page", page)
                    .params("groupid", groupid)
                    .getCall(StringConvert.create(), RxAdapter.<String>create())
                    .doOnSubscribe(() -> {
                    })
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(s -> {
                        Type type = new TypeToken<GroupMemberBean>() {
                        }.getType();
                        GroupMemberBean bean = new Gson().fromJson(s, type);
                        if (bean.getErrorCode() == 0
                                && bean.getErrorStr().equals("success")
                                && bean.getResultCount() > 0) {
                            mMemberDatas.clear();
                            mMemberDatas = bean.getResults();
                            mMemberAdapter.addData(mMemberDatas);
                            mRefreshLayout.setRefreshing(false);
                        }

                    }, throwable -> {
                    });

        }
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
