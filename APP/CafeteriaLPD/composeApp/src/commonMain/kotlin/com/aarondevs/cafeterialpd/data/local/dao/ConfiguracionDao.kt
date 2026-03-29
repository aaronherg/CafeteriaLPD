package com.aarondevs.cafeterialpd.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.aarondevs.cafeterialpd.data.local.entities.ConfiguracionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ConfiguracionDao {

    @Upsert
    suspend fun save(configuracion: ConfiguracionEntity)

    @Query("SELECT usuarioId FROM Configuracion LIMIT 1")
    suspend fun getUsuarioId(): Int

    @Query("UPDATE Configuracion SET usuarioId = :usuarioId")
    suspend fun updateUsuarioId(usuarioId: Int)

    @Query("SELECT token FROM Configuracion LIMIT 1")
    suspend fun getToken(): String

    @Query("UPDATE Configuracion SET token = :token")
    suspend fun updateToken(token: String)

    @Delete
    suspend fun delete(configuracion: ConfiguracionEntity)

    @Query("SELECT * FROM Configuracion LIMIT 1")
    suspend fun getAll(): ConfiguracionEntity?

}