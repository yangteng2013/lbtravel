package com.lymobility.shanglv.base

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kunminx.architecture.ui.page.DataBindingActivity
import com.lymobility.shanglv.core.manager.NetworkStateManager

abstract class BaseActivity: DataBindingActivity() {
    private lateinit var mActivityProvider:ViewModelProvider
    private lateinit var mApplicationProvider:ViewModelProvider
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycle?.addObserver(NetworkStateManager)
    }

    //TODO tip 2: Jetpack 通过 "工厂模式" 来实现 ViewModel 的作用域可控，
    //目前我们在项目中提供了 Application、Activity、Fragment 三个级别的作用域，
    //值得注意的是，通过不同作用域的 Provider 获得的 ViewModel 实例不是同一个，
    //所以如果 ViewModel 对状态信息的保留不符合预期，可以从这个角度出发去排查 是否眼前的 ViewModel 实例不是目标实例所致。
    //如果这样说还不理解的话，详见 https://xiaozhuanlan.com/topic/6257931840
    protected open fun <T : ViewModel> getActivityScopeViewModel(modelClass: Class<T>): T {
        mActivityProvider = ViewModelProvider(this)
        return mActivityProvider[modelClass]
    }

    protected open fun <T : ViewModel> getApplicationScopeViewModel(modelClass: Class<T>): T {
        mApplicationProvider = ViewModelProvider((this.applicationContext as BaseApplication)!!)
        return mApplicationProvider[modelClass]
    }


}