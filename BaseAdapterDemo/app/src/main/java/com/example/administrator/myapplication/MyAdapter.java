package com.example.administrator.myapplication;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2016/4/14 0014.
 */
public class MyAdapter extends BaseAdapter
{

    public LayoutInflater inflater;
    public List thelist;

    public MyAdapter(Context context, List<itemBean> thelist)
    {
        inflater = LayoutInflater.from(context);
        this.thelist = thelist;
    }

    @Override
    public int getCount()
    {
        return thelist.size();
    }

    @Override
    public Object getItem(int position)
    {
        return thelist.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        ViewHolder viewHolder;
        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.itemlayout, null);
            ImageView imageView = (ImageView)convertView.findViewById(R.id.imageid);
            TextView textView = (TextView)convertView.findViewById(R.id.textviewid);
            Button button = (Button)convertView.findViewById(R.id.buttonid);
            viewHolder = new ViewHolder(imageView, textView, button, position);

            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        itemBean thebean = (itemBean) thelist.get(position);
        viewHolder.imageView.setImageResource(thebean.imageviewResid);
        viewHolder.textView.setText(thebean.textviewStr);
        viewHolder.button.setText(viewHolder.button.getText().toString().substring(0, 6) + thebean.buttonid);

        final View finalConvertView = convertView;
        viewHolder.button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(inflater.getContext(), "Button is clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}
