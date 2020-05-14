package com.frozenorb.uklon.test.data.posts.api.mapper

import com.frozenorb.uklon.test.data.posts.entity.ApiPost
import com.frozenorb.uklon.test.domain.post.entity.Post
import com.frozenorb.uklon.test.domain.shared.Mapper
import javax.inject.Inject

class ApiDomainPostMapper @Inject constructor(
    private val userMapper: ApiDomainUserMapper
): Mapper<Post, ApiPost?>() {
    override fun map(from: Post): ApiPost =
        ApiPost(
            from.id,
            userMapper.map(from.user),
            from.user.id,
            from.title,
            from.body
        )

    override fun reverse(to: ApiPost?): Post =
        Post(
            to?.id ?: -1,
            userMapper.reverse(to?.user, to?.userId),
            to?.title ?: "",
            to?.body ?: "",
            emptyList()
        )
}