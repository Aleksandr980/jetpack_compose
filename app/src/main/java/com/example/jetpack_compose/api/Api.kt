package com.example.jetpack_compose.api

import com.example.jetpack_compose.entity.Character
import com.example.jetpack_compose.entity.Episode
import com.example.jetpack_compose.entity.Location
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


const val URL = "https://rickandmortyapi.com"

interface Api {
    @GET("/api/character")
    suspend fun characterLoad(@Query("page") page: Int): ResponseCharacter

    @GET("/api/location")
    suspend fun locationsLoad(@Query("page") page: Int): LocationsResponse

    @GET("/api/episode/{number}")
    suspend fun episodeLoad(@Path("number") number: Int): Episode
}

val retrofit: Api = Retrofit
    .Builder()
    .client(
        OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor().also {
                it.level = HttpLoggingInterceptor.Level.BODY
            }).build()
    )
    .baseUrl(URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(Api::class.java)

data class ResponseCharacter(
    val results: List<Character>
)

data class LocationsResponse(
    val results: List<Location>
)

