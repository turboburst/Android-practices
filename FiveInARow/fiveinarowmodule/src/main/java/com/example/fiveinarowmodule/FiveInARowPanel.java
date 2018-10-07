package com.example.fiveinarowmodule;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/5/14 0014.
 */
public class FiveInARowPanel extends View
{
    private int panelwidth;
    private float lineheight;
    private int maxline = 10;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w, h, oldw, oldh);
        panelwidth = w;
        lineheight = panelwidth * 1.0F / maxline;
    }

    public FiveInARowPanel(Context context)
    {
        super(context);
    }

    public FiveInARowPanel(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        setBackgroundColor(0x34ff0000);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public FiveInARowPanel(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
    {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        int widthsize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);

        int heightsize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int width = Math.min(widthsize, heightsize);
        if(widthMode == MeasureSpec.UNSPECIFIED)
        {
            width = heightsize;
        }
        else if(heightMode == MeasureSpec.UNSPECIFIED)
        {
            width = widthsize;
        }
        setMeasuredDimension(width, width);
    }



}
