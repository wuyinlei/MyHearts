package ruolan.com.myhearts.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/11/11.
 */

public class NewsBannerBean implements Serializable {

    /**
     * datas : [{"id":"6f4abcc4-ca17-458c-90fb-6200fea25c64","headPicUrl":"http://121.42.174.82//upload/image/20161110/6361437417264211411720170.jpg","listPicUrl":"http://121.42.174.82//upload/image/20161110/6361437417568909117952607.jpg","publishTime":"2016-11-10 11:29:39","summary":null,"title":"这几天显示器要大促！不看这些购买技巧你要吃亏"},{"id":"9fb359f6-be00-493e-93b3-bf6db3bceb0f","headPicUrl":"http://121.42.174.82//upload/image/20161110/6361436729609156624264039.jpg","listPicUrl":"http://121.42.174.82//upload/image/20161110/6361436729907603685009801.jpg","publishTime":"2016-11-10 09:35:03","summary":null,"title":"你中招了没？网曝大量iPhone6s出现大BUG！"},{"id":"bf7d0e21-a1a6-4f92-8e7f-e326457f7e78","headPicUrl":"http://121.42.174.82//upload/image/20161109/6361428425033900341573176.jpg","listPicUrl":"http://121.42.174.82//upload/image/20161109/6361428425362030389876073.jpg","publishTime":"2016-11-09 10:30:58","summary":null,"title":"11.11狂欢购物 小编推荐你关注它们\u2026\u2026"},{"id":"19505085-a032-419f-b784-1091830edec8","headPicUrl":"http://121.42.174.82//upload/image/20161108/6361419552660822759545435.jpg","listPicUrl":"http://121.42.174.82//upload/image/20161108/6361419553376459955265500.jpg","publishTime":"2016-11-08 09:52:29","summary":null,"title":"简单粗暴！双十一买这些核心配件准没错！"},{"id":"2f837d62-7913-427d-ba8a-08dcd44dc0c5","headPicUrl":"http://121.42.174.82//upload/image/20161107/6361410996200208699681504.jpg","listPicUrl":"http://121.42.174.82//upload/image/20161107/6361410996481462384439825.jpg","publishTime":"2016-11-07 10:06:09","summary":null,"title":"用电脑，就要对你的手和眼好一点！双十一购物功略（外设篇）"},{"id":"4dbe8cc5-71f7-4b8c-b5e3-d4ecfb326f8c","headPicUrl":"http://121.42.174.82//upload/image/20161103/6361376359753944498584499.jpg","listPicUrl":"http://121.42.174.82//upload/image/20161103/6361376360108633828201194.jpg","publishTime":"2016-11-03 09:53:58","summary":null,"title":"AMD Zen ES版新跑分曝光：虐杀六核i7、打平十核Xeon E5"}]
     * startIndex : 0
     * endIndex : 90
     * count : 91
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
         * id : 6f4abcc4-ca17-458c-90fb-6200fea25c64
         * headPicUrl : http://121.42.174.82//upload/image/20161110/6361437417264211411720170.jpg
         * listPicUrl : http://121.42.174.82//upload/image/20161110/6361437417568909117952607.jpg
         * publishTime : 2016-11-10 11:29:39
         * summary : null
         * title : 这几天显示器要大促！不看这些购买技巧你要吃亏
         */

        private String id;
        private String headPicUrl;
        private String listPicUrl;
        private String publishTime;
        private Object summary;
        private String title;

        public void setId(String id) {
            this.id = id;
        }

        public void setHeadPicUrl(String headPicUrl) {
            this.headPicUrl = headPicUrl;
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

        public String getId() {
            return id;
        }

        public String getHeadPicUrl() {
            return headPicUrl;
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
    }
}
