package com.example.pokeagenda.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokeagenda.models.CharactersResponse
import com.example.pokeagenda.models.PokemonDataResponse
import com.example.pokeagenda.models.ResultsItem
import com.example.pokeagenda.service.RetrofitPokemon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonDetailViewModel: ViewModel() {

    val data = MutableLiveData<PokemonDataResponse>()


    fun getPokemonDetail(pokemonname: String ) {

        RetrofitPokemon.createRetrofit().getPokemonDetail(pokemonname)
            .enqueue(object : Callback<PokemonDataResponse> {
                override fun onResponse(
                    call: Call<PokemonDataResponse>,
                    response: Response<PokemonDataResponse>
                ) {
                    data.postValue(response.body())
                }

                override fun onFailure(call: Call<PokemonDataResponse>, t: Throwable) {
                    t.printStackTrace()
                }

            })

    }

}