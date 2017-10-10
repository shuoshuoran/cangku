package com.example.administrator.pullloadmorerecyclerview_text;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/29.
 */

public class RVAdapter_Main extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private ArrayList<String> strings;
    public RVAdapter_Main(Context context, ArrayList<String> list) {
        this.context = context;
        this.strings = strings;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
