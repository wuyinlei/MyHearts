package ruolan.com.myhearts.entity;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2016/10/26.
 */

public class ThirdPartUser extends BmobObject{

    private String city;
    private String username;
    private String sex;
    private String imgUrl;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
