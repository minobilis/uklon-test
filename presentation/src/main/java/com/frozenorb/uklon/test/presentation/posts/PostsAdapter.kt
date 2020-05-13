package com.frozenorb.uklon.test.presentation.posts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.frozenorb.uklon.test.presentation.R
import com.frozenorb.uklon.test.presentation.posts.entity.UIPost
import javax.inject.Inject


class PostsAdapter @Inject constructor() : RecyclerView.Adapter<PostsViewHolder>() {

    var listener: Listener? = null

    private val data = mutableListOf<UIPost>()

    fun updateData(newData: List<UIPost>) {
        val diffResult = DiffUtil.calculateDiff(PostsDiffUtil(this.data, newData))
        diffResult.dispatchUpdatesTo(this)
        this.data.clear()
        this.data.addAll(newData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        return PostsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.posts_item, parent, false)
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val post = data[position]
        holder.bindTo(post, listener)
    }

    interface Listener {
        fun onItemClick(item: UIPost)
    }

    class PostsDiffUtil internal constructor(
        private var oldList: List<UIPost>,
        private var newList: List<UIPost>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldPost = oldList[oldItemPosition]
            val newPost = newList[newItemPosition]

            return oldPost == newPost
        }
    }
}