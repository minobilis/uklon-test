package com.frozenorb.uklon.test.presentation.posts.mapper

import com.frozenorb.uklon.test.domain.post.entity.User
import com.frozenorb.uklon.test.presentation.posts.entity.UIUser
import javax.inject.Inject

class UiDomainUserMapper @Inject constructor(
    private val addressMapper: UiDomainAddressMapper,
    private val companyMapper: UiDomainCompanyMapper
) : Mapper<User, UIUser>() {
    override fun map(from: User): UIUser =
        UIUser(
            addressMapper.map(from.address),
            companyMapper.map(from.company),
            from.email,
            from.id,
            from.name,
            from.phone,
            from.username,
            from.website
        )

    override fun reverse(to: UIUser): User =
        User(
            addressMapper.reverse(to.address),
            companyMapper.reverse(to.company),
            to.email,
            to.id,
            to.name,
            to.phone,
            to.username,
            to.website
        )
}