package com.example.tpentrega1

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val editText =
            findViewById<EditText>(R.id.username)//obtengo el texto ingresado y lo transformo en un string
        val editText2 =
            findViewById<EditText>(R.id.password)//obtengo la contrasenia ingresada y la transformo en un string
        val checkBoxAcepto =
            findViewById<CheckBox>(R.id.rememberMe)//indico cual es el checkbox con el id
        val botonIniciarSesion =
            findViewById<Button>(R.id.loginButton)//indico cual es el boton con el id

        var preferencias =
            getSharedPreferences(resources.getString((R.string.sp_credenciales)), MODE_PRIVATE)
        var usuarioGuardado =
            preferencias.getString(resources.getString(R.string.nombre_usuario), "")
        var passwordGuardado =
            preferencias.getString(resources.getString(R.string.password_usuario), "")




        if (usuarioGuardado != null && passwordGuardado != null) {
            startMainActivity(usuarioGuardado)
        }


        // supportActionBar!!.title = resources.getString(R.string.titulo)

        //Agregamos funcionalidad al Boton
        checkBoxAcepto.setOnClickListener {
            // Mostramos un mensaje
            Toast.makeText(this, "Registrar Usuario", Toast.LENGTH_SHORT).show()
           //  var intentTerminos = Intent(this, pantalla2Activity::class.java)
            // startActivity(intentTerminos)
        }


        botonIniciarSesion.setOnClickListener {
            val usuarioIngresado = editText.text.toString()//guardo el texto ingresado
            val contraseniaIngresada = editText2.text.toString()//guardo la contrasenia ingresada

            if (usuarioIngresado.isEmpty() || contraseniaIngresada.isEmpty()) {// si el usuario o la contrasenia estan vacios
                Toast.makeText(this, "Incomplete fields", Toast.LENGTH_SHORT)
                    .show()// escribo un mensaje de tiempo corto indicando que estan vacios
            } else if (!checkBoxAcepto.isChecked) {// si se completaron los campos y el checkbox da false, nos pregunta
                Toast.makeText(this, "Don't want to remember username?", Toast.LENGTH_SHORT).show()

            }
            if(checkBoxAcepto.isChecked) {
                var preferencias = getSharedPreferences(resources.getString((R.string.sp_credenciales)), MODE_PRIVATE)
                preferencias.edit().putString(resources.getString(R.string.nombre_usuario),usuarioIngresado  ).apply()
                preferencias.edit().putString(resources.getString(R.string.password_usuario), contraseniaIngresada).apply()
                var nuevoUsuario = Usuario ("nombre", "password" )
                AppDataBase.getDatabase(this).usuarioDao().insertUsuario(nuevoUsuario)
            val intent = Intent(this, pantalla2Activity::class.java)
            startActivity(intent)
        }
        fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.menu_pantalla2, menu)
            return super.onCreateOptionsMenu(menu)
        }


        fun onOptionsItemSelected(item: MenuItem): Boolean {
            if (item.itemId == R.id.item_Listado) {
                val intentListado = Intent(this, ListadoPersonajesActivity2::class.java)
                startActivity(intentListado)
            }

            return super.onOptionsItemSelected(item)
        }

    }
}

    private fun startMainActivity(usuarioGuardado: String) {
        // Indicamos a que pantalla queremos ir
        val intentMain = Intent(this, pantalla2Activity::class.java)
        // Agregamos datos que queremos pasar a la proxima pantalla
        intentMain.putExtra(resources.getString(R.string.nombre_usuario), usuarioGuardado)
        // Cambiamos de pantalla
        startActivity(intentMain)
        // Eliminamos la Activity actual para sacarla de la Pila
        finish()
    }
}












