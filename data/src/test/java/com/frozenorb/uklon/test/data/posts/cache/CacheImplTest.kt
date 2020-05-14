package com.frozenorb.uklon.test.data.posts.cache

import com.frozenorb.uklon.test.domain.post.entity.*
import io.reactivex.rxjava3.observers.TestObserver
import org.junit.Before
import org.junit.Test

class CacheImplTest {

    lateinit var cache: Cache

    private val posts = mutableListOf<Post>()

    private fun createPost(id: Long): Post {
        return Post(
            id,
            User(
                Address(
                    "City $id",
                    Geo(
                        "lat $id",
                        "lan $id"
                    ),
                    "Street $id",
                    "Suite $id",
                    "zip $id"
                ),
                Company(
                    "bs $id",
                    "catch $id",
                    "Company name $id"
                ),
                "email $id",
                id,
                "Name $id",
                "phone $id",
                "username $id",
                "website $id"
            ),
            "Title $id",
            "Some body $id",
            emptyList()
        )
    }

    @Before
    fun setUp() {
        cache = CacheImpl()
        for (i in 0L..4L) posts.add(createPost(i))
        cache.addPosts(posts)
    }

    @Test
    fun getPosts() {
        val testObserver = TestObserver<List<Post>>()

        cache.getPosts()
            .subscribe(testObserver)

        testObserver.assertNoErrors()
        testObserver.assertValue { posts -> posts.size == 5 }
        testObserver.assertValue { posts -> posts[3].id == 3L }
        testObserver.assertValue { posts -> posts[3].user.company.name == "Company name 3" }
    }
}