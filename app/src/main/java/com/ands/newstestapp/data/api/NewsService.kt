package com.ands.newstestapp.data.api

import com.ands.newstestapp.common.Categories
import com.ands.newstestapp.data.models.NewsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Dad52(Sobolev) on 6/2/2022.
 */
interface NewsService {

    @GET("top-headlines?country=us")
    suspend fun getNews(@Query("category") categories: Categories): Response<NewsDTO>

}