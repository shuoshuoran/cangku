package com.example.administrator.myapplication;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Administrator on 2017/8/22.
 */

public class student_Dao {
    public void addStu(student st, SQLiteDatabase datebase){
        datebase.execSQL("insert into student(name,age,sex)values('"+st.name+"',"+st.age+",'"+st.sex+"')");
    }
    public void deletStu(student st,SQLiteDatabase database){
        database.execSQL("delete from student where name='"+st.name+"'");
    }
    public void modifyStu(student st,SQLiteDatabase database){
        database.execSQL("update student set age=50 where name='"+st.name+"'");
    }

}
