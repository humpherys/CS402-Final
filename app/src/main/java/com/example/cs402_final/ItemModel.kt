package com.example.cs402_final

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.DatabaseView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.io.Serializable

/**
 * jacobhill - I changed this up a bit based on what I think we needed to do to handle Room
 */

//This should be expanded to hold all of the data we need to display an item, either on search or on
//the add/edit item screen

//@DatabaseView("SELECT * FROM items")
//data class ItemData(var id: Int,
//                    var code: String,
//                    var name: String,
//                    var price: Double,
//                    var cost: Double,
//                    var qty: Int,
//                    var vendor: String? = null,
//                    var description: String? = null,
//                    var shelf: String? = null,
//                    var upc: String? = null
//) : Serializable

class ItemModel(application: Application): AndroidViewModel(application) {

    val readAllData: Flow<List<Item>>
    private val repository: ItemRepository

    init {
        //This is placeholder, not sure if we'll need something here like the project with the json
        //loading. Use a normal ArrayList until we decide we need something more

        val itemDao = ItemDatabase.getInstance(application).itemDao
        repository = ItemRepository(itemDao)
        readAllData = repository.readAllData
    }

    fun addItem(item: Item){
        viewModelScope.launch(Dispatchers.IO){
            repository.addItem(item)
        }
    }

    fun insertItemLong(itemCode: String, itemName: String, itemPrice : Double, itemCost: Double, itemDesc: String, itemQty: Int, itemVendor : String, itemShelf : String, itemUPC : String){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addItemLong(itemCode, itemName, itemPrice, itemCost, itemDesc, itemQty, itemVendor, itemShelf, itemUPC )
        }
    }
}