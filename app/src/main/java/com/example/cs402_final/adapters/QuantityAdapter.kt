package com.example.cs402_final.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cs402_final.ItemData
import com.example.cs402_final.R

class QuantityAdapter(context: Context, private var itemList: ArrayList<ItemData>) :
    RecyclerView.Adapter<QuantityAdapter.QuantityHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuantityHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_quantity_item, parent, false)
        return QuantityHolder(view)
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: QuantityHolder, position: Int) {
        val item = itemList[position]

        holder.apply {
            titleTextView.text = item.name
        }
    }

    class QuantityHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.item_name)
    }
}