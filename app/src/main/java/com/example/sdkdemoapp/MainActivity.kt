package com.example.sdkdemoapp

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.Task
import com.google.firebase.messaging.FirebaseMessaging
import com.moengage.firebase.MoEFireBaseHelper
import com.moengage.inapp.MoEInAppHelper


class MainActivity : AppCompatActivity() {
    val TAG = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseMessaging.getInstance().token.addOnSuccessListener { token: String ->
            if (!TextUtils.isEmpty(token)) {
                Log.d(TAG, "retrieve token successful : $token")
                MoEFireBaseHelper.getInstance().passPushToken(applicationContext,token)
            } else {
                Log.w(TAG, "token should not be null...")
            }
        }
    }

    override fun onStart() {
        super.onStart()
        MoEInAppHelper.getInstance().showInApp(this)
    }
}