package ruolan.com.myhearts.utils;
import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: Utils.java
 * @author: 若兰明月
 * @date: 2016-08-28 09:20
 */

public class Utils {

    public static String getJson(Context context, String fileName) {
        StringBuilder sb = new StringBuilder();
        AssetManager assetManager = context.getAssets();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(assetManager.open(fileName)));
            String str = "";
            while (null != (str = br.readLine())) {
                sb.append(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
            sb.delete(0, sb.length());
        }
        return sb.toString().trim();
    }
}
