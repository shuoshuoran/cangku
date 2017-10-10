package com.example.administrator.testother;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private Button btn_go;
    private EditText et_01;
    private TextView tv_02;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_01 = (EditText) findViewById(R.id.et_01);
        tv_02 = (TextView) findViewById(R.id.tv_02);

        btn_go = (Button) findViewById(R.id.btn_go);
        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //意图
                //显式意图     隐式意图
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent,1);


               /* String text = et_01.getText().toString().trim();

                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("text", text);
                intent.putExtras(bundle);
                startActivity(intent);*/

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {

            case 1:

                if(data!=null){
                    String value = data.getStringExtra("value");
                    tv_02.setText(value);
                }


                break;

        }
    }
}
