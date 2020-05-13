package com.frozenorb.uklon.test.data.posts.api.mapper

import com.frozenorb.uklon.test.data.posts.entity.ApiCompany
import com.frozenorb.uklon.test.domain.post.entity.Company
import com.frozenorb.uklon.test.domain.shared.Mapper
import javax.inject.Inject

class ApiDomainCompanyMapper @Inject constructor() : Mapper<Company, ApiCompany?>() {
    override fun map(from: Company): ApiCompany =
        ApiCompany(
            from.bs,
            from.catchPhrase,
            from.name
        )

    override fun reverse(to: ApiCompany?): Company =
        Company(
            to?.bs ?: "",
            to?.catchPhrase ?: "",
            to?.name ?: ""
        )
}