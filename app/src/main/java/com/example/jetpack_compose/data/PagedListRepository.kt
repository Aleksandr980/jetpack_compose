package com.example.jetpack_compose.data


import android.util.Log
import com.example.jetpack_compose.api.LocationsResponse
import com.example.jetpack_compose.api.ResponseCharacter
import com.example.jetpack_compose.api.retrofit
import com.example.jetpack_compose.entity.Character
import com.example.jetpack_compose.entity.Episode

class PagedListRepository {

    suspend fun getCharacterList(page: Int): ResponseCharacter {
        val responseCharacter = retrofit.characterLoad(page)
        Log.d(
            "PagedListRepository",
            "PagedListRepository   return retrofit.characterLoad(page) = ${responseCharacter}"
        )
        return responseCharacter
    }

    suspend fun getEpisode(number: Int): Episode {
        val responseEpisode = retrofit.episodeLoad(number)
        Log.d(
            "PagedListRepository",
            "PagedListRepository   return  retrofit.episodeLoad(page) = ${responseEpisode}"
        )
        return responseEpisode
    }

    suspend fun getLocationList(page: Int): LocationsResponse {
        val responseLocation = retrofit.locationsLoad(page)
        Log.d(
            "PagedListRepository",
            "PagedListRepository   return  retrofit.locationsLoad(page) = ${responseLocation}"
        )
        return responseLocation
    }

}

