package com.example.cs402_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.google.android.material.textfield.TextInputEditText

class ItemSearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_search)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                var resultList = arrayListOf<ItemData>(ItemData(1, "abc","Test Item 1", 9.99,5.00,20),
                    ItemData(2, "abc","Test Item 2", 9.99,5.00,20),
                    ItemData(3, "abc","Test Item 3", 9.99,5.00,20),
                    ItemData(4, "abc","Test Item 4", 9.99,5.00,20))
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