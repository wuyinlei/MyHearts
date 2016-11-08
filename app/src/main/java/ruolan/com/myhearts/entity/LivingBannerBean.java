package ruolan.com.myhearts.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/11/8.
 */

public class LivingBannerBean implements Serializable {


    /**
     * errorCode : 0
     * errorStr : success
     * resultCount : 1
     * score : 0
     * balance : 0
     * results : [{"id":"96","icon":"http://image.xinliji.me/o_1b0njprap7h9jli11671ksm4nri.png","pic":"http://image.xinliji.me/o_1b0njq7l6abliv2hqgcjofpn.png","title":"我该如何面对你，真实的自己","subtitle":"11月9日（周三）20：00","type":"webview","url":"http://mp.weixin.qq.com/s?__biz=MzA3NDI3MDQ2OQ==&mid=508458765&idx=1&sn=a6850585bffc09a5165eac36b9e6e224&chksm=04b8856733cf0c718e762a46dfa7bdf37584c42e40104690e25e7f3378db265e934ea55db92a&mpshare=1&scene=1&srcid=1104AmRR54CpNoj1jw6dX283#wechat_redirect&token=","target":"","className":""}]
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
         * id : 96
         * icon : http://image.xinliji.me/o_1b0njprap7h9jli11671ksm4nri.png
         * pic : http://image.xinliji.me/o_1b0njq7l6abliv2hqgcjofpn.png
         * title : 我该如何面对你，真实的自己
         * subtitle : 11月9日（周三）20：00
         * type : webview
         * url : http://mp.weixin.qq.com/s?__biz=MzA3NDI3MDQ2OQ==&mid=508458765&idx=1&sn=a6850585bffc09a5165eac36b9e6e224&chksm=04b8856733cf0c718e762a46dfa7bdf37584c42e40104690e25e7f3378db265e934ea55db92a&mpshare=1&scene=1&srcid=1104AmRR54CpNoj1jw6dX283#wechat_redirect&token=
         * target :
         * className :
         */

        private String id;
        private String icon;
        private String pic;
        private String title;
        private String subtitle;
        private String type;
        private String url;
        private String target;
        private String className;

        public void setId(String id) {
            this.id = id;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public String getId() {
            return id;
        }

        public String getIcon() {
            return icon;
        }

        public String getPic() {
            return pic;
        }

        public String getTitle() {
            return title;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public String getType() {
            return type;
        }

        public String getUrl() {
            return url;
        }

        public String getTarget() {
            return target;
        }

        public String getClassName() {
            return className;
        }
    }
}
