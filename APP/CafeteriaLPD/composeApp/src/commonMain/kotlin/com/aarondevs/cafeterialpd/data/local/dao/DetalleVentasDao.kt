package com.aarondevs.cafeterialpd.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.aarondevs.cafeterialpd.data.local.entities.DetalleVentasEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DetalleVentasDao {
    @Upsert
    suspend fun save(detalleVenta: DetalleVentasEntity)

    @Query(
        """
        SELECT * 
        FROM Detalleventas  
        WHERE detalleVentaId = :id  
        LIMIT 1
        """
    )
    suspend fun find(id: Int): DetalleVentasEntity?

    @Delete
    suspend fun delete(detalleVenta: DetalleVentasEntity)

    @Query("SELECT * FROM detalleventas")
    fun getAll(): Flow<List<DetalleVentasEntity>>

}