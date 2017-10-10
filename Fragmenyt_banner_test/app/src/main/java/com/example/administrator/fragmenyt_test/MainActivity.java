package com.example.administrator.fragmenyt_test;

import android.app.FragmentManager;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrator.fragmenyt_test.MyFrament.HomeFrament;
import com.example.administrator.fragmenyt_test.MyFrament.MyFrament;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rg_all;
    private View fl_home;
    private RadioButton bt_first;
    private TextView tv_info;
    private MyFrament myFrament;
    private HomeFrament homeFrament;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg_all = (RadioGroup) findViewById(R.id.rg_all);
        fl_home = findViewById(R.id.fl_home);
        bt_first = (RadioButton) findViewById(R.id.bt_first);
        tv_info = (TextView) findViewById(R.id.tv_info);


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
                        clickHot();
                        break;
                }
            }

            private void clickHot() {
                FragmentManager fragmentManager=getFragmentManager();
                android.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                if (myFrament == null) {
                    myFrament = new MyFrament();
                    transaction.add(R.id.fl_home,myFrament);
                }
                if (homeFrament!= null) {
                    transaction.hide(homeFrament);
                }
                transaction.show(myFrament);
                transaction.commit();
            }

            private void clickHome() {
                FragmentManager fragmentManager=getFragmentManager();
                android.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

                SecondFragment secondfragment=new SecondFragment();
                secondfragment.setOnButtonClickListenner(new SecondFragment.OnButtonClickListenner() {
                    @Override
                    public void buttonClick(int num) {
                        tv_info.setText(num+"");

                    }
                });

                Bundle bundle = new Bundle();
                bundle.putString("str","dahua");
                secondfragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fl_home, secondfragment);
                fragmentTransaction.commit();

            }
        });

    }


    public void setFragmentText(String info) {
        if (homeFrament == null) {
            return;
        }
        homeFrament.setFragmentText(info);
    }

    public void setText(String info) {
        tv_info.setText(info);
    }
}
