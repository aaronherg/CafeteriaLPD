package com.aarondevs.cafeterialpd.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Categorias")
data class CategoriasEntity(
    @PrimaryKey val categoriaId: Int,
    val descripcion: String,
    val estado: String,
)