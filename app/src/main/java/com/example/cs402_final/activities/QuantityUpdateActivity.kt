package com.example.cs402_final.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cs402_final.data_classes.ItemData
import com.example.cs402_final.R
import com.example.cs402_final.adapters.QuantityAdapter

class QuantityUpdateActivity : AppCompatActivity() {

    private lateinit var searchRecyclerView: RecyclerView
    private lateinit var resultList: ArrayList<ItemData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quantity_update)

        val updateSpinner: Spinner = findViewById(R.id.update_spinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.update_options,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            updateSpinner.adapter = adapter
        }

        val extras = intent.extras

        searchRecyclerView = findViewById(R.id.quantity_recycler_view)
        searchRecyclerView.layoutManager = LinearLayoutManager(this)
        resultList = extras?.getParcelableArrayList<ItemData>("items") as ArrayList<ItemData>
        val quantityAdapter : QuantityAdapter = QuantityAdapter(this, resultList)
        searchRecyclerView.adapter = quantityAdapter

    }
}