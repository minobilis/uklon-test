package com.frozenorb.uklon.test.data.posts.api.mapper

import com.frozenorb.uklon.test.data.posts.entity.ApiUser
import com.frozenorb.uklon.test.domain.post.entity.User
import com.frozenorb.uklon.test.domain.shared.Mapper
import javax.inject.Inject

class ApiDomainUserMapper @Inject constructor(
    private val addressMapper: ApiDomainAddressMapper,
    private val companyMapper: ApiDomainCompanyMapper
) : Mapper<User, ApiUser?>() {
    override fun map(from: User): ApiUser =
        ApiUser(
            addressMapper.map(from.address),
            companyMapper.map(from.company),
            from.email,
            from.id,
            from.name,
            from.phone,
            from.username,
            from.website
        )

    override fun reverse(to: ApiUser?): User =
        User(
            addressMapper.reverse(to?.address),
            companyMapper.reverse(to?.company),
            to?.email ?: "",
            to?.id ?: -1,
            to?.name ?: "",
            to?.phone ?: "",
            to?.username ?: "",
            to?.website ?: ""
        )
}