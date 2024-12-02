package com.books.data.model

import com.google.gson.annotations.SerializedName

data class WorkResponse(
    @SerializedName("author_keys") val authorKeys: List<String>,
    @SerializedName("author_names") val authorNames: List<String>,
    @SerializedName("cover_edition_key") val coverEditionKey: String?,
    @SerializedName("cover_id") val coverId: Int,
    @SerializedName("edition_key") val editionKey: List<String>,
    @SerializedName("first_publish_year") val firstPublishYear: Int,
    val key: String,
    @SerializedName("lending_edition_s") val lendingEditionS: String?,
    val title: String
)