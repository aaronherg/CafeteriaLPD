package com.aarondevs.cafeterialpd.di

import com.aarondevs.cafeterialpd.data.remote.api.CafeteriaLPDApi
import io.ktor.client.*
import io.ktor.client.plugins.HttpRedirect
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

const val BASE_URL_API1 = ""

fun provideKtorClient(): HttpClient {
    return HttpClient {
        expectSuccess = true
        install(ContentNegotiation) {
            json(json = Json { ignoreUnknownKeys = true }, contentType = ContentType.Any)
        }
        install(HttpRedirect) {
            checkHttpMethod = false
            allowHttpsDowngrade = true
        }
    }
}


fun provideCafeteriaLPDApi(client: HttpClient): CafeteriaLPDApi {
    return CafeteriaLPDApi(client, BASE_URL_API1)
}