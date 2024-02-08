package com.example.sdkdemoapp
import android.util.Log
import com.moengage.inapp.listeners.OnClickActionListener
import com.moengage.inapp.model.ClickData

class InAppOnClickListener : OnClickActionListener {
    override fun onClick(clickData: ClickData): Boolean {
        Log.d("InApp","The action happend on clicking")
        return true;
    }
}