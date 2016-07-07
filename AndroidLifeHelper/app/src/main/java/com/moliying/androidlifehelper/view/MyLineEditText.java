package com.moliying.androidlifehelper.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.EditText;

import com.moliying.androidlifehelper.R;

/**
 * Created by ldc on 2015/12/9.
 */
public class MyLineEditText extends EditText {

    private Drawable mDrawable;
    private Context mContext;

    /**
     * 是否获取焦点，默认没有焦点
     */
    private boolean hasFocus = false;

    //画线
    private Paint mPaint;
    private int color;

    //必须的
    public MyLineEditText(Context context) {
        super(context);
        mContext = context;
        init();
    }

    //必须的
    public MyLineEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }
    //必须的
    public MyLineEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }


    private void init() {
        mDrawable = getResources().getDrawable(R.mipmap.sign_check2x);

        //此处为画线
        mPaint = new Paint();
        // mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(3.0f);
        color = Color.parseColor("#bfbfbf");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(color);
        int x=this.getScrollX();
        int w=this.getMeasuredWidth();
        canvas.drawLine(0, this.getHeight() - 1, w + x,
                this.getHeight() - 1, mPaint);
    }



    @Override
    protected void onFocusChanged(boolean focused, int direction,
                                  Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        this.hasFocus=focused;
        if (focused) {
            setColor(Color.parseColor("#00C17C"));
        } else {
            setColor(Color.parseColor("#bfbfbf"));
        }
    }

    public void setColor(int color) {
        this.color = color;
        this.setTextColor(color);
        invalidate();
    }

    public void setImageVisible(boolean isVisible){
        if (isVisible){
            setCompoundDrawablesWithIntrinsicBounds(null,null,mDrawable,null);
        }else {
            setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);
        }
    }


    //必须的
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
