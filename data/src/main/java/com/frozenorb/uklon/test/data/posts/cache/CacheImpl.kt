package com.frozenorb.uklon.test.data.posts.cache

import com.frozenorb.uklon.test.domain.post.entity.Comment
import com.frozenorb.uklon.test.domain.post.entity.Post
import com.frozenorb.uklon.test.domain.post.entity.User
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CacheImpl @Inject constructor() : Cache {

    private val posts = mutableListOf<Post>()
    private val users = mutableListOf<User>()
    private val comments = mutableListOf<Comment>()

    override fun getPosts(): Single<List<Post>> {
        return Single.fromCallable {
            posts
        }
    }

    override fun getComments(postId: Long): Single<List<Comment>> {
        return Single.fromCallable {
            comments.filter { it.postId == postId }
        }
    }

    override fun getUser(userId: Long): Single<User> {
        return Single.fromCallable {
            users.firstOrNull { it.id == userId } ?: throw NoSuchUserException(userId)
        }
    }

    override fun addUser(user: User) {
        users.forEachIndexed { index, existing ->
            if (existing.id == user.id) {
                users[index] = user
            }
        }
    }
}