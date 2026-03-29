package com.aarondevs.cafeterialpd.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.aarondevs.cafeterialpd.data.local.entities.DetalleVentasTemporalEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DetalleVentasTemporalDao {
    @Upsert
    suspend fun save(detalleVentasTemporal: DetalleVentasTemporalEntity)

    @Query(
        """
        SELECT * 
        FROM DetalleVentasTemporal 
        WHERE detalleVentaTemporalId = :id  
        LIMIT 1
        """
    )
    suspend fun find(id: Int): DetalleVentasTemporalEntity?

    @Delete
    suspend fun delete(detalleVentaTemporal: DetalleVentasTemporalEntity)

    @Query("SELECT * FROM DetalleVentasTemporal")
    fun getAll(): Flow<List<DetalleVentasTemporalEntity>>

}