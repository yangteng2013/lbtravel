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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.lymobility.shanglv.R
import com.lymobility.shanglv.core.manager.NetworkUtils
import com.lymobility.shanglv.data.bean.ArticleData
import com.lymobility.shanglv.data.bean.LoadState
import com.lymobility.shanglv.databinding.MainFragmentBinding
import com.lymobility.shanglv.ui.home.MainHomeActivity

class MainFragment : Fragment() {
    private var binding: MainFragmentBinding? = null
    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    private lateinit var viewModel: MainViewModel
    private lateinit var rootView:View
    private lateinit var btn:Button
    private lateinit var btn2:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        rootView = inflater.inflate(R.layout.main_fragment, container, false)
//        btn = rootView.findViewById(R.id.btn)
//        btn2 = rootView.findViewById(R.id.btn2)
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        var stateMsg = "isConnected=${NetworkUtils.isConnected(requireContext())} " +
                "isMobile:${NetworkUtils.isMobile(requireContext())} " +
                "isWifi:${NetworkUtils.isWifi(requireContext())}"
        binding?.btn?.setOnClickListener {
            Log.d("MainF",stateMsg)
            Toast.makeText(context,
                stateMsg ,Toast.LENGTH_SHORT).show()
            startActivity(Intent(requireActivity(),MainHomeActivity::class.java))
        }
        binding?.btn2?.setOnClickListener {
            viewModel.getData()
        }
        activity?.let { it ->
            viewModel.data.observe(it, Observer { showdata(it) })
            viewModel.loadState.observe(it, Observer { changeLoadState(it) })
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        rootView?.parent?.let {
            (it as ViewGroup).removeView(rootView)
        }
    }
    private fun changeLoadState(loadState: LoadState){
        binding?.btn2?.visibility = when(loadState){
            is LoadState.Loading -> {
                binding?.message?.text = ""
                View.VISIBLE
            }
            else -> View.GONE
        }
    }

    private fun showdata(data: ArticleData){
        binding?.message?.text= "id: ${data.data[0].id}  name: ${data.data[0].name}"
    }
}