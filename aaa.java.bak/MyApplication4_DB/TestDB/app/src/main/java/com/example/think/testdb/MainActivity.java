package com.example.think.testdb;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText et_uname;
    private EditText et_age;
    private RadioGroup rg_sex;
    private Button btn_save;
    private MyDBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_uname = (EditText) findViewById(R.id.et_uname);
        et_age = (EditText) findViewById(R.id.et_age);
        rg_sex = (RadioGroup) findViewById(R.id.rg_sex);
        btn_save = (Button) findViewById(R.id.btn_save);
        btn_save.setOnClickListener(this);
        helper=new MyDBHelper(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_save:
                save();
                break;
        }

    }

    //保存按钮的点击事件
    private void save() {

        String uname = et_uname.getText().toString().trim();
        int age = Integer.parseInt(et_age.getText().toString().trim());
        int id=rg_sex.getCheckedRadioButtonId();
        String sex="nan";
        switch (id) {
            case R.id.rb_male:
                sex="nan";

                break;
            case R.id.rb_remale:
                sex="nv";

                break;
        }

        Student stu=new Student();
        stu.name=uname;
        stu.age=age;
        stu.sex=sex;
        StudentDao sd=new StudentDao();
        SQLiteDatabase database = helper.getWritableDatabase();
        sd.addStu(stu,database);


    }
}