package com.frozenorb.uklon.test.data.posts.api

import com.frozenorb.uklon.test.data.posts.entity.ApiComment
import com.frozenorb.uklon.test.data.posts.entity.ApiPost
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PostsService {

    @GET("posts")
    fun getPosts(): Single<Response<List<ApiPost>>>

    @GET("posts/{postId}/comments")
    fun getComments(@Path("postId") postId: Long): Single<Response<List<ApiComment>>>
}