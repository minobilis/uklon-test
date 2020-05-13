package com.frozenorb.uklon.test.presentation.details.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.frozenorb.uklon.test.presentation.details.entity.UIComment
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.comments_item.*

class CommentsViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bindTo(comment: UIComment) {
        updateCommentInfo(comment)
    }

    private fun updateCommentInfo(comment: UIComment) {
        with(comment){
            comment_name.text = name
            comment_email.text = email
            comment_body.text = body
        }
    }
}