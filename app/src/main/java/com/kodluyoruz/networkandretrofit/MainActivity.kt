package com.kodluyoruz.networkandretrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kodluyoruz.networkandretrofit.models.listing.RickAndMortyBaseResponse
import com.kodluyoruz.networkandretrofit.utils.RetrofitHelper
import com.kodluyoruz.networkandretrofit.utils.RetrofitResponseHandler
import com.kodluyoruz.networkandretrofit.utils.RickMortyAdapter

class MainActivity : AppCompatActivity() {
    private val retrofitHelper = RetrofitHelper()
    private val adapter: RickMortyAdapter = RickMortyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        fetchData()
    }

    private fun fetchData() {
        retrofitHelper.listCharacter(page = 1, object : RetrofitResponseHandler {
            override fun onError() {
                Log.v("MainActivity", "Error :(")

            }

            override fun onResponse(response: RickAndMortyBaseResponse) {
                adapter.setRickMortyData(response.characters)
            }
        })
    }

    private fun initViews() {
        val recyclerView: RecyclerView = findViewById(R.id.rickAndMortyRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(baseContext)
        recyclerView.adapter = adapter

    }
}