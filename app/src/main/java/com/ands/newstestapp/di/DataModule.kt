package com.ands.newstestapp.di

import com.ands.newstestapp.data.api.NewsService
import com.ands.newstestapp.data.repository.NewsRepositoryImpl
import com.ands.newstestapp.domain.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Dad52(Sobolev) on 6/2/2022.
 */
@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    class ApiKeyInterceptor(): Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val requestBuilder = chain.request().newBuilder()
            requestBuilder.addHeader("X-Api-Key", "9b251d4d28df4d1abc9051601165aba1")
            return chain.proceed(requestBuilder.build())
        }
    }

    @Provides
    @Singleton
    fun provideNewsRepository(newsService: NewsService): NewsRepository {
        return NewsRepositoryImpl(newsService = newsService)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(ApiKeyInterceptor())
        .build()

    @Provides
    @Singleton
    fun provideNewsApiService(okHttpClient: OkHttpClient): NewsService {
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsService::class.java)
    }

}