package com.example.sdkdemoapp

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.moengage.inapp.MoEInAppHelper
import okhttp3.internal.notify

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val button = findViewById<Button>(R.id.notif_button)
        button.setOnClickListener{

        }
    }

    override fun onStart() {
        super.onStart()
        //MoEInAppHelper.getInstance().showInApp(this)



    }

}