package com.example.administrator.fragmenyt_test;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rg_all;
    private View fl_home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg_all = (RadioGroup) findViewById(R.id.rg_all);
        fl_home = findViewById(R.id.fl_home);

        rg_all.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rg_all:
                        break;
                    case R.id.bt_first:
                        clickHome();
                        break;
                    case R.id.bt_app:
                        break;
                    case R.id.bt_manage:
                        break;
                    case R.id.bt_hot:
                        break;
                }
            }

            private void clickHome() {
                FragmentManager fragmentManager=getFragmentManager();
                android.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fl_replace, new secondFragment());
                fragmentTransaction.commit();
            }
        });

    }
}
