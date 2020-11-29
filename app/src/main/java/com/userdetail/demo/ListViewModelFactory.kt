package com.userdetail.demo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.userdetail.demo.data.APIService

class ListViewModelFactory(private val apiService: APIService) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListViewModel::class.java)) {
            return ListViewModel(apiService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}