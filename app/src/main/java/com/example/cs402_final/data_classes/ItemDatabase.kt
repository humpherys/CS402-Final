package com.example.cs402_final

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import com.example.cs402_final.data_classes.Item
import com.example.cs402_final.data_classes.ItemDao
import com.example.cs402_final.data_classes.User
import com.example.cs402_final.data_classes.Vendor


@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class ItemDatabase : RoomDatabase() {

    // Set up local database
    abstract fun itemDao() : ItemDao

    private class ItemCallback(
        private val scope : CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            // If you want to keep the data through app restarts,
            // comment out the following line.
            INSTANCE?.let { database ->
                scope.launch() {
                    var itemDao = database.itemDao()
                    // Clean database of all entries
                    // This will be commented out in the future when we want to have data stored across sessions
//                    itemDao.deleteAll()
                    for(i in 0 until 5){
                        // use 0 as index so it will autogenerate
                        var inItem = Item(0, "TEST$i", "Hammer 1 Test$i", 15.00 + i, 5.00 + i, 5 + i, "TST$i", "Test Hammer$i", "item_loc$i", "item_upc$i")
                        itemDao.insertItems(inItem)
                    }
//
//                    var item = Item(0, "TEST", "Hammer 1 Test", 15.00, 5.00, 5, "TST", "Test Hammer1", "item_loc", "item_upc")
//                    itemDao.insertItems(item)

                }
            }
        }
    }

    companion object{
        @Volatile
        private var INSTANCE : ItemDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ) : ItemDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemDatabase::class.java,
                    "items_database"
                ).addCallback(ItemCallback(scope)).build()
                INSTANCE = instance
                // return instance
                return instance
            }
        }

        // gets instance of Room and adds it if it does not exist
        fun getInstance(context: Context): ItemDatabase {
            synchronized(this){
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ItemDatabase::class.java,
                        "items_database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
