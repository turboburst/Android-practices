package com.example.administrator.fiveinarow;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private EditText edittext;
    private TextView textView1, textView2, textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittext = (EditText) findViewById(R.id.edittextid);
        textView1 = (TextView) findViewById(R.id.textview1id);
        textView2 = (TextView) findViewById(R.id.textview2id);
        textView3 = (TextView) findViewById(R.id.textview3id);

        edittext.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
            {
                if(actionId == EditorInfo.IME_ACTION_SEND || actionId == EditorInfo.IME_ACTION_DONE ||
                        (event != null && KeyEvent.KEYCODE_ENTER == event.getKeyCode() && KeyEvent.ACTION_DOWN == event.getAction()))
                    textView3.setText(edittext.getText().toString());

                return false;
            }
        });



    }

    /*@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_LONG).show();
        textView3.setText(edittext.getText().toString());
        return super.onKeyDown(keyCode, event);
    }*/
}
