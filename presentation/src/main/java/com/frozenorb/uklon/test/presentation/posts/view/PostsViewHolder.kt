package com.frozenorb.uklon.test.presentation.posts.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.frozenorb.uklon.test.presentation.posts.entity.UIPost
import com.frozenorb.uklon.test.presentation.posts.entity.UIUser
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.posts_item.*

class PostsViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bindTo(post: UIPost, listener: PostsAdapter.Listener?) {
        containerView.setOnClickListener { listener?.onItemClick(post) }
        updateUserInfo(post.user)
        updatePostInfo(post)
    }

    private fun updatePostInfo(post: UIPost) {
        with(post){
            post_title.text = title
            post_body.text = body
        }
    }

    private fun updateUserInfo(user: UIUser) {
        username.text = user.username
    }
}