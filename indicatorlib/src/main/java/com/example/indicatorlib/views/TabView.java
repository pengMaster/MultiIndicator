package com.example.indicatorlib.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

import com.example.indicatorlib.R;
import com.example.indicatorlib.utils.Utils;


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

    private Paint tabPaint;
    private float tabCount;     //根据内容自动匹配
    private float tabWidth;     //tab的宽度
    private int screenWidth;    //屏幕看度
    private int tabHeight;      //tab高度
    private int tabColor;       //tab颜色
    private int tabRadius;      //tab圆角读度数
    private float tabStart;     //tab距离左边的边距
    private float tabEnd;       //tab右边的位置


    private RectF mStripBounds = new RectF();

    public TabView(Context context) {
        super(context);
    }

    public TabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public TabView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        int defaultColor = context.getResources().getColor(R.color.red);
        int defaultHeight = Utils.dp2px(context, 3);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TabViewDrawable);
        tabHeight = typedArray.getDimensionPixelSize(R.styleable.TabViewDrawable_tabHeight, defaultHeight);
        tabRadius = typedArray.getDimensionPixelSize(R.styleable.TabViewDrawable_tabRadius, 20);
        tabColor = typedArray.getColor(R.styleable.TabViewDrawable_tabColor, defaultColor);
        typedArray.recycle();

        tabPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        tabPaint.setColor(tabColor);
        tabPaint.setStyle(Paint.Style.FILL);

        screenWidth = Utils.getScreenW(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = measureLength(widthMeasureSpec, screenWidth);
        int height = measureLength(heightMeasureSpec, tabHeight);
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
        mStripBounds.set(tabStart, 0, tabEnd, tabHeight);
        canvas.drawRoundRect(mStripBounds, tabRadius, tabRadius, tabPaint);
    }

    public void setScroll(int position, float positionOffset) {
        tabWidth = screenWidth / tabCount;
        tabEnd = tabStart + tabWidth;
        tabStart = positionOffset * tabWidth + position * tabWidth;
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