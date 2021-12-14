package com.example.cs402_final

import androidx.room.DatabaseView

@DatabaseView("SELECT rowid, item_name, item_qty FROM items")
data class ItemDetail(
    var id: Int,
    var name: String?,
    var qty : Int
)