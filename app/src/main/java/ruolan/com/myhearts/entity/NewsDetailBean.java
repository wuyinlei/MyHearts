package ruolan.com.myhearts.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/11/10.
 */

public class NewsDetailBean implements Serializable {

    /**
     * id : 9cec158c-4f43-463c-9064-55c755b63cd0
     * authorName : null
     * content : <p>跟微软撇开关系后，诺基亚决定重回手机圈，而他们全新的安卓旗舰预计会在明年年初发布。
     * </p><p><br/>
     * </p><p>今年9月底，诺基亚的一款新功能机216亮相，时隔近两个月后，它的行货版本终于到来，售价299元，
     * 11月16日正式开卖。</p><p><br/></p>
     * <p><strong>诺基亚216作为一款备用机显然是合格的，其最大的亮是续航，根据官方公布的数据显示，其待
     * 机时间达到24天（iPhone 7为10天，而iPhone 7 Plus为16天），用2G网络通话可以持续18小时，音乐播放
     * 时间为47小时。</strong></p><p><strong><br/></strong></p>
     * <p>此外，诺基亚216机身尺寸118×50.2×13.5mm，整机重82.6g，采用一块2.4英寸320×240分辨率显示屏，
     * 内置16MB存储，最高支持32GB Micro SD卡扩展，提供前后双30万像素摄像头，电池容量1020mAh，
     * 使用mini SIM卡，仅支持2G网络。</p>
     * <p>大家有意否？</p>
     * <p style="text-align: center;">
     *     <img src="http://121.42.174.82//upload/image/20161107/6361411100608201201214230.jpg"
     *     style="" title="20161107_101824_010.jpg"/></p>
     *     <p style="text-align: center;">
     *         <img src="http://121.42.174.82//upload/image/20161107/6361411100667575267328500.jpg"
     *         style="" title="20161107_101824_011.jpg"/></p><p style="text-align: center;">
     *      <img src="http://121.42.174.82//upload/image/20161107/6361411100672263137044420.jpg"
     *      style="" title="20161107_101824_012.jpg"/></p>
     * editorName : null
     * publishTime : 2016-11-07 10:23:53
     * summary : 跟微软撇开关系后，诺基亚决定重回手机圈，而他们全新的安卓旗舰预计会在明年年初发布。
     * title : 续航甩iPhone 7几条街！诺基亚216行货发布：299元
     * views : 110
     * sourceName : null
     * sourceUrl : null
     */

    private String id;
    private Object authorName;
    private String content;
    private Object editorName;
    private String publishTime;
    private String summary;
    private String title;
    private int views;
    private Object sourceName;
    private Object sourceUrl;

    public void setId(String id) {
        this.id = id;
    }

    public void setAuthorName(Object authorName) {
        this.authorName = authorName;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setEditorName(Object editorName) {
        this.editorName = editorName;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public void setSourceName(Object sourceName) {
        this.sourceName = sourceName;
    }

    public void setSourceUrl(Object sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getId() {
        return id;
    }

    public Object getAuthorName() {
        return authorName;
    }

    public String getContent() {
        return content;
    }

    public Object getEditorName() {
        return editorName;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public String getSummary() {
        return summary;
    }

    public String getTitle() {
        return title;
    }

    public int getViews() {
        return views;
    }

    public Object getSourceName() {
        return sourceName;
    }

    public Object getSourceUrl() {
        return sourceUrl;
    }
}
