package com.example.sdkdemoapp

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import com.moengage.pushbase.push.PushMessageListener

class CustomPushMessageListener : PushMessageListener() {

    override fun isNotificationRequired(context: Context, payload: Bundle): Boolean {
        val shouldDisplay =  super.isNotificationRequired(context, payload)
        if(shouldDisplay){
            Log.d("Abhi","I am allowing notification to be displayed")
            return true
        }else{
            Log.d("Abhi","This is a silent notification")
            return false;
        }

    }

    override fun onNotificationReceived(context: Context, payload: Bundle) {
        super.onNotificationReceived(context, payload)
        Log.d("Abhi","I received the notification sucessfully")

    }

    override fun onNotificationClick(activity: Activity, payload: Bundle) {
        super.onNotificationClick(activity, payload)
        Log.d("Abhi","I clicked the notification sucessfully")

    }

    override fun onNotificationCleared(context: Context, payload: Bundle) {
        super.onNotificationCleared(context, payload)
        Log.d("Abhi","I cleared the notification sucessfully")

    }

}