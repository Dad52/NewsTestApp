package com.ands.newstestapp.domain

import com.ands.newstestapp.data.models.NewsDTO
import retrofit2.Response

/**
 * Created by Dad52(Sobolev) on 6/2/2022.
 */
interface NewsRepository {

    suspend fun getNews(): Response<NewsDTO>

}