package com.frozenorb.uklon.test.data.posts.cache

class NoSuchUserException(userId: Long) : RuntimeException("No such user: id = $userId")