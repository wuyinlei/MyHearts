package ruolan.com.myhearts.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/11/10.
 */

public class NewsBean implements Serializable {


    /**
     * datas : [{"id":"35836923-a948-4f00-9285-581e358db6e1","listPicUrl":"http://121.42.174.82//upload/image/20161110/6361436915904216887763600.jpg","publishTime":"2016-11-10 10:07:12","summary":null,"title":"拍下特价苹果电脑拒发货：当当硬逼用户撤单","views":35},{"id":"dbadc394-783e-413d-be21-9b564befb5bb","listPicUrl":"http://121.42.174.82//upload/image/20161109/6361428169740677699518066.jpg","publishTime":"2016-11-09 09:48:22","summary":null,"title":"工商总局约谈电商：促销不得先涨价再打折","views":123},{"id":"3f84b835-f503-4d28-a4ad-98ee13eba820","listPicUrl":"http://121.42.174.82//upload/image/20161109/6361428107282022783739037.jpg","publishTime":"2016-11-09 09:38:43","summary":null,"title":"iPhone7/7P要出\u201c亮白版\u201d？","views":69},{"id":"93cd38e1-804f-4953-9175-4799c5bcd837","listPicUrl":"http://121.42.174.82//upload/image/20161107/6361410958916839117746851.jpg","publishTime":"2016-11-07 09:59:53","summary":null,"title":"董明珠的高调真的是口无遮拦？或许我们都想的太简单了...","views":256},{"id":"afcd5fde-b033-4dff-8123-57e1347d0edf","listPicUrl":"http://121.42.174.82//upload/image/20161104/6361384809718041583099025.jpg","publishTime":"2016-11-04 09:21:41","summary":null,"title":"普京要封杀windows","views":573},{"id":"6fa4aaf1-bee0-4541-9a8f-fff95dc2f182","listPicUrl":"http://121.42.174.82//upload/image/20161104/6361384730145148569836256.jpg","publishTime":"2016-11-04 09:08:25","summary":null,"title":"MOTO将是联想唯一的手机品牌","views":304},{"id":"1c4f0ae0-5219-4fc7-a2f1-9f572617152a","listPicUrl":"http://121.42.174.82//upload/image/20161103/6361376158216134156086092.jpg","publishTime":"2016-11-03 09:19:45","summary":null,"title":"英国公司卖空气到中国，600元/瓶","views":311},{"id":"26b02ece-867d-4139-96b3-4125f22711e2","listPicUrl":"http://121.42.174.82//upload/image/20161103/6361376134870380243897952.jpg","publishTime":"2016-11-03 09:15:53","summary":null,"title":"国产X86处理器来了","views":606},{"id":"13ad193f-36a2-4574-9331-e5a328c16e9a","listPicUrl":"http://121.42.174.82//upload/image/20161101/6361359000763426081468503.jpg","publishTime":"2016-11-01 09:40:11","summary":null,"title":"国内全面禁飞Note7","views":294},{"id":"51623ebf-f94f-47d3-a7a8-e3a7fc15f227","listPicUrl":"http://121.42.174.82//upload/image/20161101/6361358983903835038429286.jpg","publishTime":"2016-11-01 09:37:22","summary":null,"title":"索尼把自家这业务卖了","views":357},{"id":"216a338b-cd6d-4091-a4ab-3f951393f5c5","listPicUrl":"http://121.42.174.82//upload/image/20161101/6361358889639574839885374.jpg","publishTime":"2016-11-01 09:21:40","summary":null,"title":"魅族开演唱会的空隙发了一款新手机","views":242},{"id":"7ce69b63-7c53-4ba8-907c-e83178e445dc","listPicUrl":"http://121.42.174.82//upload/image/20161028/6361324401926176386594956.jpg","publishTime":"2016-10-28 09:33:43","summary":"据外媒报道，LG今天发布第三季度财报，显示当季实现营收13.2万亿韩元（约人民币782亿元），同比下滑5.7%；实现运营利润2832亿韩元（约人民币19.8亿元），同比下滑3.7%，环比下滑51.6%。","title":"这家著名手机厂商亏惨了！","views":450},{"id":"cb54bf84-1fdf-4fea-a528-22b6f0ed2d5b","listPicUrl":"http://121.42.174.82//upload/image/20161028/6361324379164937408626820.jpg","publishTime":"2016-10-28 09:29:55","summary":null,"title":"谁说诺基亚死了？！","views":650},{"id":"ccf458c0-c479-4383-9629-c7ad7e38767d","listPicUrl":"http://121.42.174.82//upload/image/20161028/6361324360378760002300704.jpg","publishTime":"2016-10-28 09:26:48","summary":"立独行的罗永浩一度除了乔布斯谁也不放在眼里，但是如今，老罗似乎逐渐变了，个性不再那么棱角分明，产品也不再那么闭门造车，都更愿意倾听外边的声音。","title":"雷军、罗永浩微博互抛媚眼","views":286},{"id":"f941f07b-1dc9-430b-b0f3-0c133b932c6f","listPicUrl":"http://121.42.174.82//upload/image/20161027/6361315704614029391455590.jpg","publishTime":"2016-10-27 09:26:23","summary":null,"title":"雷军、老罗旧照曝光","views":284},{"id":"89e3f63c-522c-459d-b353-eda90ed48a9c","listPicUrl":"http://121.42.174.82//upload/image/20161027/6361315673126072287492837.jpg","publishTime":"2016-10-27 09:18:55","summary":null,"title":"微信新增了两个实用功","views":889},{"id":"3d5fc2cd-2d83-431d-bc9e-f74202d1dbdb","listPicUrl":"http://121.42.174.82//upload/image/20161026/6361307126506160579559694.jpg","publishTime":"2016-10-26 09:34:29","summary":null,"title":"最畅销国产手机品牌出炉，是它","views":525},{"id":"7342d5db-5b06-4a42-89cd-4fd39413741f","listPicUrl":"http://121.42.174.82//upload/image/20161026/6361307085892879059386219.jpg","publishTime":"2016-10-26 09:27:42","summary":null,"title":"微软：我们把手机业务作死了","views":344},{"id":"997b40c3-91ea-4669-b122-ed7ca412eb47","listPicUrl":"http://121.42.174.82//upload/image/20161026/6361307053729870779761304.jpg","publishTime":"2016-10-26 09:22:21","summary":"iPhone的分享机制再次被利用，iCloud相册被黑产人员用于广告营销后，小编匆匆赶到白帽汇来一探究竟。","title":"iPhone相册出现广告？","views":194},{"id":"181f91fe-f3da-4991-a9b2-b07728c69edf","listPicUrl":"http://121.42.174.82//upload/image/20161025/6361298712847905415085222.jpg","publishTime":"2016-10-25 10:12:19","summary":"京时间10月24日消息，据外媒报道，三星电子今天宣布，对于将GalaxyNote7更换为S7的韩国用户，公司将为他们推出一项升级计划，等明年S8或Note8发布后升级到新一代手机。这个升级计划也同时证实，三星并不打算彻底放弃Note系列，明年还会推出新机型。","title":"Note系列没有终结？这个计划证实明年还有Note8","views":314}]
     * startIndex : 0
     * endIndex : 436
     * count : 437
     */

    private int startIndex;
    private int endIndex;
    private int count;
    private List<DatasEntity> datas;

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setDatas(List<DatasEntity> datas) {
        this.datas = datas;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public int getCount() {
        return count;
    }

    public List<DatasEntity> getDatas() {
        return datas;
    }

    public static class DatasEntity {
        /**
         * id : 35836923-a948-4f00-9285-581e358db6e1
         * listPicUrl : http://121.42.174.82//upload/image/20161110/6361436915904216887763600.jpg
         * publishTime : 2016-11-10 10:07:12
         * summary : null
         * title : 拍下特价苹果电脑拒发货：当当硬逼用户撤单
         * views : 35
         */

        private String id;
        private String listPicUrl;
        private String publishTime;
        private Object summary;
        private String title;
        private int views;

        public void setId(String id) {
            this.id = id;
        }

        public void setListPicUrl(String listPicUrl) {
            this.listPicUrl = listPicUrl;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public void setSummary(Object summary) {
            this.summary = summary;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setViews(int views) {
            this.views = views;
        }

        public String getId() {
            return id;
        }

        public String getListPicUrl() {
            return listPicUrl;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public Object getSummary() {
            return summary;
        }

        public String getTitle() {
            return title;
        }

        public int getViews() {
            return views;
        }
    }
}
