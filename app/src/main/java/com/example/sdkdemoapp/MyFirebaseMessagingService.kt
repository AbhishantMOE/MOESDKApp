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
            //MoEFireBaseHelper.getInstance().passPushPayload(applicationContext, remoteMessage.data)
            if(MoEPushHelper.getInstance().isSilentPush(remoteMessage.data)){
                Log.d("Abhi","This is for silent notification hahahahaha")
                Log.d("Abhi",remoteMessage.data.toString())
            }
            else {
            Log.d("Abhi","Iam not taking anything from the remote msg")
            makeNotif()
            }
        }else{
            // your app's business logic to show notification
        }
    }



    public fun makeNotif(){

        val intent = Intent(this,MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val pendingIntent= PendingIntent.getActivity(this, 0, intent,
            PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE)
        val builder: NotificationCompat.Builder = NotificationCompat
            .Builder(applicationContext,"general")
            .setSmallIcon(R.drawable.smalllogo)
            .setAutoCancel(true)     // removes notification after clicking
            .setContentIntent(pendingIntent)

        builder.setContent(RemoteViews("com.example.sdkdemoapp",R.layout.notification))

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val notificationChannel = NotificationChannel("general","com.example.sdkdemoapp",NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        notificationManager.notify(0,builder.build())


    }



    //@RequiresApi(Build.VERSION_CODES.O)






    }

    // attach the notification created with the custom layout

    //show the notification

