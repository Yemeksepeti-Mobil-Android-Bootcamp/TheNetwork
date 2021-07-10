package com.kodluyoruz.networkandretrofit

import android.util.Log
import com.kodluyoruz.networkandretrofit.models.listing.RickAndMortyBaseResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface RetrofitResponseHandler {
    fun onResponse(response: RickAndMortyBaseResponse)
    fun onError()
}

class RetrofitHelper {
    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    var service: RickAndMortyApiService = retrofit.create(RickAndMortyApiService::class.java)

    fun listCharacter(page: Int = 1, callBack: RetrofitResponseHandler) {
        service.listCharacters(page).enqueue(object : Callback<RickAndMortyBaseResponse> {
            override fun onResponse(
                call: Call<RickAndMortyBaseResponse>,
                response: Response<RickAndMortyBaseResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        callBack.onResponse(it)
                    }
                } else {
                    callBack.onError()
                    Log.v("RetrofitHelper", "any errors.")
                }
            }

            override fun onFailure(call: Call<RickAndMortyBaseResponse>, t: Throwable) {
                Log.v("RetrofitHelper", "onFailure -> service unavailable errors.")
                callBack.onError()
            }
        })
    }
}