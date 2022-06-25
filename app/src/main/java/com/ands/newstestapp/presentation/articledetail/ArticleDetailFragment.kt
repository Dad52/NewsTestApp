package com.ands.newstestapp.presentation.articledetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ands.newstestapp.databinding.FragmentArticleDetailBinding
import com.ands.newstestapp.presentation.BaseFragment


class ArticleDetailFragment : BaseFragment<FragmentArticleDetailBinding>() {

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentArticleDetailBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}