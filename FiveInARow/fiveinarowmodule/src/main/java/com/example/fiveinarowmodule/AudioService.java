package com.example.fiveinarowmodule;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2016/5/20 0020.
 */
public class AudioService extends Service{

    private MediaPlayer mediaPlayer;

    public class PhoneReceiver extends BroadcastReceiver
    {

        @Override
        public void onReceive(Context context, Intent intent)
        {
            if(intent.getAction().equals(Intent.ACTION_NEW_OUTGOING_CALL))
            {
                mediaPlayer.stop();
            }

        }
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.music);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params)
            {
                mediaPlayer.start();
                return null;
            }
        }.execute();

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        mediaPlayer.stop();
    }
}
