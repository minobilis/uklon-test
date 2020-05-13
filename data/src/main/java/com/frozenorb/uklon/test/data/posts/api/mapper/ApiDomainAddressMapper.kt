package com.frozenorb.uklon.test.data.posts.api.mapper

import com.frozenorb.uklon.test.data.posts.entity.ApiAddress
import com.frozenorb.uklon.test.domain.post.entity.Address
import com.frozenorb.uklon.test.domain.shared.Mapper
import javax.inject.Inject

class ApiDomainAddressMapper @Inject constructor(
    private val geoMapper: ApiDomainGeoMapper
) : Mapper<Address, ApiAddress?>() {
    override fun map(from: Address): ApiAddress =
        ApiAddress(
            from.city,
            geoMapper.map(from.geo),
            from.street,
            from.suite,
            from.zipcode
        )

    override fun reverse(to: ApiAddress?): Address =
        Address(
            to?.city ?: "",
            geoMapper.reverse(to?.geo),
            to?.street ?: "",
            to?.suite ?: "",
            to?.zipcode ?: ""
        )
}