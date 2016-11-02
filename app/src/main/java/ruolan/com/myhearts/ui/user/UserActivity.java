package ruolan.com.myhearts.ui.user;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.dalong.cardvoucherlayout.CardVoucherLayout;

import org.greenrobot.eventbus.EventBus;

import java.io.File;

import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;
import cn.bmob.v3.listener.UploadFileListener;
import ruolan.com.myhearts.R;
import ruolan.com.myhearts.entity.MyUser;
import ruolan.com.myhearts.ui.base.BaseActivity;
import ruolan.com.myhearts.widget.CircleImageView;
import ruolan.com.myhearts.widget.GlideCircleTransform;

public class UserActivity extends BaseActivity implements View.OnClickListener {


    ImageView mCounselorDetailActionbarview;
    ImageView mCounselorDetailReturnBackBtn;
    TextView mCounselorDetailNicknameandqjcode;
    ImageView mCounselorDetailMoreBtn;
    CardVoucherLayout mCardView;
    ImageView mEtImgDetail;

    TextView mTvCity;
    TextView mTvProfession;
    TextView mTvBloodType;
    TextView mTvLove;
    CircleImageView mIvAvator;
    private RelativeLayout mActivityUser;

    private TextView mTvName;
    private TextView mTvDes;
    private TextView mUserFansNums;


    private RelativeLayout layout_choose;
    private RelativeLayout layout_photo;
    private RelativeLayout layout_close;
    /**
     * 定义三种状态
     */
    private static final int REQUESTCODE_PIC = 1;//相册
    private static final int REQUESTCODE_CAM = 2;//相机
    private static final int REQUESTCODE_CUT = 3;//图片裁剪

    private Bitmap mBitmap;
    private File mFile;
    protected int mScreenWidth;
    private MyUser mCurrentUser;

    private ImageView mIcBack;


    @Override
    protected int getResultId() {
        return R.layout.activity_user;
    }

    @Override
    protected void initListener() {
        mEtImgDetail.setOnClickListener(this);
        mIvAvator.setOnClickListener(this);
    }

    @Override
    public void initView() {
        //EventBus.getDefault().register(this);
        mCurrentUser = MyUser.getCurrentUser(MyUser.class);
        // Log.d("ruolan", myUser.toString());

        mActivityUser = (RelativeLayout) findViewById(R.id.activity_user);
        mCounselorDetailActionbarview = (ImageView) findViewById(R.id.counselor_detail_actionbarview);
        mCounselorDetailReturnBackBtn = (ImageView) findViewById(R.id.counselor_detail_return_back_btn);
        mCounselorDetailNicknameandqjcode = (TextView) findViewById(R.id.counselor_detail_nicknameandqjcode);
        mCounselorDetailMoreBtn = (ImageView) findViewById(R.id.counselor_detail_more_btn);
        mCardView = (CardVoucherLayout) findViewById(R.id.card_view);
        mEtImgDetail = (ImageView) findViewById(R.id.et_img_detail);
        mTvCity = (TextView) findViewById(R.id.tv_city);
        mTvProfession = (TextView) findViewById(R.id.tv_profession);
        mTvBloodType = (TextView) findViewById(R.id.tv_blood_type);
        mTvLove = (TextView) findViewById(R.id.tv_love);
        mIvAvator = (CircleImageView) findViewById(R.id.user_detail_avatar);
        mTvName = (TextView) findViewById(R.id.tv_name);
        mTvDes = (TextView) findViewById(R.id.tv_des);
        mUserFansNums = (TextView) findViewById(R.id.user_detail_fans_nums);

        mIcBack = (ImageView) findViewById(R.id.ic_back);
        mIcBack.setOnClickListener(this);

        if (mCurrentUser !=null) {
            updateUi(mCurrentUser);
        }
    }

    private void updateUi(MyUser currentUser) {
        String img = currentUser.getImgurl();
        String username = currentUser.getUsername();
        String city = currentUser.getInstance();
        String blood = currentUser.getBloodtype();
        String love = currentUser.getLove();
        String profession = currentUser.getProfession();
        String des = currentUser.getDes();
        int userfans = currentUser.getUserfans() + 500;  //模拟500个
        if (!TextUtils.isEmpty(img)) {
            Glide.with(this).load(img).asBitmap()
                    .transform(new GlideCircleTransform(this)).into(mIvAvator);
        }
        if (!TextUtils.isEmpty(username)) {

        }
        if (!TextUtils.isEmpty(city)) {
            mTvCity.setText(city);
        }
        if (!TextUtils.isEmpty(blood)){
            mTvBloodType.setText(blood);
        }

        if (!TextUtils.isEmpty(love)) {
            mTvLove.setText(love);
        }
        if (!TextUtils.isEmpty(profession)) {
            mTvProfession.setText(profession);
        }
        if (!TextUtils.isEmpty(des)) {
            mTvDes.setText(des);
        }
        if (!TextUtils.isEmpty(username)) {
            mTvName.setText(username);
        }

        if (!TextUtils.isEmpty(userfans + "")) {
            mUserFansNums.setText(userfans + "");
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mCurrentUser!=null){
            mCurrentUser = MyUser.getCurrentUser(MyUser.class);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.et_img_detail:
                startActivity(new Intent(this,UpdateUserActivity.class));
                break;
            case R.id.user_detail_avatar:
                showMyDialog();
                //Toast.makeText(this, "弹框", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ic_back:
                finish();
                break;
        }
    }


    PopupWindow avatorPop;


    private void showMyDialog() {
        View view = LayoutInflater.from(this).inflate(R.layout.pop_show_dialog,
                null);
        layout_choose = (RelativeLayout) view.findViewById(R.id.layout_choose);
        layout_photo = (RelativeLayout) view.findViewById(R.id.layout_photo);
        layout_close = (RelativeLayout) view.findViewById(R.id.layout_close);

        layout_choose.setBackgroundColor(getResources().getColor(
                R.color.base_color_text_white));
        layout_photo.setBackgroundDrawable(getResources().getDrawable(
                R.drawable.pop_bg_press));
        layout_close.setBackgroundColor(getResources().getColor(
                R.color.base_color_text_white));


        layout_photo.setOnClickListener(arg0 -> {
            layout_choose.setBackgroundColor(getResources().getColor(
                    R.color.base_color_text_white));
            layout_photo.setBackgroundDrawable(getResources().getDrawable(
                    R.drawable.pop_bg_press));
            layout_close.setBackgroundColor(getResources().getColor(
                    R.color.base_color_text_white));


            openCamera();

            // Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            //intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
            //startActivityForResult(intent,);
        });

        layout_choose.setOnClickListener(arg0 -> {
            layout_photo.setBackgroundColor(getResources().getColor(
                    R.color.base_color_text_white));
            layout_choose.setBackgroundDrawable(getResources().getDrawable(
                    R.drawable.pop_bg_press));
            layout_close.setBackgroundColor(getResources().getColor(
                    R.color.base_color_text_white));
            openPic();

        });

        layout_close.setOnClickListener(v -> {
            layout_photo.setBackgroundColor(getResources().getColor(
                    R.color.base_color_text_white));
            layout_close.setBackgroundDrawable(getResources().getDrawable(
                    R.drawable.pop_bg_press));
            layout_choose.setBackgroundColor(getResources().getColor(
                    R.color.base_color_text_white));
            avatorPop.dismiss();
        });


        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        mScreenWidth = metric.widthPixels;
        avatorPop = new PopupWindow(view, mScreenWidth, 200);
        avatorPop.setTouchInterceptor((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                avatorPop.dismiss();
                return true;
            }
            return false;
        });

        avatorPop.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        avatorPop.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        avatorPop.setTouchable(true);
        avatorPop.setFocusable(true);
        avatorPop.setOutsideTouchable(true);
        avatorPop.setBackgroundDrawable(new BitmapDrawable());
        // 动画效果 从底部弹起
        avatorPop.setAnimationStyle(R.style.Animations_GrowFromBottom);
        avatorPop.showAtLocation(mActivityUser, Gravity.BOTTOM, 0, 0);
    }

    /**
     * 打开相册
     */
    private void openPic() {
        Intent picIntent = new Intent(Intent.ACTION_PICK, null);
        picIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(picIntent, REQUESTCODE_PIC);
    }

    /**
     * 调用相机
     */
    private void openCamera() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            File file = Environment
                    .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            if (!file.exists()) {
                file.mkdirs();
            }
            mFile = new File(file, System.currentTimeMillis() + ".jpg");
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(mFile));
            intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
            startActivityForResult(intent, REQUESTCODE_CAM);
        } else {
            Toast.makeText(this, getResources()
                    .getString(R.string.please_insert_sd_card),
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUESTCODE_CAM:
                    startPhotoZoom(Uri.fromFile(mFile));
                    break;
                case REQUESTCODE_PIC:

                    if (data == null || data.getData() == null) {
                        return;
                    }


                    startPhotoZoom(data.getData());

                    break;
                case REQUESTCODE_CUT:

                    if (data != null) {
                        setPicToView(data);
                    }
                    break;


            }
        }


        super.onActivityResult(requestCode, resultCode, data);
    }

    private void setPicToView(Intent data) {
        Bundle bundle = data.getExtras();
        if (bundle != null) {

//
//            Uri selectedImage = data.getData();
//
//            String[] filePathColumn = { MediaStore.Images.Media.DATA };
//
//            Cursor cursor = getContentResolver().query(selectedImage,
//                    filePathColumn, null, null, null);
//            cursor.moveToFirst();
//
//            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//            String picturePath = cursor.getString(columnIndex);
//

            //这里也可以做文件上传
            mBitmap = bundle.getParcelable("data");
            // ivHead.setImageBitmap(mBitmap);
            mIvAvator.setImageBitmap(mBitmap);
            String path = "";
//
//            if (picturePath!=null){
//                path = picturePath;
//            }

            if (mFile != null)
                path = mFile.getPath();

            final BmobFile bmobFile = new BmobFile(new File(path));
            //Bmob这个上传文件的貌似不成功..........................
            bmobFile.uploadblock(new UploadFileListener() {

                @Override
                public void done(BmobException e) {
                    if (e == null) {
                        Toast.makeText(UserActivity.this, "pic is success", Toast.LENGTH_SHORT).show();
                        // MyUser myUser =MyUser.getCurrentUser(MyUser.class);
                        //得到上传的图片地址
                        String fileUrl = bmobFile.getFileUrl();
                        mCurrentUser.setImgurl(fileUrl);
                        //更新图片地址
                        mCurrentUser.update(mCurrentUser.getObjectId(), new UpdateListener() {
                            @Override
                            public void done(BmobException e) {
                                if (e == null) {
                                    Toast.makeText(UserActivity.this, "update", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
                    }
                }
            });

        }
    }

    /**
     * 打开系统图片裁剪功能
     *
     * @param uri  uri
     */
    private void startPhotoZoom(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", true);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 300);
        intent.putExtra("outputY", 300);
        intent.putExtra("scale", true); //黑边
        intent.putExtra("scaleUpIfNeeded", true); //黑边
        intent.putExtra("return-data", true);
        intent.putExtra("noFaceDetection", true);
        startActivityForResult(intent, REQUESTCODE_CUT);

    }
}
