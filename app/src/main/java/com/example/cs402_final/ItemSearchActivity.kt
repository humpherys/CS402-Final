package com.example.cs402_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.google.android.material.textfield.TextInputEditText

class ItemSearchActivity : AppCompatActivity() {

    private val itemViewModel: ItemViewModel by viewModels {
        ItemViewModelFactory((application as ItemsApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_search)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                //val bundle = bundleOf("some_int" to 0)
                setReorderingAllowed(true)
                add<SearchResults>(R.id.searchContainerView)
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