package com.example.pagingexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pagingexample.PagingSource.LoaderAdapter
import com.example.pagingexample.PagingSource.QuotePagingAdapter
import com.example.pagingexample.viewModel.QuoteViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var quoteViewModel: QuoteViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: QuotePagingAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.quoteList)

        quoteViewModel = ViewModelProvider(this)[QuoteViewModel::class.java]

        adapter = QuotePagingAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter.withLoadStateHeaderAndFooter(
            header = LoaderAdapter {
                adapter.retry()
            },
            footer = LoaderAdapter {
                adapter.retry()
            }
        )

        quoteViewModel.list.observe(
            this,
        ) {
            adapter.submitData(lifecycle, it)
        }
    }
}