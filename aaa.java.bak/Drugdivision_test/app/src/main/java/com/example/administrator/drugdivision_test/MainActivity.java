package com.example.administrator.drugdivision_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.drugdivision_test.JsonBean.CategoryHomeBean;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rl_main;
    private List<CategoryHomeBean.DataBean> list;
    private Adapter adpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rl_main = (RecyclerView) findViewById(R.id.rl_main);

        initDate();

    }

    private void initDate() {
        list = new ArrayList<>();


        OkHttpUtils
                .get()
                .url("http://app.chnddk.com/index.php?m=goods&c=app&a=category_list")
                .addParams("parent_id","0")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(MainActivity.this,"请求失败",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Gson gson = new Gson();
                        CategoryHomeBean categoryHomeBean = gson.fromJson(response, CategoryHomeBean.class);
                        int code = categoryHomeBean.getCode();
                        String msg = categoryHomeBean.getMsg();
                        if(code != 200){
                            Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
                        }else{
                            List<CategoryHomeBean.DataBean> data = categoryHomeBean.getData();
                            list.addAll(data);
//                            adpter.notifyDataSetChanged();
                            GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
                            rl_main.setLayoutManager(gridLayoutManager);
                            rl_main.setAdapter(adpter =new Adapter(MainActivity.this,list));
                        }
                    }
                });


       /* Integer[] integers = {R.mipmap.aa, R.mipmap.bb, R.mipmap.cc, R.mipmap.dd, R.mipmap.ee};*/

    }
}

