package com.ni.coffeeshop.ui.common.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ni.coffeeshop.data.models.MenuItemModel
import com.ni.coffeeshop.databinding.ItemMenuBinding

class MenuItemAdapter : RecyclerView.Adapter<MenuItemAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var currentPosition: Int = -1

        init {
            binding.root.setOnClickListener {
                if (currentPosition != RecyclerView.NO_POSITION) {
                    itemClickListener?.onItemClicked(currentPosition)
                }
            }
        }

        fun bind(optionItem: MenuItemModel, position: Int) {
            currentPosition = position
            binding.tvItemName.text = optionItem.name
        }
    }

    private var itemClickListener: ItemClickListener? = null
    private var menuItemList = ArrayList<MenuItemModel>()

    fun setItemClickListener(listener: ItemClickListener) {
        itemClickListener = listener
    }

    fun setList(_menuItemList: ArrayList<MenuItemModel>) {
        menuItemList = _menuItemList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): MenuItemAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMenuBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(menuItemList[position], position)
    }

    override fun getItemCount(): Int {
        return menuItemList.size
    }
}