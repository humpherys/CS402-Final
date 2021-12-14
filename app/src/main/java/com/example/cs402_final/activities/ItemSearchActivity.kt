package com.example.cs402_final.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.cs402_final.ItemData
import com.example.cs402_final.R
import com.example.cs402_final.data_classes.Item
import com.example.cs402_final.data_classes.ItemViewModel
import com.example.cs402_final.data_classes.ItemViewModelFactory
import com.example.cs402_final.data_classes.ItemsApplication
import com.example.cs402_final.fragments.SearchResults
import com.google.android.material.textfield.TextInputEditText

class ItemSearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_search)

        val itemViewModel: ItemViewModel by viewModels {
            ItemViewModelFactory((application as ItemsApplication).repository)
        }
        var item = Item(0, "TEST", "Hammer Test12", 15.00, 5.00, 5, "TST", "Test Hammer1 SEARCH", "item_loc", "item_upc")
        itemViewModel.insert(item)

        val itemObserver = Observer<Item> { newItem ->
            item = newItem
        }

        if (savedInstanceState == null) {
            supportFragmentManager.commit {

                var resultList = arrayListOf<ItemData>(
                    ItemData(0, "abc","Test Item 1", 9.99,5.00,20),
                    ItemData(0, "abc","Test Item 2", 9.99,5.00,20),
                    ItemData(0, "abc","Test Item 3", 9.99,5.00,20),
                    ItemData(0, "abc","Test Item 4", 9.99,5.00,20)
                )
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