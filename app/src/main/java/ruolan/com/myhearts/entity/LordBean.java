package ruolan.com.myhearts.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/10/21.
 */

public class LordBean {


    /**
     * errorCode : 0
     * errorStr : success
     * resultCount : 6
     * score : 0
     * balance : 0
     * results : [{"id":"1","label":"情绪困扰","icon":"http://7xi9sc.com2.z0.glb.qiniucdn.com/group_catg_worry.png"},{"id":"2","label":"亲子教育","icon":"http://7xi9sc.com2.z0.glb.qiniucdn.com/group_catg_parenting.png"},{"id":"4","label":"青春成长","icon":"http://7xi9sc.com2.z0.glb.qiniucdn.com/group_catg_grow.png"},{"id":"5","label":"婚恋情感","icon":"http://7xi9sc.com2.z0.glb.qiniucdn.com/group_catg_love.png"},{"id":"0","label":"职场社交","icon":"http://7xi9sc.com2.z0.glb.qiniucdn.com/group_catg_business.png"},{"id":"3","label":"心理障碍","icon":"http://7xi9sc.com2.z0.glb.qiniucdn.com/group_catg_obstacle.png"}]
     */

    private int errorCode;
    private String errorStr;
    private int resultCount;
    private int score;
    private int balance;
    /**
     * id : 1
     * label : 情绪困扰
     * icon : http://7xi9sc.com2.z0.glb.qiniucdn.com/group_catg_worry.png
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
        private String label;
        private String icon;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
}
