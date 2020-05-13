package com.frozenorb.uklon.test.presentation.posts.mapper

import com.frozenorb.uklon.test.domain.post.entity.Geo
import com.frozenorb.uklon.test.domain.shared.Mapper
import com.frozenorb.uklon.test.presentation.posts.entity.UIGeo
import javax.inject.Inject

class UiDomainGeoMapper @Inject constructor() : Mapper<Geo, UIGeo>() {
    override fun map(from: Geo): UIGeo =
        UIGeo(
            from.lat,
            from.lng
        )

    override fun reverse(to: UIGeo): Geo =
        Geo(
            to.lat,
            to.lng
        )
}