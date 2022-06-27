package com.ands.newstestapp.presentation.news.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.ands.newstestapp.databinding.ArticlesItemWithImageBinding
import com.ands.newstestapp.databinding.ArticlesItemWithoutImageBinding
import com.ands.newstestapp.domain.models.ArticleUi


/**
 * Created by Dad52(Sobolev) on 6/2/2022.
 */
class ArticlesAdapter : ListAdapter<ArticleUi, BaseViewHolder>(ArticleDiffUtil()) {

    var onClickNewsItem: ((ArticleUi) -> Unit)? = null

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener() {
            onClickNewsItem?.invoke(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {

        when (viewType) {
            ARTICLE_WITHOUT_IMAGE -> return ArticleWithoutImageViewHolder(
                ArticlesItemWithoutImageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            ARTICLE_WITH_IMAGE -> return ArticleWithImageViewHolder(
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
            EMPTY_URL -> ARTICLE_WITHOUT_IMAGE
            else -> ARTICLE_WITH_IMAGE
        }
    }

    companion object {
        private const val ARTICLE_WITH_IMAGE = 1
        private const val ARTICLE_WITHOUT_IMAGE = 0
        private const val EMPTY_URL = ""
    }


}