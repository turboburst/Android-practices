package com.example.administrator.festivalmessage.Activities;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.festivalmessage.Bean.Festival;
import com.example.administrator.festivalmessage.Bean.Msg;
import com.example.administrator.festivalmessage.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.HashSet;

public class SendMsgActivity extends AppCompatActivity {

    public static final String key_festivalid = "FESTIVAL_ID";
    public static final String key_msgid = "MSG_ID";
    private Festival festival;
    private Msg message;
    private int mFestivalId;
    private int mMsgId;
    private EditText editText;
    private Button button;
    private static final int CODE_REQUEST = 1;
    private HashSet<String> names = new HashSet<String>();
    private HashSet<String> numbers = new HashSet<String>();
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_msg);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        initDatas();
        initViews();
    }

    private void initViews()
    {
        
    }

    private void initDatas()
    {
        mFestivalId = getIntent().getIntExtra(key_festivalid, -1);
        mMsgId = getIntent().getIntExtra(key_msgid, -1);
    }

    public static void toActivity(Context context, int mFestivalId, int mMsgId)
    {
        Intent intent = new Intent(context, SendMsgActivity.class);
        intent.putExtra("FESTIVAL_ID", mFestivalId);
        intent.putExtra("MSG_ID", mMsgId);
        context.startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODE_REQUEST)
        {
            if (resultCode == RESULT_OK)
            {
                Uri contacturi = data.getData();
                Cursor cursor = managedQuery(contacturi, null, null, null, null);
                cursor.moveToFirst();
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                names.add(name);
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "SendMsg Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.administrator.festivalmessage.Activities/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "SendMsg Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.administrator.festivalmessage.Activities/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
