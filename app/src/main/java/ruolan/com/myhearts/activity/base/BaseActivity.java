package ruolan.com.myhearts.activity.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.application.MyApplication;
import ruolan.com.myhearts.activity.login.LoginActivity;
import ruolan.com.myhearts.utils.TranslucentUtils;

/**
 * Created by Administrator on 2016/10/20.
 */

public abstract class BaseActivity extends AppCompatActivity{
    protected static final String TAG = BaseActivity.class.getSimpleName();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getResultId());

        TranslucentUtils.setColor(this, getResources().getColor(R.color.home_bg_title), 1);

        initView();
        initListener();
        initData();
    }

    protected abstract int getResultId();

    public void initData() {

    }

    protected abstract void initListener();

    public abstract void initView();

    public void startActivity(Intent intent, boolean isNeedLogin){


        if(isNeedLogin){

         //   User user = MyApplication.getInstance().getUser();
            if(false){
                super.startActivity(intent);
            }
            else{

                //MyApplication.getInstance().putIntent(intent);
                Intent loginIntent = new Intent(this
                        , LoginActivity.class);
                super.startActivity(loginIntent);

            }

        }
        else{
            super.startActivity(intent);
        }

    }

}
