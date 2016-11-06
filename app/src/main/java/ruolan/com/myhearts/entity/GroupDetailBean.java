package ruolan.com.myhearts.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wuyinlei on 2016/11/6.
 */

public class GroupDetailBean implements Serializable{


    /**
     * errorCode : 0
     * errorStr : success
     * resultCount : 25
     * score : 0
     * balance : 0
     * results : {"id":"269","ownerId":"7301","ownerName":"宝贝蛋","ownerAvatar":"http://icon.xinliji.me/avatar_0_13.png","ownerIsConsultant":"0","name":"我是小三","icon":"http://7xi9sc.com2.z0.glb.qiniucdn.com/group_bg_s_29.png","gallery":"http://7xi9sc.com2.z0.glb.qiniucdn.com/group_bg_l_29.png","slogan":"小三也是人，你们知道我们的痛苦吗？","subject":"","maxMember":"5000","member":"169","createdDate":1427201143,"latitude":"31.24582862854004","longitude":"121.5610580444336","location":"上海","catgId":"5","needConfirm":"1","pending":"0","pendingCnt":"430","distance":"7592294.477861399","joined":"0","isBlocked":"0","gotyeGroupId":"58421","memberAvatars":["http://icon.xinliji.me/avatar_0_13.png","http://image.xinliji.me//FhTJNEKGGkDeFunHg2wdRQQUXhTB","http://image.xinliji.me//FvvgWd6kz0XBqnLZtopy-jQVYT8g","http://icon.xinliji.me/avatar_1_62.png","http://icon.xinliji.me/avatar_0_65.png","http://icon.xinliji.me/avatar_0_43.png"]}
     */

    private int errorCode;
    private String errorStr;
    private int resultCount;
    private int score;
    private int balance;
    /**
     * id : 269
     * ownerId : 7301
     * ownerName : 宝贝蛋
     * ownerAvatar : http://icon.xinliji.me/avatar_0_13.png
     * ownerIsConsultant : 0
     * name : 我是小三
     * icon : http://7xi9sc.com2.z0.glb.qiniucdn.com/group_bg_s_29.png
     * gallery : http://7xi9sc.com2.z0.glb.qiniucdn.com/group_bg_l_29.png
     * slogan : 小三也是人，你们知道我们的痛苦吗？
     * subject :
     * maxMember : 5000
     * member : 169
     * createdDate : 1427201143
     * latitude : 31.24582862854004
     * longitude : 121.5610580444336
     * location : 上海
     * catgId : 5
     * needConfirm : 1
     * pending : 0
     * pendingCnt : 430
     * distance : 7592294.477861399
     * joined : 0
     * isBlocked : 0
     * gotyeGroupId : 58421
     * memberAvatars : ["http://icon.xinliji.me/avatar_0_13.png","http://image.xinliji.me//FhTJNEKGGkDeFunHg2wdRQQUXhTB","http://image.xinliji.me//FvvgWd6kz0XBqnLZtopy-jQVYT8g","http://icon.xinliji.me/avatar_1_62.png","http://icon.xinliji.me/avatar_0_65.png","http://icon.xinliji.me/avatar_0_43.png"]
     */

    private ResultsBean results;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorStr() {
        return errorStr;
    }

    public void setErrorStr(String errorStr) {
        this.errorStr = errorStr;
    }

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public ResultsBean getResults() {
        return results;
    }

    public void setResults(ResultsBean results) {
        this.results = results;
    }

    public static class ResultsBean {
        private String id;
        private String ownerId;
        private String ownerName;
        private String ownerAvatar;
        private String ownerIsConsultant;
        private String name;
        private String icon;
        private String gallery;
        private String slogan;
        private String subject;
        private String maxMember;
        private String member;
        private int createdDate;
        private String latitude;
        private String longitude;
        private String location;
        private String catgId;
        private String needConfirm;
        private String pending;
        private String pendingCnt;
        private String distance;
        private String joined;
        private String isBlocked;
        private String gotyeGroupId;
        private List<String> memberAvatars;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOwnerId() {
            return ownerId;
        }

        public void setOwnerId(String ownerId) {
            this.ownerId = ownerId;
        }

        public String getOwnerName() {
            return ownerName;
        }

        public void setOwnerName(String ownerName) {
            this.ownerName = ownerName;
        }

        public String getOwnerAvatar() {
            return ownerAvatar;
        }

        public void setOwnerAvatar(String ownerAvatar) {
            this.ownerAvatar = ownerAvatar;
        }

        public String getOwnerIsConsultant() {
            return ownerIsConsultant;
        }

        public void setOwnerIsConsultant(String ownerIsConsultant) {
            this.ownerIsConsultant = ownerIsConsultant;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getGallery() {
            return gallery;
        }

        public void setGallery(String gallery) {
            this.gallery = gallery;
        }

        public String getSlogan() {
            return slogan;
        }

        public void setSlogan(String slogan) {
            this.slogan = slogan;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getMaxMember() {
            return maxMember;
        }

        public void setMaxMember(String maxMember) {
            this.maxMember = maxMember;
        }

        public String getMember() {
            return member;
        }

        public void setMember(String member) {
            this.member = member;
        }

        public int getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(int createdDate) {
            this.createdDate = createdDate;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getCatgId() {
            return catgId;
        }

        public void setCatgId(String catgId) {
            this.catgId = catgId;
        }

        public String getNeedConfirm() {
            return needConfirm;
        }

        public void setNeedConfirm(String needConfirm) {
            this.needConfirm = needConfirm;
        }

        public String getPending() {
            return pending;
        }

        public void setPending(String pending) {
            this.pending = pending;
        }

        public String getPendingCnt() {
            return pendingCnt;
        }

        public void setPendingCnt(String pendingCnt) {
            this.pendingCnt = pendingCnt;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getJoined() {
            return joined;
        }

        public void setJoined(String joined) {
            this.joined = joined;
        }

        public String getIsBlocked() {
            return isBlocked;
        }

        public void setIsBlocked(String isBlocked) {
            this.isBlocked = isBlocked;
        }

        public String getGotyeGroupId() {
            return gotyeGroupId;
        }

        public void setGotyeGroupId(String gotyeGroupId) {
            this.gotyeGroupId = gotyeGroupId;
        }

        public List<String> getMemberAvatars() {
            return memberAvatars;
        }

        public void setMemberAvatars(List<String> memberAvatars) {
            this.memberAvatars = memberAvatars;
        }
    }
}
