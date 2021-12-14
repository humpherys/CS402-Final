package com.example.cs402_final.data_classes

import androidx.room.DatabaseView

@DatabaseView
data class ItemDetail(
    val id: Int,
    val name: String?,
    val qty : Int
)