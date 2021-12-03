package com.example.cs402_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.textfield.TextInputEditText

class ItemSearch : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_search)

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