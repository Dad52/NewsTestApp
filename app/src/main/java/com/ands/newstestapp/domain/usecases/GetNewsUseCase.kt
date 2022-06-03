package com.ands.newstestapp.domain.usecases

import com.ands.newstestapp.data.models.NewsDTO
import com.ands.newstestapp.domain.NewsRepository
import retrofit2.Response

/**
 * Created by Dad52(Sobolev) on 6/2/2022.
 */
class GetNewsUseCase(private val repository: NewsRepository) {

    suspend fun getNews(): Response<NewsDTO> {
        return repository.getNews()
    }

}