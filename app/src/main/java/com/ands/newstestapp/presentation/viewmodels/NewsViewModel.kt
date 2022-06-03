package com.ands.newstestapp.presentation.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ands.newstestapp.common.ArticlesMapper
import com.ands.newstestapp.data.models.ArticleUi
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
    private val myApplication: Application
) : AndroidViewModel(myApplication) {

    private val _articlesList = MutableLiveData<List<ArticleUi>>()
    val articlesList: LiveData<List<ArticleUi>> = _articlesList

    init {
        loadNews()
    }

    fun loadNews() = viewModelScope.launch {
        try {
            getNewsUseCase.getNews().let { response ->
                if (response.isSuccessful) {
                    _articlesList.postValue(
                        ArticlesMapper(myApplication).map(response.body()!!.articles)
                    )
                } else {
                    Log.e("NewsViewModel", "Error during request ${response.errorBody()}")
                }
            }
        } catch (e: Exception) {
            Log.e("NewsViewModel", "Exception during request ${e.localizedMessage}")
        }
    }


}