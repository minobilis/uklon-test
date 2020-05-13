package com.frozenorb.uklon.test.data.posts.di;

import com.frozenorb.uklon.test.data.posts.repository.CommentsRepositoryImpl
import com.frozenorb.uklon.test.data.posts.repository.UserRepositoryImpl
import com.frozenorb.uklon.test.domain.post.gateway.CommentsRepository
import com.frozenorb.uklon.test.domain.post.gateway.UserRepository
import com.frozenorb.uklon.test.domain.shared.di.scope.PerFragment
import dagger.Binds
import dagger.Module

@Module
interface PostDetailsDataModule {

    @PerFragment
    @Binds
    fun bindCommentsRepository(commentsRepositoryImpl : CommentsRepositoryImpl): CommentsRepository

    @PerFragment
    @Binds
    fun bindUserRepository(userRepositoryImpl : UserRepositoryImpl): UserRepository
}
