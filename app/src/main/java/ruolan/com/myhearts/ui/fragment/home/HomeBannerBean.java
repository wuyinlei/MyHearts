package ruolan.com.myhearts.ui.fragment.home;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/10/20.
 */

public class HomeBannerBean implements Serializable{


    /**
     * errorCode : 0
     * errorStr : success
     * resultCount : 4
     * score : 0
     * balance : 0
     * results : [{"id":"90","icon":"http://image.xinliji.me/o_1av86bbtq1jh6trjh4f1c2ermei.png","pic":"http://image.xinliji.me/o_1av86btse18mu1kgtoq4u851fv2s.png","title":"用绘画了解TA的内心世界","subtitle":"主讲老师：蒋鹏","type":"webview","url":"http://mp.weixin.qq.com/s?__biz=MzIzMTI2Mzc1Mg==&mid=502311825&idx=1&sn=936c21f3fca8d60c65553e796689cbed&chksm=70a2d0f647d559e001e1321330df8b585746c3b979d7860af0401e0e24e461ce94adffbd952e&scene=0#wechat_redirect&token=","target":"","className":""},{"id":"3","icon":"http://7xi9a5.com2.z0.glb.qiniucdn.com/o_1ah420gu616203gr16rtcn8t9i.jpg","pic":"http://7xi9a5.com2.z0.glb.qiniucdn.com/o_1ah42384n1j5f1mb09ft1f438pb1k.jpg","title":"咨询师免费入驻","subtitle":"咨询师免费入驻","type":"webview","url":"http://console.xinliji.me/consultant/applyViaMobile?id=1&token=","target":"","className":""},{"id":"87","icon":"http://image.xinliji.me/o_1atu2a0b53491p7i132u13n4a98i.jpg","pic":"http://image.xinliji.me/o_1aus4lqdv1nacqpifmc1o95csqv.png","title":"做问卷，送好礼","subtitle":"萌萌哒【我心】抱枕免费送","type":"webview","url":"http://s.a.mvote.cn/survey/fd923cfb-81d0-e49f-ceff-672b4b549a5c.html?id=0&token=","target":"","className":""},{"id":"77","icon":"http://image.xinliji.me/o_1av83e1ujpskrv11d9dhgtg2ei.png","pic":"http://image.xinliji.me/o_1av8aj4741jvd1b4skl9c49pssi.png","title":"创新能力测试！看你是否具备改变世界的潜质","subtitle":"创新能力测试！看你是否具备改变世界的潜质","type":"appview_v2","url":"&token=","target":"","className":"psychology.ui.PsychTestDetailsActivity","params":[{"key":"id","value":"392"}]}]
     */

    private int errorCode;
    private String errorStr;
    private int resultCount;
    private int score;
    private int balance;
    /**
     * id : 90
     * icon : http://image.xinliji.me/o_1av86bbtq1jh6trjh4f1c2ermei.png
     * pic : http://image.xinliji.me/o_1av86btse18mu1kgtoq4u851fv2s.png
     * title : 用绘画了解TA的内心世界
     * subtitle : 主讲老师：蒋鹏
     * type : webview
     * url : http://mp.weixin.qq.com/s?__biz=MzIzMTI2Mzc1Mg==&mid=502311825&idx=1&sn=936c21f3fca8d60c65553e796689cbed&chksm=70a2d0f647d559e001e1321330df8b585746c3b979d7860af0401e0e24e461ce94adffbd952e&scene=0#wechat_redirect&token=
     * target :
     * className :
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
    }
}
