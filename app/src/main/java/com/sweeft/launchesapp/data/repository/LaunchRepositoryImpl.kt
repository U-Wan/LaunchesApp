package com.sweeft.launchesapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.sweeft.launchesapp.data.api.ApiServices
import com.sweeft.launchesapp.domain.model.Launch
import com.sweeft.launchesapp.data.api.LaunchesPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LaunchRepositoryImpl @Inject constructor(
    private val apiServices: ApiServices
) : LaunchRepository {

    companion object {
        const val PAGE_SIZE = 20
    }

    override fun getLaunches(): Flow<PagingData<Launch>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { LaunchesPagingSource(apiServices) }
        ).flow
    }
}
