package com.example.administrator.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lv_item;
    private ArrayList<GoodsCarBeen>list;
    private MyBaseadapter myBaseadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_item = (ListView) findViewById(R.id.lv_item);
        list = new ArrayList<>();
        /*for (int i = 0; i < 33; i++) {
            list.add("测试数据"+i);
        }*/
        for (int i = 0; i < 33; i++) {
            GoodsCarBeen gcb = new GoodsCarBeen();
            gcb.name = "商品" + i;


        if (i%4==0) {
            gcb.isChecked = true;

        }
            list.add(gcb);


    }

        myBaseadapter=new MyBaseadapter(this,list);
        lv_item.setAdapter(myBaseadapter);
    }
}
