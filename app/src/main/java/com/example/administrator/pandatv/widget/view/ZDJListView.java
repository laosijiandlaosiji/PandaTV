package com.example.administrator.pandatv.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * Created by li on 2017/7/30.
 */

public class ZDJListView extends ListView{

    public ZDJListView(Context context) {
        super(context);
    }

    public ZDJListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ZDJListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //判断是否滑动到顶部了
        if (getFirstVisiblePosition() == 0 && getChildAt(0).getTop() == 0) {//到顶部了
            //返回触摸事件
            getParent().requestDisallowInterceptTouchEvent(false);
        } else {//没有到头部
            //拦截触摸事件
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(ev);
    }

}
