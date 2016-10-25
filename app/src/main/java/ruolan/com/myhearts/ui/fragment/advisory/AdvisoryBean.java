package ruolan.com.myhearts.ui.fragment.advisory;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/10/21.
 */

public class AdvisoryBean implements Serializable {

    /**
     * errorCode : 0
     * errorStr : success
     * resultCount : 30
     * score : 0
     * balance : 0
     * results : [{"userid":"54442","nickname":"何峻","avatar":"http://image.xinliji.me/Fg8BSTC1TaLr30xy8415T-kVPjSr","gender":"0","city":"上海","qualification":"国二","catgs":"情绪困扰、心理障碍、社交职场","slogan":"让我们一起拨云见日","likeCnt":"123","isLiked":"1","distance":"","address":"","lon":"","lat":"","is_online":"1","canAudioCall":"1","audioCallPrice":"90","receiveAudioCall":"1"}]
     */

    private int errorCode;
    private String errorStr;
    private int resultCount;
    private int score;
    private int balance;
    /**
     * userid : 54442
     * nickname : 何峻
     * avatar : http://image.xinliji.me/Fg8BSTC1TaLr30xy8415T-kVPjSr
     * gender : 0
     * city : 上海
     * qualification : 国二
     * catgs : 情绪困扰、心理障碍、社交职场
     * slogan : 让我们一起拨云见日
     * likeCnt : 123
     * isLiked : 1
     * distance :
     * address :
     * lon :
     * lat :
     * is_online : 1
     * canAudioCall : 1
     * audioCallPrice : 90
     * receiveAudioCall : 1
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
        private String userid;
        private String nickname;
        private String avatar;
        private String gender;
        private String city;
        private String qualification;
        private String catgs;
        private String slogan;
        private String likeCnt;
        private String isLiked;
        private String distance;
        private String address;
        private String lon;
        private String lat;
        private String is_online;
        private String canAudioCall;
        private String audioCallPrice;
        private String receiveAudioCall;

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getQualification() {
            return qualification;
        }

        public void setQualification(String qualification) {
            this.qualification = qualification;
        }

        public String getCatgs() {
            return catgs;
        }

        public void setCatgs(String catgs) {
            this.catgs = catgs;
        }

        public String getSlogan() {
            return slogan;
        }

        public void setSlogan(String slogan) {
            this.slogan = slogan;
        }

        public String getLikeCnt() {
            return likeCnt;
        }

        public void setLikeCnt(String likeCnt) {
            this.likeCnt = likeCnt;
        }

        public String getIsLiked() {
            return isLiked;
        }

        public void setIsLiked(String isLiked) {
            this.isLiked = isLiked;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getLon() {
            return lon;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getIs_online() {
            return is_online;
        }

        public void setIs_online(String is_online) {
            this.is_online = is_online;
        }

        public String getCanAudioCall() {
            return canAudioCall;
        }

        public void setCanAudioCall(String canAudioCall) {
            this.canAudioCall = canAudioCall;
        }

        public String getAudioCallPrice() {
            return audioCallPrice;
        }

        public void setAudioCallPrice(String audioCallPrice) {
            this.audioCallPrice = audioCallPrice;
        }

        public String getReceiveAudioCall() {
            return receiveAudioCall;
        }

        public void setReceiveAudioCall(String receiveAudioCall) {
            this.receiveAudioCall = receiveAudioCall;
        }
    }
}
