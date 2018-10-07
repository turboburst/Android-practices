package com.example.gridview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.os.Build;

public class MainActivity extends Activity {

	private GridView gridView;
	private SimpleAdapter adapter;
	private List<Map<String, Object>> dataList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		gridView=(GridView) findViewById(R.id.gridView);
        dataList=new ArrayList<Map<String,Object>>();
        adapter=new SimpleAdapter(this, getData(), R.layout.item, new String[]{"pic","name"}, new int[]{R.id.pic,R.id.name});
        gridView.setAdapter(adapter);
	}

	private List<Map<String, Object>> getData() {
		
		int[] drawable = { R.drawable.address_book, R.drawable.calendar,
				R.drawable.camera, R.drawable.clock, R.drawable.games_control,
				R.drawable.messenger, R.drawable.ringtone, R.drawable.settings,
				R.drawable.speech_balloon, R.drawable.weather,
				R.drawable.world, R.drawable.youtube };
		String[] iconName = { "艾特", "日期", "照相", "时间", "游戏", "通讯录", "我的音乐", "设置",
				"聊天","温度", "网络", "Youtube" };
		for (int i = 0; i < drawable.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("pic", drawable[i]);
			map.put("name", iconName[i]);
            dataList.add(map);
		}
		Log.i("Main", "size="+dataList.size());
		return dataList;
	}
}
