package com.example.sdkdemoapp

import android.util.Log
import com.moengage.inapp.listeners.InAppLifeCycleListener
import com.moengage.inapp.model.InAppData

class InAppViewListener : InAppLifeCycleListener {
    override fun onDismiss(inAppData: InAppData) {
        Log.e("Abhi", "In app Dismissed ${inAppData.toString()}")
    }

    override fun onShown(inAppData: InAppData) {
        Log.e("Abhi", "In app shown ${inAppData.toString()}")
    }
}