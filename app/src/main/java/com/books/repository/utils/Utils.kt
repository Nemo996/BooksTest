package com.books.repository.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.Date

private const val LOGGING_DATE_FORMAT = "yyyy/MM/dd, hh:mm:ss"

@SuppressLint("SimpleDateFormat")
fun String.toLoggingDate(): Date? = SimpleDateFormat(LOGGING_DATE_FORMAT).parse(this)