package com.sweeft.myapp.data

import com.sweeft.myapp.domain.Launch
import retrofit2.Response


class LaunchRepository(private val apiService: ApiService) {

    suspend fun fetchData(): Response<List<Launch>> {
        return apiService.fetchData()
    }
}
