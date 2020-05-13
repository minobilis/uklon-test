package com.frozenorb.uklon.test.presentation.details.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.frozenorb.uklon.test.presentation.R
import com.frozenorb.uklon.test.presentation.details.entity.UIComment
import javax.inject.Inject


class CommentsAdapter @Inject constructor() : RecyclerView.Adapter<CommentsViewHolder>() {

    private val data = mutableListOf<UIComment>()

    fun updateData(newData: List<UIComment>) {
        val diffResult = DiffUtil.calculateDiff(
            CommentsDiffUtil(
                this.data,
                newData
            )
        )
        diffResult.dispatchUpdatesTo(this)
        this.data.clear()
        this.data.addAll(newData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        return CommentsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.comments_item, parent, false)
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        val comment = data[position]
        holder.bindTo(comment)
    }

    class CommentsDiffUtil internal constructor(
        private var oldList: List<UIComment>,
        private var newList: List<UIComment>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = oldList[oldItemPosition]
            val newItem = newList[newItemPosition]

            return oldItem == newItem
        }
    }
}