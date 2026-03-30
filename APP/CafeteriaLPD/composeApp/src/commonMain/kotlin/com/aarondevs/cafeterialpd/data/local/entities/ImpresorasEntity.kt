package com.aarondevs.cafeterialpd.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Contextual

@Entity(tableName = "Impresoras")
data class ImpresorasEntity(
    @PrimaryKey val impresoraId: Int,
    val nombre: String,
    val codigo: String,
    val estado: String
)