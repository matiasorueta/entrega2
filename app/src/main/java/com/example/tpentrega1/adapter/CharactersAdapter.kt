package com.example.tpentrega1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tpentrega1.Characters
import com.example.tpentrega1.R

class CharactersAdapter(private val listCharacters: List<Characters>):RecyclerView.Adapter<CharactersViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return CharactersViewHolder(layoutInflater.inflate(R.layout.item_character,parent,false))
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        val item= listCharacters[position]
        holder.render(item)
    }
    override fun getItemCount(): Int =listCharacters.size


}