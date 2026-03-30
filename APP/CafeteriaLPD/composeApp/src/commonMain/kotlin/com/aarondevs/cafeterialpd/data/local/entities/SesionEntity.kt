package com.aarondevs.cafeterialpd.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Sesion")
data class SesionEntity(
    @PrimaryKey val sesionId: Int,
    val token: String,
    val nombreUsuario: String,
    val apellidoUsuario: String,
    val rolId: String,
    val nombreRol: String,
    val correoUsuario: String,
    val sexoUsuario: String,
    val screen: String,
)