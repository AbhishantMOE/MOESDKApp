package com.example.sdkdemoapp

import android.app.Application
import com.moengage.core.DataCenter
import com.moengage.core.LogLevel
import com.moengage.core.MoECoreHelper
import com.moengage.core.MoEngage
import com.moengage.core.analytics.MoEAnalyticsHelper
import com.moengage.core.config.FcmConfig
import com.moengage.core.config.LogConfig
import com.moengage.core.config.NotificationConfig
import com.moengage.core.config.TrackingOptOutConfig
import com.moengage.core.enableAdIdTracking
import com.moengage.core.enableAndroidIdTracking
import com.moengage.core.model.AppStatus


class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val trackingOptOutConfig = TrackingOptOutConfig(
            isCarrierTrackingEnabled = true,
            isDeviceAttributeTrackingEnabled = true,

            )
        //
        val moEngage = MoEngage.Builder(this, "OXTAVQZDWWAROL2ESF8FWE8G", DataCenter.DATA_CENTER_1)
            .configureLogs(LogConfig(LogLevel.VERBOSE, false))
            .configureNotificationMetaData(NotificationConfig(R.drawable.zlatan_icon, R.drawable.smalllogo))
            //.configureTrackingOptOut(trackingOptOutConfig)
            .configureFcm(
                FcmConfig(false)
            )
            .build()
        MoEngage.initialiseDefaultInstance(moEngage)
//        enableAndroidIdTracking(applicationContext)
//        enableAdIdTracking(applicationContext)
//        MoEAnalyticsHelper.setAppStatus(applicationContext, AppStatus.INSTALL)
//
//        MoEAnalyticsHelper.setUniqueId(applicationContext, "65b8d313ef6641a0cd145c59")
//
//        MoEAnalyticsHelper.setFirstName(applicationContext,"Akatsuki")






    }

}