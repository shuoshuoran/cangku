package com.example.administrator.drugdivision_test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/9/16.
 */

public class SecondAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<String> lists;
    private Context mcontext;

    public SecondAdapter(Context context, List<String> lists) {
        this.mcontext=context;
        this.lists=lists;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mcontext, R.layout.item3, null);
        return new NormaHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        NormaHolder normaHolder = (NormaHolder) holder;
        normaHolder.textView.setText(lists.get(position));

    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class NormaHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public NormaHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_03);
        }
    }
}
