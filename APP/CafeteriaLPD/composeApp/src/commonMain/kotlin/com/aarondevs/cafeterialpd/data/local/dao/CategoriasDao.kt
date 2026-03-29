package com.aarondevs.cafeterialpd.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.aarondevs.cafeterialpd.data.local.entities.CategoriasEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoriasDao {
    @Upsert
    suspend fun save(categoria: CategoriasEntity)

    @Query("SELECT * FROM Categorias WHERE descripcion = :descripcion LIMIT 1")
    suspend fun findByDescripcion(descripcion: String): CategoriasEntity?

    @Query(
        """
        SELECT * 
        FROM Categorias 
        WHERE categoriaId = :id  
        LIMIT 1
        """
    )
    suspend fun find(id: Int): CategoriasEntity?

    @Delete
    suspend fun delete(categoria: CategoriasEntity)

    @Query("SELECT * FROM Categorias")
    fun getAll(): Flow<List<CategoriasEntity>>

}