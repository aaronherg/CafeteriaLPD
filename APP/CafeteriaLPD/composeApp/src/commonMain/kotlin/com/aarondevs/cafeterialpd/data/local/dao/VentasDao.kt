package com.aarondevs.cafeterialpd.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.aarondevs.cafeterialpd.data.local.entities.VentasEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface VentasDao {
    @Upsert
    suspend fun save(venta: VentasEntity)

    @Query("SELECT * FROM Ventas WHERE cliente = :cliente LIMIT 1")
    suspend fun findByCliente(cliente: String): VentasEntity?

    @Query(
        """
        SELECT * 
        FROM Ventas 
        WHERE ventaId = :id  
        LIMIT 1
        """
    )
    suspend fun find(id: Int): VentasEntity?

    @Delete
    suspend fun delete(venta: VentasEntity)

    @Query("SELECT * FROM Ventas")
    fun getAll(): Flow<List<VentasEntity>>

}