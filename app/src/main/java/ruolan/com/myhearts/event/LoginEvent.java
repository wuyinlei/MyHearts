package ruolan.com.myhearts.event;

import ruolan.com.myhearts.entity.MyUser;

/**
 * Created by Administrator on 2016/10/26.
 */

public class LoginEvent {

    public MyUser mMyUser;

    public LoginEvent(MyUser myUser) {
        mMyUser = myUser;
    }
}
