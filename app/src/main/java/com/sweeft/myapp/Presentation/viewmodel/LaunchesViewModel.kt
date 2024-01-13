package com.sweeft.myapp.Presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sweeft.myapp.data.ApiService
import com.sweeft.myapp.data.LaunchRepository
import com.sweeft.myapp.domain.Launch
import kotlinx.coroutines.launch

    class LaunchesViewModel(private val repository: LaunchRepository) : ViewModel() {

    private val _dataList = MutableLiveData<List<Launch>>()
    val dataList: LiveData<List<Launch>> get() = _dataList

    fun updateData(newData: List<Launch>) {
        _dataList.value = newData
    }
        fun fetchData() {
            viewModelScope.launch {
                try {
                    val response = repository.fetchData()
                    if (response.isSuccessful) {
                        _dataList.value = response.body() // Wrap the response.body() in a list
                    } else {
                        // Handle error
                    }
                } catch (e: Exception) {
                    // Handle exception
                }
            }
        }
    fun addItem(newItem: Launch) {
        val currentList = _dataList.value.orEmpty().toMutableList()
        currentList.add(newItem)
        _dataList.value = currentList
    }
}
