package ruolan.com.myhearts.ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ruolan.com.myhearts.ui.login.LoginActivity;

/**
 * Created by Administrator on 2016/10/21.
 */

public class BaseFragment extends Fragment {

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void startActivity(Intent intent, boolean isNeedLogin){


        if(isNeedLogin){

            //   User user = MyApplication.getInstance().getUser();
            if(false){
                super.startActivity(intent);
            }
            else{

                //MyApplication.getInstance().putIntent(intent);
                Intent loginIntent = new Intent(getActivity()
                        , LoginActivity.class);
                super.startActivity(loginIntent);

            }

        }
        else{
            super.startActivity(intent);
        }

    }
}
