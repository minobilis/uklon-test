package com.frozenorb.uklon.test.presentation.details.view

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.frozenorb.uklon.test.presentation.R
import com.frozenorb.uklon.test.presentation.details.di.factory.PostDetailsViewModelFactory
import com.frozenorb.uklon.test.presentation.details.viewmodel.PostDetailsViewModel
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.post_details_fragment.*
import javax.inject.Inject

class PostDetailsFragment : Fragment(R.layout.post_details_fragment) {

    private val commentsAdapter = CommentsAdapter()

    @Inject
    lateinit var postDetailsViewModelFactory: PostDetailsViewModelFactory

    private val postDetailsViewModel by viewModels<PostDetailsViewModel>(factoryProducer = { postDetailsViewModelFactory })

    private val postId: Long by lazy { arguments?.get(POST_ID_KEY) as Long }
    private val userId: Long by lazy { arguments?.get(USER_ID_KEY) as Long }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupUI()
        subscribeToViewStates()
        postDetailsViewModel.loadComments(postId)
        postDetailsViewModel.loadUser(userId)
    }

    private fun setupUI() {
        swipe_refresh.setOnRefreshListener { postDetailsViewModel.refreshComments(postId) }
        comments_recycler_view.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = commentsAdapter
        }
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    private fun subscribeToViewStates() {
        postDetailsViewModel.commentsViewState.observe(viewLifecycleOwner, Observer {
            when (it) {
                is PostDetailsViewModel.CommentsViewState.Loading -> {
                    swipe_refresh.isRefreshing = true
                    commentsAdapter.updateData(it.comments)
                }

                is PostDetailsViewModel.CommentsViewState.Data -> {
                    swipe_refresh.isRefreshing = false
                    commentsAdapter.updateData(it.comments)
                }

                is PostDetailsViewModel.CommentsViewState.Error -> {
                    swipe_refresh.isRefreshing = false
                    Toast.makeText(context, it.error.message, Toast.LENGTH_LONG).show()
                }
            }
        })

        postDetailsViewModel.userViewState.observe(viewLifecycleOwner, Observer { it ->
            when (it) {
                is PostDetailsViewModel.UserViewState.Loading -> {
                    it.user?.let {
                        user_name.text = it.name
                        user_email.text = it.email
                        user_company_name.text = it.company.name
                    }
                }

                is PostDetailsViewModel.UserViewState.Data -> {
                    user_name.text = it.user.name
                    user_email.text = it.user.email
                    user_company_name.text = it.user.company.name
                }

                is PostDetailsViewModel.UserViewState.Error -> {
                    Toast.makeText(context, it.error.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    companion object {
        fun newInstance(postId: Long, userId: Long): PostDetailsFragment =
            PostDetailsFragment().apply {
                arguments = bundleOf(
                    POST_ID_KEY to postId,
                    USER_ID_KEY to userId
                )
            }
        private const val POST_ID_KEY = "post_id"
        private const val USER_ID_KEY = "user_id"
    }
}