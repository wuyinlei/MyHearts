package ruolan.com.myhearts.activity.main.fragment.advisory;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/10/21.
 */

public class AdvisoryBannerBean implements Serializable {

    /**
     * errorCode : 0
     * errorStr : success
     * resultCount : 4
     * score : 0
     * balance : 0
     * results : [{"id":"20","icon":"http://image.xinliji.me/http://7xi9a5.com2.z0.glb.qiniucdn.com/o_1a4v3olibq2seo11f93bdj1i7ii.png","pic":"http://image.xinliji.me/o_1av857mhb153bcpe1ekp4eihsin.jpg","title":"推荐咨询师No.1","subtitle":"推荐咨询师No.1","type":"appview_v2","url":"&token=","target":"","className":"counselor.ui.CounselorDetailActivity","params":[{"key":"counselorid","value":"58986"}]},{"id":"40","icon":"http://image.xinliji.me/http://7xi9a5.com2.z0.glb.qiniucdn.com/o_1a8d09m1pivt1r192njpr210cdi.png","pic":"http://image.xinliji.me/o_1av897j9grrl1s7g131m12vb11sdi.png","title":"推荐咨询师No.2","subtitle":"推荐咨询师No.2","type":"appview_v2","url":"&token=","target":"","className":"counselor.ui.CounselorDetailActivity","params":[{"key":"counselorid","value":"28283"}]},{"id":"49","icon":"http://image.xinliji.me/http://7xi9a5.com2.z0.glb.qiniucdn.com/o_1ag9mocv8aue9q51idi19tmkgvn.jpg","pic":"http://image.xinliji.me/o_1av899ps414li1tk72t1me812jmi.png","title":"推荐咨询师No.3","subtitle":"推荐咨询师No.3","type":"appview_v2","url":"&token=","target":"","className":"counselor.ui.CounselorDetailActivity","params":[{"key":"counselorid","value":"87538"}]},{"id":"50","icon":"http://image.xinliji.me/http://7xi9a5.com2.z0.glb.qiniucdn.com/o_1ag9mpftn1ds91h081p2rvbmqs7i.jpg","pic":"http://image.xinliji.me/o_1av89ruin10ni1i3l12lp1bohiv6i.png","title":"推荐咨询师No.4","subtitle":"推荐咨询师No.4","type":"appview_v2","url":"&token=","target":"","className":"counselor.ui.CounselorDetailActivity","params":[{"key":"counselor.ui.CounselorDetailActivity","value":""},{"key":"counselorid","value":"88124"}]}]
     */

    private int errorCode;
    private String errorStr;
    private int resultCount;
    private int score;
    private int balance;
    /**
     * id : 20
     * icon : http://image.xinliji.me/http://7xi9a5.com2.z0.glb.qiniucdn.com/o_1a4v3olibq2seo11f93bdj1i7ii.png
     * pic : http://image.xinliji.me/o_1av857mhb153bcpe1ekp4eihsin.jpg
     * title : 推荐咨询师No.1
     * subtitle : 推荐咨询师No.1
     * type : appview_v2
     * url : &token=
     * target :
     * className : counselor.ui.CounselorDetailActivity
     * params : [{"key":"counselorid","value":"58986"}]
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
        private String pic;
        private String title;
        private String subtitle;
        private String type;
        private String url;
        private String target;
        private String className;
        /**
         * key : counselorid
         * value : 58986
         */

        private List<ParamsBean> params;

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

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public List<ParamsBean> getParams() {
            return params;
        }

        public void setParams(List<ParamsBean> params) {
            this.params = params;
        }

        public static class ParamsBean {
            private String key;
            private String value;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }
    }
}
