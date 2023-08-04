package com.ni.coffeeshop.ui.screens.home

import android.graphics.drawable.Drawable
import androidx.lifecycle.ViewModel
import com.ni.coffeeshop.R
import com.ni.coffeeshop.data.models.MenuItemModel

class HomeViewModel : ViewModel() {
    private var menuCategoryList = ArrayList<String>()
    private var menuItemList = ArrayList<MenuItemModel>()

    init {
        generateMenuCategoryList()
        generateMenuItemList()
    }

    private fun generateMenuItemList() {
        for (i in 1..5) {
            menuItemList.add(
                MenuItemModel(
                    "Dummy",
                    "Dummy",
                    2.5,
                    5.0,
                    R.drawable.coffee_demo
                )
            )
        }
    }

    private fun generateMenuCategoryList() {
        menuCategoryList.add("Item 1")
        menuCategoryList.add("Item 2")
        menuCategoryList.add("Item 3")
        menuCategoryList.add("Item 3")
        menuCategoryList.add("Item 3")
        menuCategoryList.add("Item 3")
        menuCategoryList.add("Item 3")
        menuCategoryList.add("Item 3")
        menuCategoryList.add("Item 3")

    }

    fun getMenuCategoryList(): ArrayList<String> {
        return menuCategoryList
    }

    fun getMenuItemList(): ArrayList<MenuItemModel> {
        return menuItemList
    }
}