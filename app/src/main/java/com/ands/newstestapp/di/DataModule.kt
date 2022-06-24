package com.ands.newstestapp.di

import android.content.Context
import com.ands.newstestapp.data.api.NewsService
import com.ands.newstestapp.data.repository.NewsRepositoryImpl
import com.ands.newstestapp.domain.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Dad52(Sobolev) on 6/2/2022.
 */
@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideNewsRepository(newsService: NewsService): NewsRepository {
        return NewsRepositoryImpl(newsService = newsService)
    }

    @Provides
    @Singleton
    fun provideNewsApiService(): NewsService {
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsService::class.java)
    }

}