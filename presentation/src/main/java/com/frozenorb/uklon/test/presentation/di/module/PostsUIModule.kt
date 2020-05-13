package com.frozenorb.uklon.test.presentation.di.module;

import androidx.lifecycle.ViewModel
import com.frozenorb.uklon.test.domain.shared.di.scope.PerFragment
import com.frozenorb.uklon.test.presentation.posts.PostsViewModel
import com.frozenorb.uklon.test.presentation.di.PostsViewModelFactory
import com.frozenorb.uklon.test.presentation.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface PostsUIModule {

    @PerFragment
    fun bindViewModelFactory(viewModelFactory: PostsViewModelFactory): PostsViewModelFactory

    @Binds
    @IntoMap
    @PerFragment
    @ViewModelKey(PostsViewModel::class)
    fun bindPostsViewModel(postsViewModel: PostsViewModel): ViewModel
}
