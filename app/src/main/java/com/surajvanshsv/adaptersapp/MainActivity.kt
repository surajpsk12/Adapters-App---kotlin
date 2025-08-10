package com.surajvanshsv.adaptersapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // initialize the list view
        val homelistView : ListView = findViewById(R.id.listviewhome)

        // create data source
        val operatingSystems = listOf("Windows","Linux","iOS","Android")

//        // create adapter : list view doesn't shows data directly we need to convert data to view
//        val listviewadapter = ArrayAdapter(
//            this,
//            android.R.layout.simple_list_item_1,
//            operatingSystems
//        )

        // your custom adapter jo banaye ho
        val customAdapter = MyCustomAdapter(this,operatingSystems)
        // set adapter to listview
        homelistView.adapter = customAdapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}