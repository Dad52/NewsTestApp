package com.ands.newstestapp.di

import android.content.Context
import com.ands.newstestapp.domain.NewsRepository
import com.ands.newstestapp.domain.usecases.GetNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

/**
 * Created by Dad52(Sobolev) on 6/2/2022.
 */
@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetNewsUseCase(
        newsRepository: NewsRepository,
    ): GetNewsUseCase {
        return GetNewsUseCase(repository = newsRepository)
    }

}