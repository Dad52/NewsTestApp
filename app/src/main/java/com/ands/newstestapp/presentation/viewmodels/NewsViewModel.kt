package com.ands.newstestapp.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ands.newstestapp.common.ArticlesMapper
import com.ands.newstestapp.common.Resource
import com.ands.newstestapp.data.models.ArticleUi
import com.ands.newstestapp.data.models.NewsDTO
import com.ands.newstestapp.domain.usecases.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Dad52(Sobolev) on 6/2/2022.
 */
@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase,
    private val myApplication: Application,
) : AndroidViewModel(myApplication) {

    private val _articlesList = MutableLiveData<List<ArticleUi>>()
    val articlesList: LiveData<List<ArticleUi>> = _articlesList

    private val _status = MutableLiveData<Resource<NewsDTO>>()
    val status: LiveData<Resource<NewsDTO>> = _status

    init {
        loadNews()
    }

    fun loadNews() = viewModelScope.launch {

        _status.value = Resource.Loading()

        val news = getNewsUseCase.getNews()

        _status.value = news

        if (news is Resource.Success) {
            val articlesUi =
                ArticlesMapper(myApplication.applicationContext).map(news.data!!.articles)
            _articlesList.postValue(articlesUi)
        }
    }
}