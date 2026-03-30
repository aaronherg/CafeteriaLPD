package com.aarondevs.cafeterialpd.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Contextual

@Entity(tableName = "Clientes")
data class ClientesEntity(
    @PrimaryKey val clienteId: Int,
    val telefono: String,
    val nombre: String,
    val direccion: String,
    val estado: String,
    @Contextual val version: LocalDateTime
)