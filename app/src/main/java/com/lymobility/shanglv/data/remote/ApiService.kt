package com.lymobility.shanglv.data.remote

import com.lymobility.shanglv.data.bean.ArticleData
import retrofit2.http.GET

interface ApiService {

    @GET("wxarticle/chapters/json")
    suspend fun getWXArticle() : ArticleData

}