package com.lymobility.shanglv.core.manager

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast
import com.lymobility.shanglv.R

class NetworkStateReceiver: BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        when (p1?.action) {
            ConnectivityManager.CONNECTIVITY_ACTION -> {
                p0?.also {
                    if (!NetworkUtils.isConnected(it)) {
                        Toast.makeText(
                            it.applicationContext,
                            it.applicationContext.getString(R.string.network_unable),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

            }
            else -> {}
        }
    }
}