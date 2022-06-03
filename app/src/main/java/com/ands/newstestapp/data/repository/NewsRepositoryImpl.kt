package com.ands.newstestapp.data.repository

import com.ands.newstestapp.data.api.NewsService
import com.ands.newstestapp.data.models.NewsDTO
import com.ands.newstestapp.domain.NewsRepository
import retrofit2.Response

/**
 * Created by Dad52(Sobolev) on 6/2/2022.
 */
class NewsRepositoryImpl(private val newsService: NewsService) : NewsRepository {
    override suspend fun getNews(): Response<NewsDTO> {
        return newsService.getNews()
    }
}