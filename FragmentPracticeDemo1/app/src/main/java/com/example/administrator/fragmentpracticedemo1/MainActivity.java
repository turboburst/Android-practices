package com.example.administrator.fragmentpracticedemo1;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button buttonFromFragment1;
    private TextView textViewFromFragment1;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonFromFragment1 = (Button) findViewById(R.id.fragment1buttonid);
        textViewFromFragment1 = (TextView) findViewById(R.id.fragment1textviewid);

        buttonFromFragment1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                textViewFromFragment1.setText("Hello world");
            }
        });


        fragment2 myfragment2 = new fragment2();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment2, myfragment2);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}
