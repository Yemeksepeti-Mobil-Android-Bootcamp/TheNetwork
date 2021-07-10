package com.kodluyoruz.networkandretrofit.fragment.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kodluyoruz.networkandretrofit.R
import com.kodluyoruz.networkandretrofit.models.listing.RickAndMortyBaseResponse
import com.kodluyoruz.networkandretrofit.utils.RetrofitHelper
import com.kodluyoruz.networkandretrofit.utils.RetrofitResponseHandler
import com.kodluyoruz.networkandretrofit.utils.RickMortyAdapter

class ListFragment : Fragment() {
    private val retrofitHelper = RetrofitHelper()
    private var adapter = RickMortyAdapter()
    private var page = 1
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.v("ListFragment", "onViewCreated")
        initViews(view)
        fetchData(page)
    }

    private fun fetchData(page: Int = 1) {
        Log.v("ListFragment", "fetchData")
        Toast.makeText(context, "Page Number: $page", Toast.LENGTH_SHORT).show()
        retrofitHelper.listCharacter(page = page, object : RetrofitResponseHandler {
            override fun onError() {
                Log.v("MainActivity", "Error :(")

            }

            override fun onResponse(response: RickAndMortyBaseResponse) {
                Log.v("ListFragment", "onResponse")
                adapter.setRickMortyData(response.characters)
            }
        })
    }

    private fun initViews(view: View) {
        val recyclerView: RecyclerView = view.findViewById(R.id.rickAndMortyRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        val nextButton = view.findViewById<Button>(R.id.nextButton)
        val backButton = view.findViewById<Button>(R.id.backButton)
        nextButton.setOnClickListener {
            page++
            fetchData(page)
        }
        backButton.setOnClickListener {
            if (page != 1) {
                page--
                fetchData(page)
            }
        }

    }
}