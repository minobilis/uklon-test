package com.frozenorb.uklon.test.presentation.posts

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.frozenorb.uklon.test.presentation.R
import com.frozenorb.uklon.test.presentation.posts.di.factory.PostsViewModelFactory
import com.frozenorb.uklon.test.presentation.shared.Navigable
import com.frozenorb.uklon.test.presentation.shared.Navigator
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.posts_fragment.*
import java.lang.RuntimeException
import javax.inject.Inject

class PostsFragment : Fragment(R.layout.posts_fragment) {

    private var navigator: Navigator? = null

    private val postsAdapter = PostsAdapter()

    @Inject
    lateinit var postsViewModelFactory: PostsViewModelFactory

    private val postsViewModel by viewModels<PostsViewModel>(factoryProducer = { postsViewModelFactory })

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupUI()
        subscribeToViewStates()
        postsViewModel.loadPosts()
    }

    private fun setupUI() {
        posts_recycler_view.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        posts_recycler_view.adapter = postsAdapter
        postsAdapter.listener = object : PostsAdapter.Listener {
            override fun onItemClick(item: UIPost) {
                navigator?.goToPostDetails(item.id)
            }
        }
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
        if (context is Navigable) { navigator = Navigator(context) }
        else throw RuntimeException("${context.javaClass.name} must implement ${Navigable::class.java.name} interface")
    }

    private fun subscribeToViewStates() {
        postsViewModel.postsViewState.observe(viewLifecycleOwner, Observer {
            when (it) {
                is PostsViewModel.PostsViewState.Loading ->
                    posts_text.text = getString(R.string.loading)

                is PostsViewModel.PostsViewState.Data -> {
                    posts_text.text = ""
                    postsAdapter.updateData(it.posts)
                }

                is PostsViewModel.PostsViewState.Error ->
                    posts_text.text = it.error.message
            }
        })
    }

    companion object {
        fun newInstance(): PostsFragment = PostsFragment()
    }
}