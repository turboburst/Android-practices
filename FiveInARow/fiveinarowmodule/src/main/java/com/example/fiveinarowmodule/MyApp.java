package com.example.fiveinarowmodule;

import android.app.Application;
import android.content.Intent;

/**
 * Created by Administrator on 2016/5/20 0020.
 */
public class MyApp extends Application
{
    private static MyApp instance;
    public String name;
    public int age;

    private MyApp()
    {
        name = "john";
        age = 21;
    }

    public static final MyApp getInstance()
    {
        if(instance == null)
            instance = new MyApp();
        return instance;
    }

    /*@Override
    public void onCreate()
    {
        super.onCreate();
        Intent intent = new Intent(this, AudioService.class);
        startService(intent);
    }*/
}
