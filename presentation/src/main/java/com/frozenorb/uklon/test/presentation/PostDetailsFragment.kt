package com.frozenorb.uklon.test.presentation

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class PostDetailsFragment : Fragment(R.layout.posts_fragment) {

    /*lateinit var navigator: Navigator

    @Inject
    lateinit var postsAdapter: PostsAdapter

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
        posts_recycler_view.adapter = postsAdapter
        postsAdapter.listener = object : PostsAdapter.Listener {
            override fun onItemClick(item: UIPost) {

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
                is PostsViewModel.PostsViewState.Loading -> posts_text.text = getString(R.string.loading)
                is PostsViewModel.PostsViewState.Data -> postsAdapter.updateData(it.posts)
                is PostsViewModel.PostsViewState.Error -> posts_text.text = it.error.message
            }
        })
    }*/

    companion object {
        fun newInstance(postId: Long): PostDetailsFragment =
            PostDetailsFragment().apply {
                arguments = bundleOf(POST_ID_KEY to postId)
            }

        private const val POST_ID_KEY = "post_id"
    }
}