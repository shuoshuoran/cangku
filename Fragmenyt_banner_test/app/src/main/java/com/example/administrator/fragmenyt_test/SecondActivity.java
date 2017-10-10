package com.example.administrator.fragmenyt_test;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.fragmenyt_test.adapter.Adapter_VP_scActivity;
import com.example.administrator.fragmenyt_test.util.DPPXUtil;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/20.
 */

public class SecondActivity extends AppCompatActivity {
    private RelativeLayout rl_home;
    private ViewPager vp_head;
    private RelativeLayout rl_first;
    private LinearLayout ll_first;
    private ArrayList<String> list;
    private int dp_10;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ll_first = (LinearLayout) findViewById(R.id.ll_first);
        int dp_10 = DPPXUtil.dp2px(this, 10);

        list = new ArrayList<>();
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1506492108&di=d28252edd6da18f663a75264dd93ce78&imgtype=jpg&er=1&src=http%3A%2F%2Ff6.topitme.com%2F6%2F46%2F98%2F11224838230bc98466o.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505897268979&di=f116de452beb7843b9c4b47a791cb8d7&imgtype=0&src=http%3A%2F%2Fimg17.3lian.com%2F201612%2F10%2F6ab76aaeeb2e190bd37a4f80c9dedfb0.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505897268978&di=e03cb7e67f8d8436933ee729dacd4ae4&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F1%2F590d97c86f464.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505897268977&di=3351c2732786907cd258eceb8638cf16&imgtype=0&src=http%3A%2F%2Fwww.pp3.cn%2Fuploads%2Fallimg%2Fc040111%2F10IK31M10060-3S93.jpg");
        vp_head = (ViewPager) findViewById(R.id.vp_head);
        Adapter_VP_scActivity vpAdapter = new Adapter_VP_scActivity(this, list);
        vp_head.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            changeCircle(position);
            }



            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        for (int i = 0; i < list.size(); i++) {
            ImageView iv = new ImageView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dp_10, dp_10);
            layoutParams.leftMargin=dp_10*2;
            iv.setLayoutParams(layoutParams);
            iv.setBackgroundColor(Color.parseColor("#ff0000"));
            ll_first.addView(iv);

        }
        vp_head.setAdapter(vpAdapter);
        changeCircle(0);
    }

    private void changeCircle(int pos) {
        for (int i = 0; i < list.size(); i++) {
            ImageView iv = (ImageView) ll_first.getChildAt(i);
            if (i == pos) {
                iv.setBackgroundColor(Color.parseColor("#550000ff"));
            } else {
                iv.setBackgroundColor(Color.parseColor("#3300ff00"));
            }
        }
    }
}
