package com.example.administrator.fragmentpracticedemo1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/4/16 0016.
 */
public class fragment1 extends Fragment
{
    public TextView textView;
    public Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment1layout, container, false);
        TextView textView = (TextView) view.findViewById(R.id.fragment1textviewid);
        Button button = (Button) view.findViewById(R.id.fragment1buttonid);
        textView.setText("Fragment 1");
        button.setText("Button 1");
        return view;
    }
}
