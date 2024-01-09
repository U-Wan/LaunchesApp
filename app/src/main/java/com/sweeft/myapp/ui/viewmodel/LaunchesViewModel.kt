package com.sweeft.myapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sweeft.myapp.data.Launch

class LaunchesViewModel : ViewModel() {

    private val _dataList = MutableLiveData<List<Launch>>()
    val dataList: LiveData<List<Launch>> get() = _dataList

    fun updateData(newData: List<Launch>) {
        _dataList.value = newData
    }

    fun addItem(newItem: Launch) {
        val currentList = _dataList.value.orEmpty().toMutableList()
        currentList.add(newItem)
        _dataList.value = currentList
    }
}
