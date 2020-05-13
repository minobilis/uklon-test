package com.frozenorb.uklon.test.presentation.details.di.module;

import androidx.lifecycle.ViewModel
import com.frozenorb.uklon.test.domain.shared.di.scope.PerFragment
import com.frozenorb.uklon.test.presentation.details.viewmodel.PostDetailsViewModel
import com.frozenorb.uklon.test.presentation.posts.viewmodel.PostsViewModel
import com.frozenorb.uklon.test.presentation.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface PostDetailsUIModule {

    @Binds
    @IntoMap
    @PerFragment
    @ViewModelKey(PostDetailsViewModel::class)
    fun bindPostDetailsViewModel(postDetailsViewModel: PostDetailsViewModel): ViewModel
}
