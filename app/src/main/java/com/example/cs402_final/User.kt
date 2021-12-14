package com.example.cs402_final

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "rowid") val userId : Int,
    @ColumnInfo(name = "user_email") val userEmail : String?,
    @ColumnInfo(name = "username") val userName : String?,
)