package com.example.administrator.myapplication;

        import android.database.sqlite.SQLiteDatabase;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_name;
    private EditText et_age;
    private RadioGroup rg_sex;
    private RadioButton rb_man;
    private  RadioButton rb_woman;
    private Button bt_login;
    private  DB_test db;
    private Button bt_delet;
    private Button bt_find;
    private  Button bt_modify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name=(EditText) findViewById(R.id.et_name);
        et_age = (EditText) findViewById(R.id.et_age);
        rg_sex = (RadioGroup) findViewById(R.id.rg_sex);
        rb_man = (RadioButton) findViewById(R.id.rb_man);
        rb_woman = (RadioButton) findViewById(R.id.rb_woman);
        bt_login = (Button) findViewById(R.id.bt_login);
        bt_delet= (Button) findViewById(R.id.bt_delet);
        bt_find = (Button) findViewById(R.id.bt_find);
        bt_modify = (Button) findViewById(R.id.bt_modify);
        bt_login.setOnClickListener(this);
        db = new DB_test(this);
        bt_find.setOnClickListener(this);
        bt_delet.setOnClickListener(this);
        bt_modify.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_login:
                login();
                break;
            case R.id.bt_delet:
                delet();
                break;
            case R.id.bt_find:
                find();
                break;
            case R.id.bt_modify:
                modify();
                break;
        }
    }

    private void modify() {
        
    }

    private void find() {

    }

    private void delet() {

    }

    private void login() {
        String name=et_name.getText().toString().trim();
        int age= Integer.parseInt(et_age.getText().toString().trim());
        int id=rg_sex.getCheckedRadioButtonId();
        String sex="nan";
        switch (id) {
            case R.id.rb_man:
                sex = "nan";
                break;
            case R.id.rb_woman:
                sex = "nv";

                break;
        }
        student st = new student();
        st.name=name;
        st.age=age;
        st.sex=sex;
        student_Dao sd=new student_Dao();
        SQLiteDatabase database=db.getWritableDatabase();
        sd.addStu(st,database);


    }
}
