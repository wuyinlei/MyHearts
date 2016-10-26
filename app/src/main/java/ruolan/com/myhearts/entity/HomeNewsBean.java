package ruolan.com.myhearts.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/10/21.
 */

public class HomeNewsBean implements Serializable {

    /**
     * errorCode : 0
     * errorStr : success
     * resultCount : 10
     * score : 0
     * balance : 0
     * results : [{"id":"17","icon":"http://7xi9a5.com2.z0.glb.qiniucdn.com/o_19jm13uhm1os2bq8edr1rdp1lf5i.jpg","title":"心理师没找到什么解决我问题的好方法","subtitle":"那个心理师好像没找到什么解决我问题的好方法","catg":"心理扫盲","viewCnt":"2090","isLiked":"0","likeCnt":"20","commentCnt":"19","createdDate":1429890056},{"id":"19","icon":"http://7xi9a5.com2.z0.glb.qiniucdn.com/o_19jn60pj91en51k8e193f16ug82bi.jpg","title":"什么情况下需要做心理咨询","subtitle":"什么情况下需要做心理咨询","catg":"心理扫盲","viewCnt":"3518","isLiked":"0","likeCnt":"27","commentCnt":"30","createdDate":1429895086},{"id":"20","icon":"http://7xi9a5.com2.z0.glb.qiniucdn.com/o_19jng4ifd1pi5hqlqid5942lni.jpg","title":"什么是心理健康？","subtitle":"什么是心理健康？","catg":"心理扫盲","viewCnt":"2132","isLiked":"0","likeCnt":"13","commentCnt":"7","createdDate":1429938989},{"id":"21","icon":"http://7xi9a5.com2.z0.glb.qiniucdn.com/o_19jngbr09a8gd371ecd17bd1r2fa.jpg","title":"我的心理没问题，没到什么严重地步，我需要心理咨询吗？","subtitle":"我的心理没问题，没到什么严重地步，我需要心理咨询吗？","catg":"心理扫盲","viewCnt":"1352","isLiked":"0","likeCnt":"7","commentCnt":"2","createdDate":1429939375},{"id":"22","icon":"http://7xi9a5.com2.z0.glb.qiniucdn.com/o_19jngirgi1rtrrmj1m8b1ad4fkra.jpg","title":"我想找心理咨询师，可是我有很多顾虑","subtitle":"我想找心理咨询师，可是我有很多顾虑","catg":"心理扫盲","viewCnt":"1665","isLiked":"0","likeCnt":"8","commentCnt":"2","createdDate":1429939520},{"id":"23","icon":"http://7xi9a5.com2.z0.glb.qiniucdn.com/o_19jngn1vtkqk1mg6qc0147q2n0a.jpg","title":"我自学心理学，能解决自己的心理问题吗？","subtitle":"我自学心理学，能解决自己的心理问题吗？","catg":"心理扫盲","viewCnt":"2456","isLiked":"0","likeCnt":"11","commentCnt":"6","createdDate":1429939626},{"id":"24","icon":"http://7xi9a5.com2.z0.glb.qiniucdn.com/o_19jngsk331bh4ajc1sigk3o1r57i.jpg","title":"心理咨询基本原则","subtitle":"心理咨询基本原则","catg":"心理扫盲","viewCnt":"1413","isLiked":"0","likeCnt":"10","commentCnt":"1","createdDate":1429939871},{"id":"25","icon":"http://7xi9a5.com2.z0.glb.qiniucdn.com/o_19jnh42cjn40d051kco1t0c199ua.jpg","title":"心理咨询和普通聊天的区别","subtitle":"心理咨询和普通聊天的区别","catg":"心理扫盲","viewCnt":"1438","isLiked":"0","likeCnt":"8","commentCnt":"5","createdDate":1429940047},{"id":"26","icon":"http://7xi9a5.com2.z0.glb.qiniucdn.com/o_19jnh7esij659h515o5j541s03a.jpg","title":"心理咨询师会把我的秘密说出去吗？","subtitle":"心理咨询师会把我的秘密说出去吗？","catg":"心理扫盲","viewCnt":"855","isLiked":"0","likeCnt":"8","commentCnt":"4","createdDate":1429940166},{"id":"27","icon":"http://7xi9a5.com2.z0.glb.qiniucdn.com/o_19jnhfiqd1d3e1dss18pea119u3a.jpg","title":"心理咨询为什么这么贵？","subtitle":"心理咨询为什么这么贵？","catg":"心理扫盲","viewCnt":"1999","isLiked":"0","likeCnt":"16","commentCnt":"17","createdDate":1429940606}]
     */

    private int errorCode;
    private String errorStr;
    private int resultCount;
    private int score;
    private int balance;
    /**
     * id : 17
     * icon : http://7xi9a5.com2.z0.glb.qiniucdn.com/o_19jm13uhm1os2bq8edr1rdp1lf5i.jpg
     * title : 心理师没找到什么解决我问题的好方法
     * subtitle : 那个心理师好像没找到什么解决我问题的好方法
     * catg : 心理扫盲
     * viewCnt : 2090
     * isLiked : 0
     * likeCnt : 20
     * commentCnt : 19
     * createdDate : 1429890056
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
        private String icon;
        private String title;
        private String subtitle;
        private String catg;
        private String viewCnt;
        private String isLiked;
        private String likeCnt;
        private String commentCnt;
        private int createdDate;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getCatg() {
            return catg;
        }

        public void setCatg(String catg) {
            this.catg = catg;
        }

        public String getViewCnt() {
            return viewCnt;
        }

        public void setViewCnt(String viewCnt) {
            this.viewCnt = viewCnt;
        }

        public String getIsLiked() {
            return isLiked;
        }

        public void setIsLiked(String isLiked) {
            this.isLiked = isLiked;
        }

        public String getLikeCnt() {
            return likeCnt;
        }

        public void setLikeCnt(String likeCnt) {
            this.likeCnt = likeCnt;
        }

        public String getCommentCnt() {
            return commentCnt;
        }

        public void setCommentCnt(String commentCnt) {
            this.commentCnt = commentCnt;
        }

        public int getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(int createdDate) {
            this.createdDate = createdDate;
        }
    }
}
