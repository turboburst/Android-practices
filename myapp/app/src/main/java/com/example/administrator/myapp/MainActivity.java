package com.example.administrator.myapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends Activity implements  ScrollViewListener{

    private ObservableScrollView scrollView1 = null;
    private ObservableScrollView scrollView2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView1 = (ObservableScrollView) findViewById(R.id.scrollview1);
        scrollView1.setScrollViewListener(this);
        scrollView2 = (ObservableScrollView) findViewById(R.id.scrollview2);
        scrollView2.setScrollViewListener(this);
    }

    public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
        if(scrollView == scrollView1) {
            scrollView2.scrollTo(x, y);
        } else if(scrollView == scrollView2) {
            scrollView1.scrollTo(x, y);
        }
    }
}
