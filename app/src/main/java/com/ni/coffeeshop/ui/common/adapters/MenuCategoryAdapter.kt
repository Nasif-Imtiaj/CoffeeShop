package com.ni.coffeeshop.ui.common.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ni.coffeeshop.R


class MenuCategoryAdapter() : RecyclerView.Adapter<MenuCategoryAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.tvItemName)
    }

    var menuCategoryList = ArrayList<String>()

    fun setList(_menuCategoryList: ArrayList<String>) {
        this.menuCategoryList = _menuCategoryList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuCategoryAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuCategoryAdapter.ViewHolder, position: Int) {
        holder.textView.text = menuCategoryList[position]
    }

    override fun getItemCount(): Int {
        return menuCategoryList.size
    }
}