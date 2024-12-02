package com.books.repository.model

import java.util.Date

data class ReadingLogEntry(
    val loggedDate: Date?,
    val loggedEdition: String?,
    val work: Work
)