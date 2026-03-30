package com.aarondevs.cafeterialpd.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Contextual

@Entity(tableName = "Areas")
data class AreasEntity(
    @PrimaryKey val areaId: Int,
    val codigo: String,
    val nombre: String,
    val descripcion: String,
    val estado: String,
    @Contextual val version: LocalDateTime
)