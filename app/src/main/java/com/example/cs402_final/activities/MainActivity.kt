package com.example.cs402_final.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
<<<<<<< HEAD:app/src/main/java/com/example/cs402_final/MainActivity.kt
import androidx.activity.viewModels
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
=======
import com.example.cs402_final.R
>>>>>>> main:app/src/main/java/com/example/cs402_final/activities/MainActivity.kt

class MainActivity : AppCompatActivity() {

//    val db = Room.databaseBuilder(
//        applicationContext,
//        ItemDatabase::class.java, "items_database"
//    ).build()

    private val newItemActivityRequestCode = 1
    private val itemViewModel : ItemViewModel by viewModels {
        ItemViewModelFactory((application as ItemsApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val searchButton = findViewById<Button>(R.id.button)

        searchButton.setOnClickListener {
            val intent = Intent(this@MainActivity, ItemSearchActivity::class.java)
            startActivity(intent)
        }

        //Code for Scanning the UPC Button
        val butto = findViewById<Button>(R.id.button2)
        butto.setOnClickListener{
            val scanIntent = Intent(this, ScanActivity::class.java)
            startActivity(scanIntent)
        }

        val addButton = findViewById<Button>(R.id.button5)
        addButton.setOnClickListener {
            val addIntent = Intent(this, ItemActivity::class.java)
            addIntent.putExtra("origin", "main")
            //This is for testing intent passing, should be removed eventually
//            val testItem = ItemData(1, "abc","Test Item Name", 9.99,5.00,20)
//            addIntent.putExtra("item", testItem)
            startActivity(addIntent)
        }

        val tagButton = findViewById<Button>(R.id.button3)
        tagButton.setOnClickListener {
            val tagIntent = Intent(this, TagActivity::class.java)
            startActivity(tagIntent)
        }

    }

}