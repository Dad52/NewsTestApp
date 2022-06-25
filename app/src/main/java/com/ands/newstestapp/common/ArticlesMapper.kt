package com.ands.newstestapp.common

import android.content.Context
import com.ands.newstestapp.R
import com.ands.newstestapp.data.models.Article
import com.ands.newstestapp.data.models.ArticleUi
import com.ands.newstestapp.data.models.ArticleUi.Companion.EMPTY_URL

/**
 * Created by Dad52(Sobolev) on 6/3/2022.
 */
class ArticlesMapper(
    private val context: Context,
) : Mapper<List<Article>, List<ArticleUi>> {
    override fun map(source: List<Article>): List<ArticleUi> {
        return source.map { article ->
            ArticleUi(
                author = article.author ?: context.getString(R.string.with_no_author),
                title = article.title,
                description = article.description
                    ?: context.getString(R.string.with_no_description),
                urlToImage = article.urlToImage ?: EMPTY_URL,
                publishedAt = article.publishedAt
            )
        }
    }
}