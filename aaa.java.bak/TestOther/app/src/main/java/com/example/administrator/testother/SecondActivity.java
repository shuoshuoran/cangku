package com.example.administrator.testother;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/8/25.
 */

public class SecondActivity extends Activity implements View.OnClickListener {
    private final String TAG = "SecondActivity";
    private Button btn_third;
    private TextView tv_23;
    private TextView tv_58;
    private TextView tv_10000;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();


        tv_23 = (TextView) findViewById(R.id.tv_23);
        tv_58 = (TextView) findViewById(R.id.tv_58);
        tv_10000 = (TextView) findViewById(R.id.tv_10000);
        tv_23.setOnClickListener(this);
        tv_58.setOnClickListener(this);
        tv_10000.setOnClickListener(this);

        //String text = extras.getString("text");

        btn_third = (Button) findViewById(R.id.btn_third);

       // btn_third.setText(text);

        btn_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this,ThirdActivity.class));
            }
        });
        Log.e(TAG, "onCreate: " );
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: " );

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: " );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: " );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: " );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: " );
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: " );
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e(TAG, "onConfigurationChanged: " );
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.tv_23:
                Intent intent = new Intent();
                String s = tv_23.getText().toString();
                intent.putExtra("value", s);
                setResult(2, intent);
                finish();


                break;
            case R.id.tv_58:
                Intent intent2 = new Intent();
                String s2 = tv_58.getText().toString();
                intent2.putExtra("value", s2);
                setResult(2, intent2);
                finish();

                break;
            case R.id.tv_10000:

                Intent intent3 = new Intent();
                String s3 = tv_10000.getText().toString();
                intent3.putExtra("value", s3);
                setResult(2, intent3);
                finish();

                break;
        }

    }
}
