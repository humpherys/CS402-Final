package com.example.cs402_final

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class ItemListAdapter(context: Context, var results: List<Item>) {

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
//
//        return ItemViewHolder.create(parent)
//    }

//    override fun onBindViewHolder(holder: ItemViewHolder, position: Int){
//        val current = results[position]
//
//        holder.apply {
//
//            itemItemView.text = current.itemName
//            itemItemView.setOnClickListener {
//                val addIntent = Intent(itemView.context, ItemActivity::class.java)
//            }
//        }
//    }


    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemItemView: TextView = itemView.findViewById(R.id.item_name)

        fun bind(text: String?) {
            itemItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): ItemViewHolder {
                val view: View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_search_results, parent, false)
                return ItemViewHolder(view)
            }
        }
    }

    companion object {
        private val ITEMS_COMPARATOR = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.itemName == newItem.itemName
            }
        }
    }
}