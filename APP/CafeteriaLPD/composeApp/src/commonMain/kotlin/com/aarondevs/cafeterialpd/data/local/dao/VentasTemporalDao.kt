package com.aarondevs.cafeterialpd.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.aarondevs.cafeterialpd.data.local.entities.VentasTemporalEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface VentasTemporalDao {
    @Upsert
    suspend fun save(ventaTemporal: VentasTemporalEntity)

    @Query("SELECT * FROM VentasTemporal WHERE cliente = :cliente LIMIT 1")
    suspend fun findByCliente(cliente: String): VentasTemporalEntity?

    @Query(
        """
        SELECT * 
            FROM VentasTemporal 
        WHERE ventaTemporalId = :id  
        LIMIT 1
        """
    )
    suspend fun find(id: Int): VentasTemporalEntity?

    @Delete
    suspend fun delete(ventaTemporal: VentasTemporalEntity)

    @Query("SELECT * FROM VentasTemporal")
    fun getAll(): Flow<List<VentasTemporalEntity>>

}