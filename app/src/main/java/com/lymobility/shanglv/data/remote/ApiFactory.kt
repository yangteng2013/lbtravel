package com.lymobility.shanglv.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit

object ApiFactory {

    private val mClient : OkHttpClient by lazy { newClient() }

    /**
     * 使用moshi进行json解析，
     * 已知使用条件：KotlinJsonAdapterFactory+@JsonClass
     * 注意事项：经试验，当属性与json字段名称不一致时，使用@Json注解，但属性声明必须是var才会生效.
     *  implementation 'com.squareup.moshi:moshi-kotlin:1.13.0'
     * 示例见[WanResponse]
     */
    private val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

    fun <T> createService(baseUrl:String, clazz: Class<T>): T =
        Retrofit.Builder().baseUrl(baseUrl).client(mClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build().create(clazz)


    private fun newClient() = OkHttpClient.Builder().apply{
        connectTimeout(30, TimeUnit.SECONDS)
        readTimeout(10,TimeUnit.SECONDS)
        writeTimeout(10,TimeUnit.SECONDS)
        addInterceptor(HttpLoggingInterceptor(HttpLog()).setLevel(HttpLoggingInterceptor.Level.BODY))
    }.build()

    /**
     * // https://mvnrepository.com/artifact/com.squareup.okhttp3/logging-interceptor
    implementation 'com.squareup.okhttp3:logging-interceptor:4.9.3'
     */
    class HttpLog : HttpLoggingInterceptor.Logger {
        override fun log(message: String) {
            Timber.d(message)
        }
    }


}
