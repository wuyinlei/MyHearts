package ruolan.com.myhearts.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/10/28.
 */

public class NewTitleBean implements Serializable {

    /**
     * errorCode : 0
     * errorStr : success
     * resultCount : 10
     * score : 0
     * balance : 0
     * results : {"id":"169","icon":"http://image.xinliji.me/o_1at8f1jlu81gdhjh65uceq2tk.jpg","title":"写给女孩的一封信","subtitle":"写给女孩的一封信","catg":"人格成长","viewCnt":"1404","isLiked":"0","likeCnt":"28","commentCnt":"7","createdDate":1474532518}
     */

    private int errorCode;
    private String errorStr;
    private int resultCount;
    private int score;
    private int balance;
    /**
     * id : 169
     * icon : http://image.xinliji.me/o_1at8f1jlu81gdhjh65uceq2tk.jpg
     * title : 写给女孩的一封信
     * subtitle : 写给女孩的一封信
     * catg : 人格成长
     * viewCnt : 1404
     * isLiked : 0
     * likeCnt : 28
     * commentCnt : 7
     * createdDate : 1474532518
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
