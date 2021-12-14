package com.example.cs402_final

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

class ItemRepository(private val itemDao : ItemDao) {

    val readAllData: Flow<List<Item>> = itemDao.getAll()

    suspend fun addItem(item: Item){
        itemDao.insertItems()
    }

    suspend fun addItemLong(itemCode: String, itemName: String, itemPrice : Double, itemCost: Double, itemDesc: String, itemQty: Int, itemVendor : String, itemShelf : String, itemUPC : String){
        itemDao.insertItemLong(itemCode, itemName, itemPrice, itemCost, itemDesc, itemQty, itemVendor, itemShelf, itemUPC)
    }
}