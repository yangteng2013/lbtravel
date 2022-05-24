package com.lymobility.shanglv

import android.content.ClipboardManager
import android.os.Build
import android.os.Bundle
import com.hjq.permissions.OnPermissionCallback
import com.hjq.permissions.Permission
import com.hjq.permissions.XXPermissions
import com.kunminx.architecture.ui.page.DataBindingConfig
import com.lymobility.shanglv.base.BaseActivity
import com.lymobility.shanglv.ui.model.MainActivityViewModel
import com.lymobility.shanglv.ui.main.MainFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private lateinit var mainActivityViewModel: MainActivityViewModel
    @Inject
    internal lateinit var clipboardManager: ClipboardManager

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

        Timber.i("clipboardManager.hashCode:${clipboardManager.hashCode()}")

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