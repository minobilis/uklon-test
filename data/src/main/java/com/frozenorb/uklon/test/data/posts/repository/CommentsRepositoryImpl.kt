package com.frozenorb.uklon.test.data.posts.repository

import com.frozenorb.uklon.test.data.posts.api.PostsService
import com.frozenorb.uklon.test.data.posts.api.mapper.ApiDomainCommentMapper
import com.frozenorb.uklon.test.data.posts.cache.Cache
import com.frozenorb.uklon.test.data.posts.cache.NoCommentsException
import com.frozenorb.uklon.test.domain.post.entity.Comment
import com.frozenorb.uklon.test.domain.post.gateway.CommentsRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CommentsRepositoryImpl @Inject constructor(
    private val api: PostsService,
    private val cache: Cache,
    private val commentMapper: ApiDomainCommentMapper
) : CommentsRepository {

    override fun getComments(postId: Long): Single<List<Comment>> {
        return cache.getComments(postId)
            .onErrorResumeNext {
                when (it) {
                    is NoCommentsException -> {
                        api.getComments(postId)
                            .map { response ->
                                commentMapper.reverse(response.body() ?: emptyList())
                            }
                            .doOnSuccess { comments ->
                                cache.addComments(comments)
                            }
                    }
                    else -> Single.error(it)
                }
            }
    }
}