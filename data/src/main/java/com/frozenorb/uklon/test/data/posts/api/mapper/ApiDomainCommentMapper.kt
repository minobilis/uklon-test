package com.frozenorb.uklon.test.data.posts.api.mapper

import com.frozenorb.uklon.test.data.posts.entity.ApiComment
import com.frozenorb.uklon.test.domain.post.entity.Comment
import com.frozenorb.uklon.test.domain.shared.Mapper
import javax.inject.Inject

class ApiDomainCommentMapper @Inject constructor() : Mapper<Comment, ApiComment?>() {
    override fun map(from: Comment): ApiComment =
        ApiComment(
            from.body,
            from.email,
            from.id,
            from.name,
            from.postId
        )

    override fun reverse(to: ApiComment?): Comment =
        Comment(
            to?.body ?: "",
            to?.email ?: "",
            to?.id ?: -1,
            to?.name ?: "",
            to?.postId ?: -1
        )
}