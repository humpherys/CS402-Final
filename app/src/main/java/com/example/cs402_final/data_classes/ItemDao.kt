package com.example.cs402_final.data_classes

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.cs402_final.data_classes.Item

/**
 * This is class to interact with the database. Contains functions to make it easier to get and add data
 */

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItems(vararg items: Item)

    @Query("INSERT INTO items (item_code, item_name, item_price) values (:itemCode, :itemName, :itemPrice)")
    fun insertItemShort(itemCode: String, itemName: String, itemPrice : Double) : Item

    @Query("SELECT * FROM items ORDER BY rowid ASC")
    fun getAll(): LiveData<List<Item>>


    @Query("SELECT * FROM items WHERE item_name LIKE :search")
    fun findItemByName(search: String)

    @Query("INSERT INTO items (item_code, item_name, item_price) values (:itemCode, :itemName, :itemPrice)")
    fun insertItemLong(itemCode: String, itemName: String, itemPrice : Double) : Item

}