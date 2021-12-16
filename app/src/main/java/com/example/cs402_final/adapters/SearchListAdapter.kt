package com.example.cs402_final.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.cs402_final.data_classes.Item
import com.example.cs402_final.activities.ItemActivity
import com.example.cs402_final.R

/**
 * This is the pretty much the same as Mason's with a few changes to handle Room.
 * It is not working yet
 */

class SearchListAdapter: RecyclerView.Adapter<SearchListAdapter.ResultsHolder>() {

    private var itemList = emptyList<Item>()

    class ResultsHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.item_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : ResultsHolder {
        val view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_search_item, parent, false)
        return ResultsHolder(view)
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: ResultsHolder, position: Int) {
        val item = itemList[position]

        holder.apply {
            titleTextView.text = item.itemName
            titleTextView.setOnClickListener {
                val addIntent = Intent(itemView.context, ItemActivity::class.java)
                //addIntent.putExtra("item", item)
                ContextCompat.startActivity(itemView.context, addIntent, null)
            }
        }

    }

    fun setData(item: List<Item>){
        this.itemList = item
        notifyDataSetChanged()
    }


}