package com.frozenorb.uklon.test.data.posts.di;

import com.frozenorb.uklon.test.data.posts.repository.PostRepositoryImpl
import com.frozenorb.uklon.test.domain.shared.di.scope.PerFragment
import com.frozenorb.uklon.test.domain.post.gateway.PostRepository
import dagger.Binds
import dagger.Module

@Module
interface PostsDataModule {
    @PerFragment
    @Binds
    fun bindPostsRepository(postRepositoryImpl : PostRepositoryImpl): PostRepository
}
