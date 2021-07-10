package com.kodluyoruz.networkandretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kodluyoruz.networkandretrofit.models.listing.RickAndMortyBaseResponse

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofitHelper = RetrofitHelper()
        retrofitHelper.listCharacter(page = 1, object: RetrofitResponseHandler {
            override fun onError() {
                Log.v("MainActivity", "Error :(")

            }

            override fun onResponse(response: RickAndMortyBaseResponse) {
                response.characters.forEach { character ->
                    Log.v("MainActivity", "Character: ${character.name}")
                }
            }
        })
    }
}