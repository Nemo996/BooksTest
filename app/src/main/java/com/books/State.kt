package com.books

import com.books.repository.model.Books
import com.books.repository.model.Work

internal sealed interface State {
    data object Loading : State
    data class Data(val books: Books, val details: Work? = null) : State
    data object Error : State
}