package com.sweeft.myapp.Presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sweeft.myapp.data.LaunchRepository
import com.sweeft.myapp.Presentation.viewmodel.LaunchesViewModel

class LaunchesViewModelFactory(private val repository: LaunchRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LaunchesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LaunchesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
