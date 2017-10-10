package com.example.administrator.fragmenyt_test.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.fragmenyt_test.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2017/9/20.
 */

public class Adapter_VP_scActivity extends PagerAdapter{
    private Context context;
    private List<String>string;

    public Adapter_VP_scActivity(Context context,List<String>string) {
        this.context = context;
        this.string=string;
    }

    @Override
    public int getCount() {
        return string.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.vp_second_act, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_img);

        Picasso.with(context).load(string.get(position)).into(imageView);
        container.addView(view);
        return view;
    }
}
