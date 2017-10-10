package com.example.administrator.eventbus_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button bt_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_main = (Button) findViewById(R.id.bt_main);
        bt_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(String.valueOf(getApplicationContext()));
//                SecoundActivity.class;
//                StartActivity(intent);
            }
        });
    }
}
