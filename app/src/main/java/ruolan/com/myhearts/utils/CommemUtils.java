package ruolan.com.myhearts.utils;

import android.content.Context;

import ruolan.com.myhearts.R;

/**
 * Created by Administrator on 2016/10/25.
 */

public class CommemUtils {


    /**
     * 拼接直播回放
     *
     * @param tp      请求返回的字符串
     * @param context 上下文
     * @return 直播回放(7)
     */
    public static String getDirectSedding( String tp, Context context) {

        String txtPart = null;

        txtPart = context.getResources()
                .getString(R.string.direct_sedding) + tp +")";

        return txtPart;
    }


    /**
     * 拼接直播回放
     *
     * @param tp      请求返回的字符串
     * @param context 上下文
     * @return 直播回放(7)
     */
    public static String getUserComment( String tp, Context context) {

        String txtPart = null;

        txtPart = context.getResources()
                .getString(R.string.user_comment) + tp +")";

        return txtPart;
    }


    /**
     * 拼接直播回放
     *
     * @param tp      请求返回的字符串
     * @param context 上下文
     * @return 直播回放(7)
     */
    public static String getGifCount( String tp, Context context) {

        String txtPart = null;

        txtPart = context.getResources()
                .getString(R.string.gif_count) + tp +")";

        return txtPart;
    }
}
