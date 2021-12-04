package com.example.cs402_final

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

class DatabaseHandler {

    // Set up local database
    @Database(entities = [Item::class, Vendor::class, User::class], version = 1) abstract class AppDatabase : RoomDatabase() {
        abstract val itemDao : ItemDao

        companion object{
            @Volatile
            private var INSTANCE : DatabaseHandler? = null

            fun getInstance(context: Context): DatabaseHandler {
                synchronized(this){
                    var instance = INSTANCE

                    if (instance == null) {
                        instance = Room.databaseBuilder(
                            context.applicationContext,
                            DatabaseHandler::class.java,
                            "inventory_database"
                        )
                            .fallbackToDestructiveMigration()
                            .build()
                        INSTANCE = instance
                    }
                    return instance
                }
            }
        }
    }

    val db = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java, "inventory-db"
    ).build()
}