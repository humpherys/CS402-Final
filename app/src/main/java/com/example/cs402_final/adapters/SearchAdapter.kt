package com.example.cs402_final.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.cs402_final.activities.ItemActivity
import com.example.cs402_final.ItemData
import com.example.cs402_final.R

public class SearchAdapter(context: Context, var results: ArrayList<ItemData>)
    : RecyclerView.Adapter<SearchAdapter.ResultsHolder>() {

//    private var itemList = emptyList<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : ResultsHolder {
        val view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item_view, parent, false)
        return ResultsHolder(view)
    }

    override fun getItemCount() = results.size

    override fun onBindViewHolder(holder: ResultsHolder, position: Int) {
        // val item = itemList[position]
        val item = results[position]

        holder.apply {
            titleTextView.text = item.name
            titleTextView.setOnClickListener {
                val addIntent = Intent(itemView.context, ItemActivity::class.java)
                addIntent.putExtra("item", item)
                addIntent.putExtra("origin", "search")
                startActivity(itemView.context, addIntent, null)
            }
        }

    }

    class ResultsHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.item_name)
    }
//
//    fun setData(item: List<Item>){
//        this.results = item
//        notifyDataSetChanged()
//    }
}