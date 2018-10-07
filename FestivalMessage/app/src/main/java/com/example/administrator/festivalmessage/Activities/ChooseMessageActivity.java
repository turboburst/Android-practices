package com.example.administrator.festivalmessage.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.festivalmessage.Bean.FestivalLab;
import com.example.administrator.festivalmessage.Bean.Msg;
import com.example.administrator.festivalmessage.R;

public class ChooseMessageActivity extends AppCompatActivity {

    private ListView listView;
    private FloatingActionButton floatingActionButton;
    private ArrayAdapter<Msg> arrayAdapter;
    private static int festivalID;
    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_message);
        inflater = LayoutInflater.from(this);
        initViews();
        initEvents();

    }

    private void initEvents() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendMsgActivity.toActivity(ChooseMessageActivity.this, festivalID, -1);

            }
        });
    }

    private void initViews()
    {
        listView = (ListView) findViewById(R.id.listViewid);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButtonid);
        arrayAdapter = new ArrayAdapter<Msg>(ChooseMessageActivity.this, -1,
                FestivalLab.getInstance().getMsgByFestivalid(festivalID))
        {
            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                if(convertView == null)
                {
                    convertView = inflater.inflate(R.layout.item_message, parent, false);
                }
                TextView msgTextview = (TextView) convertView.findViewById(R.id.msgtextviewid);
                Button msgButton = (Button) convertView.findViewById(R.id.msgbuttonid);
                msgTextview.setText(getItem(position).getMessage());
                msgButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SendMsgActivity.toActivity(ChooseMessageActivity.this, festivalID, getItem(position).getId());
                    }
                });

                return convertView;
            }
        };
        listView.setAdapter(arrayAdapter);
    }

    public static void toActivity(Context context, int value)
    {
        Intent intent = new Intent(context, ChooseMessageActivity.class);
        intent.putExtra(context.getString(R.string.FestivalID), value);
        festivalID = value;
        context.startActivity(intent);
    }

}
