package ruolan.com.myhearts.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/11/8.
 */

public class LivingBean implements Serializable {

    /**
     * errorCode : 0
     * errorStr : success
     * resultCount : 30
     * score : 0
     * balance : 0
     * results : [{"id":"1313","userid":"7542","nickname":"曹华","avatar":"http://image.xinliji.me/FoWbgtZAIDMEYrGk0Nzz9VN8uP5v","viewCnt":"1110","title":"师生情 同学情\n今晚8:30(8月15日)","location":"通化市","showTime":"","banner":"http://image.xinliji.me/Fsq6Y_NjSYQSrOYk5QPw0adkjQ0D","isOfficial":"0","isSupervise":"0","needTicket":"0","isConsultant":"1","state":"F","files":"http://video.xinliji.me/1472871601.mp4"},{"id":"1311","userid":"51773","nickname":"乔瑞峰","avatar":"http://image.xinliji.me/FsVzB-yW_UJlZZiqvrOPKlIYUZZB","viewCnt":"544","title":"大娃夜话敏感带","location":"难道在火星?","showTime":"","banner":"http://image.xinliji.me/FizzQDfuqguQIVAaTIAatrbERaJ4","isOfficial":"0","isSupervise":"0","needTicket":"0","isConsultant":"1","state":"F","files":"http://video.xinliji.me/1472821201.mp4"},{"id":"1303","userid":"51773","nickname":"乔瑞峰","avatar":"http://image.xinliji.me/FsVzB-yW_UJlZZiqvrOPKlIYUZZB","viewCnt":"570","title":"大娃夜话挫折教育","location":"难道在火星?","showTime":"","banner":"http://image.xinliji.me/FizzQDfuqguQIVAaTIAatrbERaJ4","isOfficial":"0","isSupervise":"0","needTicket":"0","isConsultant":"1","state":"F","files":"http://video.xinliji.me/1472734801.mp4"},{"id":"1264","userid":"89052","nickname":"徐明","avatar":"http://image.xinliji.me/o_1apmcgidq6uq1hr0unc1d1j1r91i.jpg","viewCnt":"3610","title":"巴夏信念催眠","location":"难道在火星?","showTime":"2016-09-02 19:30:00","banner":"http://image.xinliji.me/o_1arhlnp6g1vmsd4f1tcf1sik18gkv.png","isOfficial":"1","isSupervise":"0","needTicket":"0","isConsultant":"1","state":"F","files":"http://video.xinliji.me/1472824801.mp4,http://video.xinliji.me/1472824942.mp4"},{"id":"1252","userid":"51773","nickname":"乔瑞峰","avatar":"http://image.xinliji.me/FsVzB-yW_UJlZZiqvrOPKlIYUZZB","viewCnt":"635","title":"大娃夜话卖淫嫖娼","location":"难道在火星?","showTime":"","banner":"http://image.xinliji.me/FizzQDfuqguQIVAaTIAatrbERaJ4","isOfficial":"0","isSupervise":"0","needTicket":"0","isConsultant":"1","state":"F","files":"http://video.xinliji.me/1472644810.mp4"},{"id":"1238","userid":"39449","nickname":"蔡小敏","avatar":"http://image.xinliji.me//FuC4Ni8DXNMkGwJndrvx-FAIT_pm","viewCnt":"1043","title":"当我们从孩子变成父母，你是否记得你也曾经是个孩子","location":"福州市","showTime":"","banner":"http://image.xinliji.me/Fg_GCOjQNGH9fWZZTt1NjRmo6sM_","isOfficial":"0","isSupervise":"0","needTicket":"0","isConsultant":"1","state":"F","files":"http://video.xinliji.me/1472565601.mp4"},{"id":"1235","userid":"51773","nickname":"乔瑞峰","avatar":"http://image.xinliji.me/FsVzB-yW_UJlZZiqvrOPKlIYUZZB","viewCnt":"1054","title":"大娃夜话选择的权力","location":"难道在火星?","showTime":"","banner":"http://image.xinliji.me/o_1aqu2vhk7ojltl9jdk1evs2gmv.jpg","isOfficial":"0","isSupervise":"0","needTicket":"0","isConsultant":"1","state":"F","files":"http://video.xinliji.me/1472475601.mp4"},{"id":"1234","userid":"86411","nickname":"周红军","avatar":"http://image.xinliji.me/o_1aoinsfte1f211nh21sj5i7feegi.jpg","viewCnt":"225","title":"人的需求 心理学与生活和你我他8","location":"上海市","showTime":"","banner":"http://image.xinliji.me/FoEDWYU4rlsRZ1anH0XXY1s6XF0K","isOfficial":"0","isSupervise":"0","needTicket":"0","isConsultant":"1","state":"F","files":"http://video.xinliji.me/1472472001.mp4"},{"id":"1229","userid":"86411","nickname":"周红军","avatar":"http://image.xinliji.me/o_1aoinsfte1f211nh21sj5i7feegi.jpg","viewCnt":"255","title":"细水长流 心理学与生活和你我他7","location":"难道在火星?","showTime":"","banner":"http://image.xinliji.me/FoEDWYU4rlsRZ1anH0XXY1s6XF0K","isOfficial":"0","isSupervise":"0","needTicket":"0","isConsultant":"1","state":"F","files":"http://video.xinliji.me/1472392801.mp4"},{"id":"1228","userid":"39449","nickname":"蔡小敏","avatar":"http://image.xinliji.me//FuC4Ni8DXNMkGwJndrvx-FAIT_pm","viewCnt":"242","title":"开学了大一新生如何适应新环境","location":"难道在火星?","showTime":"","banner":"http://image.xinliji.me/FkgP7GdpjH06zT6yN9Onp88oWBaa","isOfficial":"0","isSupervise":"0","needTicket":"0","isConsultant":"1","state":"F","files":"http://video.xinliji.me/1472392915.mp4"},{"id":"1227","userid":"86411","nickname":"周红军","avatar":"http://image.xinliji.me/o_1aoinsfte1f211nh21sj5i7feegi.jpg","viewCnt":"38","title":"细水长流 心理学与生活和你我他7","location":"难道在火星?","showTime":"","banner":"http://image.xinliji.me/FoEDWYU4rlsRZ1anH0XXY1s6XF0K","isOfficial":"0","isSupervise":"0","needTicket":"0","isConsultant":"1","state":"F","files":"http://video.xinliji.me/1472389202.mp4"},{"id":"1224","userid":"86411","nickname":"周红军","avatar":"http://image.xinliji.me/o_1aoinsfte1f211nh21sj5i7feegi.jpg","viewCnt":"219","title":"红楼，病态的爱恋 心理学与生活和你我他6","location":"上海市","showTime":"","banner":"http://image.xinliji.me/FoEDWYU4rlsRZ1anH0XXY1s6XF0K","isOfficial":"0","isSupervise":"0","needTicket":"0","isConsultant":"1","state":"F","files":"http://video.xinliji.me/1472302801.mp4"},{"id":"1223","userid":"40704","nickname":"东振明","avatar":"http://image.xinliji.me//o_1adpmfrpfio91tokif2hhetgai.jpg","viewCnt":"3057","title":"心理咨询师的职业发展","location":"难道在火星?","showTime":"2016-08-31 19:30:00","banner":"http://image.xinliji.me/o_1ar4vit5d1tji10jt1ifg1jrj4r6q.jpg","isOfficial":"1","isSupervise":"0","needTicket":"0","isConsultant":"1","state":"F","files":"http://video.xinliji.me/1472652002.mp4"},{"id":"1222","userid":"39449","nickname":"蔡小敏","avatar":"http://image.xinliji.me//FuC4Ni8DXNMkGwJndrvx-FAIT_pm","viewCnt":"628","title":"请不要再用语言暴力伤害你的孩子","location":"福州市","showTime":"","banner":"http://image.xinliji.me/Fk50NcyIbSKh25_rK5CFOB4u6rvu","isOfficial":"0","isSupervise":"0","needTicket":"0","isConsultant":"1","state":"F","files":"http://video.xinliji.me/1472216567.mp4"},{"id":"1221","userid":"86411","nickname":"周红军","avatar":"http://image.xinliji.me/o_1aoinsfte1f211nh21sj5i7feegi.jpg","viewCnt":"380","title":"该如何生活？心理学与生活和你我他5","location":"上海市","showTime":"","banner":"http://image.xinliji.me/FoEDWYU4rlsRZ1anH0XXY1s6XF0K","isOfficial":"0","isSupervise":"0","needTicket":"0","isConsultant":"1","state":"F","files":"http://video.xinliji.me/1472216401.mp4"},{"id":"1220","userid":"86411","nickname":"周红军","avatar":"http://image.xinliji.me/o_1aoinsfte1f211nh21sj5i7feegi.jpg","viewCnt":"21","title":"该如何生活？心理学与生活和你我他5","location":"难道在火星?","showTime":"","banner":"http://image.xinliji.me/FoEDWYU4rlsRZ1anH0XXY1s6XF0K","isOfficial":"0","isSupervise":"0","needTicket":"0","isConsultant":"1","state":"F","files":"http://video.xinliji.me/1472212801.mp4"},{"id":"1219","userid":"51773","nickname":"乔瑞峰","avatar":"http://image.xinliji.me/FsVzB-yW_UJlZZiqvrOPKlIYUZZB","viewCnt":"937","title":"大娃夜话新生被骗","location":"难道在火星?","showTime":"","banner":"http://image.xinliji.me/o_1aqu2vhk7ojltl9jdk1evs2gmv.jpg","isOfficial":"0","isSupervise":"0","needTicket":"0","isConsultant":"1","state":"F","files":"http://video.xinliji.me/1472216421.mp4"},{"id":"1194","userid":"39449","nickname":"蔡小敏","avatar":"http://image.xinliji.me//FuC4Ni8DXNMkGwJndrvx-FAIT_pm","viewCnt":"1068","title":"如何让孩子主动做作业或学习","location":"福州市","showTime":"","banner":"http://image.xinliji.me/Fi0bu3O_EFtD91yiPJPsOo94tqOb","isOfficial":"0","isSupervise":"0","needTicket":"0","isConsultant":"1","state":"F","files":"http://video.xinliji.me/1472047611.mp4,http://video.xinliji.me/1472047672.mp4"},{"id":"1193","userid":"51773","nickname":"乔瑞峰","avatar":"http://image.xinliji.me/FsVzB-yW_UJlZZiqvrOPKlIYUZZB","viewCnt":"1319","title":"就业季：如何华丽丽的变身？","location":"难道在火星?","showTime":"2016-08-24 19:00:00","banner":"http://image.xinliji.me/o_1aqu2vhk7ojltl9jdk1evs2gmv.jpg","isOfficial":"1","isSupervise":"0","needTicket":"0","isConsultant":"1","state":"F","files":"http://video.xinliji.me/1472047201.mp4"},{"id":"1184","userid":"86411","nickname":"周红军","avatar":"http://image.xinliji.me/o_1aoinsfte1f211nh21sj5i7feegi.jpg","viewCnt":"427","title":"进化与我们 心理学与生活和你我他4","location":"难道在火星?","showTime":"","banner":"http://image.xinliji.me/FoEDWYU4rlsRZ1anH0XXY1s6XF0K","isOfficial":"0","isSupervise":"0","needTicket":"0","isConsultant":"1","state":"F","files":"http://video.xinliji.me/1471957201.mp4"},{"id":"1177","userid":"51773","nickname":"乔瑞峰","avatar":"http://image.xinliji.me/FsVzB-yW_UJlZZiqvrOPKlIYUZZB","viewCnt":"695","title":"大娃夜话一人一剧场","location":"难道在火星?","showTime":"","banner":"http://image.xinliji.me/FrjG0CB0oi1OTfraf7Wc2yb7Ha3V","isOfficial":"0","isSupervise":"0","needTicket":"0","isConsultant":"1","state":"F","files":"http://video.xinliji.me/1471870801.mp4"},{"id":"1175","userid":"86411","nickname":"周红军","avatar":"http://image.xinliji.me/o_1aoinsfte1f211nh21sj5i7feegi.jpg","viewCnt":"371","title":"如何培养健康的孩子 心理学与生活和你我他3","location":"上海市","showTime":"","banner":"http://image.xinliji.me/FoEDWYU4rlsRZ1anH0XXY1s6XF0K","isOfficial":"0","isSupervise":"0","needTicket":"0","isConsultant":"1","state":"F","files":"http://video.xinliji.me/1471788003.mp4"},{"id":"1170","userid":"63956","nickname":"郑立新～～天擎","avatar":"http://image.xinliji.me//Fi0RGaYl9wZ-sLanFVcLRwzznUnh","viewCnt":"182","title":"郑主任每周大话心理咨询","location":"难道在火星?","showTime":"","banner":"http://image.xinliji.me/FuIzYdKNlf5k2n_kbUyzhe9cIl3m","isOfficial":"0","isSupervise":"0","needTicket":"0","isConsultant":"1","state":"F","files":"http://video.xinliji.me/1471705201.mp4"},{"id":"1169","userid":"86411","nickname":"周红军","avatar":"http://image.xinliji.me/o_1aoinsfte1f211nh21sj5i7feegi.jpg","viewCnt":"198","title":"心理学与生活和你我他2","location":"难道在火星?","showTime":"","banner":"http://image.xinliji.me/FoEDWYU4rlsRZ1anH0XXY1s6XF0K","isOfficial":"0","isSupervise":"0","needTicket":"0","isConsultant":"1","state":"F","files":"http://video.xinliji.me/1471701601.mp4"},{"id":"1167","userid":"86411","nickname":"周红军","avatar":"http://image.xinliji.me/o_1aoinsfte1f211nh21sj5i7feegi.jpg","viewCnt":"229","title":"心理学与生活和你我他1","location":"难道在火星?","showTime":"","banner":"http://image.xinliji.me/FoEDWYU4rlsRZ1anH0XXY1s6XF0K","isOfficial":"0","isSupervise":"0","needTicket":"0","isConsultant":"1","state":"F","files":"http://video.xinliji.me/1471611728.mp4"},{"id":"1161","userid":"51773","nickname":"乔瑞峰","avatar":"http://image.xinliji.me/FsVzB-yW_UJlZZiqvrOPKlIYUZZB","viewCnt":"1142","title":"大娃夜话性教育","location":"难道在火星?","showTime":"","banner":"http://image.xinliji.me/o_1aqg7qfda8lt19lj1on5145g12gc19.jpg","isOfficial":"0","isSupervise":"0","needTicket":"0","isConsultant":"1","state":"F","files":"http://video.xinliji.me/1471611601.mp4"},{"id":"1156","userid":"19806","nickname":"李喆浩","avatar":"http://image.xinliji.me//o_19rgvdbi56o618jjqqqi841063n.jpg","viewCnt":"600","title":"万一有料 猛犸公社 职业生涯规划线下沙龙","location":"难道在火星?","showTime":"","banner":"http://image.xinliji.me/FvY32NkG06WPPnbilyytPWFxqdht","isOfficial":"0","isSupervise":"0","needTicket":"0","isConsultant":"1","state":"F","files":"http://video.xinliji.me/1471525346.mp4,http://video.xinliji.me/1471525367.mp4"},{"id":"1155","userid":"51773","nickname":"乔瑞峰","avatar":"http://image.xinliji.me/FsVzB-yW_UJlZZiqvrOPKlIYUZZB","viewCnt":"1000","title":"大娃夜话隐私","location":"难道在火星?","showTime":"","banner":"http://image.xinliji.me/FrjG0CB0oi1OTfraf7Wc2yb7Ha3V","isOfficial":"0","isSupervise":"0","needTicket":"0","isConsultant":"1","state":"F","files":"http://video.xinliji.me/1471525202.mp4"},{"id":"1152","userid":"84299","nickname":"姚刚","avatar":"http://image.xinliji.me/o_1ann6qn27v6lduscq61pdgeu3n.jpg","viewCnt":"211","title":"觉察力的培养","location":"难道在火星?","showTime":"","banner":"http://image.xinliji.me/o_1aprlbdnsto29h4n1mrdh1pup11.png","isOfficial":"0","isSupervise":"0","needTicket":"0","isConsultant":"1","state":"F","files":"http://video.xinliji.me/1471442716.mp4"},{"id":"1151","userid":"51773","nickname":"乔瑞峰","avatar":"http://image.xinliji.me/FsVzB-yW_UJlZZiqvrOPKlIYUZZB","viewCnt":"1058","title":"大娃夜话解放天性","location":"难道在火星?","showTime":"","banner":"http://image.xinliji.me/FrjG0CB0oi1OTfraf7Wc2yb7Ha3V","isOfficial":"0","isSupervise":"0","needTicket":"0","isConsultant":"1","state":"F","files":"http://video.xinliji.me/1471438801.mp4"}]
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
         * id : 1313
         * userid : 7542
         * nickname : 曹华
         * avatar : http://image.xinliji.me/FoWbgtZAIDMEYrGk0Nzz9VN8uP5v
         * viewCnt : 1110
         * title : 师生情 同学情
         今晚8:30(8月15日)
         * location : 通化市
         * showTime :
         * banner : http://image.xinliji.me/Fsq6Y_NjSYQSrOYk5QPw0adkjQ0D
         * isOfficial : 0
         * isSupervise : 0
         * needTicket : 0
         * isConsultant : 1
         * state : F
         * files : http://video.xinliji.me/1472871601.mp4
         */

        private String id;
        private String userid;
        private String nickname;
        private String avatar;
        private String viewCnt;
        private String title;
        private String location;
        private String showTime;
        private String banner;
        private String isOfficial;
        private String isSupervise;
        private String needTicket;
        private String isConsultant;
        private String state;
        private String files;

        public void setId(String id) {
            this.id = id;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public void setViewCnt(String viewCnt) {
            this.viewCnt = viewCnt;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public void setShowTime(String showTime) {
            this.showTime = showTime;
        }

        public void setBanner(String banner) {
            this.banner = banner;
        }

        public void setIsOfficial(String isOfficial) {
            this.isOfficial = isOfficial;
        }

        public void setIsSupervise(String isSupervise) {
            this.isSupervise = isSupervise;
        }

        public void setNeedTicket(String needTicket) {
            this.needTicket = needTicket;
        }

        public void setIsConsultant(String isConsultant) {
            this.isConsultant = isConsultant;
        }

        public void setState(String state) {
            this.state = state;
        }

        public void setFiles(String files) {
            this.files = files;
        }

        public String getId() {
            return id;
        }

        public String getUserid() {
            return userid;
        }

        public String getNickname() {
            return nickname;
        }

        public String getAvatar() {
            return avatar;
        }

        public String getViewCnt() {
            return viewCnt;
        }

        public String getTitle() {
            return title;
        }

        public String getLocation() {
            return location;
        }

        public String getShowTime() {
            return showTime;
        }

        public String getBanner() {
            return banner;
        }

        public String getIsOfficial() {
            return isOfficial;
        }

        public String getIsSupervise() {
            return isSupervise;
        }

        public String getNeedTicket() {
            return needTicket;
        }

        public String getIsConsultant() {
            return isConsultant;
        }

        public String getState() {
            return state;
        }

        public String getFiles() {
            return files;
        }
    }
}
