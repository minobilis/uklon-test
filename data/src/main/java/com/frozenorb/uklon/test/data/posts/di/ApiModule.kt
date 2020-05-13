package com.frozenorb.uklon.test.data.posts.di;

import com.frozenorb.uklon.test.data.posts.api.PostsService
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

const val BASE_URL = "https://jsonplaceholder.typicode.com/"

@Module
class ApiModule {

    @Singleton
    @Provides
    fun provideRetrofit (): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

    @Singleton
    @Provides
    fun providePostsService (retrofit : Retrofit): PostsService =
        retrofit.create(PostsService::class.java)
}
