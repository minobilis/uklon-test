package com.frozenorb.uklon.test.presentation.posts

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.frozenorb.uklon.test.presentation.R
import com.frozenorb.uklon.test.presentation.di.PostsViewModelFactory
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.posts_fragment.*
import javax.inject.Inject

class PostsFragment : Fragment(R.layout.posts_fragment) {

    @Inject
    lateinit var postsViewModelFactory: PostsViewModelFactory

    private val postsViewModel by viewModels<PostsViewModel>(factoryProducer = { postsViewModelFactory })

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        subscribeToViewStates()
        postsViewModel.loadPosts()
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection .inject(this)
        super.onAttach(context)
    }

    private fun subscribeToViewStates() {
        postsViewModel.postsViewState.observe(viewLifecycleOwner, Observer {
            posts_text.text = when (it) {
                is PostsViewModel.PostsViewState.Loading -> "Loading"
                is PostsViewModel.PostsViewState.Data -> it.posts.size.toString()
                is PostsViewModel.PostsViewState.Error -> it.error.message
            }
        })
    }
}