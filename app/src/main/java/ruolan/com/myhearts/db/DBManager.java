package ruolan.com.myhearts.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import ruolan.com.myhearts.R;

/**
 * 存储所有城市信息的数据库
 * */
public class DBManager {
    private static String TAG="DBManager";
    private final int BUFFER_SIZE = 400000;
    public static final String DB_NAME = "regions.db"; //保存的数据库文件名
    public static final String PACKAGE_NAME = "ruolan.com.myhearts";
    ///*"/data" + */Environment.getDataDirectory().getAbsolutePath()/* + "/" + PACKAGE_NAME*/;  //在手机里存放数据库的位置
    public static  String DB_PATH = "";
 //

    private SQLiteDatabase database;
    private Context context;
 
   public  DBManager(Context context) {
        this.context = context;
       PATH = context.getFilesDir()+"\\databases\\"+"regions.db";;
   }
 
    public void openDatabase() {
        this.database = this.openDatabase(PATH);
    }
 
    private SQLiteDatabase openDatabase(String dbfile) {
       // Log.d(TAG, dbfile);
       // Log.d(TAG, "new File(dbfile).exists():" + new File(dbfile).exists());


        writeDB();

        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(dbfile, null);
        return db;
    }

    public static String PATH;   //数据库存入手机的路径

    public void writeDB(){
        FileOutputStream fout = null;
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().openRawResource(R.raw.regions);
            fout = new FileOutputStream(new File(PATH));
            byte[] buffer = new byte[128];
            int len = 0;
            while ((len = inputStream.read(buffer))!=-1){
                fout.write(buffer, 0, len);
            }
            buffer = null;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        }

    public void closeDatabase() {
        this.database.close();
    }
}
