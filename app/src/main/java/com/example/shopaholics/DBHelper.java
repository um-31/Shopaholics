package com.example.shopaholics;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "mydata.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE USER(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "NAME TEXT," +
                    "EMAIL TEXT," +
                    "PASSWORD TEXT," +
                    "CONFIRMPASSWORD TEXT )");

            db.execSQL("CREATE TABLE tCART (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "NAME TEXT," +
                    "QUANTITY INTEGER," +
                    "PRICE INTEGER,TOTAL INTEGER)");

            db.execSQL("CREATE TABLE USERINFO (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "FIRSTNAME TEXT,LASTNAME TEXT,ADDRESS TEXT,STATE TEXT,CITY TEXT,PIN TEXT)");

            db.execSQL("CREATE TABLE CARDDATA (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "CARDNO TEXT)");

            db.execSQL("CREATE TABLE PRODUCTS (ID INTEGER PRIMARY KEY AUTOINCREMENT,PRODUCTNAME TEXT," +
                    "PRODUCTPRICE TEXT,PRODUCTDESC TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS USER");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tCART");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS USERINFO");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS CARDDATA");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS PRODUCTS");

            onCreate(sqLiteDatabase);
    }
    public Cursor getListContents() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM tCart",null);
        return cursor;
    }
}
