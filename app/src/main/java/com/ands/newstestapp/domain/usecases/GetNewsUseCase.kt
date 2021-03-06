package com.ands.newstestapp.domain.usecases

import com.ands.newstestapp.common.Categories
import com.ands.newstestapp.common.Resource
import com.ands.newstestapp.data.models.NewsDTO
import com.ands.newstestapp.domain.NewsRepository

/**
 * Created by Dad52(Sobolev) on 6/2/2022.
 */
class GetNewsUseCase(private val repository: NewsRepository) {

    suspend fun getNews(category: Categories): Resource<NewsDTO> {
        return repository.getNews(category)
    }
}