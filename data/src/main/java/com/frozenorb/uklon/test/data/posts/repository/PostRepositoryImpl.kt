package com.frozenorb.uklon.test.data.posts.repository

import com.frozenorb.uklon.test.domain.post.entity.*
import com.frozenorb.uklon.test.domain.post.gateway.PostRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor():
    PostRepository {
    override fun getPosts(): Single<List<Post>> =
        Single.just(
            listOf(
                Post(
                    0,
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
                            "name0"
                        ),
                        "email0",
                        0,
                        "Name0",
                        "phone0",
                        "username0",
                        "website0"
                    ),
                    "Title 0",
                    "Some body 0",
                    emptyList()
                ),
                Post(
                    1,
                    User(
                        Address(
                            "City 1",
                            Geo(
                                "lat1",
                                "lan1"
                            ),
                            "Street1",
                            "Suite1",
                            "zip1"
                        ),
                        Company(
                            "bs1",
                            "catch1",
                            "name1"
                        ),
                        "email1",
                        1,
                        "Name1",
                        "phone1",
                        "username1",
                        "website1"
                    ),
                    "Title 1",
                    "Some body 1",
                    emptyList()
                ),
                Post(
                    2,
                    User(
                        Address(
                            "City 2",
                            Geo(
                                "lat2",
                                "lan2"
                            ),
                            "Street2",
                            "Suite2",
                            "zip2"
                        ),
                        Company(
                            "bs2",
                            "catch2",
                            "name2"
                        ),
                        "email2",
                        2,
                        "Name2",
                        "phone2",
                        "username2",
                        "website2"
                    ),
                    "Title 2",
                    "Some body 2",
                    emptyList()
                )
            )
        )
}