package com.ands.newstestapp.domain.usecases

import android.content.Context
import android.util.Log
import com.ands.newstestapp.common.ArticlesMapper
import com.ands.newstestapp.common.Resource
import com.ands.newstestapp.data.models.ArticleUi
import com.ands.newstestapp.data.models.NewsDTO
import com.ands.newstestapp.domain.NewsRepository
import retrofit2.Response

/**
 * Created by Dad52(Sobolev) on 6/2/2022.
 */
class GetNewsUseCase(private val repository: NewsRepository) {

//    suspend fun getNews(): Response<NewsDTO> {
//        return repository.getNews()
//    }

    suspend fun getNews() : Resource<NewsDTO> {
        return repository.getNews()
    }

//    suspend fun getNewsSmart(): List<ArticleUi> {
//        try {
//            repository.getNews().let { response ->
//                if (response.isSuccessful) {
//                    return ArticlesMapper(context).map(response.body()!!.articles)
//                } else {
//                    Log.e("NewsViewModel", "Error during request ${response.errorBody()}")
//                }
//            }
//        } catch (e: Exception) {
//            Log.e("NewsViewModel", "Exception during request ${e.localizedMessage}")
//        }
//        return listOf() //todo empty list like Response.Empty
//    }

}