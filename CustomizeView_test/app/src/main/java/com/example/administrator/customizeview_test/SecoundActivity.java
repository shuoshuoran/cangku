package com.example.administrator.customizeview_test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Administrator on 2017/9/26.
 */

public class SecoundActivity extends AppCompatActivity {
    private static final String TAG ="SecoundActivity" ;
    private SecoundView se_view;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secound_view);

        se_view = (SecoundView) findViewById(R.id.se_view);
        se_view.setOnStateChangeListenner(new SecoundView.onStateChangeListenner() {
            @Override
            public void ststeChange(SecoundView.State state) {
                Log.e(TAG, "ststeChange: ");
            }
        });


    }
}
