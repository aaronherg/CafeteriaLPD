package com.aarondevs.cafeterialpd.data.remote.remotedatasource

import com.aarondevs.cafeterialpd.data.remote.api.CafeteriaLPDApi

class CafeteriaLPDSource(private val api: CafeteriaLPDApi) {

    // Categorias
    suspend fun addCategoria(
        apiKey: String, permiso: String, metodo: String,
        nombre: String, color: String, estado: String
    ) = api.addCategoria(apiKey, permiso, metodo, nombre, color, estado)

    suspend fun updateCategoria(
        apiKey: String, permiso: String, metodo: String,
        categoriaId: String, nombre: String, color: String, estado: String
    ) = api.updateCategoria(apiKey, permiso, metodo, categoriaId, nombre, color, estado)

    suspend fun deleteCategoria(
        apiKey: String, permiso: String, metodo: String,
        categoriaId: String
    ) = api.deleteCategoria(apiKey, permiso, metodo, categoriaId)

    suspend fun getCategoriaById(
        apiKey: String, permiso: String, metodo: String,
        categoriaId: String
    ) = api.getCategoriaById(apiKey, permiso, metodo, categoriaId)

    suspend fun getAllCategorias(
        apiKey: String, permiso: String, metodo: String
    ) = api.getAllCategorias(apiKey, permiso, metodo)



}