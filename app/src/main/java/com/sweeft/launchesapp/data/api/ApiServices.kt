package com.sweeft.launchesapp.data.api

import com.sweeft.launchesapp.domain.model.Launch
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {
    @GET("launches")
    suspend fun getLaunches(): Response<List<Launch>>
}


