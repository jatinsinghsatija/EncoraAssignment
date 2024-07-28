package com.example.encoraassignment.utility

import android.app.Activity
import android.app.Application
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class GlobalCache : Application(), LifecycleObserver {
    private val activityLifecycleCallbacks = ActivityLifecycleCallbacks()


    override fun onCreate() {
        super.onCreate()
        globalContext = this
        registerActivityLifecycleCallbacks(activityLifecycleCallbacks)
    }

    companion object {
        fun getCurrentActivity(): Activity? {
            return globalContext.activityLifecycleCallbacks.currentActivity
        }

        lateinit var globalContext: GlobalCache
            private set

        var isAppInForeground = false
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onAppBackgrounded() {
        //App in background
        isAppInForeground = false
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onAppForegrounded() {
        // App in foreground
        isAppInForeground = true
    }

}