package ruolan.com.myhearts.entity;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2016/11/2.
 */

public class FeedBean extends BmobObject{

    private String username;
    private String phone;
    private String content;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
