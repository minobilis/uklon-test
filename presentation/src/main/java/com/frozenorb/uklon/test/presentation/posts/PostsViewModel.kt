package com.frozenorb.uklon.test.presentation.posts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.frozenorb.uklon.test.domain.post.interactor.GetPostsUseCase
import com.frozenorb.uklon.test.domain.post.entity.Post
import javax.inject.Inject

class PostsViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase,
    private val postMapper: UiDomainPostMapper
) : ViewModel() {

    sealed class PostsViewState {
        class Data(val posts: List<UIPost>) : PostsViewState()
        object Loading : PostsViewState()
        class Error(val error: Throwable) : PostsViewState()
    }

    private val _postsViewState = MutableLiveData<PostsViewState>()
    val postsViewState = _postsViewState

    fun loadPosts() {
        _postsViewState.postValue(PostsViewState.Loading)
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

    override fun onCleared() {
        super.onCleared()
        getPostsUseCase.dispose()
    }
}