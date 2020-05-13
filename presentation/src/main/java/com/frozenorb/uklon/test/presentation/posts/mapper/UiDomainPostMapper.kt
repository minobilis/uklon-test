package com.frozenorb.uklon.test.presentation.posts.mapper

import com.frozenorb.uklon.test.domain.post.entity.Post
import com.frozenorb.uklon.test.presentation.posts.entity.UIPost
import javax.inject.Inject

class UiDomainPostMapper @Inject constructor(
    private val userMapper: UiDomainUserMapper
): Mapper<Post, UIPost>() {
    override fun map(from: Post): UIPost =
        UIPost(
            from.id,
            userMapper.map(from.user),
            from.title,
            from.body
        )

    override fun reverse(to: UIPost): Post =
        Post(
            to.id,
            userMapper.reverse(to.user),
            to.title,
            to.body
        )
}