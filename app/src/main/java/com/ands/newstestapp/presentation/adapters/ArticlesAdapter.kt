package com.ands.newstestapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.ands.newstestapp.data.models.Article
import com.ands.newstestapp.databinding.ArticlesItemWithImageBinding
import com.ands.newstestapp.databinding.ArticlesItemWithoutImageBinding


/**
 * Created by Dad52(Sobolev) on 6/2/2022.
 */
class ArticlesAdapter : ListAdapter<Article, BaseViewHolder>(ArticleDiffUtil()) {

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (holder) {
            is ArticleViewHolder.ArticleWithImageViewHolder -> holder.bind(getItem(position))
            is ArticleViewHolder.ArticleWithoutImageViewHolder -> holder.bind(getItem(position))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {

        when (viewType) {
            ARTICLE_WITHOUT_IMAGE -> return ArticleViewHolder.ArticleWithoutImageViewHolder(
                ArticlesItemWithoutImageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            ARTICLE_WITH_IMAGE -> return ArticleViewHolder.ArticleWithImageViewHolder(
                ArticlesItemWithImageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> throw IllegalArgumentException("Article type is not found")
        }

    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).urlToImage) {
            is String -> ARTICLE_WITH_IMAGE
            else -> ARTICLE_WITHOUT_IMAGE
        }
    }

    companion object {
        const val ARTICLE_WITH_IMAGE = 1
        const val ARTICLE_WITHOUT_IMAGE = 0
    }


}