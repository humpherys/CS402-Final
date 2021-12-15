package com.example.cs402_final.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cs402_final.ItemData
import com.example.cs402_final.R

class UpdateAdapter(context: Context, var results: ArrayList<ItemData>)
    : RecyclerView.Adapter<UpdateAdapter.UpdateTagHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : UpdateAdapter.UpdateTagHolder {
        val view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_selectable_item, parent, false)
        return UpdateAdapter.UpdateTagHolder(view)
    }

    override fun getItemCount() = results.size

    override fun onBindViewHolder(holder: UpdateAdapter.UpdateTagHolder, position: Int) {
        // val item = itemList[position]
        val item = results[position]

        holder.apply {
            titleTextView.text = item.name
        }

        holder.chkbox.setOnCheckedChangeListener(null)
        holder.chkbox.isChecked = item.selected ?: false
        holder.chkbox.setOnCheckedChangeListener { buttonView, isChecked ->
            item.selected = isChecked
        }

    }

    class UpdateTagHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.item_name)
        val chkbox: CheckBox = view.findViewById(R.id.checkBox)
    }
}