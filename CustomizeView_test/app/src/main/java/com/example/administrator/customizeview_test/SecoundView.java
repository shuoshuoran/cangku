package com.example.administrator.customizeview_test;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/9/26.
 */

public class SecoundView extends View {
    onStateChangeListenner onStateChangeListenner;
    private int downX;
    private int moveX;
    private int upX;
    private int bg_width;
    private int slide_width;
    private int distantX;
    private State state;
    private State currentState;
    private int count=0;


    private Bitmap bg_mip;
    private Bitmap slide_mip;

    public SecoundView(Context context) {
        this(context,null);
    }

    public SecoundView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SecoundView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SecoundView);
        boolean isOpen = typedArray.getBoolean(R.styleable.SecoundView_isOpen, false);
        if (isOpen) {
            state = State.ON;
        } else {
            state = State.OFF;
        }


        bg_mip = BitmapFactory.decodeResource(getResources(), R.mipmap.bg);
        slide_mip = BitmapFactory.decodeResource(getResources(), R.mipmap.slide);
        bg_width = bg_mip.getWidth();
        slide_width = slide_mip.getWidth();

    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        /*int widthDome = MeasureSpec.getMode(widthMeasureSpec);
        int heightDome = MeasureSpec.getMode(heightMeasureSpec);*/



        setMeasuredDimension(bg_mip.getWidth(),bg_mip.getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(bg_mip, 0, 0, null);
        if (count == 0) {
            if (state == State.OFF) {
                distantX = 0;
            } else {
                distantX=bg_width-slide_width;
            }
            if (onStateChangeListenner != null) {

                    onStateChangeListenner.ststeChange(state);


            }
            count++;
        }

        canvas.drawBitmap(slide_mip,distantX,0,null);



    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = (int) event.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                moveX = (int) event.getX();
                if (moveX <= 0) {
                    moveX = 0;
                }
                if (moveX >= bg_width - slide_width) {
                    moveX = bg_width - slide_width;
                }
                distantX = moveX;
                break;
            case MotionEvent.ACTION_UP:
                upX = (int) event.getX();
                if ((upX + slide_width / 2) > bg_width / 2) {
                    distantX = bg_width - slide_width;
                    currentState = State.ON;
                } else {
                    distantX = 0;
                    currentState = State.OFF;
                }
                if (onStateChangeListenner != null) {
                    if (currentState == state) {

                    } else {
                        onStateChangeListenner.ststeChange(currentState);
                    }
                }
                currentState = state;
                break;
        }
        invalidate();

        return true;
    }

    public void setOnStateChangeListenner(SecoundView.onStateChangeListenner onStateChangeListenner) {
        this.onStateChangeListenner = onStateChangeListenner;
    }

    enum State{
        ON,OFF
    }
    public interface onStateChangeListenner{
        void ststeChange(State state);
    }
}
