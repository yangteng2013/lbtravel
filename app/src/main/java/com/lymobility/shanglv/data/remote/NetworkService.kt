package com.lymobility.shanglv.data.remote

object NetworkService {
    const val STAGING_HOST = "http://test-obt.dfshanglv.com"
    const val PRO_HOST = "http://www.lanyou-shanglv.com"
    private const val BASE_URL = "https://www.wanandroid.com/"

    val api by lazy { ApiFactory.createService(PRO_HOST, ApiService::class.java) }
}
