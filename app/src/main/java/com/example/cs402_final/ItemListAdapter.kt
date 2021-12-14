package com.example.cs402_final

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.ScrollView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cs402_final.activities.ItemActivity
import com.example.cs402_final.adapters.SearchAdapter
import com.example.cs402_final.adapters.SearchListAdapter
import com.example.cs402_final.data_classes.Item
import com.example.cs402_final.data_classes.ItemViewModel
import org.w3c.dom.Text


class ItemListAdapter(context: Context, var results: LiveData<List<Item>>): RecyclerView.Adapter<ItemListAdapter.ItemViewHolder>() {

    private var itemList = emptyList<Item>()

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemNameText: TextView = itemView.findViewById(R.id.item_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.search_item_view, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {



        //holder.bindTo(getItemId(position))
        val current = getItemId(position)


        holder.apply {
            holder.itemNameText.text= current.to
            holder.itemNameText.setOnClickListener {
                val addIntent = Intent(itemView.context, ItemActivity::class.java)
                addIntent.putExtra("origin", "search")
                ContextCompat.startActivity(itemView.context, addIntent, null)
            }
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun setData(item: List<Item>){
        this.itemList = item
        notifyDataSetChanged()
    }

}