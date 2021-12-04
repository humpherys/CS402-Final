package com.example.cs402_final

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDao {

    @Insert
    fun insertItems(vararg items: Item)

    @Query("INSERT INTO items (item_code, item_name, item_price) values (:itemCode, :itemName, :itemPrice)")
    fun insertItem(itemCode: String, itemName: String, itemPrice : Double) : Item

    @Query("SELECT * FROM items")
    fun getAll(): List<Item>


    @Query("SELECT * FROM items WHERE item_name LIKE :search")
    fun findItemByName(search: String)
}