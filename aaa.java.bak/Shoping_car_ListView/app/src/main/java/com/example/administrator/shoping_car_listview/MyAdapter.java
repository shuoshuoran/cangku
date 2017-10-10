package com.example.administrator.shoping_car_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.shoping_car_listview.bean.Goodsbean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/12.
 */

class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Goodsbean> goods;
    OnDataChangeListnnner onDateChanggeListnnner;
    public void setOnDataChangeListnnner(OnDataChangeListnnner onDateChanggeListnnner){
        this.onDateChanggeListnnner = onDateChanggeListnnner;
    }
    interface OnDataChangeListnnner {

        void dateChange(ArrayList<Goodsbean> goods);
    }
    public MyAdapter(Context context,ArrayList<Goodsbean>goods){
        this.context=context;
        this.goods=goods;
    }


    @Override

    public int getCount() {
        return goods.size();
    }

    @Override
    public Object getItem(int position) {
        return goods.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Goodsbean bean=goods.get(position);
        final MyViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
            holder = new MyViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (MyViewHolder) convertView.getTag();
        }
        holder.iv_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bean.isChecked) {
                    holder.iv_select.setImageResource(R.mipmap.bb);
                } else {
                    holder.iv_select.setImageResource(R.mipmap.aa);
                }
                bean.isChecked = !bean.isChecked;
                if (onDateChanggeListnnner != null) {
                    onDateChanggeListnnner.dateChange(goods);
                }
            }
        });
        if (bean.isChecked) {
            holder.iv_select.setImageResource(R.mipmap.aa);
        } else {
            holder.iv_select.setImageResource(R.mipmap.bb);
        }
        holder.tv_name.setText(bean.name);
        holder.tv_price.setText(bean.price);
        return convertView;
    }




    class MyViewHolder {
        ImageView iv_select;
        TextView tv_name;
        TextView tv_price;


        public MyViewHolder(View view) {
            iv_select = (ImageView) view.findViewById(R.id.iv_select);
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_price = (TextView) view.findViewById(R.id.tv_price);
        }
    }
}