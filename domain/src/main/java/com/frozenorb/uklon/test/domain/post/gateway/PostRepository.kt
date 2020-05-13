package com.frozenorb.uklon.test.domain.post.gateway

import com.frozenorb.uklon.test.domain.post.entity.Post
import io.reactivex.rxjava3.core.Single

interface PostRepository {
    fun getPosts(): Single<List<Post>>
}