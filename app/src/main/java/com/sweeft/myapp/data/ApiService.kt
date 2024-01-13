package com.sweeft.myapp.data

import com.sweeft.myapp.domain.Launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("launches") // Removed the leading slash here
    suspend fun fetchData(): Response<List<Launch>>

    companion object {
        private const val BASE_URL = "https://api.spacexdata.com/v3/"

        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}
