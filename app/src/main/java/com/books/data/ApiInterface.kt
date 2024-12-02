package com.books.data

import com.books.data.model.BooksResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

internal interface ApiInterface {

    @GET("people/mekBot/books/want-to-read.json")
    fun fetchData(): Single<BooksResponse>
}