package com.books.di

import com.books.MainActivityViewModel
import com.books.data.ApiInterface
import com.books.repository.BooksRepository
import com.books.repository.mapper.BooksMapper
import com.books.usecase.FetchBooksUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal class MainActivityViewModelModule {

    @Provides
    fun provideBooksRepository(api:ApiInterface,mapper: BooksMapper):BooksRepository{
        return BooksRepository(
            api = api,
            mapper = mapper
        )
    }

    @Provides
    fun provideUseCase(repository: BooksRepository):FetchBooksUseCase{
        return FetchBooksUseCase(repository = repository)
    }
}