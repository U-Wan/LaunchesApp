package com.sweeft.launchesapp.data.api

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sweeft.launchesapp.domain.model.Launch

class LaunchesPagingSource(
    private val apiServices: ApiServices
) : PagingSource<Int, Launch>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Launch> {
        return try {
            val pageNumber = params.key ?: 1
            val response = apiServices.getLaunches()

            if (response.isSuccessful) {
                val launches = response.body() ?: emptyList()

                LoadResult.Page(
                    data = launches,
                    prevKey = if (pageNumber == 1) null else pageNumber - 1,
                    nextKey = if (launches.isEmpty()) null else pageNumber + 1
                )
            } else {
                LoadResult.Error(Exception("Failed to load launches: ${response.message()}"))
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Launch>): Int? {
        return null
    }
}
