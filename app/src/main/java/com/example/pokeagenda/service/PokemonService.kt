package com.example.pokeagenda.service

import com.example.pokeagenda.models.CharactersResponse
import com.example.pokeagenda.models.PokemonDataResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {

    @GET("pokemon")
    fun getAllCharacters(@Query("offset")offset:Int): Call<CharactersResponse>

    @GET("pokemon/{pokemonname}")
    fun getPokemonDetail(@Path("pokemonname")pokemonname:String): Call<PokemonDataResponse>
}