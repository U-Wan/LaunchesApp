package com.sweeft.myapp.domain

import androidx.paging.PagingData
import com.sweeft.myapp.data.LaunchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLaunchUseCase @Inject constructor(
    private val repository: LaunchRepository
) {
    operator fun invoke(): Flow<PagingData<Launch>> {
        return repository.getLaunches()
    }
}
