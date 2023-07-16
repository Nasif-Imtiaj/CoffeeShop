package com.ni.coffeeshop.ui.screens.home

import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private var menuList = ArrayList<String>()
    init {
        generateMenuList()
    }

    private fun generateMenuList(){
        menuList.add("Item 1")
        menuList.add("Item 2")
        menuList.add("Item 3")
    }
    fun getMenuList(): ArrayList<String>{
        return menuList;
    }
}