package com.frozenorb.uklon.test.presentation.posts.mapper

import com.frozenorb.uklon.test.domain.post.entity.Company
import com.frozenorb.uklon.test.domain.shared.Mapper
import com.frozenorb.uklon.test.presentation.posts.entity.UIComment
import javax.inject.Inject

class UiDomainCompanyMapper @Inject constructor() : Mapper<Company, UIComment>() {
    override fun map(from: Company): UIComment =
        UIComment(
            from.bs,
            from.catchPhrase,
            from.name
        )

    override fun reverse(to: UIComment): Company =
        Company(
            to.bs,
            to.catchPhrase,
            to.name
        )
}