package com.example.administrator.viewgroup_text;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/**
 * Created by Administrator on 2017/9/28.
 */

public class MyLayout extends ViewGroup{
    private int mar;//距离左边的间距
    private int ver;//距离上边的间距
    OnDatelistnner onDatelistnner;

    public MyLayout(Context context) {
        this(context,null);
    }

    public MyLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = 0;
        int height = 0;
        int count = 1;
        int currentTotalWidth = mar;


        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        if (modeWidth == MeasureSpec.EXACTLY) {
            width = MeasureSpec.getSize(widthMeasureSpec);
        } else {
            width = ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getWidth();
        }

        if (modeHeight == MeasureSpec.EXACTLY) {
            height = MeasureSpec.getSize(heightMeasureSpec);
        } else {
            if (getChildCount() == 0) {
                count = 0;
            } else {
                int everyHeight = getChildAt(0).getMeasuredHeight() + ver;

            for (int i = 0; i < getChildCount(); i++) {
                View view = getChildAt(i);
                currentTotalWidth += view.getMeasuredWidth() + mar;
                if (currentTotalWidth > width) {
                    count++;
                    currentTotalWidth = view.getMeasuredWidth();
                }
            }

            height = everyHeight * count;
        }
        }
        setMeasuredDimension(width, height);
    }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int currentLeft = 0;
        int currentTop = 0;
        int count = 0;
        int everyHeight = 0;
        if (getChildCount() >= 1) {
            everyHeight = getChildAt(0).getMeasuredHeight() + ver;
        }

        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);

            currentLeft += view.getMeasuredWidth() + mar;

            if (currentLeft > getMeasuredWidth()) {
                count++;
                currentTop = everyHeight * count;
                currentLeft = view.getMeasuredWidth() + mar;
            }
            view.layout(currentLeft - view.getMeasuredWidth(), currentTop, currentLeft, currentTop + view.getMeasuredHeight());

        }
    }

    public void setMar(int mar) {
        this.mar = mar;
    }

    public void setVer(int ver) {
        this.ver = ver;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
       super.onTouchEvent(event);
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            final int j = i;
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onDatelistnner != null) {
                        onDatelistnner.Date(j);
                        ToastUtils.setToast(getContext(),""+j);
                    }
                }
            });
        }
        return true;
    }

    public void setOnDatelistnner(OnDatelistnner onDatelistnner) {
        this.onDatelistnner = onDatelistnner;
    }

    public interface OnDatelistnner {
        void Date(int i);
    }
}


