package ruolan.com.myhearts.ui.register;

import cn.bmob.v3.BmobUser;

/**
 * Created by Administrator on 2016/10/25.
 */

public class MyUser extends BmobUser{

    private static final long serialVersionUID = 1L;
    private Integer age;
    private Integer num;
    private Boolean sex;


    public Boolean getSex() {
        return sex;
    }
    public void setSex(Boolean sex) {
        this.sex = sex;
    }
    public Integer getNum() {
        return num;
    }
    public void setNum(Integer num) {
        this.num = num;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return getUsername()+"\n"+getObjectId()+"\n"+age+"\n"+num+"\n"+getSessionToken()+"\n"+getEmailVerified();
    }
}
