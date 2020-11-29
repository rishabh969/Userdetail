package com.userdetail.demo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.userdetail.demo.data.APIService
import com.userdetail.demo.data.datasource.DataSource

class ListViewModel(private val apiService: APIService) : ViewModel() {

    val listData = Pager(PagingConfig(pageSize = 75)) {
        DataSource(apiService)
    }.flow.cachedIn(viewModelScope)
}