package com.aarondevs.cafeterialpd.data.remote.api

import com.aarondevs.cafeterialpd.data.remote.dto.CategoriasDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.forms.submitForm
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.Parameters
import io.ktor.http.contentType
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

class CafeteriaLPDApi(private val client: HttpClient, private val baseUrl: String) {

    // Categorias

    suspend fun addCategoria(
        apiKey: String, permiso: String, metodo: String,
        nombre: String, color: String, estado: String
    ): CategoriasDto {
        val responseText: JsonElement = client.submitForm(
            url = "$baseUrl/api/v001/private/categoriasEndpoint/",
            formParameters = Parameters.build {
                append("apikey", apiKey)
                append("permiso", permiso)
                append("metodo", metodo)

                append("nombre", nombre)
                append("color", color)
                append("estado", estado)
            }
        ).body()

        val validacion = responseText.jsonObject["Validacion"]?.jsonPrimitive?.contentOrNull
        val respuesta = responseText.jsonObject["Respuesta"]?.jsonObject

        return if (respuesta != null) {
            val respuestaConValidacion = buildJsonObject {
                respuesta.forEach { (key, value) ->
                    put(key, value)
                }
                put("Validacion", JsonPrimitive(validacion ?: ""))
            }
            Json.decodeFromJsonElement<CategoriasDto>(respuestaConValidacion)
        } else {
            CategoriasDto(Validacion = validacion)
        }
    }

    suspend fun updateCategoria(
        apiKey: String, permiso: String, metodo: String,
        categoriaId: String, nombre: String, color: String, estado: String
    ): CategoriasDto {
        val responseText: JsonElement = client.submitForm(
            url = "$baseUrl/api/v001/private/categoriasEndpoint/",
            formParameters = Parameters.build {
                append("apikey", apiKey)
                append("permiso", permiso)
                append("metodo", metodo)

                append("categoriaId", categoriaId)
                append("nombre", nombre)
                append("color", color)
                append("estado", estado)
            }
        ).body()

        val validacion = responseText.jsonObject["Validacion"]?.jsonPrimitive?.contentOrNull
        val respuesta = responseText.jsonObject["Respuesta"]?.jsonObject

        return if (respuesta != null) {
            val respuestaConValidacion = buildJsonObject {
                respuesta.forEach { (key, value) ->
                    put(key, value)
                }
                put("Validacion", JsonPrimitive(validacion ?: ""))
            }
            Json.decodeFromJsonElement<CategoriasDto>(respuestaConValidacion)
        } else {
            CategoriasDto(Validacion = validacion)
        }
    }

    suspend fun deleteCategoria(
        apiKey: String, permiso: String, metodo: String,
        categoriaId: String
    ): CategoriasDto {
        val responseText: JsonElement = client.submitForm(
            url = "$baseUrl/api/v001/private/categoriasEndpoint/",
            formParameters = Parameters.build {
                append("apikey", apiKey)
                append("permiso", permiso)
                append("metodo", metodo)
                append("categoriaId", categoriaId)
            }
        ).body()

        val validacion = responseText.jsonObject["Validacion"]?.jsonPrimitive?.contentOrNull
        val respuesta = responseText.jsonObject["Respuesta"]?.jsonObject

        return if (respuesta != null) {
            val respuestaConValidacion = buildJsonObject {
                respuesta.forEach { (key, value) ->
                    put(key, value)
                }
                put("Validacion", JsonPrimitive(validacion ?: ""))
            }
            Json.decodeFromJsonElement<CategoriasDto>(respuestaConValidacion)
        } else {
            CategoriasDto(Validacion = validacion)
        }
    }

    suspend fun getCategoriaById(
        apiKey: String, permiso: String, metodo: String,
        categoriaId: String
    ): CategoriasDto {
        val responseText: JsonElement = client.submitForm(
            url = "$baseUrl/api/v001/private/categoriasEndpoint/",
            formParameters = Parameters.build {
                append("apikey", apiKey)
                append("permiso", permiso)
                append("metodo", metodo)
                append("categoriaId", categoriaId)
            }
        ).body()

        val validacion = responseText.jsonObject["Validacion"]?.jsonPrimitive?.contentOrNull
        val respuesta = responseText.jsonObject["Respuesta"]?.jsonObject

        return if (respuesta != null) {
            val respuestaConValidacion = buildJsonObject {
                respuesta.forEach { (key, value) ->
                    put(key, value)
                }
                put("Validacion", JsonPrimitive(validacion ?: ""))
            }
            Json.decodeFromJsonElement<CategoriasDto>(respuestaConValidacion)
        } else {
            CategoriasDto(Validacion = validacion)
        }
    }

    suspend fun getAllCategorias(
        apiKey: String, permiso: String, metodo: String
    ): List<CategoriasDto> {
        val responseText: String = client.submitForm(
            url = "$baseUrl/api/v001/private/categoriasEndpoint/",
            formParameters = Parameters.build {
                append("apikey", apiKey)
                append("permiso", permiso)
                append("metodo", metodo)
            }
        ).body()

        val jsonElement = Json.parseToJsonElement(responseText).jsonObject

        val validacion = jsonElement["Validacion"]?.jsonPrimitive?.contentOrNull
        val respuesta = jsonElement["Respuesta"]?.jsonObject
        val categoriasArray = respuesta?.get("categorias")?.jsonArray ?: return emptyList()

        return categoriasArray.map { categoria ->
            val categoriaConValidacion = buildJsonObject {
                categoria.jsonObject.forEach { (key, value) ->
                    put(key, value)
                }
                put("Validacion", JsonPrimitive(validacion ?: ""))
            }
            Json.decodeFromJsonElement<CategoriasDto>(categoriaConValidacion)
        }
    }
}