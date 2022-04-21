package com.lymobility.shanglv.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.lymobility.shanglv.R
import com.lymobility.shanglv.core.manager.NetworkUtils
import com.lymobility.shanglv.ui.home.MainHomeActivity

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var stateMsg = "isConnected=${NetworkUtils.isConnected(requireContext())} " +
                "isMobile:${NetworkUtils.isMobile(requireContext())} " +
                "isWifi:${NetworkUtils.isWifi(requireContext())}"
        btn?.setOnClickListener {
            Log.d("MainF",stateMsg)
            Toast.makeText(context,
            stateMsg ,Toast.LENGTH_SHORT).show()
            startActivity(Intent(requireActivity(),MainHomeActivity::class.java))
        }

    }
    private lateinit var viewModel: MainViewModel
    private lateinit var rootView:View
    private lateinit var btn:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        rootView = inflater.inflate(R.layout.main_fragment, container, false)
        btn = rootView.findViewById(R.id.btn)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        // TODO: Use the ViewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        rootView?.parent?.let {
            (it as ViewGroup).removeView(rootView)
        }
    }
}