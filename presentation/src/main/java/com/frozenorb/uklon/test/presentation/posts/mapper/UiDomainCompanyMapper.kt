package com.frozenorb.uklon.test.presentation.posts.mapper

import com.frozenorb.uklon.test.domain.post.entity.Company
import com.frozenorb.uklon.test.presentation.posts.entity.UICompany
import javax.inject.Inject

class UiDomainCompanyMapper @Inject constructor() : Mapper<Company, UICompany>() {
    override fun map(from: Company): UICompany =
        UICompany(
            from.bs,
            from.catchPhrase,
            from.name
        )

    override fun reverse(to: UICompany): Company =
        Company(
            to.bs,
            to.catchPhrase,
            to.name
        )
}