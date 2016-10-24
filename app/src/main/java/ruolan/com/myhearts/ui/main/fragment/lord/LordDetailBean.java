package ruolan.com.myhearts.ui.main.fragment.lord;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/10/21.
 */

public class LordDetailBean implements Serializable {

    /**
     * errorCode : 0
     * errorStr : success
     * resultCount : 30
     * score : 0
     * balance : 0
     * results : [{"id":"280","ownerId":"7289","ownerName":"Michael","ownerAvatar":"http://image.xinliji.me//FjQYxi49cUhC_Auk3in_p1nHupJc","ownerIsConsultant":"0","name":"许愿棠","icon":"http://7xi9sc.com2.z0.glb.qiniucdn.com/group_bg_s_37.png","gallery":"http://7xi9sc.com2.z0.glb.qiniucdn.com/group_bg_m_37.png","slogan":"生命是一段过程，纵苦难沧桑变化，经年之后，也必将洗净铅华，静看繁花。愿每一个独一无二的你，这一生都平安喜乐，如愿以偿。我们一起，在这里许下愿望。","subject":"","maxMember":"5000","member":"399","createdDate":1427978445,"latitude":"31.021629","longitude":"121.32568","location":"上海","catgId":"0","needConfirm":"0","pending":"0","pendingCnt":"0","distance":"11291.216016683164","joined":"0","isBlocked":"0","gotyeGroupId":"70224"},{"id":"297","ownerId":"8219","ownerName":"张婷婷","ownerAvatar":"http://image.xinliji.me//FuQK-qy0v7kO1lk6PMiIzxScsCQ0","ownerIsConsultant":"1","name":"趣你的生涯","icon":"http://7xi9sc.com2.z0.glb.qiniucdn.com/group_bg_s_11.png","gallery":"http://7xi9sc.com2.z0.glb.qiniucdn.com/group_bg_m_11.png","slogan":"讨论范围：职业定位，职场发展、适应，跳槽，职场人际关系，中学生选专业，大学生找工作，职场人生活工作平衡等","subject":"","maxMember":"5000","member":"207","createdDate":1431235619,"latitude":"31.559286","longitude":"120.271001","location":"江苏省","catgId":"0","needConfirm":"0","pending":"0","pendingCnt":"0","distance":"11202.040760678643","joined":"0","isBlocked":"0","gotyeGroupId":"260502"}]
     */

    private int errorCode;
    private String errorStr;
    private int resultCount;
    private int score;
    private int balance;
    /**
     * id : 280
     * ownerId : 7289
     * ownerName : Michael
     * ownerAvatar : http://image.xinliji.me//FjQYxi49cUhC_Auk3in_p1nHupJc
     * ownerIsConsultant : 0
     * name : 许愿棠
     * icon : http://7xi9sc.com2.z0.glb.qiniucdn.com/group_bg_s_37.png
     * gallery : http://7xi9sc.com2.z0.glb.qiniucdn.com/group_bg_m_37.png
     * slogan : 生命是一段过程，纵苦难沧桑变化，经年之后，也必将洗净铅华，静看繁花。愿每一个独一无二的你，这一生都平安喜乐，如愿以偿。我们一起，在这里许下愿望。
     * subject :
     * maxMember : 5000
     * member : 399
     * createdDate : 1427978445
     * latitude : 31.021629
     * longitude : 121.32568
     * location : 上海
     * catgId : 0
     * needConfirm : 0
     * pending : 0
     * pendingCnt : 0
     * distance : 11291.216016683164
     * joined : 0
     * isBlocked : 0
     * gotyeGroupId : 70224
     */

    private List<ResultsBean> results;

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

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
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

        private boolean isNoData;

        public void setNoData(boolean hasData) {
            isNoData = hasData;
        }

        public boolean isNoData() {
            return isNoData;
        }

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
    }
}
