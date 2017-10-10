package com.example.administrator.eventbus_test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2017/9/29.
 */
public class SecoundActivity extends Activity {
    private Button bt_secound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bt_secound = (Button) findViewById(R.id.bt_secound);
        bt_secound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
