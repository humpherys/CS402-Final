package com.example.cs402_final.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
//import com.example.cs402_final.ItemData
import com.example.cs402_final.R
import com.example.cs402_final.adapters.ItemListAdapter
import com.example.cs402_final.adapters.TagData
import com.example.cs402_final.data_classes.ItemData
import com.example.cs402_final.data_classes.ItemViewModel
import com.example.cs402_final.data_classes.ItemViewModelFactory
import com.example.cs402_final.data_classes.ItemsApplication
import com.example.cs402_final.fragments.SearchResults
import com.google.android.material.textfield.TextInputEditText

class ItemSearchActivity : AppCompatActivity() {


    var action : String? = null
    var managingTag : TagData? = null
    private val itemActivityRequestCode = 1

    private val itemViewModel: ItemViewModel by viewModels {
        ItemViewModelFactory((application as ItemsApplication).repository)
    }

    private val listAdapter: ItemListAdapter by lazy {ItemListAdapter()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_search)



        // TODO DB
        // We have a fragment, not a recyclerview
//        val recyclerView = findViewById<RecyclerView>(R.id.searchContainerView)
//        val adapter = ItemListAdapter()
//        recyclerView.adapter = adapter
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        // add observer
//        itemViewModel.allItems.observe(this) { items ->
//            items.let { adapter.setData(it) }
//
//        }
        // TODO END , possibly delete

        var resultList = arrayListOf<ItemData>(
            ItemData(1, "abc","Test Item 1", 9.99,5.00,20),
            ItemData(2, "abc","Test Item 2", 9.99,5.00,20),
            ItemData(3, "abc","Test Item 3", 9.99,5.00,20),
            ItemData(4, "abc","Test Item 4", 9.99,5.00,20)
        )

        val extras = intent.extras
        action = extras?.getString("action")
        managingTag = extras?.getParcelable<TagData>("tag")

        val confirmButton = findViewById<Button>(R.id.ConfirmButton)
        if(action.equals("update")) {
            confirmButton.visibility = View.VISIBLE

            confirmButton.setOnClickListener {
                var updateIntent = Intent(this, QuantityUpdateActivity::class.java)
                var selectedItems = ArrayList<ItemData>()
                for(item in resultList) {
                    if(item.selected != null && item.selected == true) {
                        selectedItems.add(item)
                    }
                }
                updateIntent.putExtra("items", selectedItems)
                startActivity(updateIntent)
            }
        } else if(action.equals("tagManage")) {
            confirmButton.visibility = View.VISIBLE

            //TODO: Select any items that already have the managingTag applied

            confirmButton.setOnClickListener {
                var selectedItems = ArrayList<ItemData>()
                for(item in resultList) {
                    if(item.selected != null && item.selected == true) {
                        selectedItems.add(item)
                    }
                }

                //TODO: Logic to save all of the selected items with the managingTag
            }
        }

        // TODO: May use this later
//        var resultList = arrayListOf<Item>(
//            Item(0, "abc","Test Item 1", 9.99,5.00,20,"", "", "", ""),
//            Item(0, "abc","Test Item 2", 9.99,5.00,20,"", "", "", ""),
//            Item(0, "abc","Test Item 3", 9.99,5.00,20, "", "", "", ""),
//            Item(0, "abc","Test Item 4", 9.99,5.00,20, "", "", "", "")
//        )

//        var item = Item(0, "TEST", "Hammer Test12", 15.00, 5.00, 5, "TST", "Test Hammer1 SEARCH", "item_loc", "item_upc")
//        itemViewModel.insert(item)


        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                val bundle = bundleOf(
                    "fragType" to "search",
                    "results" to resultList
                )
                setReorderingAllowed(true)
                add<SearchResults>(R.id.searchContainerView, args = bundle)
            }
        }

        val searchInput = findViewById<TextInputEditText>(R.id.SearchBoxText)
        searchInput.setOnEditorActionListener { textView, i, keyEvent ->
            if(true /*conditions here*/) {
                //this will eventually contain the logic for the search button event
                true
            } else {
                true
            }
        }
    }
}