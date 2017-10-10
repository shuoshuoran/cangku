package com.example.administrator.drugdivision_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/16.
 */

public class SecondActivity extends AppCompatActivity {
    private RecyclerView rv_01;
    private SecondAdapter secondAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item2);

        rv_01 = (RecyclerView) findViewById(R.id.rv_01);
        List<String> Strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Strings.add("第" + i + "个");
        }
        secondAdapter = new SecondAdapter(this, Strings);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_01.setLayoutManager(linearLayoutManager);
        rv_01.setAdapter(secondAdapter);
    }
}
