package com.frozenorb.uklon.test.domain.post.gateway

import com.frozenorb.uklon.test.domain.post.entity.Comment
import io.reactivex.rxjava3.core.Single

interface CommentsRepository {
    fun getComments(postId: Long): Single<List<Comment>>
}