package com.lymobility.shanglv.data.remote

import com.lymobility.shanglv.data.bean.ArticleData
import com.lymobility.shanglv.data.bean.Employee
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST



interface ApiService {

    @GET("wxarticle/chapters/json")
    suspend fun getWXArticle() : ArticleData

    @POST("/sme/employee/login.json")
    fun login(
        @Field("loginName") name: String?,
        @Field("pwd") password: String?
    ): Response<Employee>
}