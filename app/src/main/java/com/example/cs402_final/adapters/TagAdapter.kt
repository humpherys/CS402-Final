package com.example.cs402_final.adapters

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.cs402_final.R
import com.example.cs402_final.activities.ItemSearchActivity
import kotlinx.parcelize.Parcelize

//TODO: We will probably need more info in the tag data eventually, but idk what the db structure is
@Parcelize
data class TagData(
    var tagName: String,
    var selected: Boolean? = null
) : Parcelable

public class TagAdapter(context: Context, private var tagList: ArrayList<TagData>) :
    RecyclerView.Adapter<TagAdapter.TagHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : TagHolder {
        val view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.view_search_item, parent, false)
        return TagHolder(view)
    }

    override fun getItemCount() = tagList.size

    override fun onBindViewHolder(holder: TagHolder, position: Int) {
        // val item = itemList[position]
        val tag = tagList[position]

        holder.apply {
            titleTextView.text = tag.tagName
            titleTextView.setOnClickListener {
                val tagIntent = Intent(itemView.context, ItemSearchActivity::class.java)
                tagIntent.putExtra("action", "tagManage")
                tagIntent.putExtra("tag", tag)
                startActivity(itemView.context, tagIntent, null)
            }
        }

    }

    class TagHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.item_name)
    }
}