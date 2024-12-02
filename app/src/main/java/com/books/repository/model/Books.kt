package com.books.repository.model

data class Books(
    val numFound: Int,
    val page: Int,
    val readingLogEntries: List<ReadingLogEntry>
)