package com.example.cs402_final

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

//TODO: We will probably need more info in the tag data eventually, but idk what the db structure is
data class TagData(var tagName: String)

public class TagAdapter(context: Context, private var tagList: ArrayList<TagData> ) : RecyclerView.Adapter<TagAdapter.TagHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : TagAdapter.TagHolder {
        val view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item_view, parent, false)
        return TagHolder(view)
    }

    override fun getItemCount() = tagList.size

    override fun onBindViewHolder(holder: TagHolder, position: Int) {
        // val item = itemList[position]
        val item = tagList[position]

        holder.apply {
            titleTextView.text = item.tagName
        }

    }

    class TagHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.item_name)
    }
}