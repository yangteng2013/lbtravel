package com.lymobility.shanglv.util

import android.widget.Toast
import com.lymobility.shanglv.core.Utils

object ToastUtils {
    fun showShort(msg: String){
        Toast.makeText(Utils.getApp(),msg,Toast.LENGTH_SHORT).show()
    }
}
