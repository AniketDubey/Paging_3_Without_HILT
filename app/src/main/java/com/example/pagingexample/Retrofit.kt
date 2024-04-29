package com.example.pagingexample

import com.example.pagingexample.QuotesApi.QuoteAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://quotable.io/"

    val RetrofitInstance: QuoteAPI by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(QuoteAPI::class.java)
    }
}