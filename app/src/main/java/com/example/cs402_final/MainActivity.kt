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


        val searchButton = findViewById<Button>(R.id.button)

        searchButton.setOnClickListener {
            val intent = Intent(this@MainActivity, ItemSearchActivity::class.java)
            startActivity(intent)
        }

        //Code for Scanning the UPC Button
        val butto = findViewById<Button>(R.id.button2)
        butto.setOnClickListener{
            val scanIntent = Intent(this,ScanActivity::class.java)
            startActivity(scanIntent)
        }
        
        val addButton = findViewById<Button>(R.id.button5)
        addButton.setOnClickListener {
            val addIntent = Intent(this, ItemActivity::class.java)

            //This is for testing intent passing, should be removed eventually
//            val testItem = ItemData(1, "abc","Test Item Name", 9.99,5.00,20)
//            addIntent.putExtra("item", testItem)
            startActivity(addIntent)
        }
    }

}