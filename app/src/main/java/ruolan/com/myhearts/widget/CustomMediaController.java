package ruolan.com.myhearts.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import master.flame.danmaku.controller.IDanmakuView;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;
import ruolan.com.myhearts.R;
import ruolan.com.myhearts.ui.play.VideoViewActivity;
import ruolan.com.myhearts.utils.BitmapUtil;
import ruolan.com.myhearts.utils.RandomUtil;


/**
 * auther: elliott zhang
 * Emaill:18292967668@163.com
 */
public class CustomMediaController extends MediaController {
    private Context mContext;
    private View mVolumeBrightnessLayout;
    private ImageView mOperationBg;
    private ImageView mOperationPercent;
    private AudioManager mAudioManager;
    private int mMaxVolume;
    private int mVolume = -1;
    private float mBrightness = -1f;
    private GestureDetector mGestureDetector;

    VideoViewActivity activity;
    private ImageView mediacontroller_snapshot;
    private ImageView mediacontroller_previous;
    private ImageView mediacontroller_next;
    private ImageView mediacontroller_screen_fit;
    /**
     * public static final int VIDEO_LAYOUT_ORIGIN
     * 缩放参数，原始画面大小。
     * 常量值：0
     * <p>
     * public static final int VIDEO_LAYOUT_SCALE
     * 缩放参数，画面全屏。
     * 常量值：1
     * <p>
     * public static final int VIDEO_LAYOUT_STRETCH
     * 缩放参数，画面拉伸。
     * 常量值：2
     * <p>
     * public static final int VIDEO_LAYOUT_ZOOM
     * 缩放参数，画面裁剪。
     * 常量值：3
     */
    private String[] strDialogs = new String[]{"100%", "全屏", "拉伸", "裁剪"};
    private int[] imgs = new int[]{R.drawable.mediacontroller_sreen_size_100,
            R.drawable.mediacontroller_screen_fit,
            R.drawable.mediacontroller_screen_size,
            R.drawable.mediacontroller_sreen_size_crop};
    private int mCurrentPageSize = 2;

    private TextView currenttime_tv;

    /**
     * 弹幕相关
     */
    private IDanmakuView mDanmakuView;
    private Switch mtanMuSwitch;
    private DanmakuContext mDanmakuContext;
    private BaseDanmakuParser mParser;

    private Handler mDismissHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                mVolumeBrightnessLayout.setVisibility(View.GONE);
            }
        }
    };

    Timer mTimer = null;
    private String mVideoTitle;

    public CustomMediaController(Context context,String title) {
        super(context);
        this.mContext = context;
        mVideoTitle = title;
        activity = (VideoViewActivity) context;
        mAudioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
        mMaxVolume = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        mGestureDetector = new GestureDetector(mContext, new VolumeBrightnesGestureListener());
        mTimer = new Timer(true);
        mTimer.schedule(task,1000,2000);  // 1s后启动任务，每2s执行一次
    }

    @Override
    protected View makeControllerView() {
        return ((LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).
                inflate(getResources().getIdentifier("mediacontroller", "layout",
                        mContext.getPackageName()), this);
    }

    boolean isPortrait=true;

    @Override
    protected void initOtherView() {

        initTopView();

        mtanMuSwitch = (Switch) mRoot.findViewById(R.id.switch_tanmu);
        mtanMuSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mtanMuSwitch.setBackgroundColor(getResources().getColor(R.color.video_red_color));
                    //开启弹幕
                    mDanmakuView.prepare(mParser, mDanmakuContext);
                    mDanmakuView.show();
                } else {
                    mtanMuSwitch.setBackgroundColor(getResources().getColor(R.color.video_gray_color));
                    //关闭弹幕
                    mDanmakuView.hide();
                }
            }
        });
        mediacontroller_snapshot = (ImageView) mRoot.findViewById(R.id.mediacontroller_snapshot);
        mediacontroller_previous = (ImageView) mRoot.findViewById(R.id.mediacontroller_previous);
        mediacontroller_next = (ImageView) mRoot.findViewById(R.id.mediacontroller_next);
        mediacontroller_screen_fit = (ImageView) mRoot.findViewById(R.id.mediacontroller_screen_fit);
        mediacontroller_snapshot.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap currentFrame = activity.getCurrentFrame();
                //保存到本地
                String picturnPath = activity.getExternalCacheDir() + File.separator + RandomUtil.getRandomLetters(6) + ".jpg";
                boolean saveSuccess = BitmapUtil.saveBitmap(currentFrame, new File(picturnPath));
                if (saveSuccess) {
                    // T.showLong(activity,"截屏保存到"+picturnPath);
                } else {
                    // T.showLong(activity,"截屏失败");
                }
            }
        });
        mediacontroller_previous.setOnClickListener(v -> activity.reverseVideo());
        mediacontroller_next.setOnClickListener(v -> activity.speedVideo());
        mediacontroller_screen_fit.setOnClickListener(v -> {
            mCurrentPageSize++;
            if (mCurrentPageSize > 3) {
                mCurrentPageSize = 0;
            }
            //T.showToastMsgShort(activity,strDialogs[mCurrentPageSize]);
            mediacontroller_screen_fit.setBackground(getResources().getDrawable(imgs[mCurrentPageSize]));
            activity.setVideoPageSize(mCurrentPageSize);
        });
        currenttime_tv = (TextView) mRoot.findViewById(R.id.currenttime_tv);

        mVolumeBrightnessLayout = mRoot.findViewById(R.id.operation_volume_brightness);
        mOperationBg = (ImageView) mRoot.findViewById(R.id.operation_bg);
        mOperationPercent = (ImageView) mRoot.findViewById(R.id.operation_percent);
        mRoot.setOnTouchListener((v, event) -> {
            // LogUtils.i(LogUtils.LOG_TAG, "onTouchEvent");
            if (mGestureDetector.onTouchEvent(event)) {
                return true;
            }
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN:
                    break;
                case MotionEvent.ACTION_UP:
                    endGesture();
                    break;
            }
            return false;
        });
    }

    private TextView mMediacontrollerFileName;  //文件名
    private TextView mNetWorkSpeedTv;  //网速
    private TextView mCurrentTimeTv; //当前时间

    private void initTopView() {
        mMediacontrollerFileName = (TextView) mRoot.findViewById(R.id.mediacontroller_file_name);
        mNetWorkSpeedTv = (TextView) mRoot.findViewById(R.id.net_work_speed_tv);
        mCurrentTimeTv = (TextView) mRoot.findViewById(R.id.currenttime_tv);

        setData();
    }


    private long lastTotalRxBytes = 0;
    private long lastTimeStamp = 0;


    private long getTotalRxBytes() {
        return TrafficStats.getUidRxBytes(mContext.getApplicationInfo().uid)==TrafficStats.UNSUPPORTED ? 0 :(TrafficStats.getTotalRxBytes()/1024);//转为KB
    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            showNetSpeed();
        }
    };

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            // TODO: 2016/11/9    //在这里获取网速，实时更新网速
            String speed = (String) msg.obj;
            if (!TextUtils.isEmpty(speed)){
                mNetWorkSpeedTv.setText(speed);
            }
            //Toast.makeText(VideoViewActivity.this, speed, Toast.LENGTH_SHORT).show();
        }
    };


    /**
     * 显示网络速度
     */
    private void showNetSpeed() {

        long nowTotalRxBytes = getTotalRxBytes();
        long nowTimeStamp = System.currentTimeMillis();
        long speed = ((nowTotalRxBytes - lastTotalRxBytes) * 1000 / (nowTimeStamp - lastTimeStamp));//毫秒转换

        lastTimeStamp = nowTimeStamp;
        lastTotalRxBytes = nowTotalRxBytes;

        Message msg = mHandler.obtainMessage();
        msg.what = 100;
        msg.obj = String.valueOf(speed) + " kb/s";

        mHandler.sendMessage(msg);//更新界面
    }



    private void setData() {

        if (!TextUtils.isEmpty(mVideoTitle)){
            mMediacontrollerFileName.setText(mVideoTitle);
        }

        SimpleDateFormat format = new SimpleDateFormat("HH:mm");//设置日期格式
        String data = format.format(new Date());
        mCurrentTimeTv.setText(data);

    }

    private String speed,mFileName;

    @Override
    public void setFileName(String fileName) {
        mFileName = fileName;
    }

    public void setNetWorkSpeedTv(String speed) {
        this.speed = speed;
    }

    private void endGesture() {
        mVolume = -1;
        mBrightness = -1f;
        // 隐藏
        mDismissHandler.removeMessages(0);
        mDismissHandler.sendEmptyMessageDelayed(0, 500);
    }

    public void setTanMuView(IDanmakuView tanMuView, DanmakuContext mDanmakuContext, BaseDanmakuParser mParser) {
        this.mDanmakuView = tanMuView;
        this.mDanmakuContext = mDanmakuContext;
        this.mParser = mParser;
    }

    private class VolumeBrightnesGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            float mOldX = e1.getX(), mOldY = e1.getY();
            int y = (int) e2.getRawY();
            Display disp = ((Activity) mContext).getWindowManager().getDefaultDisplay();
            int windowWidth = disp.getWidth();
            int windowHeight = disp.getHeight();
            if (mOldX > windowWidth * 4.0 / 5) {
                onVolumeSlide((mOldY - y) / windowHeight);
                return true;
            } else if (mOldX < windowWidth / 5.0) {
                onBrightnessSlide((mOldY - y) / windowHeight);
                return true;
            }
            return false;
        }
    }

    /**
     * 声音高低
     *
     * @param percent
     */
    private void onVolumeSlide(float percent) {
        if (mVolume == -1) {
            mVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
            if (mVolume < 0)
                mVolume = 0;

            mOperationBg.setImageResource(R.drawable.video_volumn_bg);
            mVolumeBrightnessLayout.setVisibility(View.VISIBLE);
        }

        int index = (int) (percent * mMaxVolume) + mVolume;
        if (index > mMaxVolume)
            index = mMaxVolume;
        else if (index < 0)
            index = 0;

        mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, index, 0);
        ViewGroup.LayoutParams lp = mOperationPercent.getLayoutParams();
        lp.width = findViewById(R.id.operation_full).getLayoutParams().width * index / mMaxVolume;
        mOperationPercent.setLayoutParams(lp);
    }

    /**
     * 处理屏幕亮暗
     *
     * @param percent
     */
    private void onBrightnessSlide(float percent) {
        if (mBrightness < 0) {
            mBrightness = ((Activity) mContext).getWindow().getAttributes().screenBrightness;
            if (mBrightness <= 0.00f)
                mBrightness = 0.50f;
            if (mBrightness < 0.01f)
                mBrightness = 0.01f;

            mOperationBg.setImageResource(R.drawable.video_brightness_bg);
            mVolumeBrightnessLayout.setVisibility(View.VISIBLE);
        }
        WindowManager.LayoutParams lpa = ((Activity) getContext()).getWindow().getAttributes();
        lpa.screenBrightness = mBrightness + percent;
        if (lpa.screenBrightness > 1.0f)
            lpa.screenBrightness = 1.0f;
        else if (lpa.screenBrightness < 0.01f)
            lpa.screenBrightness = 0.01f;
        ((Activity) mContext).getWindow().setAttributes(lpa);

        ViewGroup.LayoutParams lp = mOperationPercent.getLayoutParams();
        lp.width = (int) (findViewById(R.id.operation_full).getLayoutParams().width * lpa.screenBrightness);
        mOperationPercent.setLayoutParams(lp);
    }


}
