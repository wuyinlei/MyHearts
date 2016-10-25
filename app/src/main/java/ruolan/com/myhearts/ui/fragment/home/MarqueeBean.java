package ruolan.com.myhearts.ui.fragment.home;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/10/20.
 */

public class MarqueeBean implements Serializable{


    /**
     * errorCode : 0
     * errorStr : success
     * resultCount : 10
     * score : 0
     * balance : 0
     * results : [{"label":"用户 邹** 支付￥200 预约了咨询师 聂开银"},{"label":"用户 溯** 支付￥200 预约了咨询师 李向韬"},{"label":"用户 彪** 支付￥200 预约了咨询师 李向韬"},{"label":"用户 钧** 支付￥300 预约了咨询师 曹华"},{"label":"用户 十** 支付￥1500 预约了咨询师 曹华"},{"label":"用户 玉** 购买咨询师 杨振军 电话倾诉25分钟"},{"label":"用户 萍** 购买咨询师 曹华 电话倾诉25分钟"},{"label":"用户 萍** 购买咨询师 乔瑞峰 电话倾诉25分钟"},{"label":"用户 聪** 购买咨询师 曹华 电话倾诉25分钟"},{"label":"用户 娴** 购买咨询师 乔瑞峰 电话倾诉25分钟"}]
     */

    private int errorCode;
    private String errorStr;
    private int resultCount;
    private int score;
    private int balance;
    /**
     * label : 用户 邹** 支付￥200 预约了咨询师 聂开银
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
        private String label;

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }
    }
}
