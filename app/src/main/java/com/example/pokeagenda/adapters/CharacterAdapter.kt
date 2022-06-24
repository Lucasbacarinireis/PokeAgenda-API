package com.example.pokeagenda.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.TransformationUtils.fitCenter
import com.bumptech.glide.request.RequestOptions
import com.example.pokeagenda.PokemonDetailActivity
import com.example.pokeagenda.R
import com.example.pokeagenda.models.PokemonDataResponse
import com.example.pokeagenda.models.ResultsItem
import com.example.pokeagenda.viewmodel.PokemonDetailViewModel

class CharacterAdapter :
    RecyclerView.Adapter<CharacterViewHolder>() {

    private val itens = arrayListOf<ResultsItem>()


    fun addItens(list: List<ResultsItem>) {
        itens.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = itens[position]
        val textViewName = holder.itemView.findViewById<TextView>(R.id.txtCharacterName)
        textViewName.text = item.name?.replaceFirstChar { it.uppercase() }

        holder.itemView.setOnClickListener {
            val context = it.context //toda view tem um contexto
            val intent = Intent(context, PokemonDetailActivity::class.java) // O context não poderia ser o this?
            intent.putExtra("pokemonname", item.name)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return itens.size
    }
}

class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


