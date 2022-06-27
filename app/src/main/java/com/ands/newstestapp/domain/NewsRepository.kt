package com.ands.newstestapp.domain

import com.ands.newstestapp.common.Categories
import com.ands.newstestapp.common.Resource
import com.ands.newstestapp.data.models.NewsDTO

/**
 * Created by Dad52(Sobolev) on 6/2/2022.
 */
interface NewsRepository {

    suspend fun getNews(category: Categories): Resource<NewsDTO>

}