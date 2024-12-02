package com.books.data.model

import com.google.gson.annotations.SerializedName

data class BooksResponse(
    val numFound: Int,
    val page: Int,
    @SerializedName("reading_log_entries") val readingLogEntries: List<ReadingLogEntryResponse>
)