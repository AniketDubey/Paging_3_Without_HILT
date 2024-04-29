package com.example.pagingexample.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.pagingexample.QuoteRepository.QuoteRepository

class QuoteViewModel: ViewModel() {
    private val repository =  QuoteRepository()
    val list = repository.getQuotes().cachedIn(viewModelScope)
}