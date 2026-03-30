package com.aarondevs.cafeterialpd.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.aarondevs.cafeterialpd.data.local.entities.CategoriasEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.LocalDateTime

@Dao
interface CategoriasDao {
    @Upsert
    suspend fun save(categoria: CategoriasEntity)

    @Update
    suspend fun update(categoria: CategoriasEntity)

    @Query("SELECT * FROM Categorias WHERE nombre = :nombre LIMIT 1")
    suspend fun findByNombre(nombre: String): CategoriasEntity?

    @Query("""SELECT *FROM Categorias WHERE categoriaId = :id LIMIT 1""")
    suspend fun find(id: Int): CategoriasEntity?

    @Delete
    suspend fun delete(categoria: CategoriasEntity)

    @Query("""UPDATE Categorias SET estado = :estado WHERE categoriaId = :categoriaId""")
    suspend fun deleteByEstado(categoriaId: Int, estado: String)

    @Query("SELECT * FROM Categorias")
    fun getAll(): Flow<List<CategoriasEntity>>

    @Query("SELECT MAX(version) FROM Categorias")
    suspend fun getLastVersion(): LocalDateTime?

}