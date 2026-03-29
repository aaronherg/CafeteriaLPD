package com.aarondevs.cafeterialpd.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "VentasTemporal")
data class VentasTemporalEntity(
    @PrimaryKey val ventaTemporalId: Int,
    val cliente: String,
    val direccion: String,
    val metodoPago: String,
    val montoDelivery: Double,
    val montoTotal: Double,
    val fecha: String
)