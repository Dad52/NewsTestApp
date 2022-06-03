package com.ands.newstestapp.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
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
            binding.reloadNews.isRefreshing = false
            articlesAdapter.submitList(it)
        }

        binding.reloadNews.setOnRefreshListener { newsViewModel.loadNews() }

    }



}