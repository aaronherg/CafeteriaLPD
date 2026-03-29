package com.aarondevs.cafeterialpd.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Detalleventas")
data class DetalleVentasEntity(
    @PrimaryKey val detalleVentaId: Int,
    val ventaId: Int,
    val productoId: Int,
    val descripcion: String,
    val cantidad: Int,
    val precio: Double,
)