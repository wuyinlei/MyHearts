package ruolan.com.myhearts.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;
import java.util.List;

import ruolan.com.myhearts.entity.RegionInfo;

/**
 * 数据库中的主要主要操作方法
 */
public class RegionFunction {

    //通过id查找省或城市
    public static List<RegionInfo> getProvencesOrCityOnId(int id) {
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(DBManager.PATH, null);
        List<RegionInfo> regionInfos = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from regions where _id = " + id, null);
        while (cursor.moveToNext()) {
            RegionInfo regionInfo = new RegionInfo();
            int _id = cursor.getInt(cursor.getColumnIndex("_id"));
            int parent = cursor.getInt(cursor.getColumnIndex("parent"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            int type1 = cursor.getInt(cursor.getColumnIndex("type"));
            String firstName = cursor.getString(cursor.getColumnIndex("firstName"));
            regionInfo.setId(_id);
            regionInfo.setParent(parent);
            regionInfo.setName(name);
            regionInfo.setType(type1);
            regionInfo.setFirstName(firstName);
            regionInfos.add(regionInfo);
        }
        cursor.close();
        db.close();
        return regionInfos;
    }

    //通过类型来查找省或城市 1是省级 2是市级 3是县级
    public static List<RegionInfo> getProvencesOrCity(int type) {
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(DBManager.PATH, null);
        List<RegionInfo> regionInfos = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from regions where type = " + type, null);
        while (cursor.moveToNext()) {
            RegionInfo regionInfo = new RegionInfo();
            int _id = cursor.getInt(cursor.getColumnIndex("_id"));
            int parent = cursor.getInt(cursor.getColumnIndex("parent"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            int type1 = cursor.getInt(cursor.getColumnIndex("type"));
            String firstName = cursor.getString(cursor.getColumnIndex("firstName"));
            regionInfo.setId(_id);
            regionInfo.setParent(parent);
            regionInfo.setName(name);
            regionInfo.setType(type1);
            regionInfo.setFirstName(firstName);
            regionInfos.add(regionInfo);
        }
        cursor.close();
        db.close();
        return regionInfos;
    }

    //通过上一父级菜单来查找对应的城市信息
    public static List<RegionInfo> getProvencesOrCityOnParent(int parent) {
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(DBManager.PATH, null);
        List<RegionInfo> regionInfos = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from regions where parent = " + parent, null);
        while (cursor.moveToNext()) {
            RegionInfo regionInfo = new RegionInfo();
            int _id = cursor.getInt(cursor.getColumnIndex("_id"));
            int parent1 = cursor.getInt(cursor.getColumnIndex("parent"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            int type = cursor.getInt(cursor.getColumnIndex("type"));
            String firstName = cursor.getString(cursor.getColumnIndex("firstName"));
            regionInfo.setId(_id);
            regionInfo.setParent(parent1);
            regionInfo.setName(name);
            regionInfo.setType(type);
            regionInfo.setFirstName(firstName);
            regionInfos.add(regionInfo);
        }
        cursor.close();
        db.close();
        return regionInfos;
    }

    //城市信息的插入操作
    public static void insertRegion(SQLiteDatabase db, RegionInfo info) {
        ContentValues values = new ContentValues();
        values.put("parent", info.getParent());
        values.put("name", info.getName());
        values.put("type", info.getType());
        values.put("firstName", info.getFirstName());
        db.insert("regions", null, values);
    }

    //查询返回所有的城市信息
    public static List<RegionInfo> queryAllInfo() {
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(DBManager.PATH, null);
        List<RegionInfo> regionInfos = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from regions", null);
        while (cursor.moveToNext()) {
            RegionInfo regionInfo = new RegionInfo();
            int _id = cursor.getInt(cursor.getColumnIndex("_id"));
            int parent = cursor.getInt(cursor.getColumnIndex("parent"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            int type = cursor.getInt(cursor.getColumnIndex("type"));
            String firstName = cursor.getString(cursor.getColumnIndex("firstName"));
            regionInfo.setId(_id);
            regionInfo.setParent(parent);
            regionInfo.setName(name);
            regionInfo.setType(type);
            regionInfo.setFirstName(firstName);
            regionInfos.add(regionInfo);
        }
        cursor.close();
        db.close();
        return regionInfos;
    }

    //数据库的删除操作
    public static void deleteRegion(int _id, SQLiteDatabase db) {
        db.execSQL("delete from regions where _id = ?", new Object[]{_id});
    }
}
