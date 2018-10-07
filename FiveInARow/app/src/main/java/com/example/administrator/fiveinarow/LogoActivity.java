package com.example.administrator.fiveinarow;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LogoActivity extends AppCompatActivity {

    private TextView logtext;
    private final int SPLASH_LENGTH = 9000;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        logtext = (TextView)findViewById(R.id.logoTextViewID);

        new Handler().postDelayed(new Runnable()
        {
            public void run()
            {
                Intent mainintent = new Intent(LogoActivity.this, MainActivity.class);
                LogoActivity.this.startActivity(mainintent);
                LogoActivity.this.finish();
            }
        }, SPLASH_LENGTH);
    }
}
