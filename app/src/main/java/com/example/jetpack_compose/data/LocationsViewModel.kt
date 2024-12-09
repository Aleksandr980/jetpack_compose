package com.example.jetpack_compose.data

import androidx.lifecycle.ViewModel
import com.example.jetpack_compose.api.LocationsResponse
import com.example.jetpack_compose.api.retrofit

class LocationsViewModel : ViewModel() {

    suspend fun loadLocations(page: Int): LocationsResponse {
        return retrofit.locationsLoad(page)
    }
}
