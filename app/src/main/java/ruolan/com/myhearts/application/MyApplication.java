package ruolan.com.myhearts.application;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import ruolan.com.myhearts.User;

/**
 * Created by Administrator on 2016/10/20.
 */

public class MyApplication
        extends Application {

    private User user;


    private static MyApplication mInstance;


    public static MyApplication getInstance() {

        return mInstance;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
       // initUser();
      //  Fresco.initialize(this);
    }



    private Intent intent;

    public void putIntent(Intent intent) {
        this.intent = intent;
    }

    public Intent getIntent() {
        return this.intent;
    }

    public void jumpToTargetActivity(Context context) {

        context.startActivity(intent);
        this.intent = null;
    }

}
