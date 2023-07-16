package com.ni.coffeeshop.ui.screens.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ni.coffeeshop.databinding.FragmentHomeBinding
import com.ni.coffeeshop.ui.common.adapters.MenuCategoryAdapter

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    private lateinit var menuCategoryAdapter: MenuCategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        menuCategoryAdapter = MenuCategoryAdapter()
        menuCategoryAdapter.setList(viewModel.getMenuCategoryList())
        binding.rcMenu.adapter = menuCategoryAdapter
    }

}