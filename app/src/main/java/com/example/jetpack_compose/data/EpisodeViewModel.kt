package com.example.jetpack_compose.data

import androidx.lifecycle.ViewModel
import com.example.jetpack_compose.api.retrofit
import com.example.jetpack_compose.entity.Episode

class EpisodeViewModel  : ViewModel() {
     suspend fun loadEpisodes(number: Int): Episode {
        return retrofit.episodeLoad(number)
    }
}



