package com.ni.coffeeshop.ui.screens.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ni.coffeeshop.databinding.FragmentHomeBinding
import com.ni.coffeeshop.ui.common.adapter.MenuItem

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    private lateinit var adapter: MenuItem

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MenuItem()
        adapter.setItemList(getData())
        binding.rcMenu.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

    }

    private fun getData(): ArrayList<String> {
        // Replace with your own data retrieval logic
        var list = ArrayList<String>()
        list.add("Item 1")
        list.add("Item 2")
        list.add("Item 3")
        return list
    }

}