package ruolan.com.myhearts.ui.main.fragment;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/10/21.
 */

public class MentalOrationBean implements Serializable {

    /**
     * errorCode : 0
     * errorStr : success
     * resultCount : 58
     * score : 0
     * balance : 0
     * results : {"userid":"88124","qjCode":"","nickname":"陈琳","avatar":"http://image.xinliji.me/FhO6NNhYp-vXUB5DluSd65__Lx7B","slogan":"让我陪伴你度过一段平和宁静的时光\u2026\u2026","audio":"http://audio.xinliji.me/chenlin.mp3","audioLength":"","gender":"0","score":"1","dob":"1976-07-24","constellation":"5","height":"160","weight":"60","role":"0","emotion":"0","occupation":"","city":"广州","label":"","hobby":"","like":"","hate":"","likeCnt":"12","isLiked":"0","isFollowed":"0","isInBlacklist":"0","groupCnt":"0","cmtCnt":"0","isAnchor":"0","distance":"0","lastLoginLatitude":"23.131735","lastLoginLongitude":"113.294676","lastLoginTime":1476998280,"isConsultant":"1","catgs":"情绪困扰、婚恋情感、亲子教育","honor":"国家二级心理咨询师","resume":"本人性格开朗，善解人意，乐于沟通！长达七年的心理咨询工作学习与实践。国家二级心理咨询师，国际三级婚姻家庭咨询师，高级沙盘游戏教育指导师，EPA高级沙盘咨询师。咨询时长500小时，个人成长体验300小时，个案专业督导200小时。非常热爱心理咨询工作，擅长婚恋情感，亲子沟通，青少年青春期问题，家庭危机干预，抑郁焦虑等咨询，以及沙盘咨询治疗，希望用自己的真诚和专业，陪伴和支持有困惑的朋友走出人生低谷。","qualification":"国二","qualificationPhotos":"http://image.xinliji.me/o_1ap79np0j7p41gc66kj1kj81nvui.jpg","fee":"300","reserveFee":180,"clinicName":"广州红树林心理咨询","address":"","lon":"","lat":"","isNamePending":"0","isQuaPending":"0","nameDraft":"","quaDraft":"","quaPhotosDraft":"","videoProfile":"","webcallPrice":"50","canShare":"1","shareTitle":"【我心】(心理记)注册咨询师","shareContent":"相约【我心】(心理记)，我是您的专属心理咨询师 陈琳","age":40,"continuedPercent":"71.93","timelyPercent":"89.80","giftNum":"1"}
     */

    private int errorCode;
    private String errorStr;
    private int resultCount;
    private int score;
    private int balance;
    /**
     * userid : 88124
     * qjCode :
     * nickname : 陈琳
     * avatar : http://image.xinliji.me/FhO6NNhYp-vXUB5DluSd65__Lx7B
     * slogan : 让我陪伴你度过一段平和宁静的时光……
     * audio : http://audio.xinliji.me/chenlin.mp3
     * audioLength :
     * gender : 0
     * score : 1
     * dob : 1976-07-24
     * constellation : 5
     * height : 160
     * weight : 60
     * role : 0
     * emotion : 0
     * occupation :
     * city : 广州
     * label :
     * hobby :
     * like :
     * hate :
     * likeCnt : 12
     * isLiked : 0
     * isFollowed : 0
     * isInBlacklist : 0
     * groupCnt : 0
     * cmtCnt : 0
     * isAnchor : 0
     * distance : 0
     * lastLoginLatitude : 23.131735
     * lastLoginLongitude : 113.294676
     * lastLoginTime : 1476998280
     * isConsultant : 1
     * catgs : 情绪困扰、婚恋情感、亲子教育
     * honor : 国家二级心理咨询师
     * resume : 本人性格开朗，善解人意，乐于沟通！长达七年的心理咨询工作学习与实践。国家二级心理咨询师，国际三级婚姻家庭咨询师，高级沙盘游戏教育指导师，EPA高级沙盘咨询师。咨询时长500小时，个人成长体验300小时，个案专业督导200小时。非常热爱心理咨询工作，擅长婚恋情感，亲子沟通，青少年青春期问题，家庭危机干预，抑郁焦虑等咨询，以及沙盘咨询治疗，希望用自己的真诚和专业，陪伴和支持有困惑的朋友走出人生低谷。
     * qualification : 国二
     * qualificationPhotos : http://image.xinliji.me/o_1ap79np0j7p41gc66kj1kj81nvui.jpg
     * fee : 300
     * reserveFee : 180
     * clinicName : 广州红树林心理咨询
     * address :
     * lon :
     * lat :
     * isNamePending : 0
     * isQuaPending : 0
     * nameDraft :
     * quaDraft :
     * quaPhotosDraft :
     * videoProfile :
     * webcallPrice : 50
     * canShare : 1
     * shareTitle : 【我心】(心理记)注册咨询师
     * shareContent : 相约【我心】(心理记)，我是您的专属心理咨询师 陈琳
     * age : 40
     * continuedPercent : 71.93
     * timelyPercent : 89.80
     * giftNum : 1
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
        private String userid;
        private String qjCode;
        private String nickname;
        private String avatar;
        private String slogan;
        private String audio;
        private String audioLength;
        private String gender;
        private String score;
        private String dob;
        private String constellation;
        private String height;
        private String weight;
        private String role;
        private String emotion;
        private String occupation;
        private String city;
        private String label;
        private String hobby;
        private String like;
        private String hate;
        private String likeCnt;
        private String isLiked;
        private String isFollowed;
        private String isInBlacklist;
        private String groupCnt;
        private String cmtCnt;
        private String isAnchor;
        private String distance;
        private String lastLoginLatitude;
        private String lastLoginLongitude;
        private int lastLoginTime;
        private String isConsultant;
        private String catgs;
        private String honor;
        private String resume;
        private String qualification;
        private String qualificationPhotos;
        private String fee;
        private int reserveFee;
        private String clinicName;
        private String address;
        private String lon;
        private String lat;
        private String isNamePending;
        private String isQuaPending;
        private String nameDraft;
        private String quaDraft;
        private String quaPhotosDraft;
        private String videoProfile;
        private String webcallPrice;
        private String canShare;
        private String shareTitle;
        private String shareContent;
        private int age;
        private String continuedPercent;
        private String timelyPercent;
        private String giftNum;

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getQjCode() {
            return qjCode;
        }

        public void setQjCode(String qjCode) {
            this.qjCode = qjCode;
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

        public String getSlogan() {
            return slogan;
        }

        public void setSlogan(String slogan) {
            this.slogan = slogan;
        }

        public String getAudio() {
            return audio;
        }

        public void setAudio(String audio) {
            this.audio = audio;
        }

        public String getAudioLength() {
            return audioLength;
        }

        public void setAudioLength(String audioLength) {
            this.audioLength = audioLength;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getDob() {
            return dob;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

        public String getConstellation() {
            return constellation;
        }

        public void setConstellation(String constellation) {
            this.constellation = constellation;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getEmotion() {
            return emotion;
        }

        public void setEmotion(String emotion) {
            this.emotion = emotion;
        }

        public String getOccupation() {
            return occupation;
        }

        public void setOccupation(String occupation) {
            this.occupation = occupation;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getHobby() {
            return hobby;
        }

        public void setHobby(String hobby) {
            this.hobby = hobby;
        }

        public String getLike() {
            return like;
        }

        public void setLike(String like) {
            this.like = like;
        }

        public String getHate() {
            return hate;
        }

        public void setHate(String hate) {
            this.hate = hate;
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

        public String getIsFollowed() {
            return isFollowed;
        }

        public void setIsFollowed(String isFollowed) {
            this.isFollowed = isFollowed;
        }

        public String getIsInBlacklist() {
            return isInBlacklist;
        }

        public void setIsInBlacklist(String isInBlacklist) {
            this.isInBlacklist = isInBlacklist;
        }

        public String getGroupCnt() {
            return groupCnt;
        }

        public void setGroupCnt(String groupCnt) {
            this.groupCnt = groupCnt;
        }

        public String getCmtCnt() {
            return cmtCnt;
        }

        public void setCmtCnt(String cmtCnt) {
            this.cmtCnt = cmtCnt;
        }

        public String getIsAnchor() {
            return isAnchor;
        }

        public void setIsAnchor(String isAnchor) {
            this.isAnchor = isAnchor;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getLastLoginLatitude() {
            return lastLoginLatitude;
        }

        public void setLastLoginLatitude(String lastLoginLatitude) {
            this.lastLoginLatitude = lastLoginLatitude;
        }

        public String getLastLoginLongitude() {
            return lastLoginLongitude;
        }

        public void setLastLoginLongitude(String lastLoginLongitude) {
            this.lastLoginLongitude = lastLoginLongitude;
        }

        public int getLastLoginTime() {
            return lastLoginTime;
        }

        public void setLastLoginTime(int lastLoginTime) {
            this.lastLoginTime = lastLoginTime;
        }

        public String getIsConsultant() {
            return isConsultant;
        }

        public void setIsConsultant(String isConsultant) {
            this.isConsultant = isConsultant;
        }

        public String getCatgs() {
            return catgs;
        }

        public void setCatgs(String catgs) {
            this.catgs = catgs;
        }

        public String getHonor() {
            return honor;
        }

        public void setHonor(String honor) {
            this.honor = honor;
        }

        public String getResume() {
            return resume;
        }

        public void setResume(String resume) {
            this.resume = resume;
        }

        public String getQualification() {
            return qualification;
        }

        public void setQualification(String qualification) {
            this.qualification = qualification;
        }

        public String getQualificationPhotos() {
            return qualificationPhotos;
        }

        public void setQualificationPhotos(String qualificationPhotos) {
            this.qualificationPhotos = qualificationPhotos;
        }

        public String getFee() {
            return fee;
        }

        public void setFee(String fee) {
            this.fee = fee;
        }

        public int getReserveFee() {
            return reserveFee;
        }

        public void setReserveFee(int reserveFee) {
            this.reserveFee = reserveFee;
        }

        public String getClinicName() {
            return clinicName;
        }

        public void setClinicName(String clinicName) {
            this.clinicName = clinicName;
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

        public String getIsNamePending() {
            return isNamePending;
        }

        public void setIsNamePending(String isNamePending) {
            this.isNamePending = isNamePending;
        }

        public String getIsQuaPending() {
            return isQuaPending;
        }

        public void setIsQuaPending(String isQuaPending) {
            this.isQuaPending = isQuaPending;
        }

        public String getNameDraft() {
            return nameDraft;
        }

        public void setNameDraft(String nameDraft) {
            this.nameDraft = nameDraft;
        }

        public String getQuaDraft() {
            return quaDraft;
        }

        public void setQuaDraft(String quaDraft) {
            this.quaDraft = quaDraft;
        }

        public String getQuaPhotosDraft() {
            return quaPhotosDraft;
        }

        public void setQuaPhotosDraft(String quaPhotosDraft) {
            this.quaPhotosDraft = quaPhotosDraft;
        }

        public String getVideoProfile() {
            return videoProfile;
        }

        public void setVideoProfile(String videoProfile) {
            this.videoProfile = videoProfile;
        }

        public String getWebcallPrice() {
            return webcallPrice;
        }

        public void setWebcallPrice(String webcallPrice) {
            this.webcallPrice = webcallPrice;
        }

        public String getCanShare() {
            return canShare;
        }

        public void setCanShare(String canShare) {
            this.canShare = canShare;
        }

        public String getShareTitle() {
            return shareTitle;
        }

        public void setShareTitle(String shareTitle) {
            this.shareTitle = shareTitle;
        }

        public String getShareContent() {
            return shareContent;
        }

        public void setShareContent(String shareContent) {
            this.shareContent = shareContent;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getContinuedPercent() {
            return continuedPercent;
        }

        public void setContinuedPercent(String continuedPercent) {
            this.continuedPercent = continuedPercent;
        }

        public String getTimelyPercent() {
            return timelyPercent;
        }

        public void setTimelyPercent(String timelyPercent) {
            this.timelyPercent = timelyPercent;
        }

        public String getGiftNum() {
            return giftNum;
        }

        public void setGiftNum(String giftNum) {
            this.giftNum = giftNum;
        }
    }
}
