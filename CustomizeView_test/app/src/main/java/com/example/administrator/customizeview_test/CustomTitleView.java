package com.example.administrator.customizeview_test;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;

import java.util.TimerTask;

/**
 * Created by Administrator on 2017/9/25.
 */


public class CustomTitleView extends TextView{
    private int currentTime=50;
    private int tatilTime=50;
    private String mTatilText;
    private int mTatilTextSize;
    private Paint paint;
    private Rect rect;
    private int mTitleTextColor;


    CustomTitleViewListenner customTitleViewListenner;
    private int getCurrentState = 0;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    if (currentTime == 0) {
                        timerTask.cancel();
                        currentTime=0;
                        currentTime=tatilTime;
                        invalidate();
                        return;
                    }
                    invalidate();
                    currentTime--;
                    customTitleViewListenner.custom(currentTime);

                    break;
            }
        }
    };


   private TimerTask timerTask;
    public void setOnCustTitleViewListenner(CustomTitleViewListenner custTitleViewListenner) {
        this.customTitleViewListenner = custTitleViewListenner;
    }



    public CustomTitleView(Context context) {
        super(context,null);
    }
    public CustomTitleView(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }
    public CustomTitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


            paint = new Paint();
        paint.setTextSize(mTatilTextSize);
        rect = new Rect();
        paint.getTextBounds(mTatilText,0,mTatilText.length(),rect);

    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int width;
        int height;

        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            paint.setTextSize(mTatilTextSize);
            paint.getTextBounds(mTatilText, 0, mTatilText.length(), rect);
            float textwidth=rect.width();
            int desired=(int)(getPaddingLeft()+mTatilTextSize+getPaddingRight());
            width=desired;
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            paint.setTextSize(mTatilTextSize);
            paint.getTextBounds(mTatilText, 0, mTatilText.length(), rect);
            float textheight = rect.height();
            int desired = getPaddingLeft() + mTatilTextSize + getPaddingRight();
            height=desired;
        }


/*
 switch (om_width) {
            case MeasureSpec.UNSPECIFIED:
                break;
            case MeasureSpec.AT_MOST:
        }
        setMeasuredDimension(150, 60);
*/


        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#00ffff"));
        paint.setTextSize(20);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("我是测试文字",0,0,paint);
    }

    public void drawText(Canvas canvas, String text) {
        Rect rect = new Rect(0,0,150,60);
        Paint reckPaint = new Paint();
        reckPaint.setColor(Color.parseColor("#ff0000"));
        reckPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(rect, reckPaint);

        Paint textPaint = new Paint();
        textPaint.setColor(Color.parseColor("#00ff00"));
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetrics fontMetrics=textPaint.getFontMetrics();
        float top=fontMetrics.top;
        float bottom=fontMetrics.bottom;

        int y=rect.centerY();
        int baseLineY = (int) (y - top / 2 - bottom / 2);
        int x = rect.centerX();
        canvas.drawText(text,x,baseLineY,textPaint);
    }

    public interface CustomTitleViewListenner{
        void custom(int time);
    }

}
