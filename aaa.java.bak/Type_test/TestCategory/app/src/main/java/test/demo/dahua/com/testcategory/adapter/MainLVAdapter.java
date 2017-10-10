package test.demo.dahua.com.testcategory.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import test.demo.dahua.com.testcategory.GlideApp;
import test.demo.dahua.com.testcategory.R;
import test.demo.dahua.com.testcategory.Utility;
import test.demo.dahua.com.testcategory.bean.CategoryBean;
import test.demo.dahua.com.testcategory.view.MyListView;

/**
 * Created by dragon on 2017/9/12.
 */

public class MainLVAdapter extends BaseAdapter {
    private Context context;
    private CategoryBean categoryBean;


    public MainLVAdapter(Context context, CategoryBean categoryBean) {
        this.context = context;
        this.categoryBean = categoryBean;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Object getItem(int position) {
        if(position==0){
            return categoryBean.url;
        }else{
            return categoryBean.names;
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int itemViewType = getItemViewType(position);
        ImgHolder imgHolder;
        ListHolder listHolder;
        switch (itemViewType) {

            case 0:
                if(convertView==null){
                    convertView = LayoutInflater.from(context).inflate(R.layout.img, null);
                    imgHolder = new ImgHolder(convertView);
                    convertView.setTag(imgHolder);


                }else{
                    imgHolder = (ImgHolder) convertView.getTag();

                }
                GlideApp.with(context).load(categoryBean.url).placeholder(R.mipmap.loading).error(R.mipmap.error)
                        .into(imgHolder.iv_01);
                return convertView;


            case 1:
                if(convertView==null){
                    convertView = LayoutInflater.from(context).inflate(R.layout.list, null);
                    listHolder = new ListHolder(convertView);
                    convertView.setTag(listHolder);

                }else {
                    listHolder = (ListHolder) convertView.getTag();

                }
                MianLVAdapterAdapter adapterAdapter = new MianLVAdapterAdapter(context, categoryBean.names);

                listHolder.lv_item.setAdapter(adapterAdapter);
                Utility.setListViewHeightBasedOnChildren(listHolder.lv_item);
                return convertView;

        }


        return null;



    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return 0;
        }else {
            return 1;
        }

    }



    class ImgHolder {
        ImageView iv_01;
        public ImgHolder(View itemView){
            iv_01 = (ImageView) itemView.findViewById(R.id.iv_01);
        }
    }


    class ListHolder{
        ListView lv_item;

        public ListHolder(View itemView) {
            lv_item = (ListView) itemView.findViewById(R.id.lv_item);

        }
    }
}
