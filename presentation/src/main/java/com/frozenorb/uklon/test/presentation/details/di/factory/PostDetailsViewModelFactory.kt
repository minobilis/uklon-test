package com.frozenorb.uklon.test.presentation.details.di.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.frozenorb.uklon.test.domain.shared.di.scope.PerFragment
import javax.inject.Inject
import javax.inject.Provider

@PerFragment
class PostDetailsViewModelFactory @Inject constructor(private val viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = viewModels[modelClass]?.get() as T
}
