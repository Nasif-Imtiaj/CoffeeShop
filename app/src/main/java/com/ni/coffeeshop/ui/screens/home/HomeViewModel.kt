package com.ni.coffeeshop.ui.screens.home

import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private var menuCategoryList = ArrayList<String>()
    init {
        generateMenuCategoryList()
    }

    private fun generateMenuCategoryList(){
        menuCategoryList.add("Item 1")
        menuCategoryList.add("Item 2")
        menuCategoryList.add("Item 3")
    }
    fun getMenuCategoryList(): ArrayList<String>{
        return menuCategoryList
    }
}