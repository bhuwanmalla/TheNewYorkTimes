package bhuwan.example.thenewyorktimes.repository

import bhuwan.TopStoriesModel
import bhuwan.example.thenewyorktimes.Retrofit.RetrofitBuilder
import bhuwan.example.thenewyorktimes.models.ArticlesModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewYorkTimesRepository {

    private val apiService = RetrofitBuilder.api

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