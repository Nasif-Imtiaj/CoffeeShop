package com.ni.coffeeshop.ui.screens.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.ni.coffeeshop.databinding.FragmentHomeBinding
import com.ni.coffeeshop.ui.common.FragmentHelper
import com.ni.coffeeshop.ui.common.adapters.ItemClickListener
import com.ni.coffeeshop.ui.common.adapters.MenuCategoryAdapter
import com.ni.coffeeshop.ui.common.adapters.MenuItemAdapter
import com.ni.coffeeshop.ui.screens.coffee.CoffeeFragment


class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    private lateinit var menuCategoryAdapter: MenuCategoryAdapter
    private lateinit var menuItemAdapter: MenuItemAdapter

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
        initMenuCategory()
        initMenuItem()
    }

    fun initMenuCategory(){
        menuCategoryAdapter = MenuCategoryAdapter()
        menuCategoryAdapter.setList(viewModel.getMenuCategoryList())
        binding.rvMenuCategories.adapter = menuCategoryAdapter
    }

    fun initMenuItem(){
        menuItemAdapter = MenuItemAdapter()
        menuItemAdapter.setList(viewModel.getMenuItemList())
        binding.rvMenuItems.adapter = menuItemAdapter
        menuItemAdapter.setItemClickListener(object : ItemClickListener {
            override fun onItemClicked(index: Int) {
                 FragmentHelper.loadFragment(
                     requireActivity() as AppCompatActivity,
                     CoffeeFragment.newInstance(),
                     true,
                     false,
                     "",
                     binding.flFragmentContainer.id
                 )
            }
        })
        val layoutManager = GridLayoutManager(context, 2)
        binding.rvMenuItems.layoutManager = layoutManager
    }
}