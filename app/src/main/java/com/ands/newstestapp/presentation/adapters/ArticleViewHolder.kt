package com.ands.newstestapp.presentation.adapters


import android.widget.TextView
import androidx.viewbinding.ViewBinding
import com.ands.newstestapp.common.ImageSource
import com.ands.newstestapp.data.models.ArticleUi
import com.ands.newstestapp.databinding.ArticlesItemWithImageBinding
import com.ands.newstestapp.databinding.ArticlesItemWithoutImageBinding

/**
 * Created by Dad52(Sobolev) on 6/2/2022.
 */
sealed class ArticleViewHolder(binding: ViewBinding) : BaseViewHolder(binding) {

    class ArticleWithoutImageViewHolder(private val binding: ArticlesItemWithoutImageBinding) :
        BaseViewHolder(binding) {

        override fun description(): TextView = binding.description

        override fun headline(): TextView = binding.headline

        override fun author(): TextView = binding.author

        override fun timeDate(): TextView = binding.timeDate
    }

    class ArticleWithImageViewHolder(private val binding: ArticlesItemWithImageBinding) :
        BaseViewHolder(binding) {

        override fun bind(articleUi: ArticleUi) {
            super.bind(articleUi)
                ImageSource.NetImageSource(
                    url = articleUi.urlToImage,
                    radiusRoundedCorner = 12f
                ).show(binding.image)

        }

        override fun description(): TextView = binding.description

        override fun headline(): TextView = binding.headline

        override fun author(): TextView = binding.author

        override fun timeDate(): TextView = binding.timeDate
    }

}
