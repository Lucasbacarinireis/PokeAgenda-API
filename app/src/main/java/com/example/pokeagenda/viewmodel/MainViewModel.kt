package com.example.pokeagenda.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokeagenda.models.CharactersResponse
import com.example.pokeagenda.models.ResultsItem
import com.example.pokeagenda.service.RetrofitPokemon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    val data = MutableLiveData<List<ResultsItem>>()


    fun getAllCharacters(page: Int ) {

        RetrofitPokemon.createRetrofit().getAllCharacters(page * 20)
            .enqueue(object : Callback<CharactersResponse> {
                override fun onResponse(
                    call: Call<CharactersResponse>,
                    response: Response<CharactersResponse>
                ) {
                    data.postValue(response.body()?.results)
                }

                override fun onFailure(call: Call<CharactersResponse>, t: Throwable) {
                    t.printStackTrace()
                }
            })
    }
}