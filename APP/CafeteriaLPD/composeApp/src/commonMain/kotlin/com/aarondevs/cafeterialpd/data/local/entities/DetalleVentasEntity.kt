package com.aarondevs.cafeterialpd.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Contextual

@Entity(tableName = "DetalleVentas")
data class DetalleVentasEntity(
    @PrimaryKey val detalleVentaId: Int,
    val ventaId: Int,
    val productoId: Int,
    val nombreProducto: String,
    val precioProducto: Double,
    val cantidadProducto: Int,
    val imagenProducto: String,
    val estado: String,
    @Contextual val version: LocalDateTime
)