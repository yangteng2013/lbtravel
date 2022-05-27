package com.lymobility.shanglv.data.remote

object NetworkService {
    private const val BASE_URL = "https://www.wanandroid.com/"

    val api by lazy { ApiFactory.createService(BASE_URL, ApiService::class.java) }
}
