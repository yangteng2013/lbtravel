package com.lymobility.shanglv.data.remote

class ApiException(val errorCode: Int,val msg: String):Throwable(msg)
