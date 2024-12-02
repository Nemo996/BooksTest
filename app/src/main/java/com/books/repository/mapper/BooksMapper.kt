package com.books.repository.mapper

import com.books.data.model.BooksResponse
import com.books.repository.model.Books

internal class BooksMapper(private val readingLogEntryMapper: ReadingLogEntryMapper) {
    fun map(data: BooksResponse):Books{
        return Books(
            numFound = data.numFound,
            page = data.page,
            readingLogEntries = data.readingLogEntries.map { readingLogEntry->
                readingLogEntryMapper.map(readingLogEntry)
            }
        )
    }
}