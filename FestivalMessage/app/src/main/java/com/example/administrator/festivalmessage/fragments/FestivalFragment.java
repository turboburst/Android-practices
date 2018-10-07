package com.example.administrator.festivalmessage.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.TextView;

import com.example.administrator.festivalmessage.Activities.ChooseMessageActivity;
import com.example.administrator.festivalmessage.Bean.Festival;
import com.example.administrator.festivalmessage.Bean.FestivalLab;
import com.example.administrator.festivalmessage.R;

/**
 * Created by Administrator on 2016/6/20 0020.
 */

public class FestivalFragment extends Fragment
{
    private GridView gridView;
    private ArrayAdapter<Festival> adapter;
    private LayoutInflater inflater;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View mView = inflater.inflate(R.layout.festival_fragment_layout, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        inflater = LayoutInflater.from(getContext());
        gridView = (GridView) view.findViewById(R.id.gridviewid);
        adapter = new ArrayAdapter<Festival>(getContext(), -1, FestivalLab.getInstance().getFestivals()){
            @Override
            public View getView(int position, View convertView, ViewGroup parent)
            {
                if(convertView == null)
                {
                    convertView = inflater.inflate(R.layout.itemfestivallayout, parent, false);
                }

                TextView textView = (TextView) convertView.findViewById(R.id.textviewid);
                textView.setText(getItem(position).getFestivalName());

                return convertView;
            }
        };
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                ChooseMessageActivity.toActivity(getActivity(), adapter.getItem(position).getFestivalID());
            }
        });

    }


}
