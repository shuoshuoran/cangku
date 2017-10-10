package com.example.administrator.recyclerview;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.sql.CommonDataSource;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_main;
    private Adapter adapter;
    private SwipeRefreshLayout srl_01;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_main = (RecyclerView) findViewById(R.id.rl_main);
        srl_01 = (SwipeRefreshLayout) findViewById(R.id.srl_01);


        final List<String> strings = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            strings.add("第" + i + "个");
        }
        adapter = new Adapter(this, strings);
        Log.e("--",strings.toString());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_main.setLayoutManager(linearLayoutManager);
        srl_01.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                strings.add(0,"这是刷新出来的数据！");
                adapter.notifyDataSetChanged();
               srl_01 .setRefreshing(false);


            }
        });


       /* GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        rv_main.setLayoutManager(gridLayoutManager);*/
        rv_main.setAdapter(adapter);

        rv_main.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

    }
}