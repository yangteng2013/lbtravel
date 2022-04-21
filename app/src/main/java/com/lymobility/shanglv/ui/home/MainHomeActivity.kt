package com.lymobility.shanglv.ui.home

import android.content.Intent
import android.net.wifi.hotspot2.pps.HomeSp
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationBarView
import com.kunminx.architecture.ui.page.DataBindingConfig
import com.lymobility.shanglv.R
import com.lymobility.shanglv.base.BaseActivity
import com.lymobility.shanglv.databinding.ActivityMainHomeBinding
import com.lymobility.shanglv.ui.home.ui.dashboard.DashboardFragment
import com.lymobility.shanglv.ui.home.ui.home.HomeFragment
import com.lymobility.shanglv.ui.home.ui.notifications.NotificationsFragment
import com.lymobility.shanglv.ui.manager.ManagerActivity
import com.lymobility.shanglv.ui.travelrequest.TravelRequestActivity

class MainHomeActivity : BaseActivity() {

    private lateinit var binding: ActivityMainHomeBinding
    private val _tag = MainHomeActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main_home)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home, R.id.navigation_manager,R.id.navigation_make,R.id.navigation_dashboard, R.id.navigation_notifications
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navView.setOnItemSelectedListener { item ->
            var selectFragment: Fragment? = null
            when (item.itemId) {
                R.id.navigation_home -> {
                    selectFragment = HomeFragment()
                }
                R.id.navigation_manager -> {
                    startActivity(Intent(this,ManagerActivity::class.java))
                    return@setOnItemSelectedListener false
                }
                R.id.navigation_make -> {
                    startActivity(Intent(this,TravelRequestActivity::class.java))
                    return@setOnItemSelectedListener false
                }
                R.id.navigation_dashboard -> {
                    selectFragment = DashboardFragment()
                }
                R.id.navigation_notifications -> {
                    selectFragment = NotificationsFragment()
                }
                else -> {}
            }
            selectFragment?.apply {
                supportFragmentManager.beginTransaction().replace(R.id.container, this).commitNow()
            }
            true
        }

    }

    override fun initViewModel() {
        TODO("Not yet implemented")
    }

    override fun getDataBindingConfig(): DataBindingConfig {
        TODO("Not yet implemented")
    }


}