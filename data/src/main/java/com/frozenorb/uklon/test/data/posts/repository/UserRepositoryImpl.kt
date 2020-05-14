package com.frozenorb.uklon.test.data.posts.repository

import com.frozenorb.uklon.test.data.posts.api.PostsService
import com.frozenorb.uklon.test.data.posts.api.mapper.ApiDomainUserMapper
import com.frozenorb.uklon.test.domain.post.entity.User
import com.frozenorb.uklon.test.domain.post.gateway.UserRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: PostsService,
    private val userMapper: ApiDomainUserMapper
) : UserRepository {

    override fun getUser(userId: Long): Single<User> =
        api.getUser(userId).map {
            userMapper.reverse(it.body())
        }
}