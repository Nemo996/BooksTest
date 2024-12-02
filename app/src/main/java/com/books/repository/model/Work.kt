package com.books.repository.model

data class Work(
    val authorKeys: List<String>,
    val authorNames: List<String>,
    val coverEditionKey: String?,
    val coverId: Int,
    val editionKey: List<String>,
    val firstPublishYear: Int,
    val key: String,
    val lendingEditionS: String?,
    val title: String
)