package com.kodluyoruz.networkandretrofit.utils

import com.kodluyoruz.networkandretrofit.models.core.Character
import com.kodluyoruz.networkandretrofit.models.listing.RickAndMortyBaseResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApiService {
    @GET("character")
    fun listCharacters(@Query("page") page: Int): Call<RickAndMortyBaseResponse>

    @GET("character/{id}")
    fun getCharacter(@Path("id") id: Int): Call<Character>
}