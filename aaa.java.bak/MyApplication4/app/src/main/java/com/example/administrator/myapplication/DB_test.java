package com.example.administrator.myapplication;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Administrator on 2017/8/22.
 */

public class DB_test extends SQLiteOpenHelper {
    private static final String TAG = "DB_test";

    public DB_test(Context context) {
        this(context, "aa", null, 1);
    }

    public DB_test(Context context, String name, SQLiteDatabase.CursorFactory factor, int version) {
        this(context, name, factor, version, null);
    }

    public DB_test(Context context, String name, SQLiteDatabase.CursorFactory factor, int version, DatabaseErrorHandler errorhandler) {
        super(context, "db_test", null, 1, errorhandler);
    }
    @Override
    public void onCreate(SQLiteDatabase sqlLiteDatebase) {
        sqlLiteDatebase.execSQL("create table student(_id integer primary key autoincrement,name verchar(10),age integer,sex verchar(10))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e(TAG,"onUpgrate:");
    }

  
}


