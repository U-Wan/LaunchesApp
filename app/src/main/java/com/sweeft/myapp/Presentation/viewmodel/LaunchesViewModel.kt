package com.sweeft.myapp.Presentation.viewmodel

import android.nfc.tech.MifareUltralight.PAGE_SIZE
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.sweeft.myapp.data.ApiServices
import com.sweeft.myapp.domain.Launch
import com.sweeft.myapp.paging.LaunchesPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel

class LaunchesViewModel
@Inject
constructor(
    private val apiService: ApiServices
) : ViewModel() {

    private val _listData = MutableStateFlow<PagingData<Launch>>(PagingData.empty())

    val listData: StateFlow<PagingData<Launch>> get() = _listData

    fun fetchData() {
        viewModelScope.launch {
            try {
                val data = Pager(PagingConfig(pageSize = 1)) {
                    LaunchesPagingSource(apiService)
                }.flow.cachedIn(viewModelScope)

                data.collect {
                    _listData.value = it
                    // Log the fetched data
                    Log.d("LaunchesViewModel", "Fetched data: $it")
                }
            } catch (e: Exception) {
                // Log or handle the exception
                e.printStackTrace()
                Log.e("LaunchesViewModel", "Error fetching data: ${e.message}")
            }
        }
    }
}
