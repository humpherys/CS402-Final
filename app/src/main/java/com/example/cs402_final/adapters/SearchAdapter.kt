package com.example.cs402_final.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.flow.Flow

import com.example.cs402_final.activities.ItemActivity
import com.example.cs402_final.data_classes.ItemData
import com.example.cs402_final.R
import com.example.cs402_final.data_classes.Item

public class SearchAdapter(context: Context, var results: ArrayList<ItemData>)
    : RecyclerView.Adapter<SearchAdapter.ResultsHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : ResultsHolder {
        val view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_search_item, parent, false)

        return ResultsHolder(view)
    }

    override fun getItemCount() = results.size

    override fun onBindViewHolder(holder: ResultsHolder, position: Int) {
        val item = results[position]

        holder.apply {
            titleTextView.text = item.name
            titleTextView.setOnClickListener {
                val addIntent = Intent(itemView.context, ItemActivity::class.java)
//                addIntent.putExtra("item", item)
                addIntent.putExtra("origin", "search")
                startActivity(itemView.context, addIntent, null)
            }
        }
    }

    class ResultsHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.item_name)
    }
}