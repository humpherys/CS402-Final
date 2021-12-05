package com.example.cs402_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.textfield.TextInputEditText
import android.widget.TextView




class ItemActivity : AppCompatActivity() {

    private var displayedItem: ItemData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        val extras = intent.extras
        val itemCode = findViewById<TextInputEditText>(R.id.ItemCode)
        val itemNameContainer = findViewById<TextInputEditText>(R.id.ItemName)
        val itemPrice = findViewById<TextInputEditText>(R.id.ItemPrice)

        itemCode.setOnEditorActionListener { textView, i, keyEvent ->
            displayedItem?.let {
                it.code = textView.text.toString()
            }
            //Why doesn't this work???!!
            //textView.focusSearch(View.FOCUS_RIGHT).requestFocus()
            true
        }


        val itemName = extras?.getSerializable("item")
        if(itemName is ItemData) {
            displayedItem = itemName

            displayedItem?.let {
                itemCode.setText(it.code)
                itemNameContainer.setText(it.name)
                itemPrice.setText(it.price.toBigDecimal().toPlainString())
            }
        }
    }
}