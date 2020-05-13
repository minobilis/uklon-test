package com.frozenorb.uklon.test.data.posts.entity

class ApiUser(
    var address: ApiAddress? = null,
    var company: ApiCompany? = null,
    var email: String? = null,
    var id: Long? = null,
    var name: String? = null,
    var phone: String? = null,
    var username: String? = null,
    var website: String? = null
)