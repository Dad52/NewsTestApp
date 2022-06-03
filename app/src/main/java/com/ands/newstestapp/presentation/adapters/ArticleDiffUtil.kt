package com.ands.newstestapp.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.ands.newstestapp.data.models.ArticleUi

/**
 * Created by Dad52(Sobolev) on 6/3/2022.
 */
class ArticleDiffUtil : DiffUtil.ItemCallback<ArticleUi>() {
    override fun areItemsTheSame(oldItem: ArticleUi, newItem: ArticleUi): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: ArticleUi, newItem: ArticleUi): Boolean {
        return oldItem == newItem
    }
}