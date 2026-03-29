package com.aarondevs.cafeterialpd.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Productos")
data class ProductosEntity(
    @PrimaryKey val productoId: Int,
    val codigo: String,
    val descripcion: String,
    val precio: Double,
    val imagen: String
)
