package com.books

import androidx.lifecycle.ViewModel
import com.books.repository.model.Work
import com.books.usecase.FetchBooksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
internal class MainActivityViewModel @Inject constructor(private val useCase: FetchBooksUseCase) :
    ViewModel() {
    private val _state = MutableStateFlow<State>(State.Loading)
    private val compositeDisposable = CompositeDisposable()
    val state: StateFlow<State> = _state

    init {
        fetch()
    }

    fun onRetryError() {
        fetch()
    }

    fun showBottomSheet(details:Work) {
        val state = state.value
        if (state is State.Data && state.details == null) {
            _state.value = state.copy(details = details)
        }
    }

    fun hideBottomSheet() {
        val state = state.value
        if (state is State.Data && state.details != null ) {
            _state.value = state.copy(details = null)
        }
    }

    private fun fetch() {
        if (state.value !is State.Loading) {
            _state.value = State.Loading
        }
        compositeDisposable.add(useCase.fetch()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ data ->
                _state.value = State.Data(data)
            }, { error ->
                _state.value = State.Error
                error.printStackTrace()
            })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}