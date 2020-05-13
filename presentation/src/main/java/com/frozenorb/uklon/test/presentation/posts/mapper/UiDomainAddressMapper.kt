package com.frozenorb.uklon.test.presentation.posts.mapper

import com.frozenorb.uklon.test.domain.post.entity.Address
import com.frozenorb.uklon.test.presentation.posts.entity.UIAddress
import javax.inject.Inject

class UiDomainAddressMapper @Inject constructor(
    private val geoMapper: UiDomainGeoMapper
) : Mapper<Address, UIAddress>() {
    override fun map(from: Address): UIAddress =
        UIAddress(
            from.city,
            geoMapper.map(from.geo),
            from.street,
            from.suite,
            from.zipcode
        )

    override fun reverse(to: UIAddress): Address =
        Address(
            to.city,
            geoMapper.reverse(to.geo),
            to.street,
            to.suite,
            to.zipcode
        )
}