package com.frozenorb.uklon.test.data.posts.di;

import com.frozenorb.uklon.test.data.posts.cache.Cache
import com.frozenorb.uklon.test.data.posts.cache.CacheImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface CacheModule {

    @Singleton
    @Binds
    fun bindCache (cache : CacheImpl): Cache
}
