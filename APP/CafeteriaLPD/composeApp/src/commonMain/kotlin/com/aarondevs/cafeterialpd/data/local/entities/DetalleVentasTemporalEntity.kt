package com.aarondevs.cafeterialpd.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DetalleventasTemporal")
data class DetalleVentasTemporalEntity(
    @PrimaryKey val detalleVentaTemporalId: Int,
    val ventaTemporalId: Int,
    val productoId: Int,
    val descripcion: String,
    val cantidad: Int,
    val precio: Double
)