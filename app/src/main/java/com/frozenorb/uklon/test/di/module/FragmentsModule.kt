package com.frozenorb.uklon.test.di.module;

import com.frozenorb.uklon.test.data.posts.di.PostDetailsDataModule
import com.frozenorb.uklon.test.data.posts.di.PostsDataModule
import com.frozenorb.uklon.test.domain.shared.di.scope.PerFragment
import com.frozenorb.uklon.test.presentation.details.di.module.PostDetailsUIModule
import com.frozenorb.uklon.test.presentation.details.view.PostDetailsFragment
import com.frozenorb.uklon.test.presentation.posts.di.module.PostsUIModule
import com.frozenorb.uklon.test.presentation.posts.view.PostsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentsModule {

    @PerFragment
    @ContributesAndroidInjector(modules = [PostsUIModule::class, PostsDataModule::class])
    abstract fun contributePostsFragmentInjector(): PostsFragment

    @PerFragment
    @ContributesAndroidInjector(modules = [PostDetailsUIModule::class, PostDetailsDataModule::class])
    abstract fun contributePostDetailsFragmentInjector(): PostDetailsFragment
}