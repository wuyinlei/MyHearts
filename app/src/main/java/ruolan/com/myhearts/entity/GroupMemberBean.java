package ruolan.com.myhearts.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/11/7.
 */

public class GroupMemberBean implements Serializable {


    /**
     * errorCode : 0
     * errorStr : success
     * resultCount : 30
     * score : 0
     * balance : 0
     * results : [{"userid":"9454","nickname":"婷婷六月天","avatar":"http://icon.xinliji.me/avatar_0_71.png","gender":"0","role":"0","isConsultant":"0","height":"160","weight":"60","isAdmin":"1","distance":"7422363.462391103","age":22},{"userid":"92023","nickname":"霭黛","avatar":"http://icon.xinliji.me//avatar_0_83.png","gender":"0","role":"0","isConsultant":"0","height":"160","weight":"60","isAdmin":"0","distance":"0","age":22},{"userid":"94963","nickname":"发新","avatar":"http://icon.xinliji.me//avatar_1_4.png","gender":"1","role":"0","isConsultant":"0","height":"160","weight":"60","isAdmin":"0","distance":"0","age":27},{"userid":"103780","nickname":"巧玉莎莎","avatar":"http://image.xinliji.me/FuNOxAlVQ5Wss4c5U8_CORCFqTrg","gender":"0","role":"0","isConsultant":"0","height":"160","weight":"60","isAdmin":"0","distance":"0","age":19},{"userid":"106916","nickname":"霄惠","avatar":"http://image.xinliji.me/FtTfoRw5er_J0zAbeSUqWVa3cNV_","gender":"0","role":"0","isConsultant":"0","height":"160","weight":"60","isAdmin":"0","distance":"0","age":16},{"userid":"107699","nickname":"园馨","avatar":"http://icon.xinliji.me//avatar_0_21.png","gender":"0","role":"0","isConsultant":"0","height":"160","weight":"60","isAdmin":"0","distance":"0","age":22},{"userid":"108189","nickname":"欣月","avatar":"http://icon.xinliji.me//avatar_0_78.png","gender":"0","role":"0","isConsultant":"0","height":"160","weight":"60","isAdmin":"0","distance":"0","age":24},{"userid":"108557","nickname":"离离","avatar":"http://icon.xinliji.me//avatar_0_91.png","gender":"0","role":"0","isConsultant":"0","height":"160","weight":"60","isAdmin":"0","distance":"0","age":23},{"userid":"113591","nickname":"。。。","avatar":"http://image.xinliji.me/Fpm2ET8z8ZujpUw6W5Zzoqb7j4Yw","gender":"1","role":"0","isConsultant":"0","height":"160","weight":"60","isAdmin":"0","distance":"0","age":17},{"userid":"107092","nickname":"岚霄","avatar":"http://icon.xinliji.me//avatar_0_73.png","gender":"0","role":"0","isConsultant":"0","height":"160","weight":"60","isAdmin":"0","distance":"7021031.839638501","age":26},{"userid":"100988","nickname":"巧芳","avatar":"http://icon.xinliji.me//avatar_0_16.png","gender":"0","role":"0","isConsultant":"0","height":"160","weight":"60","isAdmin":"0","distance":"7178759.052359455","age":27},{"userid":"110092","nickname":"奇建","avatar":"http://icon.xinliji.me//avatar_1_95.png","gender":"1","role":"0","isConsultant":"0","height":"160","weight":"60","isAdmin":"0","distance":"7188762.07639111","age":16},{"userid":"107560","nickname":"行以","avatar":"http://icon.xinliji.me//avatar_1_11.png","gender":"1","role":"0","isConsultant":"0","height":"160","weight":"60","isAdmin":"0","distance":"7252759.738099247","age":21},{"userid":"106323","nickname":"莎妹","avatar":"http://icon.xinliji.me//avatar_0_136.png","gender":"0","role":"0","isConsultant":"0","height":"160","weight":"60","isAdmin":"0","distance":"7283427.251835585","age":23},{"userid":"105467","nickname":"秀青","avatar":"http://icon.xinliji.me//avatar_0_79.png","gender":"0","role":"0","isConsultant":"0","height":"160","weight":"60","isAdmin":"0","distance":"7283867.658912832","age":21},{"userid":"107122","nickname":"朗行","avatar":"http://icon.xinliji.me//avatar_1_10.png","gender":"1","role":"0","isConsultant":"0","height":"160","weight":"60","isAdmin":"0","distance":"7283873.359786607","age":19},{"userid":"112526","nickname":"鸣有","avatar":"http://icon.xinliji.me//avatar_1_25.png","gender":"1","role":"0","isConsultant":"0","height":"160","weight":"60","isAdmin":"0","distance":"7295282.739435581","age":31},{"userid":"104454","nickname":"慧蓓","avatar":"http://image.xinliji.me/FmjqjVU2CTzVyv57-sddXcEH5Vxi","gender":"0","role":"0","isConsultant":"0","height":"160","weight":"60","isAdmin":"0","distance":"7302702.3550632335","age":21},{"userid":"111755","nickname":"梦飘","avatar":"http://icon.xinliji.me//avatar_0_47.png","gender":"0","role":"0","isConsultant":"0","height":"160","weight":"60","isAdmin":"0","distance":"7308550.848323391","age":13},{"userid":"105408","nickname":"先鸣","avatar":"http://image.xinliji.me/FlTTUqniBGDiomD1UE5Om0dGQnP2","gender":"1","role":"0","isConsultant":"0","height":"160","weight":"60","isAdmin":"0","distance":"7312941.341129999","age":30},{"userid":"104596","nickname":"慧燕","avatar":"http://icon.xinliji.me//avatar_0_166.png","gender":"0","role":"0","isConsultant":"0","height":"160","weight":"60","isAdmin":"0","distance":"7318764.023796737","age":31},{"userid":"109744","nickname":"纨蓓","avatar":"http://icon.xinliji.me//avatar_0_23.png","gender":"0","role":"0","isConsultant":"0","height":"160","weight":"60","isAdmin":"0","distance":"7319501.303593374","age":29},{"userid":"105171","nickname":"莲凡","avatar":"http://icon.xinliji.me//avatar_0_73.png","gender":"0","role":"0","isConsultant":"0","height":"160","weight":"60","isAdmin":"0","distance":"7320628.878282024","age":16},{"userid":"99532","nickname":"刚维","avatar":"http://icon.xinliji.me//avatar_1_152.png","gender":"1","role":"0","isConsultant":"0","height":"160","weight":"60","isAdmin":"0","distance":"7333475.200227287","age":16},{"userid":"9838","nickname":"向日葵","avatar":"http://image.xinliji.me//Fk90OfzsWrryw3x9rntQ9AjKNkC6","gender":"0","role":"0","isConsultant":"0","height":"160","weight":"60","isAdmin":"0","distance":"7344574.62097059","age":18},{"userid":"92149","nickname":"凡羽","avatar":"http://icon.xinliji.me//avatar_0_88.png","gender":"0","role":"0","isConsultant":"0","height":"160","weight":"60","isAdmin":"0","distance":"7374132.98618081","age":30},{"userid":"89894","nickname":"雪莲","avatar":"http://icon.xinliji.me//avatar_0_162.png","gender":"0","role":"0","isConsultant":"0","height":"160","weight":"60","isAdmin":"0","distance":"7375831.406029483","age":22},{"userid":"112336","nickname":"悦欢","avatar":"http://icon.xinliji.me//avatar_0_176.png","gender":"0","role":"0","isConsultant":"0","height":"160","weight":"60","isAdmin":"0","distance":"7384482.465074076","age":30},{"userid":"108891","nickname":"娅秀","avatar":"http://icon.xinliji.me//avatar_0_130.png","gender":"0","role":"0","isConsultant":"0","height":"160","weight":"60","isAdmin":"0","distance":"7391574.64662358","age":22},{"userid":"92592","nickname":"广琛","avatar":"http://icon.xinliji.me//avatar_1_92.png","gender":"1","role":"0","isConsultant":"0","height":"160","weight":"60","isAdmin":"0","distance":"7392234.618980924","age":18}]
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
         * userid : 9454
         * nickname : 婷婷六月天
         * avatar : http://icon.xinliji.me/avatar_0_71.png
         * gender : 0
         * role : 0
         * isConsultant : 0
         * height : 160
         * weight : 60
         * isAdmin : 1
         * distance : 7422363.462391103
         * age : 22
         */

        private String userid;
        private String nickname;
        private String avatar;
        private String gender;
        private String role;
        private String isConsultant;
        private String height;
        private String weight;
        private String isAdmin;
        private String distance;
        private int age;

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public void setIsConsultant(String isConsultant) {
            this.isConsultant = isConsultant;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public void setIsAdmin(String isAdmin) {
            this.isAdmin = isAdmin;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public void setAge(int age) {
            this.age = age;
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

        public String getGender() {
            return gender;
        }

        public String getRole() {
            return role;
        }

        public String getIsConsultant() {
            return isConsultant;
        }

        public String getHeight() {
            return height;
        }

        public String getWeight() {
            return weight;
        }

        public String getIsAdmin() {
            return isAdmin;
        }

        public String getDistance() {
            return distance;
        }

        public int getAge() {
            return age;
        }
    }
}
