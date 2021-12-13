package com.example.cs402_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputEditText


class ItemActivity : AppCompatActivity() {

    private var displayedItem: ItemData? = null

    private var newName: String? = null
    private var newDescription: String? = null
    private var newCode: String? = null
    private var newPrice: Double = 0.0
    private var newCost: Double = 0.0
    private var newQuantity: Int = 0
    private var newVendor: String? = null
    private var newShelf: String? = null
    private var newUPC: String? = null

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
            } ?: run {
                newName = text.toString()
            }
        }

        itemDescription.doOnTextChanged { text, start, before, count ->
            displayedItem?.let {
                it.description = text.toString()
            } ?: run {
                newDescription = text.toString()
            }
        }

        itemCode.doOnTextChanged { text, start, before, count ->
            displayedItem?.let {
                it.code = text.toString()
            } ?: run {
                newCode = text.toString()
            }
        }

        itemPrice.doOnTextChanged { text, start, before, count ->
            displayedItem?.let {
                val parsedPrice = String.format("%.2f", text.toString().toDouble())
                it.price = parsedPrice.toDouble()
            } ?: run {
                val parsedPrice = String.format("%.2f", text.toString().toDouble())
                newPrice = parsedPrice.toDouble()
            }
        }

        itemCost.doOnTextChanged { text, start, before, count ->
            displayedItem?.let {
                val parsedPrice = String.format("%.2f", text.toString().toDouble())
                it.cost = parsedPrice.toDouble()
            } ?: run {
                val parsedPrice = String.format("%.2f", text.toString().toDouble())
                newCost = parsedPrice.toDouble()
            }
        }

        itemQuantity.doOnTextChanged { text, start, before, count ->
            displayedItem?.let {
                it.qty = text.toString().toInt()
            } ?: run {
                newQuantity = text.toString().toInt()
            }
        }

        itemVendor.doOnTextChanged { text, start, before, count ->
            displayedItem?.let {
                it.vendor = text.toString()
            } ?: run {
                newVendor = text.toString()
            }
        }

        itemShelf.doOnTextChanged { text, start, before, count ->
            displayedItem?.let {
                it.shelf = text.toString()
            } ?: run {
                newShelf = text.toString()
            }
        }

        itemUPC.doOnTextChanged { text, start, before, count ->
            displayedItem?.let {
                it.upc = text.toString()
            } ?: run {
                newUPC = text.toString()
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