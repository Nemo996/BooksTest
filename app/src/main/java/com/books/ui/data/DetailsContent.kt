package com.books.ui.data

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.books.R
import com.books.repository.model.Work
import com.books.ui.getCoverUrl
import com.books.ui.toAuthorsNames

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsContent(onDismissRequest: () -> Unit, bottomSheetState: SheetState, bookDetails: Work) {
    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        sheetState = bottomSheetState
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
            AsyncImage(
                model = bookDetails.coverId.getCoverUrl(),
                contentDescription = "cover",
                error = painterResource(id = R.drawable.ic_launcher_foreground),
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
            )
            Text(
                text = stringResource(id = R.string.title, bookDetails.title),
                Modifier.fillMaxWidth().padding(top = 16.dp),
                maxLines = 1
            )
            Text(
                text = stringResource(
                    id = R.string.authors,
                    bookDetails.authorNames.toAuthorsNames()
                ),
                modifier = Modifier.fillMaxWidth(),
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = stringResource(
                    id = R.string.year,
                    bookDetails.firstPublishYear
                ),
                modifier = Modifier.fillMaxWidth(),
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}