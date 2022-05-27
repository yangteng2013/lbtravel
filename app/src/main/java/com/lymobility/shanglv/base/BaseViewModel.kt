package com.lymobility.shanglv.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lymobility.shanglv.data.bean.LoadState
import com.lymobility.shanglv.data.remote.ExceptionUtil
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun ViewModel.launch(
    block : suspend CoroutineScope.() -> Unit,
    onError: (e:Throwable) -> Unit,
    onComplete : () -> Unit = {}
){
    viewModelScope.launch(
        CoroutineExceptionHandler { _, throwable ->
            run{
                ExceptionUtil.catchException(throwable)
                onError(throwable)
            }
        }
    ) {
        try {
            block.invoke(this)
        }finally {
            onComplete()
        }

    }
}


abstract class BaseViewModel : ViewModel() {
    val loadState = MutableLiveData<LoadState>()
}