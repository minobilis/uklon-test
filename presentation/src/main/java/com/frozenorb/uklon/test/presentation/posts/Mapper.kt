package com.frozenorb.uklon.test.presentation.posts

abstract class Mapper<From, To> {

    abstract fun map(from: From): To

    abstract fun reverse(to: To): From

    open fun map(from: List<From>): List<To> = from.map { map(it) }

    open fun reverse(to: List<To>): List<From> = to.map { reverse(it) }
}