package ruolan.com.myhearts.activity.main.fragment.home;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/10/20.
 */

public class HomeBannerOne implements Serializable {

    /**
     * errorCode : 0
     * errorStr : success
     * resultCount : 3
     * score : 0
     * balance : 0
     * results : {"id":"1480","banner":"http://image.xinliji.me/o_1avee70m4m4covv1ifd1su56l114.png","state":"N"}
     */

    private int errorCode;
    private String errorStr;
    private int resultCount;
    private int score;
    private int balance;
    /**
     * id : 1480
     * banner : http://image.xinliji.me/o_1avee70m4m4covv1ifd1su56l114.png
     * state : N
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
        private String banner;
        private String state;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getBanner() {
            return banner;
        }

        public void setBanner(String banner) {
            this.banner = banner;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }
}
