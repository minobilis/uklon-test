package com.frozenorb.uklon.test.domain.post.entity

class Post(
    val id: Long,
    val user: User,
    val title: String,
    val body: String,
    val comments: List<Comment>
)