package com.ands.newstestapp.data.api

import com.ands.newstestapp.data.models.NewsDTO
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Dad52(Sobolev) on 6/2/2022.
 */
interface NewsService {

    @GET("top-headlines?country=us&category=business&apiKey=9b251d4d28df4d1abc9051601165aba1")
    suspend fun getNews(): Response<NewsDTO>

}