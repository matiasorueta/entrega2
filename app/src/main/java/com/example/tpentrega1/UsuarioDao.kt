package com.example.tpentrega1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsuarioDao {
    @Query("select * from usuario_table")
    fun getAll(): List<Usuario>

    @Insert
    fun insertUsuario(usuario: Usuario)
}