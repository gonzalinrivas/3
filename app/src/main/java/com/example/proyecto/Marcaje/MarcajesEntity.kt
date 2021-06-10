package com.example.proyecto.Marcaje

import androidx.room.PrimaryKey

data class MarcajesEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var name: String,
    var matricula: String,
    //var tipoActividad:String,
    var isFavorite: Boolean = false


) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MarcajesEntity

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}

