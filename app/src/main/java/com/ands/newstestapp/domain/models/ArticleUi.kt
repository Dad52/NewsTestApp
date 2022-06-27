package com.ands.newstestapp.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by Dad52(Sobolev) on 6/3/2022.
 */
@Parcelize
data class ArticleUi(
    val author: String,
    val title: String,
    val description: String,
    val urlToImage: String,
    val publishedAt: String,
) : Parcelable {
    companion object {
        const val EMPTY_URL = ""
    }
}