package com.example.administrator.texiao_test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/22.
 */

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private ArrayList<String> strings;
    private TextView tv_name;

    public MainAdapter(Context context, ArrayList<String> strings) {
        this.context = context;
        this.strings = strings;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /*View view = LayoutInflater.from(context).inflate(R.layout.head_main, parent, false);
        return new NormaHolder(view);*/
        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.head_main, parent, false);
            return new ImgHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_text, parent, false);
            return new NormaHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
       /* NormaHolder normaHolder = (NormaHolder) holder;
        normaHolder.textView.setText(position);*/
        if (position == 0) {
            ImgHolder imageholder = (ImgHolder) holder;
            imageholder.imageView.setImageResource(R.mipmap.aa);
        } else {
            NormaHolder normaHolder = (NormaHolder) holder;
            normaHolder.textView.setText(strings.get(position - 1));
        }
    }

    @Override
    public int getItemCount() {
        return strings.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }


    }

     class NormaHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public NormaHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_text01);
        }
    }

    class ImgHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ImgHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_head);
        }
    }
}
