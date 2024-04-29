package com.example.pagingexample.QuoteRepository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.pagingexample.PagingSource.QuotePagingSource

class QuoteRepository {
    fun getQuotes() = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        pagingSourceFactory = { QuotePagingSource() }
    ).liveData
}