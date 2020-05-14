package com.frozenorb.uklon.test.data.posts.cache

import com.frozenorb.uklon.test.domain.post.entity.Comment
import com.frozenorb.uklon.test.domain.post.entity.Post
import com.frozenorb.uklon.test.domain.post.entity.User
import io.reactivex.rxjava3.core.Single

interface Cache {

    fun getPosts(): Single<List<Post>>

    fun getComments(postId: Long): Single<List<Comment>>

    fun getUser(userId: Long): Single<User>

    fun addUser(user: User)
}