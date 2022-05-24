package com.lymobility.shanglv

import com.lymobility.shanglv.base.BaseApplication
import com.lymobility.shanglv.core.Utils
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        Utils.initApp(this)
    }
}