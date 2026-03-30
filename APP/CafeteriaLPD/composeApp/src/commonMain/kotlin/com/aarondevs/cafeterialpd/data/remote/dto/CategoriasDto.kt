package com.aarondevs.cafeterialpd.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class CategoriasDto(
    val Validacion: String? = null,
    val mensaje: String? = null,
    val categoriaId: Int? = null,
    val nombre: String? = null,
    val color: String? = null,
    val estado: String? = null,
    val version: String? = null
)