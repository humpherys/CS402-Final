package com.example.cs402_final

import androidx.lifecycle.LiveData

class ItemRepository(private val itemDao : ItemDao) {

    val readAllData: LiveData<List<Item>> = itemDao.getAll()

    suspend fun addItem(item: Item){
        itemDao.insertItems()
    }

}