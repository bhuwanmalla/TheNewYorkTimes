package bhuwan.example.thenewyorktimes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bhuwan.example.thenewyorktimes.models.ArticlesModel
import bhuwan.example.thenewyorktimes.repository.NewYorkTimesRepository
import kotlinx.coroutines.launch

class ArticlesViewModel : ViewModel() {

    private val repository = NewYorkTimesRepository()

    private val _articles = MutableLiveData<ArticlesModel>()
    val articles: LiveData<ArticlesModel>
        get() = _articles

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading


    init {
        fetchedData()
    }

    fun fetchedData() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val fetchedArticles = repository.fetchArticles()
                _articles.value = fetchedArticles

            } catch (e: Exception) {
                e.message
            } finally {
                _isLoading.value = false
            }
        }
    }
}