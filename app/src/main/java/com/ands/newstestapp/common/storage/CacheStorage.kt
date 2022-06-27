package com.ands.newstestapp.common.storage

import com.ands.newstestapp.domain.models.ArticleUi

/**
 * Created by Dad52(Sobolev) on 6/10/2022.
 */
interface CacheStorage {

    fun saveListArticles(list: List<ArticleUi>)

    fun getListArticles(): List<ArticleUi>?

}