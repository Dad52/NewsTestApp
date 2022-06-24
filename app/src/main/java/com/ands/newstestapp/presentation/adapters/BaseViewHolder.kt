package com.ands.newstestapp.presentation.adapters

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.ands.newstestapp.common.ItemBind
import com.ands.newstestapp.common.Mapper
import com.ands.newstestapp.data.models.ArticleUi

/**
 * Created by Dad52(Sobolev) on 6/3/2022.
 */

abstract class BaseViewHolder(
    binding: ViewBinding,
) : RecyclerView.ViewHolder(binding.root), ItemBind {

    private val dateTimeMapper = Mapper.DateTimeMapper(context = binding.root.context)

    override fun bind(articleUi: ArticleUi) {

        description().text = articleUi.description

        author().text = articleUi.author

        headline().text = articleUi.title
        timeDate().text = dateTimeMapper.map(articleUi.publishedAt)
    }

    abstract fun description(): TextView
    abstract fun headline(): TextView
    abstract fun author(): TextView
    abstract fun timeDate(): TextView
}
