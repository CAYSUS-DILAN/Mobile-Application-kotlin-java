package com.example.dbhelper;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "userdb.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "usertable";


    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_NO = "mobile";
    private static final String COLUMN_DOB = "dob";
    private static final String COLUMN_CITY = "address";


    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = " CREATE TABLE " + TABLE_NAME + " ( " + COLUMN_NAME + " TEXT," + COLUMN_NO + " TEXT," + COLUMN_DOB + " TEXT," + COLUMN_CITY + " TEXT)";
        db.execSQL(CREATE_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists usertable");
    }


    public boolean insertdata(String name, String mobile, String dob, String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_NO, mobile);
        values.put(COLUMN_DOB, dob);
        values.put(COLUMN_CITY, address);
        long result = db.insert(TABLE_NAME, null, values);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor getdata() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM usertable", null);
        return cursor;
    }
}
