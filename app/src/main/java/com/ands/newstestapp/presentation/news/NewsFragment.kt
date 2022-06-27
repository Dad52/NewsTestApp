package com.ands.newstestapp.presentation.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.ands.newstestapp.R
import com.ands.newstestapp.common.Categories
import com.ands.newstestapp.common.Resource
import com.ands.newstestapp.databinding.FragmentNewsBinding
import com.ands.newstestapp.presentation.BaseFragment
import com.ands.newstestapp.presentation.news.adapter.ArticlesAdapter
import com.ands.newstestapp.presentation.newsdetail.NewsDetailFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : BaseFragment<FragmentNewsBinding>() {

    private val newsViewModel: NewsViewModel by viewModels()
    private val articlesAdapter = ArticlesAdapter()

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentNewsBinding.inflate(layoutInflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupObservers()
        setupChipsListeners()

        binding.general.isChecked = true//todo найти другой способ
    }

    private fun setupRecyclerView() = with(binding) {
        newsList.apply {
            adapter = articlesAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        newsViewModel.articlesList.observe(viewLifecycleOwner) {
            articlesAdapter.submitList(it)
        }
        articlesAdapter.onClickNewsItem = {
            val bundle = Bundle().apply {
                putParcelable(NewsDetailFragment.ARTICLE_UI, it)
            }
            Navigation.findNavController(binding.root)
                .navigate(R.id.action_newsFragment_to_newsDetailFragment, bundle)
        }

        reloadNews.setOnRefreshListener { newsViewModel.loadNews() }
    }

    private fun setupObservers() = with(binding) {

        newsViewModel.status.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {
                    reloadNews.isRefreshing = false
                    internetConnectionStatus.isVisible = false
                }
                is Resource.Error -> {
                    internetConnectionStatus.isVisible = true
                    internetConnectionStatus.text = it.message
                }
                is Resource.Loading -> {
                    internetConnectionStatus.isVisible = true
                    internetConnectionStatus.text = it.message
                    reloadNews.isRefreshing = false
                }
            }//TODO сделать анимацию загрузки
            newsList.smoothScrollToPosition(0)
        }
    }

    private fun setupChipsListeners() = with(binding) {
        business.setOnClickListener() { newsViewModel.changeCategory(Categories.business) }
        sports.setOnClickListener() { newsViewModel.changeCategory(Categories.sports) }
        general.setOnClickListener() { newsViewModel.changeCategory(Categories.general) }
        technology.setOnClickListener() { newsViewModel.changeCategory(Categories.technology) }
        science.setOnClickListener() { newsViewModel.changeCategory(Categories.science) }
        health.setOnClickListener() { newsViewModel.changeCategory(Categories.health) }
        entertainment.setOnClickListener() { newsViewModel.changeCategory(Categories.entertainment) }
    }//TODO перекинуть это все в адаптер


}