package com.example.cs402_final

import androidx.room.DatabaseView

@DatabaseView
data class ItemDetail(
    val id: Int,
    val name: String?,
    val qty : Int
)