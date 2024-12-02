package com.books.ui

fun List<String>.toAuthorsNames(): String {
    val authors = StringBuilder()
    this.forEachIndexed() { listIndex, name ->
        if (listIndex != this.size - 1) {
            authors.append("$name, ")
        } else {
            authors.append(name)
        }
    }
    return authors.toString()
}

fun Int.getCoverUrl(): String = "https://covers.openlibrary.org/a/id/$this-M.jpg"