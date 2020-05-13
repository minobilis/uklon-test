package com.frozenorb.uklon.test.presentation.posts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.frozenorb.uklon.test.domain.post.interactor.GetPostsUseCase
import com.frozenorb.uklon.test.domain.post.entity.Post
import com.frozenorb.uklon.test.presentation.posts.entity.UIPost
import com.frozenorb.uklon.test.presentation.posts.mapper.UiDomainPostMapper
import javax.inject.Inject

class PostsViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase,
    private val postMapper: UiDomainPostMapper
) : ViewModel() {

    sealed class PostsViewState {
        data class Data(val posts: List<UIPost>) : PostsViewState()
        data class Loading(val posts: List<UIPost> = emptyList()) : PostsViewState()
        data class Error(val error: Throwable) : PostsViewState()
    }

    private val _postsViewState = MutableLiveData<PostsViewState>()
    val postsViewState = _postsViewState

    fun loadPosts() {
        _postsViewState.postValue(
            PostsViewState.Loading(
                getViewStateData()
            )
        )
        getPostsUseCase.execute(
            onSuccess = { _postsViewState.postValue(it.toDataViewState()) },
            onError = { _postsViewState.postValue(it.toErrorViewState()) }
        )
    }

    private fun List<Post>.toDataViewState() =
        PostsViewState.Data(
            postMapper.map(this)
        )

    private fun Throwable.toErrorViewState() =
        PostsViewState.Error(
            this
        )

    private fun getViewStateData() =
        (_postsViewState.value as? PostsViewState.Data)?.posts ?: emptyList()

    override fun onCleared() {
        super.onCleared()
        getPostsUseCase.dispose()
    }

    fun refreshPosts() {
        getPostsUseCase.dispose()
        loadPosts()
    }
}