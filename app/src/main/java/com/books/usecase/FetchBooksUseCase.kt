package com.books.usecase

import com.books.repository.BooksRepository
import com.books.repository.model.Books
import io.reactivex.rxjava3.core.Single

internal class FetchBooksUseCase(private val repository: BooksRepository) {

    fun fetch():Single<Books>{
        return repository.fetchBooks()
    }
}