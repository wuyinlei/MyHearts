package ruolan.com.myhearts.ui.main.fragment.advisory;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/10/24.
 */

public class UserDetailBean implements Serializable {

    /**
     * errorCode : 0
     * errorStr : success
     * resultCount : 61
     * score : 0
     * balance : 0
     * results : {"userid":"7542","qjCode":"","nickname":"曹华","avatar":"http://image.xinliji.me/FoWbgtZAIDMEYrGk0Nzz9VN8uP5v","slogan":"我 心   知 你 心 !\n\n愿陪您：走出心理阴霾，走进阳光心海\n\n          请 预约咨询  或  电话倾诉","audio":"http://audio.xinliji.me/caohua.mp3","audioLength":"","gender":"0","score":"861","dob":"1961-04-28","constellation":"1","height":"160","weight":"60","role":"0","emotion":"0","occupation":"","city":"通化","label":"","hobby":"","like":"","hate":"","likeCnt":"910","isLiked":"1","isFollowed":"1","isInBlacklist":"0","groupCnt":"0","cmtCnt":"70","isAnchor":"0","distance":"0","lastLoginLatitude":"41.705614","lastLoginLongitude":"125.941455","lastLoginTime":1477301235,"isConsultant":"1","catgs":"婚恋情感、青春成长、社交职场","honor":"国家二级心理咨询师","resume":"接待心理咨询个案来访万余人次   累计5000小时以上。实践经验丰富，积累了大量成功案例。\n      一、婚姻家庭\r 亲情关系\n1、婚姻家庭关系策略\n\r2、婚外情的对应策略。\n3、家庭暴力、冷暴力的对应策略。\r\n4、婚姻危机的对应策略。\r\n 5、离婚前的心理辅导及法律准备。\r\n 6、离婚心理安慰、情绪辅导、自信重塑\n 7、小三情结辅导及小三应对策略。  \r\n     二、恋爱技巧    情感分析\n     三、职场困扰    职业规划  \n     四、社交障碍    情绪困扰\n\r    五、感情纠葛    感情危机   \n     六、成长陪伴    人生指导\n     七、各异行为    接纳改变\n     八、亲子教育    家庭育子\n     九、大学生各类情况和情感的辅导。\r\n     十、法律咨询。","qualification":"国二","qualificationPhotos":"http://7xi9a5.com2.z0.glb.qiniucdn.com/o_19mcp0kog107f2b1hdi1p7t3s7i.jpg,http://7xi9a5.com2.z0.glb.qiniucdn.com/o_19qe718uv15mrd0l13nkucp10rvi.jpg","fee":"500","reserveFee":300,"clinicName":"阳光心晴 首席","address":"","lon":"","lat":"","isNamePending":"0","isQuaPending":"0","nameDraft":"曹华","quaDraft":"","quaPhotosDraft":"","videoProfile":"http://video.xinliji.me/cao_hua_video_480P","webcallPrice":"50","canShare":"1","shareTitle":"【我心】(心理记)注册咨询师","shareContent":"相约【我心】(心理记)，我是您的专属心理咨询师 曹华","age":55,"catgsRating":[{"key":"EMOTION_OTHER","label":"其他","rating":"2"},{"key":"GUPI","label":"孤僻","rating":"2"},{"key":"JIAOLV","label":"焦虑","rating":"12"},{"key":"JIATINGBAOLI","label":"家庭暴力","rating":"2"},{"key":"LIANAI","label":"恋爱困惑","rating":"16"},{"key":"MOOD_OTHER","label":"其他","rating":"11"},{"key":"POXIGUANXI","label":"婆媳关系","rating":"1"},{"key":"PSYCHOLOGICAL_OTHER","label":"其他","rating":"3"},{"key":"RENJIGUANXI","label":"人际关系","rating":"1"},{"key":"RENSHENGGUIHUA","label":"人生规划","rating":"1"}],"topComment":{"id":"61986","objectId":"7542","objectType":"consultant","userid":"60873","name":"菁**","avatar":"http://icon.xinliji.me//avatar_0_110.png","replyToUserid":"","replyToUserName":"","replyToContent":"","content":"老师很耐心，谢谢老师。","createdDate":1470056963,"consultantTags":"自卑","rating":"5"},"topFmRadio":{"id":"20","subject":"走出婚恋的\u201c迷宫\u201d","content":"主讲老师：曹华","url":"http://7xi9a5.com2.z0.glb.qiniucdn.com/o_1al23qirc49e4ta1su51q3r42on.mp3","icon":"http://7xi9a5.com2.z0.glb.qiniucdn.com/o_1al23q0p5pon3fl6d316f01atri.png","datetime":1465728735},"continuedPercent":"63.77","timelyPercent":"60.00","giftNum":"445"}
     */

    private int errorCode;
    private String errorStr;
    private int resultCount;
    private int score;
    private int balance;
    /**
     * userid : 7542
     * qjCode :
     * nickname : 曹华
     * avatar : http://image.xinliji.me/FoWbgtZAIDMEYrGk0Nzz9VN8uP5v
     * slogan : 我 心   知 你 心 !

     愿陪您：走出心理阴霾，走进阳光心海

     请 预约咨询  或  电话倾诉
     * audio : http://audio.xinliji.me/caohua.mp3
     * audioLength :
     * gender : 0
     * score : 861
     * dob : 1961-04-28
     * constellation : 1
     * height : 160
     * weight : 60
     * role : 0
     * emotion : 0
     * occupation :
     * city : 通化
     * label :
     * hobby :
     * like :
     * hate :
     * likeCnt : 910
     * isLiked : 1
     * isFollowed : 1
     * isInBlacklist : 0
     * groupCnt : 0
     * cmtCnt : 70
     * isAnchor : 0
     * distance : 0
     * lastLoginLatitude : 41.705614
     * lastLoginLongitude : 125.941455
     * lastLoginTime : 1477301235
     * isConsultant : 1
     * catgs : 婚恋情感、青春成长、社交职场
     * honor : 国家二级心理咨询师
     * resume : 接待心理咨询个案来访万余人次   累计5000小时以上。实践经验丰富，积累了大量成功案例。
     一、婚姻家庭 亲情关系
     1、婚姻家庭关系策略
     2、婚外情的对应策略。
     3、家庭暴力、冷暴力的对应策略。
     4、婚姻危机的对应策略。
     5、离婚前的心理辅导及法律准备。
     6、离婚心理安慰、情绪辅导、自信重塑
     7、小三情结辅导及小三应对策略。
     二、恋爱技巧    情感分析
     三、职场困扰    职业规划
     四、社交障碍    情绪困扰
     五、感情纠葛    感情危机
     六、成长陪伴    人生指导
     七、各异行为    接纳改变
     八、亲子教育    家庭育子
     九、大学生各类情况和情感的辅导。
     十、法律咨询。
     * qualification : 国二
     * qualificationPhotos : http://7xi9a5.com2.z0.glb.qiniucdn.com/o_19mcp0kog107f2b1hdi1p7t3s7i.jpg,http://7xi9a5.com2.z0.glb.qiniucdn.com/o_19qe718uv15mrd0l13nkucp10rvi.jpg
     * fee : 500
     * reserveFee : 300
     * clinicName : 阳光心晴 首席
     * address :
     * lon :
     * lat :
     * isNamePending : 0
     * isQuaPending : 0
     * nameDraft : 曹华
     * quaDraft :
     * quaPhotosDraft :
     * videoProfile : http://video.xinliji.me/cao_hua_video_480P
     * webcallPrice : 50
     * canShare : 1
     * shareTitle : 【我心】(心理记)注册咨询师
     * shareContent : 相约【我心】(心理记)，我是您的专属心理咨询师 曹华
     * age : 55
     * catgsRating : [{"key":"EMOTION_OTHER","label":"其他","rating":"2"},{"key":"GUPI","label":"孤僻","rating":"2"},{"key":"JIAOLV","label":"焦虑","rating":"12"},{"key":"JIATINGBAOLI","label":"家庭暴力","rating":"2"},{"key":"LIANAI","label":"恋爱困惑","rating":"16"},{"key":"MOOD_OTHER","label":"其他","rating":"11"},{"key":"POXIGUANXI","label":"婆媳关系","rating":"1"},{"key":"PSYCHOLOGICAL_OTHER","label":"其他","rating":"3"},{"key":"RENJIGUANXI","label":"人际关系","rating":"1"},{"key":"RENSHENGGUIHUA","label":"人生规划","rating":"1"}]
     * topComment : {"id":"61986","objectId":"7542","objectType":"consultant","userid":"60873","name":"菁**","avatar":"http://icon.xinliji.me//avatar_0_110.png","replyToUserid":"","replyToUserName":"","replyToContent":"","content":"老师很耐心，谢谢老师。","createdDate":1470056963,"consultantTags":"自卑","rating":"5"}
     * topFmRadio : {"id":"20","subject":"走出婚恋的\u201c迷宫\u201d","content":"主讲老师：曹华","url":"http://7xi9a5.com2.z0.glb.qiniucdn.com/o_1al23qirc49e4ta1su51q3r42on.mp3","icon":"http://7xi9a5.com2.z0.glb.qiniucdn.com/o_1al23q0p5pon3fl6d316f01atri.png","datetime":1465728735}
     * continuedPercent : 63.77
     * timelyPercent : 60.00
     * giftNum : 445
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
        /**
         * id : 61986
         * objectId : 7542
         * objectType : consultant
         * userid : 60873
         * name : 菁**
         * avatar : http://icon.xinliji.me//avatar_0_110.png
         * replyToUserid :
         * replyToUserName :
         * replyToContent :
         * content : 老师很耐心，谢谢老师。
         * createdDate : 1470056963
         * consultantTags : 自卑
         * rating : 5
         */

        private TopCommentBean topComment;
        /**
         * id : 20
         * subject : 走出婚恋的“迷宫”
         * content : 主讲老师：曹华
         * url : http://7xi9a5.com2.z0.glb.qiniucdn.com/o_1al23qirc49e4ta1su51q3r42on.mp3
         * icon : http://7xi9a5.com2.z0.glb.qiniucdn.com/o_1al23q0p5pon3fl6d316f01atri.png
         * datetime : 1465728735
         */

        private TopFmRadioBean topFmRadio;
        private String continuedPercent;
        private String timelyPercent;
        private String giftNum;
        /**
         * key : EMOTION_OTHER
         * label : 其他
         * rating : 2
         */

        private List<CatgsRatingBean> catgsRating;

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

        public TopCommentBean getTopComment() {
            return topComment;
        }

        public void setTopComment(TopCommentBean topComment) {
            this.topComment = topComment;
        }

        public TopFmRadioBean getTopFmRadio() {
            return topFmRadio;
        }

        public void setTopFmRadio(TopFmRadioBean topFmRadio) {
            this.topFmRadio = topFmRadio;
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

        public List<CatgsRatingBean> getCatgsRating() {
            return catgsRating;
        }

        public void setCatgsRating(List<CatgsRatingBean> catgsRating) {
            this.catgsRating = catgsRating;
        }

        public static class TopCommentBean {
            private String id;
            private String objectId;
            private String objectType;
            private String userid;
            private String name;
            private String avatar;
            private String replyToUserid;
            private String replyToUserName;
            private String replyToContent;
            private String content;
            private int createdDate;
            private String consultantTags;
            private String rating;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getObjectId() {
                return objectId;
            }

            public void setObjectId(String objectId) {
                this.objectId = objectId;
            }

            public String getObjectType() {
                return objectType;
            }

            public void setObjectType(String objectType) {
                this.objectType = objectType;
            }

            public String getUserid() {
                return userid;
            }

            public void setUserid(String userid) {
                this.userid = userid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getReplyToUserid() {
                return replyToUserid;
            }

            public void setReplyToUserid(String replyToUserid) {
                this.replyToUserid = replyToUserid;
            }

            public String getReplyToUserName() {
                return replyToUserName;
            }

            public void setReplyToUserName(String replyToUserName) {
                this.replyToUserName = replyToUserName;
            }

            public String getReplyToContent() {
                return replyToContent;
            }

            public void setReplyToContent(String replyToContent) {
                this.replyToContent = replyToContent;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getCreatedDate() {
                return createdDate;
            }

            public void setCreatedDate(int createdDate) {
                this.createdDate = createdDate;
            }

            public String getConsultantTags() {
                return consultantTags;
            }

            public void setConsultantTags(String consultantTags) {
                this.consultantTags = consultantTags;
            }

            public String getRating() {
                return rating;
            }

            public void setRating(String rating) {
                this.rating = rating;
            }
        }

        public static class TopFmRadioBean {
            private String id;
            private String subject;
            private String content;
            private String url;
            private String icon;
            private int datetime;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getSubject() {
                return subject;
            }

            public void setSubject(String subject) {
                this.subject = subject;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public int getDatetime() {
                return datetime;
            }

            public void setDatetime(int datetime) {
                this.datetime = datetime;
            }
        }

        public static class CatgsRatingBean {
            private String key;
            private String label;
            private String rating;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getRating() {
                return rating;
            }

            public void setRating(String rating) {
                this.rating = rating;
            }
        }
    }
}
