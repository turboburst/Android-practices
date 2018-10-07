package com.example.administrator.myapplication;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/4/14 0014.
 */
public class ViewHolder
{
    public ImageView imageView;
    public TextView textView;
    public Button button;
    public int position;

    public ViewHolder(ImageView imageView, TextView textView, Button button, int position)
    {
        this.imageView = imageView;
        this.textView = textView;
        this.button = button;
        this.position = position;
    }

    public int getPosition()
    {
        return position;
    }

}
