package com.example.administrator.customizeview_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
//    private static final String TAG ="MainActivity" ;
     private CustomTitleView ctv_main;
     public static final String TAG ="MainActivity" ;

//    private SecoundView secoundView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* secoundView = (SecoundView) findViewById(R.id.se_view);
        secoundView.setOnStateChangeListenner(new SecoundView.onStateChangeListenner() {
            @Override
            public void ststeChange(SecoundView.State state) {
                Log.e(TAG, "ststeChange: ");
            }
        });*/

        ctv_main = (CustomTitleView) findViewById(R.id.ctv_main);


        ctv_main.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick:");
            }
        });
            ctv_main.setOnCustTitleViewListenner(new CustomTitleView.CustomTitleViewListenner() {
                @Override
                public void custom(int time) {
                    Log.e(TAG, "custom:" + time);
                }
            });
    }
    }

