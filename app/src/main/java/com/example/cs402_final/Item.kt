package com.example.cs402_final

import androidx.room.*

// For Full Text Searching
@Fts4
@Entity(tableName = "items")
data class Item(
    @Ignore @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "rowid") var itemId : Int,
    @ColumnInfo(name = "item_code") var itemCode : String?,
    @ColumnInfo(name = "item_name") var itemName : String?,
    @ColumnInfo(name = "item_price") var itemPrice : Double,
    @ColumnInfo(name = "item_cost") var itemCost : Double,
    @ColumnInfo(name = "item_qty") var itemQty : Int,
    @ColumnInfo(name = "item_vendor_code") var itemVendorCode : String?,
    @ColumnInfo(name = "item_description") var itemDesc : String?,
    @ColumnInfo(name = "item_loc") var itemLoc : String?,
    @ColumnInfo(name = "item_upc") var itemUPC : String?,
    @ColumnInfo(name = "item_img") var itemImg : String?
    ) {
    constructor() : this(0, "", "", 0.00, 0.00, 0, "", "", "",
            "", "")
}

