package com.ands.newstestapp.data.models

/**
 * Created by Dad52(Sobolev) on 6/3/2022.
 */
data class Article(
    val source: Source,
    val author: String? = null,
    val title: String,
    val description: String? = null,
    val url: String,
    val urlToImage: String? = null,
    val publishedAt: String,
    val content: String,
)