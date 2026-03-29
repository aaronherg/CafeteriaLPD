package com.aarondevs.cafeterialpd.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Ventas")
data class VentasEntity(
    @PrimaryKey val ventaId: Int,
    val codigo: String,
    val cliente: String,
    val direccion: String,
    val metodoPago: String,
    val montoDelivery: Double,
    val montoTotal: Double,
    val fecha: String
)