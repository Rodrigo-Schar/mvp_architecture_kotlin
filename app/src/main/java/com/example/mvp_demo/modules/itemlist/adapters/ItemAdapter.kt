package com.example.mvp_demo.modules.itemlist.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvp_demo.databinding.ItemcardBinding
import com.example.mvp_demo.modules.itemlist.models.Item

class ItemAdapter(val itemList: MutableList<Item>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(val binding: ItemcardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun fillData(item: Item) {
            binding.lbTitle.text = "Title: ${item.title}"
            binding.lbBody.text = "Description: ${item.body}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemcardBinding.inflate(inflater, null, false)
        val itemViewHolder = ItemViewHolder(binding)
        return itemViewHolder
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.fillData(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}