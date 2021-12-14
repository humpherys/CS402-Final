package com.example.cs402_final.data_classes

import androidx.lifecycle.LiveData

import kotlinx.coroutines.flow.Flow
import com.example.cs402_final.data_classes.Item
import com.example.cs402_final.data_classes.ItemDao

class ItemRepository(private val itemDao : ItemDao) {

    val readAllData: LiveData<List<Item>> = itemDao.getAll()

    suspend fun addItem(item: Item){
        itemDao.insertItems()
    }

//    suspend fun addItemLong(itemCode: String, itemName: String, itemPrice : Double, itemCost: Double, itemDesc: String, itemQty: Int, itemVendor : String, itemShelf : String, itemUPC : String){
//        itemDao.insertItemLong(itemCode, itemName, itemPrice, itemCost, itemDesc, itemQty, itemVendor, itemShelf, itemUPC)
//    }
}