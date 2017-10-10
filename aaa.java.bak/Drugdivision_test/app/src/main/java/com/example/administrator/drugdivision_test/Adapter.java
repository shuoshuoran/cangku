package com.example.administrator.drugdivision_test;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.drugdivision_test.JsonBean.CategoryHomeBean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */

class Adapter extends RecyclerView.Adapter<Adapter.MyViewHoeder> {

    private List<CategoryHomeBean.DataBean> dataBeen;
    private Context context;

    public Adapter(Context context, List<CategoryHomeBean.DataBean> dataBeen) {
        this.context=context;
        this.dataBeen=dataBeen;
    }

    @Override
    public MyViewHoeder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHoeder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHoeder holder, int position) {
        holder.text.setText(dataBeen.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return dataBeen.size();
    }

    class MyViewHoeder extends RecyclerView.ViewHolder{

        private final ImageView imageView;
        private final TextView text;

        public MyViewHoeder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_image);
            text = (TextView) itemView.findViewById(R.id.tv_text);
        }
    }

   /* @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate( R.layout.item, null);
        return new NormaHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        NormaHolder normaHolder = (NormaHolder) holder;
      *//*  normaHolder.imageView.setBackgroundResource(integer[position]);
        switch (position) {
            case 0:

            normaHolder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mcontext, SecondActivity.class);
                    mcontext.startActivity(intent);

                }
            });
            break;
        }*//*
    }

    @Override
    public int getItemCount() {
        return dataBeen.size();
    }

    public class NormaHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public NormaHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_image);

        }
    }*/
}
