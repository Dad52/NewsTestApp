package com.ands.newstestapp.data.repository

import com.ands.newstestapp.common.Resource
import com.ands.newstestapp.data.api.NewsService
import com.ands.newstestapp.data.models.NewsDTO
import com.ands.newstestapp.domain.NewsRepository

/**
 * Created by Dad52(Sobolev) on 6/2/2022.
 */
class NewsRepositoryImpl(private val newsService: NewsService) : BaseRepository(), NewsRepository {

    override suspend fun getNews(): Resource<NewsDTO> {
        return safeApiCall { newsService.getNews() }
    }

}