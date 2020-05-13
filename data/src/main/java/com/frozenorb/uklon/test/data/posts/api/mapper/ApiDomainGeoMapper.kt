package com.frozenorb.uklon.test.data.posts.api.mapper

import com.frozenorb.uklon.test.data.posts.entity.ApiGeo
import com.frozenorb.uklon.test.domain.post.entity.Geo
import com.frozenorb.uklon.test.domain.shared.Mapper
import javax.inject.Inject

class ApiDomainGeoMapper @Inject constructor() : Mapper<Geo, ApiGeo?>() {
    override fun map(from: Geo): ApiGeo =
        ApiGeo(
            from.lat,
            from.lng
        )

    override fun reverse(to: ApiGeo?): Geo =
        Geo(
            to?.lat ?: "",
            to?.lng ?: ""
        )
}