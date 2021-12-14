package com.example.cs402_final

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class ItemDatabase : RoomDatabase() {

    // Set up local database
    abstract val itemDao : ItemDao

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
                    "items"
                )
                    // Wipes and rebuilds instead of migrating if no Migration object.
                    // Migration is not part of this codelab.
                    .fallbackToDestructiveMigration()
                    .addCallback(ItemCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

        private class ItemCallback(
            private val scope : CoroutineScope
        ) : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

                // If you want to keep the data through app restarts,
                // comment out the following line.
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.itemDao)
                    }
                }

            }
        }

        suspend fun populateDatabase(itemDao: ItemDao){
            // Clean database of all entries
            // This will be commented out in the future when we want to have data stored across sessions
            itemDao.deleteAll()

            var item = Item(0, "TEST", "Hammer Test", 15.00, 5.00, 5, "TST", "Test Hammer1", "item_loc", "item_upc", "item_img")
            itemDao.insertItems(item)

            // empty constructor
            var item2 = Item()

            itemDao.insertItems(item2)

        }

        // gets instance of Room and adds it if it does not exist
        fun getInstance(context: Context): ItemDatabase {
            synchronized(this){
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ItemDatabase::class.java,
                        "inventory_database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
