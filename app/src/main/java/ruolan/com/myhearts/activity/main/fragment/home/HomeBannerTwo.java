package ruolan.com.myhearts.activity.main.fragment.home;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/10/20.
 */

public class HomeBannerTwo implements Serializable {

    /**
     * errorCode : 0
     * errorStr : success
     * resultCount : 4
     * score : 0
     * balance : 0
     * results : {"id":"495","title":"你算得上是一个优雅的人吗？","instro":"","image":"http://image.xinliji.me/o_1avamvfk41nrr704npka0d1ne7n.jpg"}
     */

    private int errorCode;
    private String errorStr;
    private int resultCount;
    private int score;
    private int balance;
    /**
     * id : 495
     * title : 你算得上是一个优雅的人吗？
     * instro :
     * image : http://image.xinliji.me/o_1avamvfk41nrr704npka0d1ne7n.jpg
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
        private String title;
        private String instro;
        private String image;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getInstro() {
            return instro;
        }

        public void setInstro(String instro) {
            this.instro = instro;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
