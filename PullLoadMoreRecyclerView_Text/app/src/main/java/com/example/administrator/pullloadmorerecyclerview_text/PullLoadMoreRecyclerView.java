package com.example.administrator.pullloadmorerecyclerview_text;


import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/9/29.
 */

public class PullLoadMoreRecyclerView extends RecyclerView{
    private TextView tv_state;
    private View headView;
    private RefreshState refreshState;
    private RefreshState currentState;
    private int headHeight;
    private LinearLayoutManager linearLayoutManager;
    private int downY;
    private int upY;
    private int moveY;

    public PullLoadMoreRecyclerView(Context context) {
        super(context);
    }

    public PullLoadMoreRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PullLoadMoreRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (headView == null) {
            refreshState = RefreshState.SUCCESS;
            headView = getChildAt(0);
            tv_state = (TextView) findViewById(R.id.tv_state);
            headHeight = headView.getMeasuredHeight();
            headView.setPadding(0, -headHeight, 0, 0);
            linearLayoutManager = (LinearLayoutManager) getLayoutManager();

        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downY = (int) e.getY();
            case MotionEvent.ACTION_MOVE:
                moveY = (int) e.getY();
                if (moveY - downY < headHeight) {
                    currentState = RefreshState.PULL_TO_REFRESH;
                } else {
                    currentState = RefreshState.RELEASE_TO_REFRESH;
                }
                headView.setPadding(0,-headHeight+(moveY-downY),0,0);
            case MotionEvent.ACTION_UP:
                if (linearLayoutManager.findFirstVisibleItemPosition() == 0) {
                    currentState = RefreshState.REFRESHING;
                   /* if (refreshState != RefreshState.REFRESHING) {
                        if () {
                        }
                    }*/
                    headView.setPadding(0,0,0,0);
                } else {
                    headView.setPadding(0,0,0,0);
                }

                upY = (int) e.getY();

        }
        if (refreshState != currentState) {
            setStateText(currentState);
        }


        return super.onTouchEvent(e);
    }


    private void setStateText(RefreshState refreshState) {
        switch (refreshState) {
            case PULL_TO_REFRESH:
                tv_state.setText("下拉刷新");
                break;
            case RELEASE_TO_REFRESH:
                tv_state.setText("刷新更多");
                break;
            case REFRESHING:
                tv_state.setText("正在刷新");
                break;
            case SUCCESS:
                tv_state.setText("刷新完毕");
                break;
        }
    }


    enum RefreshState {
        PULL_TO_REFRESH,RELEASE_TO_REFRESH,REFRESHING,SUCCESS
    }
   /* onRefreshStateListenner onRefreshStateListenner;
    public void setOnRefreshStateListenner(onRefreshStateListenner onRefreshStateListenner) {
        this.onRefreshStateListenner = onRefreshStateListenner;
    }*/




    OnLodingMoreListenner onLodingMoreListenner;
    public void setOnLodingMoreListenner(OnLodingMoreListenner onLodingMoreListenner) {
        this.onLodingMoreListenner = onLodingMoreListenner;
    }


    public interface OnLodingMoreListenner {
        void lodingMore();
    }
}
