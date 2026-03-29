package com.aarondevs.cafeterialpd

import android.app.Application
import com.aarondevs.cafeterialpd.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class CafeteriaLPDApp : Application() {

    companion object {
        lateinit var instance: CafeteriaLPDApp
            private set
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

        initKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@CafeteriaLPDApp)
        }
    }

}