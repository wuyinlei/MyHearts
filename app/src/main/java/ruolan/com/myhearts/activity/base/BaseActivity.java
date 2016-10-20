package ruolan.com.myhearts.activity.base;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import ruolan.com.myhearts.application.MyApplication;
import ruolan.com.myhearts.activity.login.LoginActivity;

/**
 * Created by Administrator on 2016/10/20.
 */

public class BaseActivity extends AppCompatActivity{
    protected static final String TAG = BaseActivity.class.getSimpleName();

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
