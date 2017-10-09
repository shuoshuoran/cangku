package test.demo.dahua.com.testview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by dragon on 2017/9/25.
 */

public class CountDownView extends TextView {


    private int currentTime=50;
    private int TotalTime=50;
    onCountDownListenner countDownListenner;
    //0 :初始状态
    //1 :获取中
    private int currentState = 0;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {

                case 1:
                    if(currentTime==0){
                        timerTask.cancel();
                        currentState = 0;

                        currentTime = TotalTime;
                        invalidate();
                        return;
                    }
                    invalidate();

                    currentTime--;
                    countDownListenner.countDown(currentTime);


                    break;
            }
        }
    };
    private TimerTask timerTask;

    public void setOnCountDownListenner(onCountDownListenner countDownListenner) {
        this.countDownListenner = countDownListenner;
    }






    public CountDownView(Context context) {
        this(context,null);
    }

    public CountDownView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CountDownView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.CountDownView);
        int integer = typedArray.getInteger(R.styleable.CountDownView_totalSecond, 50);
        TotalTime = integer;
        currentTime = TotalTime;
        typedArray.recycle();

        initView();
    }

    private void initView() {


    }

    public void setTime(int tatal){
        TotalTime = tatal;
        currentTime = tatal;

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
      /*  int mode = MeasureSpec.getMode(widthMeasureSpec);
        switch (mode) {

            case MeasureSpec.UNSPECIFIED:

                break;

            case MeasureSpec.AT_MOST:

        }
*/
       // setMeasuredDimension(150, 60);
       /* super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        int with = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);*/
        setMeasuredDimension(150,60);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
      /*  Paint paint = new Paint();
        paint.setColor(Color.parseColor("#ff0000"));
        paint.setTextSize(20);
        paint.setTextAlign(Paint.Align.CENTER);

        canvas.drawText("我是测试文字", 0, 0, paint);*/

        if(currentState==0){
            drawText(canvas,"获取验证码");
        }else{
            drawText(canvas,currentTime+"");
        }






    }

    public void drawText(Canvas canvas,String text){
        Rect rect = new Rect(0,0,150,60);//画一个矩形
        Paint rectPaint = new Paint();
        rectPaint.setColor(Color.BLUE);
        rectPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(rect, rectPaint);

        Paint textPaint = new Paint();
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(30);
        textPaint.setStyle(Paint.Style.FILL);
        //该方法即为设置基线上那个点究竟是left,center,还是right  这里我设置为center
        textPaint.setTextAlign(Paint.Align.CENTER);

        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float top = fontMetrics.top;//为基线到字体上边框的距离,即上图中的top
        float bottom = fontMetrics.bottom;//为基线到字体下边框的距离,即上图中的bottom



        int y = rect.centerY();
        int baseLineY = (int) (y - top/2 - bottom/2);//基线中间点的y轴计算公式

        int x = rect.centerX();


        canvas.drawText(text,x,baseLineY,textPaint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                break;

            case MotionEvent.ACTION_MOVE:

                break;

            case MotionEvent.ACTION_UP:
                if(currentState==0){
                    if(countDownListenner!=null){

                        currentState = 1;
                        Timer timer = new Timer();
                        timerTask = new TimerTask() {
                            @Override
                            public void run() {

                                Message msg = handler.obtainMessage();
                                msg.what = 1;
                                msg.obj = currentTime;
                                handler.sendMessage(msg);


                            }
                        };


                        timer.schedule(timerTask, 0, 1000);




                    }
                }



                break;
        }




        return super.onTouchEvent(event);

    }

    public interface onCountDownListenner{
       void  countDown(int time);

    }

    public void destorySelf(){
        timerTask.cancel();
        currentState = 0;
        invalidate();
        timerTask = null;
        handler.removeCallbacksAndMessages(null);
        handler = null;
    }



}
