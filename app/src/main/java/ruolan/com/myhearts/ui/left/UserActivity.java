package ruolan.com.myhearts.ui.left;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dalong.cardvoucherlayout.CardVoucherLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import ruolan.com.myhearts.R;
import ruolan.com.myhearts.widget.CircleImageView;

public class UserActivity extends AppCompatActivity {

    @BindView(R.id.counselor_detail_actionbarview)
    ImageView mCounselorDetailActionbarview;
    @BindView(R.id.counselor_detail_return_back_btn)
    Button mCounselorDetailReturnBackBtn;
    @BindView(R.id.counselor_detail_nicknameandqjcode)
    TextView mCounselorDetailNicknameandqjcode;
    @BindView(R.id.counselor_detail_more_btn)
    ImageView mCounselorDetailMoreBtn;
    @BindView(R.id.user_detail_avatar)
    CircleImageView mUserDetailAvatar;
    @BindView(R.id.user_detail_id)
    TextView mUserDetailId;
    @BindView(R.id.audio_length_txt)
    TextView mAudioLengthTxt;
    @BindView(R.id.audio_play_btn)
    ImageButton mAudioPlayBtn;
    @BindView(R.id.audio_play_layout)
    LinearLayout mAudioPlayLayout;
    @BindView(R.id.audio_playing_bobble)
    ImageView mAudioPlayingBobble;
    @BindView(R.id.user_detail_fans_nums)
    TextView mUserDetailFansNums;
    @BindView(R.id.userdetail_head_layout)
    RelativeLayout mUserdetailHeadLayout;
    @BindView(R.id.card_view)
    CardVoucherLayout mCardView;
    @BindView(R.id.tv_city)
    TextView mTvCity;
    @BindView(R.id.tv_profession)
    TextView mTvProfession;
    @BindView(R.id.tv_blood_type)
    TextView mTvBloodType;
    @BindView(R.id.goupdate_cleanmsg)
    LinearLayout mGoupdateCleanmsg;
    @BindView(R.id.tv_love)
    TextView mTvLove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);
    }
}
