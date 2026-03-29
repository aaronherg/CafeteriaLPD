package com.aarondevs.cafeterialpd.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.aarondevs.cafeterialpd.data.local.entities.ProductosEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductosDao {
    @Upsert
    suspend fun save(producto: ProductosEntity)

    @Query("SELECT * FROM Productos WHERE descripcion = :descripcion LIMIT 1")
    suspend fun findByDescripcion(descripcion: String): ProductosEntity?

    @Query(
        """
        SELECT * 
        FROM Productos 
        WHERE productoId = :id  
        LIMIT 1
        """
    )
    suspend fun find(id: Int): ProductosEntity?

    @Delete
    suspend fun delete(producto: ProductosEntity)

    @Query("SELECT * FROM Productos")
    fun getAll(): Flow<List<ProductosEntity>>

}