package com.frozenorb.uklon.test.data.posts.repository

import com.frozenorb.uklon.test.domain.post.entity.*
import com.frozenorb.uklon.test.domain.post.gateway.CommentsRepository
import com.frozenorb.uklon.test.domain.post.gateway.PostRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CommentsRepositoryImpl @Inject constructor() : CommentsRepository {

    override fun getComments(postId: Long): Single<List<Comment>> =
        Single.just(
            listOf(
                Comment(
                    "body0",
                    "email0",
                    0,
                    "name0",
                    postId
                ),
                Comment(
                    "body1",
                    "email1",
                    1,
                    "name1",
                    postId
                ),
                Comment(
                    "body2",
                    "email2",
                    2,
                    "name2",
                    postId
                ),
                Comment(
                    "body3",
                    "email3",
                    3,
                    "name3",
                    postId
                )
            )
        )
}