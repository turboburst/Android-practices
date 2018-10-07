package com.example.turbpburst.notification

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun buttonClick(v: View){
        sendNotification()
    }

    @SuppressLint("ServiceCast")
    fun sendNotification(){
        var intent = Intent(this, MainActivity::class.java)
        var pIntent = PendingIntent.getActivity(this, 110, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        var mBuilder = NotificationCompat.Builder(this)
        var notification: Notification = mBuilder
                .setSmallIcon(R.drawable.notification_icon_background)
                .setContentTitle("My notification")
                .setContentText("notification")
                .setContentIntent(pIntent)
                .build()
        var notificationId = 123
        var notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(notificationId, notification)
    }
}
