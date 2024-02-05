package com.example.sdkdemoapp

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import android.widget.RemoteViews
import android.widget.RemoteViews.RemoteView
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import okhttp3.internal.notify

const val channelId = "Notification_channel"
const val channelName= "com.example.sdkdemoapp"

class MyFirebaseMessagingService : FirebaseMessagingService() {
    // generate the notification

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.e("token===>",token)
    }

    //@RequiresApi(Build.VERSION_CODES.O)
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        if(remoteMessage.notification != null){
        generateNotification(
            remoteMessage.notification!!.title!!,
            remoteMessage.notification!!.body!!
        )
    }
    }

    fun getRemoteView(title:String,message:String): RemoteViews{
        val remoteView = RemoteViews("com.example.sdkdemoapp",R.layout.notification )

        remoteView.setTextViewText(R.id.title,title)
        remoteView.setTextViewText(R.id.message,message)
        remoteView.setImageViewResource(R.id.app_logo,R.drawable.smalllogo)

        return remoteView
    }

    //@RequiresApi(Build.VERSION_CODES.O)
    fun generateNotification(title:String, message:String){

        // to redirect to app
        val intent = Intent(this,MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)  // clears all the activity in activity stack and puts this on top
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE
        )

        //channel id, channel name
        var builder : NotificationCompat.Builder = NotificationCompat
            .Builder(applicationContext, channelId)
            .setSmallIcon(R.drawable.smalllogo)
            .setAutoCancel(true)
            .setVibrate(longArrayOf(1000,1000,1000,1000))
            .setOnlyAlertOnce(true).setContentIntent(pendingIntent)

        builder = builder.setContent(getRemoteView(title,message))


        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE,) as NotificationManager

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val notificationChannel = NotificationChannel(channelId, channelName,NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        notificationManager.notify(0,builder.build())





    }

    // attach the notification created with the custom layout

    //show the notification

}