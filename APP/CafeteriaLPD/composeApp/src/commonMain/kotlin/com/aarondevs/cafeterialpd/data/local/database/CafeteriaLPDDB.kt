package com.aarondevs.cafeterialpd.data.local.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.aarondevs.cafeterialpd.data.local.dao.CategoriasDao
import com.aarondevs.cafeterialpd.data.local.dao.ConfiguracionDao
import com.aarondevs.cafeterialpd.data.local.dao.DetalleVentasDao
import com.aarondevs.cafeterialpd.data.local.dao.DetalleVentasTemporalDao
import com.aarondevs.cafeterialpd.data.local.dao.ProductosDao
import com.aarondevs.cafeterialpd.data.local.dao.VentasDao
import com.aarondevs.cafeterialpd.data.local.dao.VentasTemporalDao
import com.aarondevs.cafeterialpd.data.local.entities.CategoriasEntity
import com.aarondevs.cafeterialpd.data.local.entities.ConfiguracionEntity
import com.aarondevs.cafeterialpd.data.local.entities.DetalleVentasEntity
import com.aarondevs.cafeterialpd.data.local.entities.DetalleVentasTemporalEntity
import com.aarondevs.cafeterialpd.data.local.entities.ProductosEntity
import com.aarondevs.cafeterialpd.data.local.entities.VentasEntity
import com.aarondevs.cafeterialpd.data.local.entities.VentasTemporalEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

const val DATABASE_NAME = "cafeterialpd.db"

@Database(
    entities = [ConfiguracionEntity::class,
        DetalleVentasEntity::class,
        DetalleVentasTemporalEntity::class,
        ProductosEntity::class,
        VentasEntity::class,
        VentasTemporalEntity::class,
        CategoriasEntity::class],
    version = 2,
    exportSchema = false
)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class CafeteriaLPDDB : RoomDatabase() {
    abstract fun getConfiguracionDao(): ConfiguracionDao
    abstract fun getDetalleVentasDao(): DetalleVentasDao
    abstract fun getDetalleVentasTemporalDao(): DetalleVentasTemporalDao
    abstract fun getProductosDao(): ProductosDao
    abstract fun getVentasDao(): VentasDao
    abstract fun getVentasTemporalDao(): VentasTemporalDao
    abstract fun getCategoriasDao(): CategoriasDao
}

@Suppress("KotlinNoActualForExpect")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<CafeteriaLPDDB> {
    override fun initialize(): CafeteriaLPDDB
}

fun getRoomDatabase(
    builder: RoomDatabase.Builder<CafeteriaLPDDB>
): CafeteriaLPDDB {
    return builder
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}