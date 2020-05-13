package com.frozenorb.uklon.test.presentation.details.mapper

import com.frozenorb.uklon.test.domain.post.entity.Comment
import com.frozenorb.uklon.test.presentation.details.entity.UIComment
import com.frozenorb.uklon.test.domain.shared.Mapper
import javax.inject.Inject

class UiDomainCommentMapper @Inject constructor() : Mapper<Comment, UIComment>() {
    override fun map(from: Comment): UIComment =
        UIComment(
            from.body,
            from.email,
            from.id,
            from.name,
            from.postId
        )

    override fun reverse(to: UIComment): Comment =
        Comment(
            to.body,
            to.email,
            to.id,
            to.name,
            to.postId
        )
}