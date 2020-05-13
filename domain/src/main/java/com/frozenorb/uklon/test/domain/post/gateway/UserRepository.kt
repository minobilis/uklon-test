package com.frozenorb.uklon.test.domain.post.gateway

import com.frozenorb.uklon.test.domain.post.entity.User
import io.reactivex.rxjava3.core.Single

interface UserRepository {
    fun getUser(userId: Long): Single<User>
}