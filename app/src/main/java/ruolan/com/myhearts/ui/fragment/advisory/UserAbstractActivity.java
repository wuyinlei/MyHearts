package ruolan.com.myhearts.ui.fragment.advisory;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.ui.base.BaseActivity;
import ruolan.com.myhearts.widget.CircleImageView;

public class UserAbstractActivity extends BaseActivity implements View.OnClickListener {

    private CircleImageView mAvatarimg;
    private TextView mNametxt;
    private TextView mQualificationtxt;
    private LinearLayout toplayout;
    private TextView mContenttxt;
    private ImageButton mClosebtn;

    @Override
    protected int getResultId() {
        return R.layout.activity_user_abstract;
    }

    @Override
    protected void initListener() {
mClosebtn.setOnClickListener(this);
    }

    @Override
    public void initData() {
        super.initData();
        if (!TextUtils.isEmpty(mImgUrl)){
            Glide.with(this)
                    .load(mImgUrl)
                    .asBitmap()
                    .into(mAvatarimg);
        }
        if (!TextUtils.isEmpty(mName))
            mNametxt.setText(mName);
        if (!TextUtils.isEmpty(mAdvisory)){
            mQualificationtxt.setText(mAdvisory);
        }

        if (!TextUtils.isEmpty(mAbstractDes)){
            mContenttxt.setText(mAbstractDes);
        }
    }

    String mImgUrl,mName,mAdvisory,mAbstractDes;

    @Override
    public void initView() {
        this.mClosebtn = (ImageButton) findViewById(R.id.close_btn);
        this.mContenttxt = (TextView) findViewById(R.id.content_txt);
        this.toplayout = (LinearLayout) findViewById(R.id.top_layout);
        this.mQualificationtxt = (TextView) findViewById(R.id.qualification_txt);
        this.mNametxt = (TextView) findViewById(R.id.name_txt);
        this.mAvatarimg = (CircleImageView) findViewById(R.id.avatar_img);

        mImgUrl = getIntent().getStringExtra("img");
        mName = getIntent().getStringExtra("name");
        mAdvisory = getIntent().getStringExtra("advisory");
        mAbstractDes = getIntent().getStringExtra("abstract");
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.close_btn){
            finish();
            overridePendingTransition(R.anim.slide_right_in,R.anim.push_left_out);
        }
    }
}
