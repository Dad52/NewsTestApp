package com.ands.newstestapp.presentation.newsdetail

import android.content.Context
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ands.newstestapp.common.ImageSource
import com.ands.newstestapp.common.Mapper
import com.ands.newstestapp.databinding.FragmentNewsDetailBinding
import com.ands.newstestapp.domain.models.ArticleUi
import com.ands.newstestapp.presentation.BaseFragment
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailFragment : BaseFragment<FragmentNewsDetailBinding>() {

    private val imageSource = ImageSource.NetImageSource(radiusRoundedCorner = 12f)

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentNewsDetailBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fillData()
    }

    private fun fillData() = with(binding) {

        val args = requireArguments().getParcelable<ArticleUi>(ARTICLE_UI)
            ?: ArticleUi("", "", "", "", "", "")

        headline.text = args.title
        description.text = args.content
        timeDate.text = args.publishedAt
        author.text = args.author
        imageSource.show(args.urlToImage, image)

    }

    companion object {
        const val ARTICLE_UI = "article_ui"
    }
}