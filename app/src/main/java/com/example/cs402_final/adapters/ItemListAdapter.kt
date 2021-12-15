package com.example.cs402_final.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.cs402_final.R
import com.example.cs402_final.activities.ItemActivity
import com.example.cs402_final.data_classes.Item


class ItemListAdapter: RecyclerView.Adapter<ItemListAdapter.ItemViewHolder>() {

    private var itemList = emptyList<Item>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder.create(parent)
//        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.search_item_view, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val current = itemList[position]

        holder.apply {
            itemItemViewName.text = current.itemName
            itemItemViewName.setOnClickListener {
                val addIntent = Intent(itemView.context, ItemActivity::class.java)
//              addIntent.putExtra("item", item)
                addIntent.putExtra("origin", "search")
                ContextCompat.startActivity(itemView.context, addIntent, null)
            }
        }

            // TODO Below is for custom row Item

//            itemViewItemID.text = current.itemId.toString()
//            itemViewItemQty.text = current.itemQty.toString()
//            itemViewButton.setOnClickListener {
//                val addIntent = Intent(itemView.context, ItemActivity::class.java)
////                addIntent.putExtra("item", item)
//                addIntent.putExtra("origin", "search")
//                ContextCompat.startActivity(itemView.context, addIntent, null)
//            }

        //holder.bind(current.toString())
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemItemViewName: TextView = itemView.findViewById(R.id.item_name)

        // TODO This is for custom_row_item if we decide to use that
//        val itemViewButton: Button = itemView.findViewById(R.id.view_but)
//        val itemViewItemID: TextView = itemView.findViewById(R.id.id_txt)
//        val itemViewItemQty: TextView = itemView.findViewById(R.id.item_qty)


        fun bind(text: String?) {
            itemItemViewName.text = text
            itemItemViewName.setOnClickListener {
                val addIntent = Intent(itemView.context, ItemActivity::class.java)
//                addIntent.putExtra("item", item)
                addIntent.putExtra("origin", "search")
                ContextCompat.startActivity(itemView.context, addIntent, null)
            }
        }

        companion object {
            fun create(parent: ViewGroup): ItemViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_search_item, parent, false)
                return ItemViewHolder(view)
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