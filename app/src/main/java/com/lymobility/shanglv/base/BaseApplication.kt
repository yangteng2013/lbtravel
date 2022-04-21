package com.lymobility.shanglv.base

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner

open class BaseApplication : Application(),ViewModelStoreOwner {

    private lateinit var appViewModelStore:ViewModelStore

    override fun onCreate() {
        super.onCreate()
        appViewModelStore = ViewModelStore()
    }

    override fun getViewModelStore(): ViewModelStore {
        return appViewModelStore
    }

}