package com.books.repository.mapper

import com.books.data.model.ReadingLogEntryResponse
import com.books.repository.model.ReadingLogEntry
import com.books.repository.utils.toLoggingDate

internal class ReadingLogEntryMapper(private val workMapper: WorkMapper) {
    fun map(data:ReadingLogEntryResponse):ReadingLogEntry{
        return ReadingLogEntry(
            loggedDate = data.loggedDate.toLoggingDate(),
            loggedEdition = data.loggedEdition,
            work = workMapper.map(data.work)
        )
    }
}