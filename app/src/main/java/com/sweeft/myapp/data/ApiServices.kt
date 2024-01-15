package com.sweeft.myapp.data

import com.sweeft.myapp.domain.Launch
import com.sweeft.myapp.utills.Constants
import retrofit2.Response
import retrofit2.http.GET


interface ApiServices {
    @GET("launches")
    suspend fun getLaunches(): Response<List<Launch>>
}


