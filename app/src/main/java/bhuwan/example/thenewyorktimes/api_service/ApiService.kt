package bhuwan.example.thenewyorktimes.api_service

import bhuwan.TopStoriesModel
import bhuwan.example.thenewyorktimes.constants.UrlConst
import bhuwan.example.thenewyorktimes.models.ArticlesModel
import retrofit2.http.GET

interface ApiService {
    @GET(UrlConst.ARTICLES_URL)
    suspend fun getArticles(): ArticlesModel

    @GET(UrlConst.TOP_STORIES_URL)
    suspend fun getTopStories(): TopStoriesModel

}