package com.jcodecraeer.xrecyclerview;

/**
 * Created by jianghejie on 15/11/22.
 */

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


public class JellyView extends View  implements BaseRefreshHeader{
    Path path;  // Path主要用于绘制复杂的图形轮廓，比如折线，圆弧以及各种复杂图案

    Paint paint;

    private int minimumHeight = 0;

    private int jellyHeight =0;

    public JellyView(Context context) {
        super(context);
        init();
    }

    public JellyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public JellyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @SuppressWarnings("unused")
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public JellyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        if (isInEditMode()) { // view自带方法 isInEditMode()：如果该视图处于编辑模式，则返回true，否则为false。
            return;
        }
        path = new Path();
        paint = new Paint();
        paint.setColor(getContext().getResources().getColor(android.R.color.holo_blue_bright));
        paint.setAntiAlias(true);
    }

    public void setJellyColor(int jellyColor) {
        paint.setColor(jellyColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        path.reset(); // 清除path设置的所有属性，复位到初始状态
        path.lineTo(0, minimumHeight); // 方法用于从当前轮廓点绘制一条线段到x，y点：
        // path.quadTo 用于绘制圆滑曲线，即贝塞尔曲线。
        path.quadTo(getMeasuredWidth() / 2, minimumHeight + jellyHeight, getMeasuredWidth(), minimumHeight);
        path.lineTo(getMeasuredWidth(), 0);
        canvas.drawPath(path, paint);
    }

    @Override
    public void setMinimumHeight(int minimumHeight) {
        this.minimumHeight = minimumHeight;
    }

    public void setJellyHeight(int ribbonHeight) {
        this.jellyHeight = ribbonHeight;
    }

    @Override
    public int getMinimumHeight() {
        return minimumHeight;
    }

    public int getJellyHeight() {
        return jellyHeight;
    }


    @Override
    public void refreshComplete(){

    }

    @Override
    public void onMove(float delta) {
        jellyHeight = jellyHeight + (int)delta;
        Log.i("jellyHeight", "delta = " + delta);
        this.invalidate();
    }

    @Override
    public boolean releaseAction() {
       return false;
    }
}
