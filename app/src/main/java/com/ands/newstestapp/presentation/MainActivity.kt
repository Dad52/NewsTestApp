package com.ands.newstestapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.ands.newstestapp.common.Resource
import com.ands.newstestapp.databinding.ActivityMainBinding
import com.ands.newstestapp.presentation.adapters.ArticlesAdapter
import com.ands.newstestapp.presentation.viewmodels.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val newsViewModel: NewsViewModel by viewModels()
    private val articlesAdapter = ArticlesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.newsList.apply {
            adapter = articlesAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        newsViewModel.articlesList.observe(this) {
            articlesAdapter.submitList(it)
        }

        newsViewModel.status.observe(this) {
            when(it) {
                is Resource.Success -> {
                    binding.reloadNews.isRefreshing = false
                    binding.internetConnectionStatus.isVisible = false
                }
                is Resource.Error -> {
                    binding.internetConnectionStatus.isVisible = true
                    binding.internetConnectionStatus.text = it.message
                }
                is Resource.Loading -> {
                    binding.internetConnectionStatus.isVisible = true
                    binding.internetConnectionStatus.text = it.message
                    binding.reloadNews.isRefreshing = false
                }
            }//TODO сделать анимацию загрузки
        }

        binding.reloadNews.setOnRefreshListener { newsViewModel.loadNews() }

    }

}