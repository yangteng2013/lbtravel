package com.lymobility.shanglv.core

import android.content.Context
object Utils {
    private var appContext:Context?=null

    fun initApp(context: Context){
        if (appContext==null) {
            appContext = context
        }
    }

    fun getApp():Context{
        return appContext!!
    }


}