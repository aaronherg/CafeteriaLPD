package com.aarondevs.cafeterialpd.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Configuracion")
data class ConfiguracionEntity(
    @PrimaryKey val configuracionId: Int,
    val negocio: String,
    val direccion: String,
    val telefono: String,
    val montoEnvio: Double,
    val usuarioId: Int,
    val token: String
)