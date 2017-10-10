package com.example.think.testdb;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by think on 2017/8/21.
 */

public class StudentDao {

    public void addStu(Student stu, SQLiteDatabase database){
     database.execSQL("insert into student(name,age,sex) values('"+stu.name+"',"+stu.age+",'"+stu.sex+"')");

    }


}
