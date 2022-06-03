package com.ands.newstestapp.data.models

/**
 * Created by Dad52(Sobolev) on 6/3/2022.
 */
data class ArticleUi(
    val author: String,
    val title: String,
    val description: String,
    val urlToImage: String,
    val publishedAt: String,
) {
    companion object {
        const val EMPTY_URL = ""
    }
}