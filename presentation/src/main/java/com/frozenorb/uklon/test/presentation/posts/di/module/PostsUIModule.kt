package com.frozenorb.uklon.test.presentation.posts.di.module;

import androidx.lifecycle.ViewModel
import com.frozenorb.uklon.test.domain.shared.di.scope.PerFragment
import com.frozenorb.uklon.test.presentation.posts.viewmodel.PostsViewModel
import com.frozenorb.uklon.test.presentation.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface PostsUIModule {

    @Binds
    @IntoMap
    @PerFragment
    @ViewModelKey(PostsViewModel::class)
    fun bindPostsViewModel(postsViewModel: PostsViewModel): ViewModel
}
