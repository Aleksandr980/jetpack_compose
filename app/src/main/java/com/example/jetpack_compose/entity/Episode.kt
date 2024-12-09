package com.example.jetpack_compose.entity

data class Episode(
    val id: Int,
    val name: String,
    val air_date: String,
    val episode: String,

)

data class ResponseEpisodes(
    val results: List<Episode>,
    val info: Info
)
data class Info(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)