package com.example.multiindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;


/**
 * <pre>
 *     author : Wp
 *     e-mail : 1101313414@qq.com
 *     time   : 2019/5/24 10:35 AM
 *     desc   : viewPager 指示器
 *     version: 1.0
 * </pre>
 */
public class TabView extends View implements ViewPager.OnPageChangeListener {


    private float tabHeight;
    private Paint tabPaint;
    private float tabCount;
    private float tabWidth;//tab的宽度

    private int default_width;
    private int default_height;

    private float start;//tab距离左边的边距


    private RectF mStripBounds = new RectF();

    public TabView(Context context) {
        super(context);
        init(context);
    }

    public TabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TabView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        tabHeight = Utils.dp2px(context, 3);

        tabPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        tabPaint.setColor(Color.RED);
        tabPaint.setStyle(Paint.Style.FILL);

        default_width = Utils.getScreenW(context);
        default_height = (int) tabHeight;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = measureLength(widthMeasureSpec, default_width);
        int height = measureLength(heightMeasureSpec, default_height);
        setMeasuredDimension(width, height);

    }

    private int measureLength(int measureSpec, int defaultLength) {
        int length = 0;
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);
        switch (mode) {
            case MeasureSpec.AT_MOST:
                length = Math.min(size, defaultLength);
                break;
            case MeasureSpec.EXACTLY:
                length = size;
                break;
            case MeasureSpec.UNSPECIFIED:
                length = defaultLength;
                break;
        }
        return length;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawTab(canvas);
    }

    private void drawTab(Canvas canvas) {
        //重点在于计算这个开始start位置的值和 tabWidth这个tab宽度的值 此值在滑动时都可能是变化的
        mStripBounds.set(start, 0, start + tabWidth, tabHeight);
        canvas.drawRoundRect(mStripBounds, 20, 20, tabPaint);
    }

    public void setScroll(int position, float positionOffset) {
        tabWidth = default_width / tabCount;
        start = positionOffset * tabWidth + position * tabWidth;
        invalidate();
    }

    public void  setViewPager(ViewPager viewPager){
        viewPager.addOnPageChangeListener(this);
        tabCount = viewPager.getAdapter().getCount();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        setScroll(position, positionOffset);
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}