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
import com.moengage.firebase.MoEFireBaseHelper
import com.moengage.pushbase.MoEPushHelper
import okhttp3.internal.notify

const val channelId = "Notification_channel"
const val channelName= "com.example.sdkdemoapp"

class MyFirebaseMessagingService : FirebaseMessagingService() {
    // generate the notification

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.e("token===>",token)
        MoEFireBaseHelper.getInstance().passPushToken(applicationContext,token)
    }

    //@RequiresApi(Build.VERSION_CODES.O)
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        if (MoEPushHelper.getInstance().isFromMoEngagePlatform(remoteMessage.data)){
            MoEFireBaseHelper.getInstance().passPushPayload(applicationContext, remoteMessage.data)
        }else{
            // your app's business logic to show notification
        }
    }



    //@RequiresApi(Build.VERSION_CODES.O)






    }

    // attach the notification created with the custom layout

    //show the notification

