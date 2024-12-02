package com.books.data.model

import com.google.gson.annotations.SerializedName

data class ReadingLogEntryResponse(
    @SerializedName("logged_date") val loggedDate: String,
    @SerializedName("logged_edition") val loggedEdition: String?,
    val work: WorkResponse
)