package com.example.administrator.festivalmessage.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.administrator.festivalmessage.R;

/**
 * Created by Administrator on 2016/6/20 0020.
 */
public class SendAlreadyFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.sendalready_fragment_layout, container, false);
        return mView;
    }
}
