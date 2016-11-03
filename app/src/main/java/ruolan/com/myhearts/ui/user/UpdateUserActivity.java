package ruolan.com.myhearts.ui.user;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;

import java.util.Calendar;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;
import cn.qqtheme.framework.picker.ConstellationPicker;
import cn.qqtheme.framework.picker.DatePicker;
import ruolan.com.myhearts.R;
import ruolan.com.myhearts.entity.MyUser;
import ruolan.com.myhearts.ui.base.BaseActivity;
import ruolan.com.myhearts.utils.PreferencesUtils;
import ruolan.com.myhearts.widget.CustomPrograss;

public class UpdateUserActivity extends BaseActivity implements View.OnClickListener {


    private Calendar calendar = Calendar.getInstance();

    private EditText mSettingNickename,
            mSettingLike;
    private TextView mSettingAge,
            mConstellation,
            mSettingLableText,
            mSettingSlogn,
            mSettingCity,
            mBloodType,
            mSettingOcc;
    private MyUser mCurrentUser;

    private ImageView mIcBack, mUpdate;


    @Override
    protected int getResultId() {
        return R.layout.user_setting_layout;
    }

    @Override
    public void initData() {
        super.initData();
        mCurrentUser = MyUser.getCurrentUser(MyUser.class);
        if (mCurrentUser!=null) {  //如果能够找到当前的用户信息，就去更新ui，如果没有那就代表没有登录过
            updateUI(mCurrentUser);
        }
    }

    /**
     * 填充ui
     *
     * @param user
     */
    private void updateUI(MyUser user) {
        if (!TextUtils.isEmpty(user.getUsername())) {
            mSettingNickename.setText(user.getUsername());
        }
        if (!TextUtils.isEmpty(user.getLove())) {
            mSettingLike.setText(user.getLove());
        }
        if (!TextUtils.isEmpty(user.getInstance())) {
            mSettingCity.setText(user.getInstance());
        }
        if (!TextUtils.isEmpty(user.getDes())) {
            mSettingSlogn.setText(user.getDes());
        }
        if (!TextUtils.isEmpty(user.getBloodtype())) {
            mBloodType.setText(user.getBloodtype());
        }
        if (!TextUtils.isEmpty(user.getProfession())) {
            mSettingOcc.setText(user.getProfession());
        }
        if (!TextUtils.isEmpty(user.getAge() + "")) {
            mSettingAge.setText(user.getAge() + "");
        }
        if (!TextUtils.isEmpty(user.getConstellation())) {
            mConstellation.setText(user.getConstellation());
        }

    }

    @Override
    protected void initListener() {
        mSettingCity.setOnClickListener(this);
        mSettingSlogn.setOnClickListener(this);
        mSettingAge.setOnClickListener(this);
        mConstellation.setOnClickListener(this);
        mSettingLableText.setOnClickListener(this);
        mBloodType.setOnClickListener(this);
        mSettingOcc.setOnClickListener(this);
        mIcBack.setOnClickListener(this);
        mUpdate.setOnClickListener(this);
    }

    @Override
    public void initView() {
        mSettingNickename = (EditText) findViewById(R.id.setting_nickename);
        mSettingLike = (EditText) findViewById(R.id.setting_like);
        mSettingCity = (TextView) findViewById(R.id.setting_city);
        mSettingSlogn = (TextView) findViewById(R.id.setting_slogn);
        mSettingAge = (TextView) findViewById(R.id.setting_age);
        mConstellation = (TextView) findViewById(R.id.constellation);
        mSettingLableText = (TextView) findViewById(R.id.settinglable_text);
        mBloodType = (TextView) findViewById(R.id.blood_type);
        mSettingOcc = (TextView) findViewById(R.id.setting_occ);
        mIcBack = (ImageView) findViewById(R.id.ic_back);
        mUpdate = (ImageView) findViewById(R.id.update);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.setting_city:
                onCitySelect();
                break;
            case R.id.setting_slogn:
                onSlognEdit();
                break;
            case R.id.setting_age:
                onYearMonthDayPicker();
                break;
            case R.id.constellation:
                onConstellationPicker();
                break;
            case R.id.settinglable_text:

                break;
            case R.id.blood_type:
                onBloodTypePicker();
                break;
            case R.id.setting_occ:
                onOccDialog();
                break;

            case R.id.ic_back:
                finish();
                break;

            case R.id.update:
                updateUesrInfo();
                break;


        }
    }

    /**
     * 个性签名编辑
     */
    private void onSlognEdit() {
        Intent intent = new Intent(this, IndividualityActivity.class);
        startActivityForResult(intent, REQUEST_DES_CODE);
    }

    /**
     * 更新用户信息
     */
    private void updateUesrInfo() {
        CustomPrograss.show(this, getResources().getString(R.string.updating), true, null);
        String objectId = mCurrentUser.getObjectId();
        MyUser user = new MyUser();

        String ageString = mSettingAge.getText().toString();
        if (!TextUtils.isEmpty(ageString)) {
            int age = Integer.parseInt(ageString);
            user.setAge(age);
        }
        String instance = mSettingCity.getText().toString();
        if (!TextUtils.isEmpty(instance))
            user.setInstance(instance);

        String bloodtype = mBloodType.getText().toString();
        if (!TextUtils.isEmpty(bloodtype))
            user.setBloodtype(bloodtype);
        String slogn = mSettingSlogn.getText().toString();
        if (!TextUtils.isEmpty(slogn))
            user.setDes(slogn);
        String constellation = mConstellation.getText().toString();
        if (!TextUtils.isEmpty(constellation))
            user.setConstellation(constellation);
        String profession = mSettingOcc.getText().toString();
        if (!TextUtils.isEmpty(profession))
            user.setProfession(profession);
        String username = mSettingNickename.getText().toString();
        if (!TextUtils.isEmpty(username))
            user.setUsername(username);
        String love = mSettingLike.getText().toString();
        if (!TextUtils.isEmpty(love)) user.setLove(love);

        String label = mSettingSlogn.getText().toString();
        if (!TextUtils.isEmpty(label))
            user.setLabel(label);
        user.update(objectId, new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    CustomPrograss.disMiss();


                }
            }
        });

    }


    //返回码
    private final int RESULT_CODE = 100;
    //请求码
    private final int REQUEST_CODE = 101;

    private final int REQUEST_DES_CODE = 102;


    private void onCitySelect() {
        Intent intent = new Intent(this, CityActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_CODE) {
            String cityName = PreferencesUtils.getCityName(this);
            mSettingCity.setText(cityName);
        }
        if (requestCode == REQUEST_DES_CODE && resultCode == RESULT_CODE) {
            String slognName = PreferencesUtils.getSlognName(this);
            mSettingSlogn.setText(slognName);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    /**
     * 职业选择
     */
    private void onOccDialog() {
        new MaterialDialog.Builder(this)
                .title(R.string.occ_title)
                .items(R.array.occ)
                .backgroundColor(getResources().getColor(R.color.dialog_bg))
                .itemsCallback((dialog, itemView, position, text) -> mSettingOcc.setText(text))
                .show();
    }

    /**
     * 血型选择
     */
    private void onBloodTypePicker() {
        ProfessorPicker picker = new ProfessorPicker(this);
        picker.setTopBackgroundColor(0xFFEEEEEE);
        picker.setTopLineVisible(false);
        picker.setCancelTextColor(0xFF33B5E5);
        picker.setSubmitTextColor(0xFF33B5E5);
        picker.setTextColor(0xFFFF0000, 0xFFCCCCCC);
        picker.setLineColor(0xFFEE0000);
        picker.setSelectedItem("UnKnow");
        picker.setOnOptionPickListener(option -> {
            //showToast(option);
            mBloodType.setText(option);
        });
        picker.show();

    }

    /**
     * 年龄选择
     */
    private void onYearMonthDayPicker() {
        DatePicker picker = new DatePicker(this);
        picker.setRange(1910, 2016);
        picker.setSelectedItem(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
        picker.setOnDatePickListener((DatePicker.OnYearMonthDayPickListener) (year, month, day) -> {
            //showToast(year + "-" + month + "-" + day);
            int yearOld = Integer.parseInt(year);
            Calendar ca = Calendar.getInstance();
            int curYear = ca.get(Calendar.YEAR);//获取年份
            int age = curYear - yearOld;
            mSettingAge.setText(age + "");
        });
        picker.show();

    }

    /**
     * 星座选择器
     */
    private void onConstellationPicker() {
        ConstellationPicker picker = new ConstellationPicker(this);
        picker.setTopBackgroundColor(0xFFEEEEEE);
        picker.setTopLineVisible(false);
        picker.setCancelTextColor(0xFF33B5E5);
        picker.setSubmitTextColor(0xFF33B5E5);
        picker.setTextColor(0xFFFF0000, 0xFFCCCCCC);
        picker.setLineColor(0xFFEE0000);
        picker.setSelectedItem("射手");
        picker.setOnOptionPickListener(option -> {
            //showToast(option);
            mConstellation.setText(option);
        });
        picker.show();

    }
}
