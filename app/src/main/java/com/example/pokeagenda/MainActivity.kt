package com.example.pokeagenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.pokeagenda.adapters.CharacterAdapter
import com.example.pokeagenda.models.PokemonDataResponse
import com.example.pokeagenda.models.ResultsItem
import com.example.pokeagenda.viewmodel.MainViewModel
import com.example.pokeagenda.viewmodel.PokemonDetailViewModel

class MainActivity : AppCompatActivity() {

    val mainViewModel = MainViewModel()
    lateinit var recyclerView: RecyclerView
    val adapterCharacters = CharacterAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = adapterCharacters

        mainViewModel.data.observe(this) {
            Log.e("Teste", it.toString())
            adapterCharacters.addItens(it)
        }
        mainViewModel.getAllCharacters(1)

        configureRecyclerView()
    }

    private fun configureRecyclerView() {

        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        recyclerView.addOnScrollListener(object :
            EndlessRecyclerViewScrollListener(linearLayoutManager) {
            override fun onLoadMore(page: Int) {
                mainViewModel.getAllCharacters(page)
            }
        })
    }


}