package com.lymobility.shanglv

import android.os.Build
import android.os.Bundle
import com.hjq.permissions.OnPermissionCallback
import com.hjq.permissions.Permission
import com.hjq.permissions.XXPermissions
import com.kunminx.architecture.ui.page.DataBindingConfig
import com.lymobility.shanglv.base.BaseActivity
import com.lymobility.shanglv.ui.model.MainActivityViewModel
import com.lymobility.shanglv.ui.main.MainFragment

class MainActivity : BaseActivity() {
    private lateinit var mainActivityViewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //TODO tip：Android 12 部分权限的处理
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            XXPermissions.with(this)
                .permission(Permission.READ_PHONE_STATE)
                .request(object : OnPermissionCallback {
                    override fun onGranted(permissions: List<String>, all: Boolean) {
                        initFragment(savedInstanceState)
                    }

                    override fun onDenied(permissions: List<String>, never: Boolean) {
                        finish()
                    }
                })
        } else {
            initFragment(savedInstanceState)
        }


    }

    private fun initFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

    override fun initViewModel() {
        mainActivityViewModel = getActivityScopeViewModel(MainActivityViewModel::class.java)
    }

    override fun getDataBindingConfig(): DataBindingConfig {
        return DataBindingConfig(R.layout.main_activity,BR.vm,mainActivityViewModel)
    }


}