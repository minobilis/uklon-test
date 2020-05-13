package com.frozenorb.uklon.test.presentation.posts

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.posts_item.*

class PostsViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bindTo(post: UIPost, listener: PostsAdapter.Listener?) {
        containerView.setOnClickListener { listener?.onItemClick(post) }
        updateUserInfo(post)
        updatePostInfo(post)
    }

    private fun updatePostInfo(post: UIPost) {
        post_title.text = post.title
    }

    private fun updateUserInfo(post: UIPost) {

    }

    /*private fun updateUserInfo(listener: ServiceSettingsDelegateAdapter.Listener?, pair: Pair<ServiceFilterModel, ServiceModel>) {
        if (pair.second.logo.isNotEmpty()) {
            val base64 = getBase64ImageString(pair.second.logo)
            val decodedString = Base64.decode(base64, Base64.DEFAULT)
            val bitmap = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)

            avatar_av.setIconPadding(0)
            avatar_av.setInitials("")
            avatar_av.setAvatarBackgroundColor(ContextCompat.getColor(avatar_av.context, android.R.color.transparent))

            GlideApp.with(containerView.context)
                    .load(bitmap)
                    .transform(CircleCrop())
                    .into(avatar_av.getImage())
        } else {
            val serviceInitials = pair.second.name.buildAbbreviation(MAXIMUM_INITIALS_NUMBER)
            avatar_av.setInitials(serviceInitials)
            avatar_av.setAvatarBackgroundColor(ContextCompat.getColor(avatar_av.context, R.color.medium_primary))
        }
    }

    private fun updateTitle(listener: ServiceSettingsDelegateAdapter.Listener?, pair: Pair<ServiceFilterModel, ServiceModel>) {
        val service = pair.second
        title_tv.text = service.name
    }

    private fun updateToggleButton(listener: ServiceSettingsDelegateAdapter.Listener?, pair: Pair<ServiceFilterModel, ServiceModel>) {
        service_switch.run {
            setOnCheckedChangeListener { _, isChecked -> listener?.onItemCheckedChange(pair.first, isChecked) }
            if (isChecked != pair.first.isActive) {
                isChecked = pair.first.isActive
            }
        }
    }

    companion object {
        const val MAXIMUM_INITIALS_NUMBER = 2
    }*/
}