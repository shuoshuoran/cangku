package com.example.administrator.listview;

import android.content.Context;
import android.content.IntentFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2017/9/8.
 */

class MyBaseadapter extends BaseAdapter{
    private static final int[] DATE = null;
    private Context context;
    private ArrayList<GoodsCarBeen>list;

    public MyBaseadapter(Context context, ArrayList<GoodsCarBeen> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public  View getView(int position, View convertView, ViewGroup parent) {
      /*  View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false1);
        TextView tv = (TextView) view.findViewById(R.id.tv_name);
        tv.setText(list.get(position));

        ViewHolder holder = null;
        if (convertView == null) {


            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false1);
            holder = new ViewHolder();
            holder.textView = (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(holder);


        }
        if (convertView == null) {
            holder = (ViewHolder) convertView.getTag();
            holder.textView.getText();
            holder.textView.setText(list.get(position));
        }*/

        final GoodsCarBeen goodsCarBeen = list.get(position);

        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item3, parent, false);
            holder.textView = (TextView) convertView.findViewById(R.id.tv_03);
            holder.isChecked = (CheckBox) convertView.findViewById(R.id.cb_box);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.isChecked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                goodsCarBeen.isChecked = isChecked;
                notifyDataSetChanged();
            }
        });
        holder.textView.setText(goodsCarBeen.name);
        holder.isChecked.setChecked(goodsCarBeen.isChecked);
        return convertView;
    }

}