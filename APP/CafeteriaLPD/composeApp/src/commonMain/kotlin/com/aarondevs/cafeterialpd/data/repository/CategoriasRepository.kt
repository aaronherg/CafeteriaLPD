package com.aarondevs.cafeterialpd.data.repository

import com.aarondevs.cafeterialpd.data.local.dao.CategoriasDao
import com.aarondevs.cafeterialpd.data.local.entities.CategoriasEntity
import com.aarondevs.cafeterialpd.data.remote.dto.CategoriasDto
import com.aarondevs.cafeterialpd.data.remote.remotedatasource.CafeteriaLPDSource
import com.aarondevs.cafeterialpd.librery.Metodos
import com.aarondevs.cafeterialpd.librery.Permisos
import com.aarondevs.cafeterialpd.librery.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class CategoriasRepository(
    private val api: CafeteriaLPDSource,
    private val dao: CategoriasDao
) {

    // =========================
    // ADD
    // =========================
    fun addCategoria(
        apiKey: String,
        nombre: String,
        color: String
    ): Flow<Resource<String>> = flow {
        emit(Resource.Loading())

        try {
            val response = api.addCategoria(
                apiKey,
                Permisos.AGREGAR_CATEGORIA,
                Metodos.ADD_CATEGORIA,
                nombre,
                color,
                ""
            )

            if (response.Validacion == "Exitoso") {
                emit(Resource.Success(response.mensaje ?: "Categoría agregada"))
            } else {
                emit(Resource.Error(response.mensaje ?: "Error en API"))
            }

        } catch (e: Exception) {
            val local = CategoriasEntity(
                categoriaId = generarIdLocal(),
                nombre = nombre,
                color = color,
                estado = "Nuevo",
                version = now()
            )
            dao.save(local)

            emit(Resource.Error("Guardado local: ${e.message}"))
        }
    }

    // =========================
    // UPDATE
    // =========================
    fun updateCategoria(
        apiKey: String,
        categoria: CategoriasEntity
    ): Flow<Resource<String>> = flow {
        emit(Resource.Loading())

        try {
            val response = api.updateCategoria(
                apiKey,
                Permisos.EDITAR_CATEGORIA,
                Metodos.UPDATE_CATEGORIA,
                categoria.categoriaId.toString(),
                categoria.nombre,
                categoria.color,
                categoria.estado
            )

            if (response.Validacion == "Exitoso") {
                dao.save(categoria.copy(version = now(), estado = ""))
                emit(Resource.Success(response.mensaje ?: "Actualizado"))
            } else {
                emit(Resource.Error(response.mensaje ?: "Error en API"))
            }

        } catch (e: Exception) {
            dao.save(
                categoria.copy(
                    estado = "Actualizado",
                    version = now()
                )
            )
            emit(Resource.Error("Actualizado local: ${e.message}"))
        }
    }

    // =========================
    // DELETE
    // =========================
    fun deleteCategoria(
        apiKey: String,
        categoria: CategoriasEntity
    ): Flow<Resource<String>> = flow {
        emit(Resource.Loading())

        dao.deleteByEstado(categoria.categoriaId, "Eliminado")

        try {
            val response = api.deleteCategoria(
                apiKey,
                Permisos.ELIMINAR_CATEGORIA,
                Metodos.DELETE_CATEGORIA,
                categoria.categoriaId.toString()
            )

            if (response.Validacion == "Exitoso") {
                dao.delete(categoria)
                emit(Resource.Success(response.mensaje ?: "Eliminado"))
            } else {
                emit(Resource.Error(response.mensaje ?: "Error al eliminar"))
            }

        } catch (e: Exception) {
            emit(Resource.Error("Eliminado local pendiente: ${e.message}"))
        }
    }

    // =========================
    // GET BY ID
    // =========================
    fun getCategoriaById(
        apiKey: String,
        categoriaId: Int
    ): Flow<Resource<CategoriasEntity>> = flow {
        emit(Resource.Loading())

        val local = dao.find(categoriaId)

        if (local != null) {
            emit(Resource.Success(local))
            return@flow
        }

        try {
            val response = api.getCategoriaById(
                apiKey,
                Permisos.BUSCAR_CATEGORIA,
                Metodos.GET_ID_CATEGORIA,
                categoriaId.toString()
            )

            if (response.Validacion == "Exitoso") {
                val entity = response.toEntity()
                dao.save(entity)
                emit(Resource.Success(entity))
            } else {
                emit(Resource.Error(response.mensaje ?: "No encontrado"))
            }

        } catch (e: Exception) {
            emit(Resource.Error("Error: ${e.message}"))
        }
    }

    // =========================
    // GET ALL
    // =========================
    fun getAllCategorias(): Flow<List<CategoriasEntity>> = dao.getAll()

    // =========================
    // SYNC API -> LOCAL
    // =========================
    suspend fun syncApiToLocal(apiKey: String) {
        try {
            val remoteList = api.getAllCategorias(
                apiKey,
                Permisos.LISTAR_CATEGORIAS,
                Metodos.GET_ALL_CATEGORIA
            )

            remoteList.forEach { dto ->
                val id = dto.categoriaId ?: return@forEach
                val local = dao.find(id)

                if (local == null) {
                    dao.save(dto.toEntity())
                } else {
                    val remoteVersion = dto.version.toLocalDateTime()
                    if (remoteVersion > local.version) {
                        dao.save(dto.toEntity())
                    }
                }
            }

        } catch (_: Exception) {}
    }

    // =========================
    // SYNC LOCAL -> API
    // =========================
    suspend fun syncLocalToApi(apiKey: String) {

        val localList = dao.getAll().firstOrNull() ?: return

        localList.forEach { categoria ->

            try {
                when (categoria.estado) {

                    "Nuevo" -> {
                        val res = api.addCategoria(
                            apiKey,
                            Permisos.AGREGAR_CATEGORIA,
                            Metodos.ADD_CATEGORIA,
                            categoria.nombre,
                            categoria.color,
                            ""
                        )
                        if (res.Validacion == "Exitoso") {
                            dao.delete(categoria)
                        }
                    }

                    "Actualizado" -> {
                        val res = api.updateCategoria(
                            apiKey,
                            Permisos.EDITAR_CATEGORIA,
                            Metodos.UPDATE_CATEGORIA,
                            categoria.categoriaId.toString(),
                            categoria.nombre,
                            categoria.color,
                            ""
                        )
                        if (res.Validacion == "Exitoso") {
                            dao.save(categoria.copy(estado = ""))
                        }
                    }

                    "Eliminado" -> {
                        val res = api.deleteCategoria(
                            apiKey,
                            Permisos.ELIMINAR_CATEGORIA,
                            Metodos.DELETE_CATEGORIA,
                            categoria.categoriaId.toString()
                        )
                        if (res.Validacion == "Exitoso") {
                            dao.delete(categoria)
                        }
                    }
                }

            } catch (_: Exception) {}
        }
    }

    // =========================
    // SYNC MASTER
    // =========================
    suspend fun sync(apiKey: String) {
        syncLocalToApi(apiKey)
        syncApiToLocal(apiKey)
    }

    // =========================
    // HELPERS
    // =========================
    private fun generarIdLocal(): Int = (-1..-999999).random()

    private fun now(): LocalDateTime = DateUtils.now()

    private fun String?.toLocalDateTime(): LocalDateTime {
        return DateUtils.parse(this)
    }

    private fun CategoriasDto.toEntity(): CategoriasEntity {
        return CategoriasEntity(
            categoriaId = categoriaId ?: 0,
            nombre = nombre.orEmpty(),
            color = color.orEmpty(),
            estado = estado.orEmpty(),
            version = version.toLocalDateTime()
        )
    }
}