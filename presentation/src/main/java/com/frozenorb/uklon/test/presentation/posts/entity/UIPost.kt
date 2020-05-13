package com.frozenorb.uklon.test.presentation.posts.entity

import com.frozenorb.uklon.test.presentation.details.entity.UIComment

class UIPost(
    val id: Long,
    val user: UIUser,
    val title: String,
    val body: String,
    val comments: List<UIComment>
)