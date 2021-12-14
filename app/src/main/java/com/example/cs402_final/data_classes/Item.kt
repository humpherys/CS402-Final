package com.example.cs402_final.data_classes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Fts4
import androidx.room.PrimaryKey

// For Full Text Searching
@Fts4
@Entity(tableName = "items")
data class Item (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "rowid") val itemId : Int,
    @ColumnInfo(name = "item_code") val itemCode : String?,
    @ColumnInfo(name = "item_name") val itemName : String?,
    @ColumnInfo(name = "item_price") val itemPrice : Double,
    @ColumnInfo(name = "item_cost") val itemCost : Double,
    @ColumnInfo(name = "item_qty") val itemQty : Int,
    @ColumnInfo(name = "item_vendor_code") val itemVendorCode : String?,
    @ColumnInfo(name = "item_description") val itemDesc : String?,
    @ColumnInfo(name = "item_loc") val itemLoc : String?,
    @ColumnInfo(name = "item_upc") val itemUPC : String?,
    @ColumnInfo(name = "item_img") val itemImg : String?
    )
