package ruolan.com.myhearts.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/11/7.
 */

public class CircleFriendsUserBean implements Serializable {


    /**
     * errorCode : 0
     * errorStr : success
     * resultCount : 21
     * score : 0
     * balance : 0
     * results : {"id":"27011","actId":"0","actName":"","isAnon":"0","labelId":"1","label":"其他","userid":"112608","nickname":"王趁","avatar":"http://image.xinliji.me/FlJ2OUkyw8rWjpclkROH--_E9fvV","gender":"1","dob":"1991-08-13","type":"user_event","location":"","content":"good morning☔☔☔","createdDateTime":1478471746,"commentCnt":"0","photoCnt":"1","viewCnt":"491","isConsultant":"1","photos":["http://image.xinliji.me/ca3c0383-ca48-4843-ba26-7a961bcdff89"],"age":25}
     */

    private int errorCode;
    private String errorStr;
    private int resultCount;
    private int score;
    private int balance;
    private ResultsEntity results;

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorStr(String errorStr) {
        this.errorStr = errorStr;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setResults(ResultsEntity results) {
        this.results = results;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorStr() {
        return errorStr;
    }

    public int getResultCount() {
        return resultCount;
    }

    public int getScore() {
        return score;
    }

    public int getBalance() {
        return balance;
    }

    public ResultsEntity getResults() {
        return results;
    }

    public static class ResultsEntity {
        /**
         * id : 27011
         * actId : 0
         * actName :
         * isAnon : 0
         * labelId : 1
         * label : 其他
         * userid : 112608
         * nickname : 王趁
         * avatar : http://image.xinliji.me/FlJ2OUkyw8rWjpclkROH--_E9fvV
         * gender : 1
         * dob : 1991-08-13
         * type : user_event
         * location :
         * content : good morning☔☔☔
         * createdDateTime : 1478471746
         * commentCnt : 0
         * photoCnt : 1
         * viewCnt : 491
         * isConsultant : 1
         * photos : ["http://image.xinliji.me/ca3c0383-ca48-4843-ba26-7a961bcdff89"]
         * age : 25
         */

        private String id;
        private String actId;
        private String actName;
        private String isAnon;
        private String labelId;
        private String label;
        private String userid;
        private String nickname;
        private String avatar;
        private String gender;
        private String dob;
        private String type;
        private String location;
        private String content;
        private int createdDateTime;
        private String commentCnt;
        private String photoCnt;
        private String viewCnt;
        private String isConsultant;
        private int age;
        private List<String> photos;

        public void setId(String id) {
            this.id = id;
        }

        public void setActId(String actId) {
            this.actId = actId;
        }

        public void setActName(String actName) {
            this.actName = actName;
        }

        public void setIsAnon(String isAnon) {
            this.isAnon = isAnon;
        }

        public void setLabelId(String labelId) {
            this.labelId = labelId;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setCreatedDateTime(int createdDateTime) {
            this.createdDateTime = createdDateTime;
        }

        public void setCommentCnt(String commentCnt) {
            this.commentCnt = commentCnt;
        }

        public void setPhotoCnt(String photoCnt) {
            this.photoCnt = photoCnt;
        }

        public void setViewCnt(String viewCnt) {
            this.viewCnt = viewCnt;
        }

        public void setIsConsultant(String isConsultant) {
            this.isConsultant = isConsultant;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setPhotos(List<String> photos) {
            this.photos = photos;
        }

        public String getId() {
            return id;
        }

        public String getActId() {
            return actId;
        }

        public String getActName() {
            return actName;
        }

        public String getIsAnon() {
            return isAnon;
        }

        public String getLabelId() {
            return labelId;
        }

        public String getLabel() {
            return label;
        }

        public String getUserid() {
            return userid;
        }

        public String getNickname() {
            return nickname;
        }

        public String getAvatar() {
            return avatar;
        }

        public String getGender() {
            return gender;
        }

        public String getDob() {
            return dob;
        }

        public String getType() {
            return type;
        }

        public String getLocation() {
            return location;
        }

        public String getContent() {
            return content;
        }

        public int getCreatedDateTime() {
            return createdDateTime;
        }

        public String getCommentCnt() {
            return commentCnt;
        }

        public String getPhotoCnt() {
            return photoCnt;
        }

        public String getViewCnt() {
            return viewCnt;
        }

        public String getIsConsultant() {
            return isConsultant;
        }

        public int getAge() {
            return age;
        }

        public List<String> getPhotos() {
            return photos;
        }
    }
}
