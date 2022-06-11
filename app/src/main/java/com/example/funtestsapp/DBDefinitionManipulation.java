package com.example.funtestsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class DBDefinitionManipulation {
    private static final String DB_NAME="topic.db";
    private static final String DB_TABLE="topicinfo";
    private static final int DB_VERSION = 1;

    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_NUM = "num";

    private SQLiteDatabase db;
    private final Context context;

    public DBDefinitionManipulation(Context _context) {
        context = _context;
    }

    /** Close the database */
    public void close() {
        if (db != null){
            db.close();
            db = null;
        }
    }

    /** Open the database */
    public void open() throws SQLiteException {
        DBOpenHelper dbOpenHelper = new DBOpenHelper(context, DB_NAME, null, DB_VERSION);
        try {
            db = dbOpenHelper.getWritableDatabase();
        }
        catch (SQLiteException ex) {
            db = dbOpenHelper.getReadableDatabase();
        }
    }
    public long insert(Topic topic) {
        ContentValues newValues = new ContentValues();
        newValues.put(KEY_NAME, topic.name);
        newValues.put(KEY_NUM, topic.num);
        return db.insert(DB_TABLE, null, newValues);
    }


    public Topic[] queryAllData() {
        Cursor results =  db.query(DB_TABLE, new String[] { KEY_ID, KEY_NAME, KEY_NUM},
                null, null, null, null, null);
        return ConvertToTopic(results);
    }

    public Topic[] queryOneData(long id) {
        Cursor results =  db.query(DB_TABLE, new String[] { KEY_ID, KEY_NAME, KEY_NUM},
                KEY_ID + "=" + id, null, null, null, null);
        return ConvertToTopic(results);
    }

    private Topic[] ConvertToTopic(Cursor cursor){
        int resultCounts = cursor.getCount();
        if (resultCounts == 0 || !cursor.moveToFirst()){
            return null;
        }
        Topic[] topics = new Topic[resultCounts];
        for (int i = 0 ; i<resultCounts; i++){
            topics[i] = new Topic();
            topics[i].id = cursor.getInt(0);
            topics[i].name = cursor.getString(cursor.getColumnIndex(KEY_NAME));
            topics[i].num = cursor.getString(cursor.getColumnIndex(KEY_NUM));
            cursor.moveToNext();
        }
        return topics;
    }

    public long deleteOneData(long id) {
        return db.delete(DB_TABLE,  KEY_ID + "=" + id, null);
    }

    public long updateOneData(long id , Topic topic){
        ContentValues updateValues = new ContentValues();
        updateValues.put(KEY_NAME, topic.name);
        updateValues.put(KEY_NUM, topic.num);
        return db.update(DB_TABLE, updateValues,  KEY_ID + "=" + id, null);
    }

    /** 静态Helper类，用于建立、更新和打开数据库*/
    private static class DBOpenHelper extends SQLiteOpenHelper {

        public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        private static final String DB_CREATE = "create table " +
                DB_TABLE + " (" + KEY_ID + " integer primary key autoincrement, " +
                KEY_NAME+ " text not null, " + KEY_NUM+ " integer);";

        @Override
        public void onCreate(SQLiteDatabase _db) {
            _db.execSQL(DB_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion) {
            _db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
            onCreate(_db);
        }
    }
}
