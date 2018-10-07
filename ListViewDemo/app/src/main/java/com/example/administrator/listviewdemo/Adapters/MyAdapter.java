package com.example.administrator.listviewdemo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.listviewdemo.R;
import com.example.administrator.listviewdemo.Utils.ItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/25 0025.
 */
public class MyAdapter extends BaseAdapter {

    public LayoutInflater inflater;
    public List<ItemBean> itemBeanList = new ArrayList<ItemBean>();
    public Context context;

    public MyAdapter(Context context, List<ItemBean> itemBeanList)
    {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.itemBeanList = itemBeanList;
    }

    @Override
    public int getCount() {
        return itemBeanList.size();
    }

    @Override
    public ItemBean getItem(int position) {
        return itemBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.itemlayout, null);

            viewHolder = new ViewHolder(context, (ImageView) convertView.findViewById(R.id.imageviewid), (TextView) convertView.findViewById(R.id.textviewid));

            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ItemBean item = itemBeanList.get(position);
        viewHolder.getImageView().setImageResource(item.getImgId());
        viewHolder.getTextView().setText(item.getDes());

        return convertView;
    }

}
