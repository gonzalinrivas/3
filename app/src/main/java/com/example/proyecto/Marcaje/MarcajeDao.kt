package com.example.proyecto.Marcaje

import androidx.room.*

@Dao
interface MarcajeDao {
    @Query("SELECT * FROM MarcajesEntity")
    fun getAllMarcajes(): MutableList<MarcajesEntity>

    @Query("SELECT * FROM MarcajesEntity where id=:id")
    fun getMarcajeById(id: Long): MarcajesEntity

    @Insert
    fun addMarcaje(marcajesEntity: MarcajesEntity): Long

    @Update
    fun updateMarcaje(marcajesEntity: MarcajesEntity)

    @Delete
    fun deleteMarcaje(marcajesEntity: MarcajesEntity)

}