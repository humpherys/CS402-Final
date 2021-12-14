package com.example.cs402_final.data_classes

import androidx.lifecycle.LiveData
import com.example.cs402_final.data_classes.Item
import com.example.cs402_final.data_classes.ItemDao

class ItemRepository(private val itemDao : ItemDao) {

    val readAllData: LiveData<List<Item>> = itemDao.getAll()

    suspend fun addItem(item: Item){
        itemDao.insertItems()
    }

}