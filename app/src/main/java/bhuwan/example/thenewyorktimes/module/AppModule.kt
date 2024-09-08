package bhuwan.example.thenewyorktimes.module

import bhuwan.example.thenewyorktimes.api_service.ApiService
import bhuwan.example.thenewyorktimes.constants.UrlConst
import bhuwan.example.thenewyorktimes.repository.NewYorkTimesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(UrlConst.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideNewYorkTimesRepository(apiService: ApiService): NewYorkTimesRepository {
        return NewYorkTimesRepository(apiService)
    }


}