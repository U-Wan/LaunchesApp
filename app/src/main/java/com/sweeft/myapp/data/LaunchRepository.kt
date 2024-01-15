package com.sweeft.myapp.data

import androidx.paging.PagingData
import com.sweeft.myapp.domain.Launch
import kotlinx.coroutines.flow.Flow


interface LaunchRepository {
    fun getLaunches(): Flow<PagingData<Launch>>
}
