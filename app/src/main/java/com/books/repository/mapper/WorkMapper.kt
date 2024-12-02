package com.books.repository.mapper

import com.books.data.model.WorkResponse
import com.books.repository.model.Work

internal class WorkMapper {
    fun map(data: WorkResponse): Work {
        return Work(
            authorKeys = data.authorKeys,
            authorNames = data.authorNames,
            coverEditionKey = data.coverEditionKey,
            coverId = data.coverId,
            editionKey = data.editionKey,
            firstPublishYear = data.firstPublishYear,
            key = data.key,
            lendingEditionS = data.lendingEditionS,
            title = data.title
        )
    }
}