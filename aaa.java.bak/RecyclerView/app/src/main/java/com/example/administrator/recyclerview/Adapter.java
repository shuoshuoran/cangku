package com.example.administrator.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/9/13.
 */

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<String> strings;
    private Context mycontext;
    private int TEST_VIEW_1=0;
    private int TEST_VIEW_2=1;
    private int TEST_VIEW_3=2;
    private int TEST_VIEW_4=3;



    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TEST_VIEW_1;
        } else if (position == 1) {
            return TEST_VIEW_2;
        } else if (position == 2) {
            return TEST_VIEW_3;
        } else {
            return TEST_VIEW_4;
        }


    }

    public Adapter(Context context, List<String> String) {
        this.strings = String;
        this.mycontext=context;
    }


    @Override
    public RecyclerView.ViewHolder  onCreateViewHolder(ViewGroup parent, int viewType) {
       /* View view = View.inflate(mycontext, R.layout.item, null);
        return new NormaHolder(view);*/
        if (viewType == TEST_VIEW_1) {
            View view = View.inflate(mycontext, R.layout.item, null);
            return new FirstHolder(view);
        } else if (viewType == TEST_VIEW_2) {
            View view = View.inflate(mycontext, R.layout.twoitem, null);
            return new SecondHolder(view);
        } else if (viewType == TEST_VIEW_3) {
            View view = View.inflate(mycontext, R.layout.threeitem, null);
            return new ThreedHolder(view);
        } else {
            View view = View.inflate(mycontext,R.layout.fouritem, null);
            return new FourHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        if(position>=3){
            FourHolder fourHolder = (FourHolder) holder;
            fourHolder.textView.setText(strings.get(position-3));
        }


    }

    @Override
    public int getItemCount() {
        return strings.size()+3;
    }

    private static class NormaHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public NormaHolder(View itemView){
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_item);

        }
    }

    private class FirstHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public FirstHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_item);

        }
    }

    private class SecondHolder extends RecyclerView.ViewHolder {
        ImageView myImageView;
        public SecondHolder(View itemView) {
            super(itemView);
            myImageView = (ImageView) itemView.findViewById(R.id.iv_show);
        }
    }

    private class ThreedHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        public ThreedHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_three);
            imageView = (ImageView) itemView.findViewById(R.id.iv_three);
        }
    }

    private class FourHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public FourHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_four);
        }
    }
}
