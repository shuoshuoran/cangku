package sun.com.netease.muchviewtoger;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import sun.com.netease.muchviewtoger.Adapters.MainAdapter;
import sun.com.netease.muchviewtoger.PxToDp.PxToDp;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycle_01;
    private LinearLayout line_01;
    private ArrayList<String> list;
    private int count;
    private int sum;
    private float util;
    private int utildp;
    private int leijia;
    private TextView text_01;





    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycle_01 = (RecyclerView) findViewById(R.id.recycle_01);
        line_01 = (LinearLayout) findViewById(R.id.line_01);
        text_01 = (TextView) findViewById(R.id.text_01);


        list = new ArrayList<>();
        for (int i = 0 ; i <20;i++) {
            list.add("测试数据"+i);
        }

        sum = getStatusBarHeight(this);
        utildp = PxToDp.px2dp(this, sum);

        recycle_01.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                count = 190 - utildp - 45;
                PxToDp.dp2px(MainActivity.this,count);
                leijia += dy;

                util = (float)leijia / (float)count;

                if (util >= 1.0) {
                    util = 1.0f;
                }
                line_01.getBackground().setAlpha((int)(util*255));
                text_01.setTextColor(Color.argb((int)(util*255),255,255,0));

                //line_01.setBackgroundColor(Color.argb(255, 0, 255, 0));

            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycle_01.setLayoutManager(layoutManager);
        MainAdapter mainAdapter = new MainAdapter(this, list);
        recycle_01.setAdapter(mainAdapter);

    }



    private int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
