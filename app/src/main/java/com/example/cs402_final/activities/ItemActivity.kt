package com.example.cs402_final.activities

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.core.widget.doOnTextChanged
import com.example.cs402_final.ItemData
import com.example.cs402_final.R
import com.example.cs402_final.data_classes.Item
import com.example.cs402_final.data_classes.ItemViewModel
import com.example.cs402_final.data_classes.ItemViewModelFactory
import com.example.cs402_final.data_classes.ItemsApplication
import com.google.android.material.textfield.TextInputEditText


class ItemActivity : AppCompatActivity() {

    private var displayedItem: ItemData? = null
    private lateinit var startedFrom: String
    private var displayedDBItem: Item? = null

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

        val itemViewModel: ItemViewModel by viewModels {
            ItemViewModelFactory((application as ItemsApplication).repository)
        }

        val extras = intent.extras
        startedFrom = extras?.getString("origin") ?: ""

        val itemNameContainer = findViewById<TextInputEditText>(R.id.ItemName)
        val itemDescription = findViewById<TextInputEditText>(R.id.ItemDescription)
        val itemCode = findViewById<TextInputEditText>(R.id.ItemCode)
        val itemPrice = findViewById<TextInputEditText>(R.id.ItemPrice)
        val itemCost = findViewById<TextInputEditText>(R.id.ItemCost)
        val itemQuantity = findViewById<TextInputEditText>(R.id.ItemQty)
        val itemVendor = findViewById<TextInputEditText>(R.id.ItemVendor)
        val itemShelf = findViewById<TextInputEditText>(R.id.ItemShelf)
        val itemUPC = findViewById<TextInputEditText>(R.id.ItemUPC)

        val saveButton = findViewById<Button>(R.id.SaveButton)

//        itemNameContainer.doOnTextChanged { text, start, before, count ->
//            displayedItem?.let {
//                it.name = text.toString()
//            } ?: run {
//                newName = text.toString()
//            }
//        }
//
//        itemDescription.doOnTextChanged { text, start, before, count ->
//            displayedItem?.let {
//                it.description = text.toString()
//            } ?: run {
//                newDescription = text.toString()
//            }
//        }
//
//        itemCode.doOnTextChanged { text, start, before, count ->
//            displayedItem?.let {
//                it.code = text.toString()
//            } ?: run {
//                newCode = text.toString()
//            }
//        }
//
//        itemPrice.doOnTextChanged { text, start, before, count ->
//            displayedItem?.let {
//                val parsedPrice = String.format("%.2f", text.toString().toDouble())
//                it.price = parsedPrice.toDouble()
//            } ?: run {
//                val parsedPrice = String.format("%.2f", text.toString().toDouble())
//                newPrice = parsedPrice.toDouble()
//            }
//        }
//
//        itemCost.doOnTextChanged { text, start, before, count ->
//            displayedItem?.let {
//                val parsedPrice = String.format("%.2f", text.toString().toDouble())
//                it.cost = parsedPrice.toDouble()
//            } ?: run {
//                val parsedPrice = String.format("%.2f", text.toString().toDouble())
//                newCost = parsedPrice.toDouble()
//            }
//        }
//
//        itemQuantity.doOnTextChanged { text, start, before, count ->
//            displayedItem?.let {
//                it.qty = text.toString().toInt()
//            } ?: run {
//                newQuantity = text.toString().toInt()
//            }
//        }
//
//        itemVendor.doOnTextChanged { text, start, before, count ->
//            displayedItem?.let {
//                it.vendor = text.toString()
//            } ?: run {
//                newVendor = text.toString()
//            }
//        }
//
//        itemShelf.doOnTextChanged { text, start, before, count ->
//            displayedItem?.let {
//                it.shelf = text.toString()
//            } ?: run {
//                newShelf = text.toString()
//            }
//        }
//
//        itemUPC.doOnTextChanged { text, start, before, count ->
//            displayedItem?.let {
//                it.upc = text.toString()
//            } ?: run {
//                newUPC = text.toString()
//            }
//        }

        // ------------------------------- Masons Above, Jacob Below, Jacob is for DB

        itemNameContainer.doOnTextChanged { text, start, before, count ->
            displayedDBItem?.let {
                it.itemName = text.toString()
            } ?: run {
                newName = text.toString()
            }
        }

        itemDescription.doOnTextChanged { text, start, before, count ->
            displayedDBItem?.let {
                it.itemDesc = text.toString()
            } ?: run {
                newDescription = text.toString()
            }
        }

        itemCode.doOnTextChanged { text, start, before, count ->
            displayedDBItem?.let {
                it.itemCode = text.toString()
            } ?: run {
                newCode = text.toString()
            }
        }

        itemPrice.doOnTextChanged { text, start, before, count ->
            displayedDBItem?.let {
                val parsedPrice = String.format("%.2f", text.toString().toDouble())
                it.itemPrice = parsedPrice.toDouble()
            } ?: run {
                val parsedPrice = String.format("%.2f", text.toString().toDouble())
                newPrice = parsedPrice.toDouble()
            }
        }

        itemCost.doOnTextChanged { text, start, before, count ->
            displayedDBItem?.let {
                val parsedPrice = String.format("%.2f", text.toString().toDouble())
                it.itemCost = parsedPrice.toDouble()
            } ?: run {
                val parsedPrice = String.format("%.2f", text.toString().toDouble())
                newCost = parsedPrice.toDouble()
            }
        }

        itemQuantity.doOnTextChanged { text, start, before, count ->
            displayedDBItem?.let {
                it.itemQty = text.toString().toInt()
            } ?: run {
                newQuantity = text.toString().toInt()
            }
        }

        itemVendor.doOnTextChanged { text, start, before, count ->
            displayedDBItem?.let {
                it.itemVendorCode = text.toString()
            } ?: run {
                newVendor = text.toString()
            }
        }

        itemShelf.doOnTextChanged { text, start, before, count ->
            displayedDBItem?.let {
                it.itemLoc = text.toString()
            } ?: run {
                newShelf = text.toString()
            }
        }

        itemUPC.doOnTextChanged { text, start, before, count ->
            displayedDBItem?.let {
                it.itemUPC = text.toString()
            } ?: run {
                newUPC = text.toString()
            }
        }

        saveButton.setOnClickListener {
            if(startedFrom.equals("search")) {
                //TODO: do something here to save data from the existing item to storage
                //TODO: Also need to figure out how to properly update the search list on return, Room should do this for us
                    //or maybe just clear the search?
                var newItem1 = Item(0,
                    newCode!!,
                    newName!!,
                    newPrice,
                    newCost,
                    newQuantity,
                    newVendor,
                    newDescription,
                    newShelf,
                    newUPC)

                // Write updateItem function and uncomment line below for updating
                // itemViewModel.updateItem(newItem1)


                finish()
            } else if(startedFrom.equals("main") || startedFrom.equals("")) {
                if(newCode == null || newName == null) {
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Cannot save!")
                    builder.setMessage("Item name and item code must be set before saving!")
                    builder.setPositiveButton("Okay", null)
                    builder.show();
                } else {
                    //TODO: We need a way to choose what the new id will be
                    // Maybe it will just be auto set to something different when inserted into db
                    // var id = 0
//                    var newItem = ItemData(id,
//                        newCode!!,
//                        newName!!,
//                        newPrice,
//                        newCost,
//                        newQuantity,
//                        newVendor,
//                        newDescription,
//                        newShelf,
//                        newUPC)

                    var newItem1 = Item(0,
                        newCode!!,
                        newName!!,
                        newPrice,
                        newCost,
                        newQuantity,
                        newVendor,
                        newDescription,
                        newShelf,
                        newUPC)

                    //TODO: do something to save the new item to storage

                    itemViewModel.insert(newItem1)
                    finish()
                }
                // check to see if it was added?
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

        val itemName = extras?.getParcelable<ItemData>("item")
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