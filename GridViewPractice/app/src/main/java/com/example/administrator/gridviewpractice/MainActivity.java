package com.example.administrator.gridviewpractice;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity
{
    private GridView gridView;
    private SimpleAdapter simpleAdapter;
    private List<HashMap<String, Object>> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView)findViewById(R.id.gridviewid);
        datas = new ArrayList<HashMap<String ,Object>>();

        HashMap<String, Object> themap;
        final String[] iconnames = new String[]{"name1", "name2", "name3", "name4", "name5", "name6", "name7", "name8", "name9"};
        int[] iconids = new int[]{R.drawable.address_book, R.drawable.calendar, R.drawable.camera,
                                    R.drawable.clock, R.drawable.games_control, R.drawable.messenger,
                                    R.drawable.ringtone, R.drawable.settings, R.drawable.speech_balloon};

        for(int i = 0; i < iconids.length; i ++)
        {
            themap = new HashMap<String, Object>();
            themap.put("pic", iconids[i]);
            themap.put("name", iconnames[i]);
            datas.add(themap);
        }

        simpleAdapter = new SimpleAdapter(this, datas, R.layout.itemlayout, new String[]{"pic", "name"},
                new int[]{R.id.imageviewid, R.id.textviewid});
        gridView.setAdapter(simpleAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(MainActivity.this, iconnames[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
