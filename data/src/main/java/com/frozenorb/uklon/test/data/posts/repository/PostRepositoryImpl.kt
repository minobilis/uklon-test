package com.frozenorb.uklon.test.data.posts.repository

import com.frozenorb.uklon.test.data.posts.api.PostsService
import com.frozenorb.uklon.test.data.posts.api.mapper.ApiDomainPostMapper
import com.frozenorb.uklon.test.domain.post.entity.Post
import com.frozenorb.uklon.test.domain.post.gateway.PostRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val api: PostsService,
    private val postMapper: ApiDomainPostMapper
) :
    PostRepository {
    override fun getPosts(): Single<List<Post>> =
        api.getPosts().map {
            postMapper.reverse(it.body() ?: emptyList())
        }
}