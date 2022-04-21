package com.lymobility.shanglv.core.manager

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

/**
 * 网络状态判断，兼容android 10（29）API
 *
 */
object NetworkUtils {

    fun isMobile(context:Context):Boolean{
        var connManager: ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            connManager?.activeNetwork?.also { ant ->
                connManager.getNetworkCapabilities(ant)?.also { nc ->
                    return nc.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                }
            }
        }else{
            connManager?.activeNetworkInfo?.also { ani ->
                return ani.type == ConnectivityManager.TYPE_MOBILE
            }
        }
        return false
    }

    fun isWifi(context:Context):Boolean{
        var connManager: ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            connManager?.activeNetwork?.also { ant ->
                connManager.getNetworkCapabilities(ant)?.also { nc ->
                    return nc.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                }
            }
        }else{
            connManager?.activeNetworkInfo?.also { ani ->
                return ani.type == ConnectivityManager.TYPE_WIFI
            }
        }
        return false
    }

    fun isConnected(context:Context):Boolean{
        var connManager: ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            connManager?.activeNetwork?.also { ant ->
                connManager.getNetworkCapabilities(ant)?.also { nc ->
                    return nc.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                }
            }
        }else{
            connManager?.activeNetworkInfo?.also { ani ->
                return ani.isConnected
            }
        }
        return false
    }



}