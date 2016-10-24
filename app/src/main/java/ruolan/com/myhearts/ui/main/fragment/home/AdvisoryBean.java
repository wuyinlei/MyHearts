package ruolan.com.myhearts.ui.main.fragment.home;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/10/20.
 */

public class AdvisoryBean implements Serializable {

    /**
     * errorCode : 0
     * errorStr : success
     * resultCount : 4
     * score : 0
     * balance : 0
     * results : [{"userid":"58986","nickname":"罗振华","avatar":"http://image.xinliji.me/o_1av89demb12nm3pc1cp213plvjsq.jpg","title":"情感婚恋咨询师","qualification":"国二"},{"userid":"28283","nickname":"周戴贤","avatar":"http://image.xinliji.me/o_1av8c4qk0k0j1hjf1uh6nao1doga.png","title":"家庭关系咨询师","qualification":"国二"},{"userid":"87538","nickname":"曹萍","avatar":"http://image.xinliji.me/o_1av89gdgp1unq1ff4uriqpp4721k.png","title":"个人成长咨询师","qualification":"国二"},{"userid":"88124","nickname":"陈琳","avatar":"http://image.xinliji.me/o_1av89h6m011d0gvr1v4s13181d8t21.png","title":"两性关系咨询师","qualification":"国二"}]
     */

    private int errorCode;
    private String errorStr;
    private int resultCount;
    private int score;
    private int balance;
    /**
     * userid : 58986
     * nickname : 罗振华
     * avatar : http://image.xinliji.me/o_1av89demb12nm3pc1cp213plvjsq.jpg
     * title : 情感婚恋咨询师
     * qualification : 国二
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
        private String title;
        private String qualification;

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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getQualification() {
            return qualification;
        }

        public void setQualification(String qualification) {
            this.qualification = qualification;
        }
    }
}
