package com.aarondevs.cafeterialpd.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Contextual

@Entity(tableName = "Configuracion")
data class ConfiguracionEntity(
    @PrimaryKey val configuracionId: Int,
    val negocio: String,
    val direccion: String,
    val telefono: String,
    val envio: Double,
    @Contextual val version: LocalDateTime
)