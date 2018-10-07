package com.example.fiveinarowmodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*MyApp myApp = MyApp.getInstance();
        String name = myApp.name;
        int age = myApp.age;
        Toast.makeText(MainActivity.this, name + " " + age, Toast.LENGTH_LONG).show();*/
    }
}
