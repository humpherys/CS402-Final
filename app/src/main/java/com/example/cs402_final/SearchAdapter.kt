package com.example.cs402_final

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

public class SearchAdapter(context: Context, var results: ArrayList<ItemData>)
    : RecyclerView.Adapter<SearchAdapter.ResultsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : SearchAdapter.ResultsHolder {
        val view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item_view, parent, false)
        return ResultsHolder(view)
    }

    override fun getItemCount() = results.size

    override fun onBindViewHolder(holder: ResultsHolder, position: Int) {
        val item = results[position]
        holder.apply {
            titleTextView.text = item.name
        }
    }

    class ResultsHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.item_name)
    }
}