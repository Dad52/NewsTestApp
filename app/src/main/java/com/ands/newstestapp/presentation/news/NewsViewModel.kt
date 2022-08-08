package com.ands.newstestapp.presentation.news

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ands.newstestapp.common.ArticlesMapper
import com.ands.newstestapp.common.Categories
import com.ands.newstestapp.common.Mapper
import com.ands.newstestapp.common.Resource
import com.ands.newstestapp.data.models.NewsDTO
import com.ands.newstestapp.domain.models.ArticleUi
import com.ands.newstestapp.domain.usecases.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Dad52(Sobolev) on 6/2/2022.
 */
@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase,
    private val myApplication: Application,
    private val dispatchersIO: CoroutineDispatcher = Dispatchers.IO
) : AndroidViewModel(myApplication) {

    private val _articlesList = MutableLiveData<List<ArticleUi>>()
    val articlesList: LiveData<List<ArticleUi>> = _articlesList

    private val _status = MutableLiveData<Resource<NewsDTO>>()
    val status: LiveData<Resource<NewsDTO>> = _status

    private var currentCategory = Categories.general

    init {
        loadNews()
    }

    fun changeCategory(newCategory: Categories) {
        currentCategory = newCategory
        loadNews()
    }

    fun loadNews() = viewModelScope.launch(dispatchersIO) {

        _status.value = Resource.Loading()

        val news = getNewsUseCase.getNews(currentCategory)

        _status.value = news

        if (news is Resource.Success) {
            val appContext = myApplication.applicationContext
            val articlesUi =
                ArticlesMapper(appContext, Mapper.DateTimeMapper(context = appContext)).map(news.data!!.articles)
            _articlesList.postValue(articlesUi)
        }
    }
}

//abstract class BaseViewModel : ViewModel() {
//
//    private val _failure: MutableLiveData<Failure> = MutableLiveData()
//    val failure: LiveData<Failure> = _failure
//
//    protected fun handleFailure(failure: Failure) {
//        _failure.value = failure
//    }
//}
// todo https://russianblogs.com/article/59082410816/
// todo https://github.com/android10/Android-CleanArchitecture-Kotlin/blob/main/app/src/main/kotlin/com/fernandocejas/sample/core/platform/BaseViewModel.kt