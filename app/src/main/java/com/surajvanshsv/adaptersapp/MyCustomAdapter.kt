package com.surajvanshsv.adaptersapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyCustomAdapter(private val context : Context,
                      private val items :List<String>): BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any? {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
// return the view of data that is specified at given postion in data storage
    // convert view : recycled view that can be reused to optimize performance
    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View
        if(convertView == null){
            // inflate a new view using layout inflater , if no view then inflate new
            view = inflater.inflate(R.layout.my_custom_layout,
                parent,
                false)
        }else {
            // if already a view reuse it
            view = convertView
        }
    // bind data to view
        val item = getItem(position) as String // item aa gaya storage se , now next isko ui me daalo
        val titleTextView = view.findViewById<TextView>(R.id.textViewCustom) // get ui , ui ka refernece le ke  aao jisme dalna hia
        titleTextView.text = item  // storage se laye hue ko daalo ui me

        return view

    }


}