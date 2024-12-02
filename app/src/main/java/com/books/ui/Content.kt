package com.books.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.books.MainActivityViewModel
import com.books.State
import com.books.repository.model.Work
import com.books.ui.data.DataContent
import com.books.ui.data.DetailsContent
import com.books.ui.error.ErrorContent
import com.books.ui.loading.LoadingContent

@Composable
internal fun Content(viewModel: MainActivityViewModel = hiltViewModel()) {
    val state: State by viewModel.state.collectAsStateWithLifecycle()
    Content(
        onRetryClick = viewModel::onRetryError,
        hideBottomSheet = viewModel::hideBottomSheet,
        onItemClicked = viewModel::showBottomSheet,
        state = state
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun Content(
    onRetryClick: () -> Unit,
    onItemClicked: (Work) -> Unit,
    hideBottomSheet: () -> Unit,
    state: State
) {
    val bottomSheetState = rememberModalBottomSheetState()
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (state) {
                is State.Data -> {
                    DataContent(
                        onItemClicked = onItemClicked,
                        state.books.readingLogEntries.map { log -> log.work })
                    if (state.details != null) {
                        DetailsContent(
                            onDismissRequest = hideBottomSheet,
                            bottomSheetState = bottomSheetState,
                            bookDetails = state.details
                        )
                    }
                }

                State.Error -> ErrorContent(onRetryClick = onRetryClick)
                State.Loading -> LoadingContent()
            }
        }
    }
}