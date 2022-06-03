package com.ands.newstestapp.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ands.newstestapp.data.models.Article
import com.ands.newstestapp.domain.usecases.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Dad52(Sobolev) on 6/2/2022.
 */
@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase
) : ViewModel() {

    private val _articlesList = MutableLiveData<List<Article>>()
    val articlesList: LiveData<List<Article>> = _articlesList

    init {
        loadNews()
    }

    fun loadNews() {
        viewModelScope.launch {
            try {
                getNewsUseCase.getNews().let { response ->
                    if (response.isSuccessful) {
                        _articlesList.postValue(response.body()?.articles)
                    } else {
                        Log.e("NewsViewModel", "Error during request ${response.errorBody()}")
                    }
                }
            } catch (e: Exception) {
                Log.e("NewsViewModel", "Exception during request ${e.localizedMessage}")
            }
        }
    }


}