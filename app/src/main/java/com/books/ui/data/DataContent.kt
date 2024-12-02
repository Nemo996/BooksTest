package com.books.ui.data

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.books.repository.model.Work
import com.books.ui.toAuthorsNames

@Composable
fun DataContent(onItemClicked: (Work) -> Unit, list: List<Work>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(list.size) { index ->
            val item = list[index]
            BookItem(
                onClick = onItemClicked,
                book = item
            )
        }
    }
}