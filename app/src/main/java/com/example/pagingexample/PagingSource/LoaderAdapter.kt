package com.example.pagingexample.PagingSource

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pagingexample.R

class LoaderAdapter(private val retry: () -> Unit) :
    LoadStateAdapter<LoaderAdapter.LoaderViewHolder>() {


    override fun onBindViewHolder(holder: LoaderViewHolder, loadState: LoadState) {
        holder.bind(loadState)
        holder.retryButton.setOnClickListener {
            retry.invoke()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoaderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.loader_item, parent, false
        )
        return LoaderViewHolder(view)
    }

    class LoaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val progressBar = itemView.findViewById<ProgressBar>(R.id.progress_bar)
        val errorText = itemView.findViewById<TextView>(R.id.error_msg)
        val retryButton = itemView.findViewById<Button>(R.id.retry_button)

        fun bind(loadState: LoadState) {
            progressBar.isVisible = loadState is LoadState.Loading
            retryButton.isVisible = loadState is LoadState.Error
            errorText.isVisible = loadState is LoadState.Error
        }
    }
}