package ruolan.com.myhearts.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/11/7.
 */

public class CircleFriendsCommentBean implements Serializable {


    /**
     * errorCode : 0
     * errorStr : success
     * resultCount : 3
     * score : 0
     * balance : 0
     * results : [{"id":"85321","objectId":"27051","objectType":"user_event","isAnon":"0","userid":"87135","name":"金新新","avatar":"http://image.xinliji.me/FmLElAFDsaTsvm30k4U_oaTtEtqv","isConsultant":"1","isLiked":"0","likeCnt":"0","isAnonReplyToUser":"","replyToUserid":"","replyToUserName":"","replyToContent":"","content":"因为人生并不是为了一个结果呀。我们都不知道自己要去哪里，注重在这条路上学到了什么，而不是最终会怎么样。","createdDate":1478510988},{"id":"85316","objectId":"27051","objectType":"user_event","isAnon":"0","userid":"114455","name":"spoiler","avatar":"http://q.qlogo.cn/qqapp/1104104412/290C71EE807D93DB379888805E9E1A83/100","isConsultant":"0","isLiked":"0","likeCnt":"0","isAnonReplyToUser":"","replyToUserid":"","replyToUserName":"","replyToContent":"","content":"同感","createdDate":1478509748},{"id":"85304","objectId":"27051","objectType":"user_event","isAnon":"0","userid":"27838","name":"海洋","avatar":"http://image.xinliji.me//o_19t9nt30111gv1c1o1apv4pd1rmei.jpg","isConsultant":"1","isLiked":"0","likeCnt":"0","isAnonReplyToUser":"","replyToUserid":"","replyToUserName":"","replyToContent":"","content":"嘴巴笨等都是你对自己的自我否定，可能事实并非如此。自我否定多了，就容易生无可恋","createdDate":1478505067}]
     */

    private int errorCode;
    private String errorStr;
    private int resultCount;
    private int score;
    private int balance;
    private List<ResultsEntity> results;

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

    public void setResults(List<ResultsEntity> results) {
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

    public List<ResultsEntity> getResults() {
        return results;
    }

    public static class ResultsEntity {
        /**
         * id : 85321
         * objectId : 27051
         * objectType : user_event
         * isAnon : 0
         * userid : 87135
         * name : 金新新
         * avatar : http://image.xinliji.me/FmLElAFDsaTsvm30k4U_oaTtEtqv
         * isConsultant : 1
         * isLiked : 0
         * likeCnt : 0
         * isAnonReplyToUser :
         * replyToUserid :
         * replyToUserName :
         * replyToContent :
         * content : 因为人生并不是为了一个结果呀。我们都不知道自己要去哪里，注重在这条路上学到了什么，而不是最终会怎么样。
         * createdDate : 1478510988
         */

        private String id;
        private String objectId;
        private String objectType;
        private String isAnon;
        private String userid;
        private String name;
        private String avatar;
        private String isConsultant;
        private String isLiked;
        private String likeCnt;
        private String isAnonReplyToUser;
        private String replyToUserid;
        private String replyToUserName;
        private String replyToContent;
        private String content;
        private int createdDate;

        public void setId(String id) {
            this.id = id;
        }

        public void setObjectId(String objectId) {
            this.objectId = objectId;
        }

        public void setObjectType(String objectType) {
            this.objectType = objectType;
        }

        public void setIsAnon(String isAnon) {
            this.isAnon = isAnon;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public void setIsConsultant(String isConsultant) {
            this.isConsultant = isConsultant;
        }

        public void setIsLiked(String isLiked) {
            this.isLiked = isLiked;
        }

        public void setLikeCnt(String likeCnt) {
            this.likeCnt = likeCnt;
        }

        public void setIsAnonReplyToUser(String isAnonReplyToUser) {
            this.isAnonReplyToUser = isAnonReplyToUser;
        }

        public void setReplyToUserid(String replyToUserid) {
            this.replyToUserid = replyToUserid;
        }

        public void setReplyToUserName(String replyToUserName) {
            this.replyToUserName = replyToUserName;
        }

        public void setReplyToContent(String replyToContent) {
            this.replyToContent = replyToContent;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setCreatedDate(int createdDate) {
            this.createdDate = createdDate;
        }

        public String getId() {
            return id;
        }

        public String getObjectId() {
            return objectId;
        }

        public String getObjectType() {
            return objectType;
        }

        public String getIsAnon() {
            return isAnon;
        }

        public String getUserid() {
            return userid;
        }

        public String getName() {
            return name;
        }

        public String getAvatar() {
            return avatar;
        }

        public String getIsConsultant() {
            return isConsultant;
        }

        public String getIsLiked() {
            return isLiked;
        }

        public String getLikeCnt() {
            return likeCnt;
        }

        public String getIsAnonReplyToUser() {
            return isAnonReplyToUser;
        }

        public String getReplyToUserid() {
            return replyToUserid;
        }

        public String getReplyToUserName() {
            return replyToUserName;
        }

        public String getReplyToContent() {
            return replyToContent;
        }

        public String getContent() {
            return content;
        }

        public int getCreatedDate() {
            return createdDate;
        }
    }
}
