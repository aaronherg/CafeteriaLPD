package com.aarondevs.cafeterialpd.di

import com.aarondevs.cafeterialpd.data.local.database.getDatabaseBuilder
import com.aarondevs.cafeterialpd.data.local.database.getRoomDatabase
import org.koin.dsl.module

actual val nativeModule = module {
    single {
        val builder = getDatabaseBuilder()
        getRoomDatabase(builder).getConfiguracionDao()
        getRoomDatabase(builder).getDetalleVentasDao()
        getRoomDatabase(builder).getDetalleVentasTemporalDao()
        getRoomDatabase(builder).getProductosDao()
        getRoomDatabase(builder).getVentasDao()
        getRoomDatabase(builder).getVentasTemporalDao()
        getRoomDatabase(builder).getCategoriasDao()
    }
}