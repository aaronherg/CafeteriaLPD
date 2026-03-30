package com.aarondevs.cafeterialpd.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Contextual

@Entity(tableName = "DetalleCarritos")
data class DetalleCarritosEntity(
    @PrimaryKey val dtalleCarritoId: Int,
    val carritoId: Int,
    val productoId: Int,
    val nombreProducto: String,
    val precioProducto: String,
    val cantidadProducto: String,
    val imagenProducto: String
)