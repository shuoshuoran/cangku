package com.example.administrator.viewgroup_text;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/9/27.
 */

public class MyViewGroup extends ViewGroup{
    private int totalwidth;
    private int totalheigth;


    public MyViewGroup(Context context) {
        this(context,null);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        totalwidth=0;
        totalheigth=0;

        measureChildren(widthMeasureSpec, heightMeasureSpec);
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);

            int measureWidth = child.getMeasuredWidth();
            int measureHeight = child.getMeasuredHeight();
            totalwidth += measureWidth;
            totalheigth += measureHeight;


        }
        setMeasuredDimension(totalwidth,totalheigth);
    }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int left=0;
        int top=0;
        for (int i = 0; i < getChildCount(); i++) {
            View childView = getChildAt(i);
            childView.layout(left, top, left + childView.getMeasuredWidth(), top + childView.getMeasuredHeight());
            left += childView.getWidth();
            top += childView.getHeight();

        }
    }
}
