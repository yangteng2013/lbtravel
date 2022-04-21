package com.lymobility.shanglv.core.manager

import android.content.Context
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.lymobility.shanglv.R
import com.lymobility.shanglv.core.Utils

object NetworkStateManager:DefaultLifecycleObserver {
    private val _tag:String = NetworkStateManager@this.javaClass.simpleName
    private val networkStateReceiver:NetworkStateReceiver = NetworkStateReceiver()
    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.d(_tag,"====>onResume")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Utils.getApp().registerNetworkCallback()
        }else{
            Utils.getApp().registerReceiver(networkStateReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
        }
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.d(_tag,"====>onPause")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Utils.getApp().unregisterNetworkCallback()
        }else{
            Utils.getApp().unregisterReceiver(networkStateReceiver)
        }

    }

    //https://blog.csdn.net/SweetTool/article/details/105377697
    private fun Context.registerNetworkCallback(){
        var cm:ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var builder:NetworkRequest.Builder = NetworkRequest.Builder()
        builder.addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
        builder.addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
        cm.registerNetworkCallback(builder.build(), callback)
    }
    private fun Context.unregisterNetworkCallback(){
        var cm:ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        cm.unregisterNetworkCallback(callback)
    }

    private var callback:ConnectivityManager.NetworkCallback = object : ConnectivityManager.NetworkCallback(){
        //可用网络接入
        override fun onCapabilitiesChanged(
            network: Network,
            networkCapabilities: NetworkCapabilities
        ) {
            super.onCapabilitiesChanged(network, networkCapabilities)
            //在此获取网络类型connected
            Log.d(_tag,"====>onCapabilitiesChanged")
        }

        //网络断开
        override fun onLost(network: Network) {
            super.onLost(network)
            Log.d(_tag,"====>onLost")
            Toast.makeText(
                Utils.getApp().applicationContext,
                Utils.getApp().applicationContext.getString(R.string.network_unable),
                Toast.LENGTH_SHORT
            ).show()

        }

    }

}


