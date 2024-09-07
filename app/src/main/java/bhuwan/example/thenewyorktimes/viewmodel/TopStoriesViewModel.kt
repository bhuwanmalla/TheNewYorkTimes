package bhuwan.example.thenewyorktimes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bhuwan.TopStoriesModel
import bhuwan.example.thenewyorktimes.repository.NewYorkTimesRepository
import kotlinx.coroutines.launch

class TopStoriesViewModel : ViewModel() {

    private val repository = NewYorkTimesRepository()

    private val _topStories = MutableLiveData<TopStoriesModel>()
    val topStories: LiveData<TopStoriesModel>
        get() = _topStories

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading


    init {
        fetchStories()
    }

    fun fetchStories() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val fetchedStories = repository.fetchTopStories()
                _topStories.value = fetchedStories
            } catch (e: Exception) {
                e.message
            } finally {
                _isLoading.value = false
            }
        }
    }

}