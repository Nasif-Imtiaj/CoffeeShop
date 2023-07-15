package com.ni.coffeeshop.ui.common.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ni.coffeeshop.R


class MenuItem() : RecyclerView.Adapter<MenuItem.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.tvItemName)
    }

    var itemNamesList = ArrayList<String>()

    fun setItemList(_itemNamesList: ArrayList<String>) {
        this.itemNamesList = _itemNamesList
        Log.d("TESTSIZE", "setItemList: ${itemNamesList.size}")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItem.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuItem.ViewHolder, position: Int) {
        holder.textView.text = itemNamesList[position]
    }

    override fun getItemCount(): Int {
        return itemNamesList.size
    }
}