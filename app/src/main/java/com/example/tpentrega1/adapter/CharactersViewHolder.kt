
/*package com.example.tpentrega1.adapter
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tpentrega1.Characters
import com.example.tpentrega1.R
import com.bumptech.glide.Glide


class CharactersViewHolder(view:View):RecyclerView.ViewHolder(view){
    val nameCharacter=view.findViewById<TextView>(R.id.tvCharacterName)
    val realmsCharacter=view.findViewById<TextView>(R.id.tvCharacterRealms)
    val ageCharacter=view.findViewById<TextView>(R.id.tvCharacterAge)
    val photo= view.findViewById<ImageView>(R.id.ivCharacter)

    fun render(charactersModel: Characters){
        nameCharacter.text = charactersModel.nombreCharacter
        realmsCharacter.text=charactersModel.realms
        ageCharacter.text = charactersModel.age
        Glide.with(photo.context).load(charactersModel.photo).into(photo)
    }
}*/
package com.example.tpentrega1.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tpentrega1.Characters
import com.example.tpentrega1.R

class CharactersViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val nameCharacter: TextView
    private val realmsCharacter: TextView
    private val ageCharacter: TextView
    private val photo: ImageView

    init {
        nameCharacter = view.findViewById(R.id.tvCharacterName)
        realmsCharacter = view.findViewById(R.id.tvCharacterRealms)
        ageCharacter = view.findViewById(R.id.tvCharacterAge)
        photo = view.findViewById(R.id.ivCharacter)
    }

    fun render(charactersModel: Characters) {
        nameCharacter.text = charactersModel.nombreCharacter
        realmsCharacter.text = charactersModel.realms
        ageCharacter.text = charactersModel.age
        Glide.with(photo.context).load(charactersModel.photo).into(photo)
    }
}