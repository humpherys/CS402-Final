package com.example.cs402_final.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.cs402_final.ItemData
import com.example.cs402_final.R
import com.example.cs402_final.fragments.SearchResults
import com.google.android.material.textfield.TextInputEditText

class ItemSearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_search)

        var resultList = arrayListOf<ItemData>(
            ItemData(1, "abc","Test Item 1", 9.99,5.00,20),
            ItemData(2, "abc","Test Item 2", 9.99,5.00,20),
            ItemData(3, "abc","Test Item 3", 9.99,5.00,20),
            ItemData(4, "abc","Test Item 4", 9.99,5.00,20)
        )

        val extras = intent.extras
        val action = extras?.getString("action")
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
        }

        if (savedInstanceState == null) {
            supportFragmentManager.commit {

                val bundle = bundleOf(
                    "fragType" to (action ?: "search"),
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