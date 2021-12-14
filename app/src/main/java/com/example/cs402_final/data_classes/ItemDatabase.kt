package com.example.cs402_final

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cs402_final.data_classes.Item
import com.example.cs402_final.data_classes.ItemDao
import com.example.cs402_final.data_classes.User
import com.example.cs402_final.data_classes.Vendor

@Database(entities = [Item::class, Vendor::class, User::class], views = [ItemData::class], version = 1) abstract class AppDatabase : RoomDatabase()
abstract class ItemDatabase : RoomDatabase() {

    // Set up local database
    abstract val itemDao : ItemDao

    companion object{
        @Volatile
        private var INSTANCE : ItemDatabase? = null

        // gets instance of Room and adds it if it does not exist
        fun getInstance(context: Context): ItemDatabase {
            synchronized(this){
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ItemDatabase::class.java,
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
