package com.frozenorb.uklon.test.data.posts.repository

import com.frozenorb.uklon.test.data.posts.api.PostsService
import com.frozenorb.uklon.test.data.posts.api.mapper.ApiDomainUserMapper
import com.frozenorb.uklon.test.data.posts.cache.Cache
import com.frozenorb.uklon.test.data.posts.cache.NoSuchUserException
import com.frozenorb.uklon.test.domain.post.entity.User
import com.frozenorb.uklon.test.domain.post.gateway.UserRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: PostsService,
    private val cache: Cache,
    private val userMapper: ApiDomainUserMapper
) : UserRepository {

    override fun getUser(userId: Long): Single<User> {
        return cache.getUser(userId)
            .onErrorResumeNext {
                when (it) {
                    is NoSuchUserException -> {
                        api.getUser(userId)
                            .map { response ->
                                userMapper.reverse(response.body())
                            }
                            .doOnSuccess { user ->
                                cache.addUser(user)
                            }
                    }
                    else -> Single.error(it)
                }
            }
    }
}