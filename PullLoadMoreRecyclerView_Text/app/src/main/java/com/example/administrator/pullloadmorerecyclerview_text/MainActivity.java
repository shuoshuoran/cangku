package com.example.administrator.pullloadmorerecyclerview_text;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private PullLoadMoreRecyclerView plm;
    private ArrayList<String> strings;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plm = (PullLoadMoreRecyclerView) findViewById(R.id.plm);
        strings = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        for (int i = 0; i < strings.size(); i++) {
            strings.add(i + "");
        }
        plm.setLayoutManager(linearLayoutManager);
        plm.setAdapter(new RVAdapter_Main(this,strings));
    }
}
