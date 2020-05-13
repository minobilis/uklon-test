package com.frozenorb.uklon.test.presentation.shared

import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.frozenorb.uklon.test.presentation.details.view.PostDetailsFragment
import com.frozenorb.uklon.test.presentation.posts.view.PostsFragment
import javax.inject.Inject

class Navigator @Inject constructor(private val navigable: Navigable) {

    fun goToPostList() {
        navigable.acquireFragmentManager().commit {
            replace(
                navigable.getFragmentContainerId(),
                PostsFragment.newInstance()
            )
        }
    }

    fun goToPostDetails(postId: Long, userId: Long) {
        navigable.acquireFragmentManager().commit {
            addToBackStack(PostDetailsFragment::class.java.simpleName)
            replace(
                navigable.getFragmentContainerId(),
                PostDetailsFragment.newInstance(postId, userId)
            )
        }
    }

    fun getTopFragment(): Fragment? =
        navigable.acquireFragmentManager().fragments.lastOrNull()
}
