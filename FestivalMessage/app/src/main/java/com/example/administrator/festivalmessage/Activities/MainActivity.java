package com.example.administrator.festivalmessage.Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.example.administrator.festivalmessage.R;
import com.example.administrator.festivalmessage.fragments.FestivalFragment;
import com.example.administrator.festivalmessage.fragments.SendAlreadyFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private final String[] mTitles = new String[]{"festival", "send already"};

    private List<Fragment> fragments;
    private FestivalFragment festivalFragment;
    private SendAlreadyFragment sendAlreadyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragments = new ArrayList<Fragment>();
        festivalFragment = new FestivalFragment();
        sendAlreadyFragment = new SendAlreadyFragment();
        fragments.add(festivalFragment);
        fragments.add(sendAlreadyFragment);

        tabLayout = (TabLayout) findViewById(R.id.tablayoutid);
        viewPager = (ViewPager) findViewById(R.id.viewpagerid);

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return mTitles.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles[position];
            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }
}
