package com.example.cs402_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputEditText


class ItemActivity : AppCompatActivity() {

    private var displayedItem: ItemData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        val extras = intent.extras

        val itemNameContainer = findViewById<TextInputEditText>(R.id.ItemName)
        val itemDescription = findViewById<TextInputEditText>(R.id.ItemDescription)
        val itemCode = findViewById<TextInputEditText>(R.id.ItemCode)
        val itemPrice = findViewById<TextInputEditText>(R.id.ItemPrice)
        val itemCost = findViewById<TextInputEditText>(R.id.ItemCost)
        val itemQuantity = findViewById<TextInputEditText>(R.id.ItemQty)
        val itemVendor = findViewById<TextInputEditText>(R.id.ItemVendor)
        val itemShelf = findViewById<TextInputEditText>(R.id.ItemShelf)
        val itemUPC = findViewById<TextInputEditText>(R.id.ItemUPC)

        itemNameContainer.doOnTextChanged { text, start, before, count ->
            displayedItem?.let {
                it.name = text.toString()
            }
        }

        itemDescription.doOnTextChanged { text, start, before, count ->
            displayedItem?.let {
                it.description = text.toString()
            }
        }

        itemCode.doOnTextChanged { text, start, before, count ->
            displayedItem?.let {
                it.code = text.toString()
            }
        }

        itemPrice.doOnTextChanged { text, start, before, count ->
            displayedItem?.let {
                val parsedPrice = String.format("%.2f", text.toString().toDouble())
                it.price = parsedPrice.toDouble()
            }
        }

        itemCost.doOnTextChanged { text, start, before, count ->
            displayedItem?.let {
                val parsedPrice = String.format("%.2f", text.toString().toDouble())
                it.cost = parsedPrice.toDouble()
            }
        }

        itemQuantity.doOnTextChanged { text, start, before, count ->
            displayedItem?.let {
                it.qty = text.toString().toInt()
            }
        }

        itemVendor.doOnTextChanged { text, start, before, count ->
            displayedItem?.let {
                it.vendor = text.toString()
            }
        }

        itemShelf.doOnTextChanged { text, start, before, count ->
            displayedItem?.let {
                it.shelf = text.toString()
            }
        }

        itemUPC.doOnTextChanged { text, start, before, count ->
            displayedItem?.let {
                it.upc = text.toString()
            }
        }

        //If we ever need a listener for the Next key, this works as a template
        //It's how I handled text updates until I found out about doOnTextChanged
//        itemDescription.setOnEditorActionListener { textView, i, keyEvent ->
//            if(i == EditorInfo.IME_ACTION_NEXT) {
//                displayedItem?.let {
//                    it.description = textView.text.toString()
//                }
//                true
//            }
//            false
//        }

        val itemName = extras?.getSerializable("item")
        if(itemName is ItemData) {
            displayedItem = itemName

            displayedItem?.let {
                itemNameContainer.setText(it.name)
                itemDescription.setText(it.description ?: "")
                itemCode.setText(it.code)

                val priceParsed = String.format("%.2f", it.price)
                val costParsed = String.format("%.2f", it.cost)
                itemPrice.setText(priceParsed)
                itemCost.setText(costParsed)

                itemQuantity.setText(it.qty.toString())
                itemVendor.setText(it.vendor ?: "")
                itemShelf.setText(it.shelf ?: "")
                itemUPC.setText(it.upc ?: "")
            }
        }
    }
}