package com.example.administrator.texiao_test;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private LinearLayout ll_head;
    private ArrayList<String> list;
    private RecyclerView rv_main;
    private MainAdapter adapter;
    private int num;
    private int untilDP;
    private int count;
    private int sum;
    private float util;
    private TextView tv_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll_head = (LinearLayout) findViewById(R.id.ll_head);
        rv_main = (RecyclerView) findViewById(R.id.rv_main);
        tv_name = (TextView) findViewById(R.id.tv_name);


        list=new  ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("第" + i + "个");
        }

        num=getStatuHeight(this);
        untilDP=PxToDp.px2dp(this, num);
        rv_main.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                count = 190 - untilDP - 50;
                PxToDp.px2dp(MainActivity.this, count);
                sum += dy;
                util = (float) sum / (float) count;
                if (util >= 1.0) {
                    util = 1.0f;
                }
                ll_head.getBackground().setAlpha((int) (util * 255));
                tv_name.setTextColor(Color.argb((int)(util*255),255,255,0));
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_main.setLayoutManager(layoutManager);
        adapter = new MainAdapter(this, list);
        rv_main.setAdapter(adapter);

    }

    private int getStatuHeight(Context context) {
        int result=0;
        int resultId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resultId> 0) {
            result = context.getResources().getDimensionPixelSize(resultId);
        }

        return result;
    }

}

