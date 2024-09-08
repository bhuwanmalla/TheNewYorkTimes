package bhuwan.example.thenewyorktimes.repository

import bhuwan.TopStoriesModel
import bhuwan.example.thenewyorktimes.api_service.ApiService
import bhuwan.example.thenewyorktimes.models.ArticlesModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewYorkTimesRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun fetchArticles(): ArticlesModel {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getArticles()
                response
            } catch (e: Exception) {
                ArticlesModel()
            }
        }
    }

    suspend fun fetchTopStories(): TopStoriesModel {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getTopStories()
                response
            } catch (e: Exception) {
                TopStoriesModel()
            }
        }
    }


}