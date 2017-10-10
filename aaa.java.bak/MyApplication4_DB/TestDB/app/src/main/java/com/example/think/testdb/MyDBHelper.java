package com.example.think.testdb;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by think on 2017/8/21.
 */

public class MyDBHelper extends SQLiteOpenHelper {
    private static final String TAG ="MyDBHelper" ;

    public MyDBHelper(Context context){
        this(context,"aa",null,1);

    }

    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        this(context, name, factory, version,null);
    }

    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, "test.db", null, 1, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
              sqLiteDatabase.execSQL("create table student(_id integer primary key autoincrement ,name varchar(20),age integer,sex varchar(20))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.e(TAG, "onUpgrade: ");
                


    }
}
