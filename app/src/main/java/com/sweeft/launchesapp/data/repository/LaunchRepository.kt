package com.sweeft.launchesapp.data.repository

import androidx.paging.PagingData
import com.sweeft.launchesapp.domain.model.Launch
import kotlinx.coroutines.flow.Flow


interface LaunchRepository {
    fun getLaunches(): Flow<PagingData<Launch>>
}
