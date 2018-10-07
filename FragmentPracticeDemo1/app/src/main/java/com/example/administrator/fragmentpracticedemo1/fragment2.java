package com.example.administrator.fragmentpracticedemo1;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/4/17 0017.
 */
public class fragment2 extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment2layout, container, false);
        TextView textView = (TextView) view.findViewById(R.id.fragment2textviewid);
        Button button = (Button) view.findViewById(R.id.fragment2buttonid);
        textView.setText("fragment2");
        button.setText("button2");
        return view;
    }
}
