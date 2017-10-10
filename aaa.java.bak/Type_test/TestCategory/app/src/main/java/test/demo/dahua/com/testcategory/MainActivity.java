package test.demo.dahua.com.testcategory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import test.demo.dahua.com.testcategory.adapter.MainLVAdapter;
import test.demo.dahua.com.testcategory.bean.CategoryBean;
import test.demo.dahua.com.testcategory.view.MyListView;

public class MainActivity extends AppCompatActivity {
    private ListView lv_01;
    private CategoryBean categoryBean;
    private MainLVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoryBean = new CategoryBean();
        categoryBean.url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505220544227&di=a43d2e9a5277665c023ffd67756076ee&imgtype=jpg&src=http%3A%2F%2Fimg2.imgtn.bdimg.com%2Fit%2Fu%3D1603772297%2C3742832012%26fm%3D214%26gp%3D0.jpg";

        ArrayList<String> names = new ArrayList<>();
        for(int i=0;i<40;i++){
            names.add("测试数据" + i);

        }
        categoryBean.names = names;

        adapter = new MainLVAdapter(this, categoryBean);



        lv_01 = (ListView) findViewById(R.id.lv_01);
        lv_01.setAdapter(adapter);
//        Utility.setListViewHeightBasedOnChildren(lv_01);


    }
}
