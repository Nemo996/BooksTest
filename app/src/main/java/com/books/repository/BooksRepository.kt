package com.books.repository

import com.books.data.ApiInterface
import com.books.repository.mapper.BooksMapper
import com.books.repository.model.Books
import io.reactivex.rxjava3.core.Single

internal class BooksRepository(
    private val api: ApiInterface,
    private val mapper: BooksMapper
) {

    fun fetchBooks(): Single<Books> {
        return api.fetchData().map(mapper::map)
    }
}