package com.ands.newstestapp.data.models

/**
 * Created by Dad52(Sobolev) on 6/2/2022.
 */
data class NewsDTO(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>,
)


