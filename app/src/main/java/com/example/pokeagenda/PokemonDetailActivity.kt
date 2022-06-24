package com.example.pokeagenda

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.pokeagenda.viewmodel.PokemonDetailViewModel

class PokemonDetailActivity : AppCompatActivity(R.layout.activity_pokemon_detail) {

    val pokemonDetailViewModel = PokemonDetailViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pokemonName = findViewById<TextView>(R.id.txtName)
        val pokemonPeso = findViewById<TextView>(R.id.txtPeso)
        val pokemonAltura = findViewById<TextView>(R.id.txtTamanho)

        val imagens = findViewById<ImageView>(R.id.pokemonImageView)
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        pokemonDetailViewModel.getPokemonDetail(intent.getStringExtra("pokemonname").orEmpty())
        pokemonDetailViewModel.data.observe(this) {

            pokemonName.text = it.name.toString().replaceFirstChar { it.uppercase() }
            pokemonPeso.text = it.weight.toString().replaceFirstChar { it.uppercase() }
            pokemonAltura.text = it.height.toString().replaceFirstChar { it.uppercase() }

            Glide.with(imagens)
                .applyDefaultRequestOptions(requestOptions)
                .load(it.sprites?.frontDefault)
                .fitCenter()
                .into(imagens)
        }


    }
}