package com.example.administrator.shoping_car_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.shoping_car_listview.bean.Goodsbean;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lv_01;
    private ImageView iv_select_all;
    private TextView tv_price;
    private boolean isChecked;
    private MyAdapter myAdapter;
    private ArrayList<Goodsbean> goods;
    private ImageView iv_select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_01 = (ListView) findViewById(R.id.lv_01);
        iv_select_all = (ImageView) findViewById(R.id.iv_select_all);
        tv_price = (TextView) findViewById(R.id.tv_price);

        goods = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Goodsbean gd=new Goodsbean();
            gd.name = "名字" + i;
            gd.price = (i + 10) + "";
            if (i % 4 == 0) {
                gd.isChecked = true;
            } else {
                gd.isChecked = false;
            }
            goods.add(gd);
        }
        myAdapter = new MyAdapter(this, goods);

        lv_01.setAdapter(myAdapter);
        iv_select_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isChecked) {
                    for (Goodsbean gd :goods) {
                        gd.isChecked = false;
                    }
                    myAdapter.notifyDataSetChanged();
                } else {
                    for (Goodsbean gd : goods) {
                        gd.isChecked = true;
                    }myAdapter.notifyDataSetChanged();
                }
                isChecked = !isChecked;
                setToatalPrice(goods);
            }


        });
    }

    public void setToatalPrice(ArrayList<Goodsbean> goods) {
        int toatalPrice=0;
        int toatalChecked=0;
        for (Goodsbean gd : goods) {
            if (gd.isChecked) {
                int price = Integer.parseInt(gd.price);
                toatalPrice +=price;
                toatalChecked++;
            }
        }
        tv_price.setText(toatalPrice + "");
        if (toatalChecked == goods.size()) {
            iv_select_all.setImageResource(R.mipmap.aa);
        } else {
            iv_select_all.setImageResource(R.mipmap.bb);
        }
    }
}
