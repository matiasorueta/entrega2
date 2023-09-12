package com.example.tpentrega1

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tpentrega1.adapter.CharactersAdapter



class pantalla2Activity : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla2)

        val toolbar=findViewById<Toolbar>(R.id.Toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title= resources.getString(R.string.Titulo)

        fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.menu_pantalla2, menu)
            return super.onCreateOptionsMenu(menu)
        }


        fun onOptionsItemSelected(item: MenuItem): Boolean {
            if (item.itemId==R.id.item_Listado){
                val intentListado = Intent (this,ListadoPersonajesActivity2::class.java)
                startActivity(intentListado)
            }

            return super.onOptionsItemSelected(item)
        }
    initRecyclerView()}



    private fun initRecyclerView(){
        val recyclerView= findViewById<RecyclerView>(R.id.characters)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter = CharactersAdapter(CharactersProvider.listCharacters)
    }

}