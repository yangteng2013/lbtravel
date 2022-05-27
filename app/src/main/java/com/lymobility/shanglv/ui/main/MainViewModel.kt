package com.lymobility.shanglv.ui.main

import androidx.lifecycle.MutableLiveData
import com.lymobility.shanglv.base.BaseViewModel
import com.lymobility.shanglv.base.launch
import com.lymobility.shanglv.data.bean.ArticleData
import com.lymobility.shanglv.data.bean.LoadState
import com.lymobility.shanglv.data.remote.Repository

class MainViewModel : BaseViewModel() {

    val data = MutableLiveData<ArticleData>()

    fun getData() = launch({
        loadState.value = LoadState.Loading()
        data.value = Repository.getWXArticle()
        loadState.value = LoadState.Success()
    },{
        loadState.value = LoadState.Fail()
    })
}