package com.example.cs402_final.data_classes

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow
import com.example.cs402_final.data_classes.Item

/**
 * This is class to interact with the database. Contains functions to make it easier to get and add data
 */

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItems(vararg items: Item)

//    @Query("INSERT INTO items (item_code, item_name, item_price) values (:itemCode, :itemName, :itemPrice)")
//    fun insertItemShort(itemCode: String, itemName: String, itemPrice : Double)

    @Query("SELECT * FROM items ORDER BY rowid ASC")
    fun getAll(): Flow<List<Item>>


    @Query("SELECT * FROM items WHERE item_name LIKE :search ORDER BY item_name ASC")
    fun findItemByName(search: String) : Flow<List<Item>>

    @Query("SELECT * FROM items WHERE item_code LIKE :tag")
    fun findByTag(tag: String): Flow<List<Item>>

//    @Query("INSERT INTO items (item_code, item_name, item_price, item_cost, item_description, item_qty, item_vendor_code, item_loc, item_upc) values (:itemCode, :itemName, :itemPrice, :itemCost, :itemDesc, :itemQty,:itemVendor, :itemShelf, :itemUPC)")
//    fun insertItemLong(itemCode: String, itemName: String, itemPrice : Double, itemCost: Double, itemDesc: String, itemQty: Int, itemVendor : String, itemShelf : String, itemUPC : String)

    @Query("DELETE FROM items")
    suspend fun deleteAll()
}