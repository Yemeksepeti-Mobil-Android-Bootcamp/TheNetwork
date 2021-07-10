package com.kodluyoruz.networkandretrofit.models.listing


import com.google.gson.annotations.SerializedName
import com.kodluyoruz.networkandretrofit.models.core.Character

data class RickAndMortyBaseResponse(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val characters: List<Character>
)