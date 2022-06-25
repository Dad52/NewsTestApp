package com.ands.newstestapp.presentation.adapters

import android.widget.TextView
import com.ands.newstestapp.common.ImageSource
import com.ands.newstestapp.data.models.ArticleUi
import com.ands.newstestapp.databinding.ArticlesItemWithImageBinding

/**
 * Created by Dad52(Sobolev) on 6/4/2022.
 */
class ArticleWithImageViewHolder(
    private val binding: ArticlesItemWithImageBinding,
) : BaseViewHolder(binding) {

    override fun bind(articleUi: ArticleUi) {
        super.bind(articleUi)
        ImageSource.NetImageSource(
            radiusRoundedCorner = 12f
        ).show(articleUi.urlToImage, binding.image)

    }

    override fun description(): TextView = binding.description
    override fun headline(): TextView = binding.headline
    override fun author(): TextView = binding.author
    override fun timeDate(): TextView = binding.timeDate
}