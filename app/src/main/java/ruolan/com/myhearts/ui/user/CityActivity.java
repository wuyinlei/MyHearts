package ruolan.com.myhearts.ui.user;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.adapter.CityGridViewAdapter;
import ruolan.com.myhearts.adapter.SortAdapter;
import ruolan.com.myhearts.db.RegionFunction;
import ruolan.com.myhearts.entity.CityModel;
import ruolan.com.myhearts.entity.RegionInfo;
import ruolan.com.myhearts.ui.base.BaseActivity;
import ruolan.com.myhearts.utils.KeyBoard;
import ruolan.com.myhearts.utils.PinyinComparator;
import ruolan.com.myhearts.utils.PreferencesUtils;
import ruolan.com.myhearts.widget.city.ClearCityEditText;
import ruolan.com.myhearts.widget.city.SideBar;

public class CityActivity extends BaseActivity {
    private List<RegionInfo> countyList;//用于存放县一级的城市名
    private List<RegionInfo> cityList;//用于存放城市名（二级城市，省下直接下辖单位）
    private List<RegionInfo> provinceList;//用于存放省级地名（江苏、北京、山东等）
    private List<String> countyName;
    private List<String> cityName;
    private List<String> provinceName;
    private ListView sortListView;
    private SideBar sideBar;
    private TextView dialog;
    private SortAdapter adapter;
    private ClearCityEditText clearEditText;
    private List<RegionInfo> hotCity;//热门城市列表
    private CityGridViewAdapter gridViewAdapter;
    private GridView gridView;
    private List<CityModel> SourceDateList;//用于存放排序后的二级城市，最主要的功能

    /**
     * 根据拼音来排列ListView里面的数据类
     */
    private PinyinComparator pinyinComparator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getResultId() {
        return R.layout.activity_city;
    }

    public void initData() {

        //获取所有的省级城市
        provinceList= RegionFunction.getProvencesOrCity(1);
        //获取数据库中的所有二级城市信息
        cityList = RegionFunction.getProvencesOrCity(2);
        //获取数据库中所有的三级城市信息
        countyList=RegionFunction.getProvencesOrCity(3);

        provinceName=new ArrayList<>();
        for(RegionInfo info : provinceList){
            provinceName.add(info.getName().trim());
        }
        //四个直辖市，港、澳、台特殊处理
        provinceName.remove("北京");
        provinceName.remove("天津");
        provinceName.remove("上海");
        provinceName.remove("重庆");
        provinceName.remove("香港");
        provinceName.remove("澳门");
        provinceName.remove("台湾");

        cityName = new ArrayList<>();
        for (RegionInfo info : cityList) {
            cityName.add(info.getName().trim());
        }
        cityName.add("北京");
        cityName.add("天津");
        cityName.add("上海");
        cityName.add("重庆");
        cityName.add("香港");
        cityName.add("澳门");
        cityName.add("台湾");

        countyName = new ArrayList<>();
        for(RegionInfo info : countyList){
            countyName.add(info.getName().trim());
        }

        //热门城市的数据初始化
        hotCity = new ArrayList<>();
        //手动设置热城市
        hotCity.add(new RegionInfo(2, 1, getResources().getString(R.string.beijing),"B"));
        hotCity.add(new RegionInfo(25, 1, getResources().getString(R.string.shanghai),"S"));
        hotCity.add(new RegionInfo(77, 6, getResources().getString(R.string.shengzhen),"S"));
        hotCity.add(new RegionInfo(76, 6, getResources().getString(R.string.guangzhou),"G"));
        hotCity.add(new RegionInfo(343, 1, getResources().getString(R.string.tianjin),"T"));

        pinyinComparator = new PinyinComparator();
        // 根据a-z进行排序源数据
        SourceDateList = filledData(cityList);
        Collections.sort(SourceDateList, pinyinComparator);

    }

    @Override
    protected void initListener() {
        //设置右侧触摸监听
        sideBar.setOnTouchingLetterChangedListener(s -> {
            KeyBoard.closeSoftKeyboard(CityActivity.this);
            //该字母首次出现的位置
            int position = adapter.getPositionForSection(s.charAt(0));
            if (position != -1) {
                sortListView.setSelection(position);
            }

        });

        sortListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //这里要利用adapter.getItem(position)来获取当前position所对应的对象
                String cityName = ((CityModel) adapter.getItem(position - 1)).getName();
                if (cityName != null && cityName.length() > 0) {
                    Toast.makeText(CityActivity.this, cityName, Toast.LENGTH_SHORT).show();
                    KeyBoard.closeSoftKeyboard(CityActivity.this);
                    PreferencesUtils.saveCityName(CityActivity.this, cityName);
                    Intent intent = new Intent();
                    setResult(100, intent);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            finish();
                        }
                    }, 500);
                }
            }
        });

        //根据输入框输入值的改变来过滤搜索
        clearEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //当输入框里面的值为空，更新为原来的列表，否则为过滤数据列表
                filterData(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            String cityName1 = hotCity.get(position).getName();
            if (cityName1 != null && cityName1.length() > 0) {
                Toast.makeText(CityActivity.this, cityName1, Toast.LENGTH_SHORT).show();
                KeyBoard.closeSoftKeyboard(CityActivity.this);
                PreferencesUtils.saveCityName(CityActivity.this, cityName1);
                Intent intent = new Intent();
                setResult(100, intent);
                new Handler().postDelayed(() -> finish(), 500);
            }
        });
    }

    @Override
    public void initView() {

        initData();

        View view = View.inflate(this, R.layout.head_city_list, null);
        gridView = (GridView) view.findViewById(R.id.gridview_hot);
        gridViewAdapter = new CityGridViewAdapter(this, hotCity);
        gridView.setAdapter(gridViewAdapter);
        gridView.setSelector(new ColorDrawable(Color.TRANSPARENT));

        sideBar = (SideBar) findViewById(R.id.sidrbar);
        dialog = (TextView) findViewById(R.id.dialog);
        sideBar.setTextView(dialog);

        sortListView = (ListView) findViewById(R.id.country_lvcountry);
        sortListView.addHeaderView(view);
        adapter = new SortAdapter(this, SourceDateList);
        sortListView.setAdapter(adapter);
        clearEditText = (ClearCityEditText) findViewById(R.id.filter_edit);
    }


    /**
     * 为ListView填充数据
     */
    private List<CityModel> filledData(List<RegionInfo> date) {
        List<CityModel> mSortList = new ArrayList<>();

        for (int i = 0; i < date.size(); i++) {
            CityModel cityModel = new CityModel();
            String name = date.get(i).getName();
            String firstName=date.get(i).getFirstName();
            cityModel.setName(name);
            cityModel.setFirstName(firstName);
            mSortList.add(cityModel);
        }
        return mSortList;

    }

    /**
     * 根据输入框中的值来过滤数据并更新ListView
     */
    private void filterData(String keyword) {
        List<CityModel> filterDateList = new ArrayList<>();

        if (TextUtils.isEmpty(keyword)) {
            filterDateList = SourceDateList;
        } else {
            if (provinceName.contains(keyword)) {
                filterDateList.clear();
                //匹配省级城市的名单
                for(int i=0;i<provinceList.size();i++) {
                    String name=provinceList.get(i).getName();
                    int id=provinceList.get(i).getId();
                    if(name.startsWith(keyword)){
                        filterDateList.addAll(filledData(RegionFunction.getProvencesOrCityOnParent(id)));
                    }
                }

            } else if(cityName.contains(keyword)){
                filterDateList.clear();
                //匹配二级城市菜单
                for (int i = 0; i< cityList.size(); i++) {
                    String name = cityList.get(i).getName();
                    int id=cityList.get(i).getId();
                    if (name.equals(keyword)) {
                        filterDateList.addAll(filledData(RegionFunction.getProvencesOrCityOnParent(id)));
                    }
                }
            } else if(!cityName.contains(keyword)&&!provinceName.contains(keyword)){
                filterDateList.clear();
                //模糊匹配二级城市
                for (CityModel cityModel : SourceDateList) {
                    String name = cityModel.getName();
                    String firstName=cityModel.getFirstName().toLowerCase();
                    if (name.indexOf(keyword.toString()) != -1 || firstName.startsWith(keyword.toString())) {
                        filterDateList.add(cityModel);
                    }
                }
                if(filterDateList.size()==0){
                    //二级城市匹配失败，匹配县级城市（三级城市）
                    for(int i=0;i<countyList.size();i++){
                        String name=countyList.get(i).getName();
                        String firstName=countyList.get(i).getFirstName();
                        if(name.startsWith(keyword)){
                            CityModel model=new CityModel();
                            model.setName(name);
                            model.setFirstName(firstName);
                            filterDateList.add(model);
                        }
                    }
                    if(filterDateList.size()==0){
                        //数据库中无法找到对应的信息，提示错误信息
                        Toast.makeText(CityActivity.this,
                                getResources().getString(R.string.input_correct_key),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }

        // 根据a-z进行排序
        Collections.sort(filterDateList, pinyinComparator);
        adapter.updateListView(filterDateList);
        KeyBoard.closeSoftKeyboard(CityActivity.this);
    }

}
