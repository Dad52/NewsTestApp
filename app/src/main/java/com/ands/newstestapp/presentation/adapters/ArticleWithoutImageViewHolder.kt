package com.ands.newstestapp.presentation.adapters

import android.widget.TextView
import com.ands.newstestapp.databinding.ArticlesItemWithoutImageBinding

/**
 * Created by Dad52(Sobolev) on 6/2/2022.
 */
class ArticleWithoutImageViewHolder(
    private val binding: ArticlesItemWithoutImageBinding,
) : BaseViewHolder(binding) {

    override fun description(): TextView = binding.description
    override fun headline(): TextView = binding.headline
    override fun author(): TextView = binding.author
    override fun timeDate(): TextView = binding.timeDate
}




