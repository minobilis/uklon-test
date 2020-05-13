package com.frozenorb.uklon.test.data.posts.repository

import com.frozenorb.uklon.test.domain.post.entity.Address
import com.frozenorb.uklon.test.domain.post.entity.Company
import com.frozenorb.uklon.test.domain.post.entity.Geo
import com.frozenorb.uklon.test.domain.post.entity.User
import com.frozenorb.uklon.test.domain.post.gateway.UserRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor() : UserRepository {

    override fun getUser(userId: Long): Single<User> =
        Single.just(
            User(
                Address(
                    "City 0",
                    Geo(
                        "lat0",
                        "lan0"
                    ),
                    "Street0",
                    "Suite0",
                    "zip0"
                ),
                Company(
                    "bs0",
                    "catch0",
                    "Company name0"
                ),
                "email0",
                0,
                "Name0",
                "phone0",
                "username0",
                "website0"
            )
        )
}