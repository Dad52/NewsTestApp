package com.ands.newstestapp.data.db

import androidx.room.Insert
import androidx.room.Query
import com.ands.newstestapp.data.models.ArticleUi

/**
 * Created by Dad52(Sobolev) on 6/24/2022.
 */
interface Dao {

    @Insert
    suspend fun writeArticlesToCache(list: List<ArticleUi>)

    @Query("SELECT * FROM articles")
    suspend fun getArticlesFromCache(): List<ArticleUi>

    @Query("DELETE FROM articles")
    suspend fun deleteAllArticles()
}