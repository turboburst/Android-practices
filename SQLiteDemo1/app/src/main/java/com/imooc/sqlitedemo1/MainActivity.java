package com.imooc.sqlitedemo1;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//ÿ���������Լ������ݿ� Ĭ��������Ǹ��Ի��಻����
		//����һ�����ݿ� ���Ҵ�
		SQLiteDatabase db =   openOrCreateDatabase("user.db", MODE_PRIVATE, null);
			db.execSQL("create table if not exists usertb (_id integer primary key autoincrement, name text not null , age integer not null , sex text not null )");
			db.execSQL("insert into usertb(name,sex,age) values('����','Ů',18)");
			db.execSQL("insert into usertb(name,sex,age) values('����','Ů',19)");
			db.execSQL("insert into usertb(name,sex,age) values('����','��',20)");
			
			 Cursor c = db.rawQuery("select * from usertb", null);
			 	if (c!=null) {
			 		while (c.moveToNext())
					{
						Log.i("info", "_id:"+c.getInt(c.getColumnIndex("_id")));
						Log.i("info", "name:"+c.getString(c.getColumnIndex("name")));
						Log.i("info", "age:"+c.getInt(c.getColumnIndex("age")));
						Log.i("info", "sex:"+c.getString(c.getColumnIndex("sex")));
						Log.i("info", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					}
			 		c.close();
			 	}
			 	db.close();
	}



}
