package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    public ListView listView;
    public List<itemBean> thelist = new ArrayList<itemBean>();
    public int[] imageResid = new int[]
                    {R.drawable.png1, R.drawable.png2, R.drawable.png3,
                    R.drawable.png4, R.drawable.png5, R.drawable.png6,
                    R.drawable.png7, R.drawable.png8, R.drawable.png9,
                    R.drawable.png10, R.drawable.png11, R.drawable.png12,
                    R.drawable.png13, R.drawable.png14, R.drawable.png15};
    public MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listviewid);
        for(int i = 0; i < imageResid.length; i ++)
        {
            itemBean thebean = new itemBean(imageResid[i], "image " + i, i);
            thelist.add(thebean);
        }

        myAdapter = new MyAdapter(this, thelist);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                //onItemClick事件只能处理listview中的item的点击事件，在此例子中，这里的item是指那个表示了itemBean
                //的itemlayout,是个View.也就是说，onItemClick事件不能处理这里面的button, 或者其他控件的点击事件，
                //如果你想那么做，只能去itemlayout的根布局设置android:descendantFocusability="blocksDescendants"
                //然后在MyAdapter里面的getView方法中写button的onClick方法（通过setOnClickListener()）
                Toast.makeText(view.getContext(), "The item(the view) of listview is clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
