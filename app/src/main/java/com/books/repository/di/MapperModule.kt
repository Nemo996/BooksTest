package com.books.repository.di

import com.books.repository.mapper.BooksMapper
import com.books.repository.mapper.ReadingLogEntryMapper
import com.books.repository.mapper.WorkMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal class MapperModule {

    @Provides
    fun provideWorkMapper(): WorkMapper {
        return WorkMapper()
    }

    @Provides
    fun provideReadingLogEntryMapper(workMapper: WorkMapper): ReadingLogEntryMapper {
        return ReadingLogEntryMapper(workMapper)
    }

    @Provides
    fun provideBooksMapper(readingLogEntryMapper: ReadingLogEntryMapper): BooksMapper {
        return BooksMapper(readingLogEntryMapper)
    }
}