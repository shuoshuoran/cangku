package com.example.administrator.viewgroup_text;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MyLayout ml_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ml_main = (MyLayout) findViewById(R.id.ml_mian);
        ml_main.setMar(40);
        ml_main.setVer(20);
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            strings.add("" + i);
            TextView textView = new TextView(this);
            textView.setText("第"+i);
            ml_main.addView(textView);
            ml_main.setOnDatelistnner(new MyLayout.OnDatelistnner() {
                @Override
                public void Date(int i) {

                }
            });
        }

    }
}
