package com.example.administrator.listviewdemo.Activities;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.listviewdemo.Adapters.MyAdapter;
import com.example.administrator.listviewdemo.R;
import com.example.administrator.listviewdemo.Utils.ItemBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ListView listView;
    public MyAdapter myAdapter;
    public List<ItemBean> itemBeanList;
    public CursorAdapter cursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initDatas();

        cursorAdapter = new CursorAdapter(this, null, true) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return null;
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {

            }

            @Override
            public void changeCursor(Cursor cursor) {
                super.changeCursor(cursor);
            }
        };

        myAdapter = new MyAdapter(this, itemBeanList);
        listView.setAdapter(myAdapter);

        //setOnItemClickListener这个方法就是设置点击列表项的事件的方法，
        //注意，是点击整个列表项，而不是点击列表项中某个东西（比如这里的图片或者文字）
        //如果要实现点击列表项中某个东西的事件，那不是这个方法。
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                switch (position)
                {
                    case 0:
                        intent.setClass(MainActivity.this, AppleActivity.class);
                        break;
                    case 1:
                        intent.setClass(MainActivity.this, BananaActivity.class);
                        break;
                    case 2:
                        intent.setClass(MainActivity.this, GrapeActivity.class);
                        break;

                    case 3:
                        intent.setClass(MainActivity.this, AppleActivity.class);
                        break;
                    case 4:
                        intent.setClass(MainActivity.this, BananaActivity.class);
                        break;
                    case 5:
                        intent.setClass(MainActivity.this, GrapeActivity.class);
                        break;

                    case 6:
                        intent.setClass(MainActivity.this, AppleActivity.class);
                        break;
                    case 7:
                        intent.setClass(MainActivity.this, BananaActivity.class);
                        break;
                    case 8:
                        intent.setClass(MainActivity.this, GrapeActivity.class);
                        break;

                    case 9:
                        intent.setClass(MainActivity.this, AppleActivity.class);
                        break;
                    case 10:
                        intent.setClass(MainActivity.this, BananaActivity.class);
                        break;
                    case 11:
                        intent.setClass(MainActivity.this, GrapeActivity.class);
                        break;

                    case 12:
                        intent.setClass(MainActivity.this, AppleActivity.class);
                        break;
                    case 13:
                        intent.setClass(MainActivity.this, BananaActivity.class);
                        break;
                    case 14:
                        intent.setClass(MainActivity.this, GrapeActivity.class);
                        break;

                    case 15:
                        intent.setClass(MainActivity.this, AppleActivity.class);
                        break;
                    case 16:
                        intent.setClass(MainActivity.this, BananaActivity.class);
                        break;
                    case 17:
                        intent.setClass(MainActivity.this, GrapeActivity.class);
                        break;
                    case 18:
                        intent.setClass(MainActivity.this, GrapeActivity.class);
                        break;

                    case 19:
                        intent.setClass(MainActivity.this, GrapeActivity.class);
                        break;

                }
                startActivity(intent);
            }
        });
    }


    private void initDatas()
    {
        itemBeanList = new ArrayList<ItemBean>();
        itemBeanList.add(new ItemBean(R.mipmap.apple, "apple"));
        itemBeanList.add(new ItemBean(R.mipmap.banana, "banana"));
        itemBeanList.add(new ItemBean(R.mipmap.grape, "grape"));
        itemBeanList.add(new ItemBean(R.mipmap.png1, "png1"));
        itemBeanList.add(new ItemBean(R.mipmap.png2, "png2"));
        itemBeanList.add(new ItemBean(R.mipmap.png3, "png3"));
        itemBeanList.add(new ItemBean(R.mipmap.png4, "png4"));
        itemBeanList.add(new ItemBean(R.mipmap.png5, "png5"));
        itemBeanList.add(new ItemBean(R.mipmap.png6, "png6"));
        itemBeanList.add(new ItemBean(R.mipmap.png7, "png7"));
        itemBeanList.add(new ItemBean(R.mipmap.png8, "png8"));
        itemBeanList.add(new ItemBean(R.mipmap.png9, "png9"));
        itemBeanList.add(new ItemBean(R.mipmap.png10, "png10"));
        itemBeanList.add(new ItemBean(R.mipmap.png11, "png11"));
        itemBeanList.add(new ItemBean(R.mipmap.png12, "png12"));
        itemBeanList.add(new ItemBean(R.mipmap.png13, "png13"));
        itemBeanList.add(new ItemBean(R.mipmap.png14, "png14"));
        itemBeanList.add(new ItemBean(R.mipmap.png15, "png15"));
        itemBeanList.add(new ItemBean(R.mipmap.png16, "png16"));
        itemBeanList.add(new ItemBean(R.mipmap.png17, "png17"));

    }

    private void initViews()
    {
        listView = (ListView) findViewById(R.id.listviewid);
    }
}
