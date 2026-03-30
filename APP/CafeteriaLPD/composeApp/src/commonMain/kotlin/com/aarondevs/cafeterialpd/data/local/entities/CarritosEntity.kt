package com.aarondevs.cafeterialpd.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Contextual

@Entity(tableName = "Carritos")
data class CarritosEntity(
    @PrimaryKey val carritoId: Int,
    val areaId: String,
    val codigo: String,
    val cliente: String,
    val telefono: String,
    val direccion: String,
    val envio: String,
    val metodoPago: String,
    val comentario: String,
    @Contextual val fecha: LocalDateTime
)