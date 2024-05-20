package com.parivesh.photogallary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ImageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = ImageAdapter(context = this, images = getListOfImages())
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = adapter
    }
    fun getListOfImages(): ArrayList<String> {
        val BASE_URL = "https://picsum.photos/id/%d/200/200"
        var imageList = ArrayList<String>()
        for (i in 10..100) {
            imageList.add(String.format(BASE_URL, i))
        }
        return imageList
    }
}