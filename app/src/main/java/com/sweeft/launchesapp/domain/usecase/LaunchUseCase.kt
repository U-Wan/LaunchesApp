package com.sweeft.launchesapp.domain.usecase

import androidx.paging.PagingData
import com.sweeft.launchesapp.data.repository.LaunchRepository
import com.sweeft.launchesapp.domain.model.Launch
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLaunchUseCase @Inject constructor(
    private val repository: LaunchRepository
) {
    operator fun invoke(): Flow<PagingData<Launch>> {
        return repository.getLaunches()
    }
}
