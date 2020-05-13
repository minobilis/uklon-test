package com.frozenorb.uklon.test.di.module;

import com.frozenorb.uklon.test.data.posts.di.PostsDataModule
import com.frozenorb.uklon.test.presentation.posts.PostsFragment
import com.frozenorb.uklon.test.domain.shared.di.scope.PerFragment
import com.frozenorb.uklon.test.presentation.di.module.PostsUIModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentsModule {

    @PerFragment
    @ContributesAndroidInjector(modules = [PostsUIModule::class, PostsDataModule::class])
    abstract fun contributePostsFragmentInjector(): PostsFragment
}