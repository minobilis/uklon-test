package com.frozenorb.uklon.test.data.posts.api

import com.frozenorb.uklon.test.data.posts.entity.ApiPost
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET

interface PostsService {

    @GET("posts")
    fun getPosts(): Single<Response<List<ApiPost>>>
}