package com.lymobility.shanglv

import com.lymobility.shanglv.base.BaseApplication
import com.lymobility.shanglv.core.Utils

class App : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        Utils.initApp(this)
    }
}