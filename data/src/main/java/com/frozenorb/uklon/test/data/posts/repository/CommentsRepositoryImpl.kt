package com.frozenorb.uklon.test.data.posts.repository

import com.frozenorb.uklon.test.data.posts.api.PostsService
import com.frozenorb.uklon.test.data.posts.api.mapper.ApiDomainCommentMapper
import com.frozenorb.uklon.test.domain.post.entity.Comment
import com.frozenorb.uklon.test.domain.post.gateway.CommentsRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CommentsRepositoryImpl @Inject constructor(
    private val api: PostsService,
    private val commentMapper: ApiDomainCommentMapper
) : CommentsRepository {

    override fun getComments(postId: Long): Single<List<Comment>> =
        api.getComments(postId).map {
            commentMapper.reverse(it.body() ?: emptyList())
        }
}