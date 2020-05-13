package com.frozenorb.uklon.test.data.posts.repository

import com.frozenorb.uklon.test.domain.post.entity.Post
import com.frozenorb.uklon.test.domain.post.gateway.PostRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor():
    PostRepository {
    override fun getPosts(): Single<List<Post>> =
        Single.just(
            listOf(
                Post(
                    0,
                    0,
                    "Title 0",
                    "Some body 0"
                ),
                Post(
                    1,
                    1,
                    "Title 1",
                    "Some body 1"
                ),
                Post(
                    2,
                    2,
                    "Title 2",
                    "Some body 2"
                )
            )
        )
}