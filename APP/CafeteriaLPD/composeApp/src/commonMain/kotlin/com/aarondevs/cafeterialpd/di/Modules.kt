package com.aarondevs.cafeterialpd.di

import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    single(named("apiClient")) { provideKtorClient() }
}

val dataModule = module {

}

val viewModelsModule = module {

}

expect val nativeModule: Module