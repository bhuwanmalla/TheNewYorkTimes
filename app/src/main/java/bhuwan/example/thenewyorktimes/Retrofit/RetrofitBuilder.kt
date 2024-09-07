package bhuwan.example.thenewyorktimes.Retrofit

import bhuwan.example.thenewyorktimes.api_service.ApiService
import bhuwan.example.thenewyorktimes.constants.UrlConst
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(UrlConst.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

}