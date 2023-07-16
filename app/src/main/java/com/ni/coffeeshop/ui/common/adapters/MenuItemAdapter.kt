package com.ni.coffeeshop.ui.common.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ni.coffeeshop.R
import com.ni.coffeeshop.data.models.MenuItemModel

class MenuItemAdapter : RecyclerView.Adapter<MenuItemAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView : TextView = itemView.findViewById(R.id.tvItemName)
    }
    private var menuItemList = ArrayList<MenuItemModel>()

    fun setList(_menuItemList : ArrayList<MenuItemModel>){
        menuItemList = _menuItemList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = menuItemList[position].name
     }


    override fun getItemCount(): Int {
       return menuItemList.size
    }

}