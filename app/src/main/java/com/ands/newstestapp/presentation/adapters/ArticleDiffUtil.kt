package com.ands.newstestapp.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.ands.newstestapp.data.models.Article

/**
 * Created by Dad52(Sobolev) on 6/3/2022.
 */
class ArticleDiffUtil : DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }
}