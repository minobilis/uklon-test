package com.frozenorb.uklon.test.presentation.posts

import com.frozenorb.uklon.test.domain.post.entity.Post
import javax.inject.Inject

class UiDomainPostMapper @Inject constructor(): Mapper<Post, UIPost>() {
    override fun map(from: Post): UIPost =
        UIPost(
            from.id,
            from.userId,
            from.title,
            from.body
        )

    override fun reverse(to: UIPost): Post =
        Post(
            to.id,
            to.userId,
            to.title,
            to.body
        )
}