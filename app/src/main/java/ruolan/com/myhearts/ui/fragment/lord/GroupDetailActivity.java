package ruolan.com.myhearts.ui.fragment.lord;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okrx.RxAdapter;

import java.lang.reflect.Type;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.adapter.GroupMemberRecommentAdapter;
import ruolan.com.myhearts.contant.HttpUrlPaths;
import ruolan.com.myhearts.entity.GroupDetailBean;
import ruolan.com.myhearts.entity.GroupDetailBean.ResultsBean;
import ruolan.com.myhearts.ui.base.BaseActivity;
import rx.android.schedulers.AndroidSchedulers;

public class GroupDetailActivity extends BaseActivity implements View.OnClickListener {

    private Button mIcBack;
    private ImageView mDetailIcon, mGroupNickimage;
    private TextView mGroupNickname, mGroupId,
            mGroupAddress, mGroupType, mGroupMember,
            mGroupSlogn;
    private RecyclerView mGroupDetailRecycler;
    private ResultsBean mResults;


    @Override
    protected int getResultId() {
        return R.layout.activity_group_detail;
    }

    @Override
    protected void initListener() {
        mIcBack.setOnClickListener(this);
    }

    @Override
    public void initData() {
        super.initData();

        if (id != 0) {
            OkGo.post(HttpUrlPaths.LORD_GROUP_DETAIL_URL)
                    .params("groupid", id)
                    .params("userid", 0)
                    .getCall(StringConvert.create(), RxAdapter.<String>create())
                    .doOnSubscribe(() -> {
                    })
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(s -> {
                        Type type = new TypeToken<GroupDetailBean>() {
                        }.getType();
                        GroupDetailBean bean = new Gson().fromJson(s, type);
                        if (bean.getErrorCode() == 0
                                && bean.getErrorStr().equals("success")
                                && bean.getResultCount() > 0) {
                            mResults = bean.getResults();
                            setData(mResults);
                        }
                    }, throwable -> {
                    });
        }

    }

    /**
     * 设置data
     *
     * @param results
     */
    private void setData(ResultsBean results) {
        Glide.with(this)
                .load(results.getGallery())
                .asBitmap().into(mDetailIcon);
        Glide.with(this)
                .load(results.getOwnerAvatar())
                .asBitmap().into(mGroupNickimage);
        mGroupNickname.setText(results.getOwnerName());
        mGroupId.setText(results.getId());
        mGroupAddress.setText(results.getLocation());
        if (!TextUtils.isEmpty(mTitle)) {
            mGroupType.setText(mTitle);
        }
        mGroupMember.setText(results.getMember());
        if (!TextUtils.isEmpty(results.getSlogan())) {
            mGroupSlogn.setText(results.getSlogan());
        } else {
            mGroupSlogn.setText(getResources().getString(R.string.description_solgn));
        }

        GroupMemberRecommentAdapter memberAdapter = new GroupMemberRecommentAdapter(this, results.getMemberAvatars());
        mGroupDetailRecycler.setAdapter(memberAdapter);
        memberAdapter.setOnItemClickListener((view, position) -> {
            Intent intent = new Intent(this,GroupMemberActivity.class);
            intent.putExtra("member",mResults.getMember());
            intent.putExtra("groupid",mResults.getId());
            startActivity(intent);
        });
    }


    String mTitle;
    int id;

    @Override
    public void initView() {
        id = getIntent().getIntExtra("id", 0);
        mTitle = getIntent().getStringExtra("title");
        mIcBack = (Button) findViewById(R.id.user_detail_return_back_btn);
        mDetailIcon = (ImageView) findViewById(R.id.detail_icon);
        mGroupNickimage = (ImageView) findViewById(R.id.group_nickimage);
        mGroupNickname = (TextView) findViewById(R.id.group_nickname);
        mGroupId = (TextView) findViewById(R.id.group_id);
        mGroupAddress = (TextView) findViewById(R.id.group_address);
        mGroupType = (TextView) findViewById(R.id.group_type);
        mGroupMember = (TextView) findViewById(R.id.group_member);
        mGroupSlogn = (TextView) findViewById(R.id.group_slogn);
        mGroupDetailRecycler = (RecyclerView) findViewById(R.id.group_detail_member);
        mGroupDetailRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        mGroupDetailRecycler.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.user_detail_return_back_btn:
                finish();
                break;

        }
    }
}
