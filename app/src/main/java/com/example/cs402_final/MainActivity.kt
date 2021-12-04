package com.example.cs402_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up local database
        @Database(entities = [Item::class, Vendor::class, User::class], version = 1) abstract class AppDatabase : RoomDatabase() {
            abstract fun itemDao() : ItemDao
        }

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "inventory-db"
        ).build()

        val itemDao = db.itemDao()
        // insert 10 test items into our items table
        for(i in 0 until 10){
            // make new item to insert into db
            when(i){
                0 -> itemDao.insertItem("ZZZZ", "Test Item $i", (i).toDouble())
                1,2,3 -> itemDao.insertItem("AAAA", "Test Hammer $i", (i+i).toDouble())
                4,5,6 -> itemDao.insertItem("BBBB", "Test Drill $i", (i+i).toDouble())
                7,8,9 -> itemDao.insertItem("CCCC", "Test Powersaw $i", (i+i).toDouble())
            }
        }

        val items = itemDao.getAll()


        val searchButton = findViewById<Button>(R.id.button)

        searchButton.setOnClickListener {
            val intent = Intent(this@MainActivity, ItemSearch::class.java)
            startActivity(intent)
        }

        //Code for Scanning the UPC Button
        val butto = findViewById<Button>(R.id.button2)
        butto.setOnClickListener{
            val scanIntent = Intent(this,ScanActivity::class.java)
            startActivity(scanIntent)
        }

    }

}