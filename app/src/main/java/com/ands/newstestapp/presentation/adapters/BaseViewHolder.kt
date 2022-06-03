package com.ands.newstestapp.presentation.adapters

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.ands.newstestapp.R
import com.ands.newstestapp.common.DateTimeMapper
import com.ands.newstestapp.data.models.Article

/**
 * Created by Dad52(Sobolev) on 6/3/2022.
 */

abstract class BaseViewHolder(
    private val binding: ViewBinding
) : RecyclerView.ViewHolder(binding.root), ItemBind {

    override fun bind(article: Article) {

        description().text = if (article.description == null || article.description.isEmpty())
            itemView.context.getString(R.string.with_no_description)
        else
            article.description

        author().text = if (article.author == null || article.author.isEmpty())
            itemView.context.getString(R.string.with_no_author)
        else
            article.author

        headline().text = article.title
        timeDate().text = DateTimeMapper(context = binding.root.context).map(article.publishedAt)
    }

    abstract fun description(): TextView
    abstract fun headline(): TextView
    abstract fun author(): TextView
    abstract fun timeDate(): TextView
}

interface ItemBind {
    fun bind(article: Article)
}
