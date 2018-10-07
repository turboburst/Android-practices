package com.example.administrator.listviewdemo.Adapters;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/6/25 0025.
 */
public class ViewHolder {

    public ImageView imageView;
    public TextView textView;
    public Context context;

    public ViewHolder(final Context context, ImageView imageView, final TextView textView)
    {
        this.context = context;
        setImageView(imageView);
        setTextView(textView);

        //在ViewHolder里面设置具体控件的点击事件
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, textView.getText() + " image", Toast.LENGTH_SHORT).show();

            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, textView.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }


}
