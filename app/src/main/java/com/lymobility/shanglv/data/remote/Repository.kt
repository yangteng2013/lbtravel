package com.lymobility.shanglv.data.remote

import android.content.Context
import com.lymobility.shanglv.data.bean.ArticleData
import com.lymobility.shanglv.data.bean.Employee

object Repository {
    private suspend fun <T : BaseBean> preprocessData(baseBean: T, context: Context? = null): T =
        if (baseBean.errorCode == 0) {// 成功
            // 返回数据
            baseBean
        } else {// 失败
            // 抛出接口异常
            throw ApiException(baseBean.errorCode, baseBean.errorMsg)
        }

    private suspend fun <T : Response<*>> preprocessDatas(baseBean: T, context: Context? = null): T =
        if (baseBean.code == 0) {// 成功
            // 返回数据
            baseBean
        } else {// 失败
            // 抛出接口异常
            throw ApiException(baseBean.code, baseBean.message)
        }

    suspend fun getWXArticle(): ArticleData =
        NetworkService.api.getWXArticle().let {
            preprocessData(it)
        }

    suspend fun login(userName:String, pwd:String): Response<Employee> =
        NetworkService.api.login(userName,pwd).let {
            preprocessDatas(it)
        }
}
