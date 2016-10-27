package ruolan.com.myhearts.entity;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by Administrator on 2016/10/25.
 */

public class MyUser extends BmobUser{

    private static final long serialVersionUID = 1L;
    private Integer age;
    private Integer num;
    private Boolean sex;

    private String imgurl;
    private String instance;
    private String profession;
    private String bloodtype;
    private String love;
    private String des;
    private int userfans;
    private String constellation;
    private String label;

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getConstellation() {
        return constellation;
    }

    //这个BmobFile是特有的，我们可以用来上传我们的图片(头像资源)


    public void setUserfans(int userfans) {
        this.userfans = userfans;
    }

    public int getUserfans() {
        return userfans;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDes() {
        return des;
    }

    public void setLove(String love) {
        this.love = love;
    }

    public String getLove() {
        return love;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getProfession() {
        return profession;
    }

    public String getBloodtype() {
        return bloodtype;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }

    public String getInstance() {
        return instance;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getImgurl() {
        return imgurl;
    }

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
