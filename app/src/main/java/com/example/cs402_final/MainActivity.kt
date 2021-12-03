package com.example.cs402_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Code for Scanning the UPC Button
        val butto = findViewById<Button>(R.id.ScanUPCButton)
        butto.setOnClickListener{
            val scanIntent = Intent(this,ScanActivity::class.java)
            startActivity(scanIntent)
        }
    }



}