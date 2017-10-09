package test.demo.dahua.com.testview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by dragon on 2017/9/25.
 */

public class MyToggleButtom extends View {

    onStateChangeListenner onStateChangeListenner;
    private Bitmap bg;
    private Bitmap silde;
    private int bg_with;
    private int bg_height;
    private int slide_with;
    private int downX;
    private int moveX;
    private int upX;
    private int distantX;
    private State currentStat;
    private State state;
    private int count = 0;

    public MyToggleButtom(Context context) {
        this(context, null);
    }

    public MyToggleButtom(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyToggleButtom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyToggleButtom);
        boolean isOpen = typedArray.getBoolean(R.styleable.MyToggleButtom_isOpen, false);
        if (isOpen) {
            state = State.ON;
        } else {
            state = State.OFF;
        }

        initView();
    }

    public void setState(State state) {
        this.state = state;
    }

    private void initView() {
        bg = BitmapFactory.decodeResource(getResources(), R.mipmap.bg);
        silde = BitmapFactory.decodeResource(getResources(), R.mipmap.slide);
        bg_with = bg.getWidth();
        bg_height = bg.getHeight();
        slide_with = silde.getWidth();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(bg_with, bg_height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(bg, 0, 0, null);

        if (count == 0) {
            if (state == State.OFF) {
                distantX = 0;

            } else {
                distantX = bg_with - slide_with;
            }
            if (onStateChangeListenner != null) {
                onStateChangeListenner.stateChange(state);
            }

            count++;
        }

        canvas.drawBitmap(silde, distantX, 0, null);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                downX = (int) event.getX();

                break;
            case MotionEvent.ACTION_MOVE:
                moveX = (int) event.getX();
                if (moveX <= 0) {
                    moveX = 0;
                }
                if (moveX >= bg_with - slide_with) {
                    moveX = bg_with - slide_with;
                }
                distantX = moveX;

                break;

            case MotionEvent.ACTION_UP:
                upX = (int) event.getX();


                if ((upX + slide_with / 2) > bg_with / 2) {
                    distantX = bg_with - slide_with;
                    currentStat = State.ON;

                } else {
                    distantX = 0;
                    currentStat = State.OFF;

                }
                if (onStateChangeListenner != null) {
                    if (currentStat == state) {

                    } else {
                        onStateChangeListenner.stateChange(currentStat);

                    }
                }
                state = currentStat;
                break;
        }

        invalidate();


        return true;

    }

    public void setOnStateChangeListenner(MyToggleButtom.onStateChangeListenner onStateChangeListenner) {
        this.onStateChangeListenner = onStateChangeListenner;
    }

    enum State {
        ON, OFF
    }

    public interface onStateChangeListenner {
        void stateChange(State state);
    }


}
