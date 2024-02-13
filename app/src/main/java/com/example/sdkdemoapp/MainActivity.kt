package com.example.sdkdemoapp

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.Task
import com.google.firebase.messaging.FirebaseMessaging
import com.moengage.firebase.MoEFireBaseHelper
import com.moengage.inapp.MoEInAppHelper
import com.moengage.pushbase.MoEPushHelper


class MainActivity : AppCompatActivity() {
    val TAG = MainActivity::class.java.simpleName

    fun onButtonClick(view: View) {
        Log.d("Button","Button CLicked")
        // code to execute when the button is clicked
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myButton = findViewById<Button>(R.id.button1)

        myButton.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }


//        MoEInAppHelper.getInstance().addInAppLifeCycleListener(InAppViewListener())
//        MoEInAppHelper.getInstance().setClickActionListener(InAppOnClickListener())
          MoEPushHelper.getInstance().registerMessageListener(CustomPushMessageListener())



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
        //MoEInAppHelper.getInstance().showInApp(this)

        //MoEInAppHelper.getInstance().showNudge(this)
    }
}