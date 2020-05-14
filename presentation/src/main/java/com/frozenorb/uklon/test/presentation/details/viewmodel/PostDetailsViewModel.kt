package com.frozenorb.uklon.test.presentation.details.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.frozenorb.uklon.test.domain.post.entity.Comment
import com.frozenorb.uklon.test.domain.post.entity.User
import com.frozenorb.uklon.test.domain.post.interactor.GetCommentsUseCase
import com.frozenorb.uklon.test.domain.post.interactor.GetUserUseCase
import com.frozenorb.uklon.test.presentation.details.entity.UIComment
import com.frozenorb.uklon.test.presentation.details.mapper.UiDomainCommentMapper
import com.frozenorb.uklon.test.presentation.posts.entity.UIUser
import com.frozenorb.uklon.test.presentation.posts.mapper.UiDomainUserMapper
import javax.inject.Inject

class PostDetailsViewModel @Inject constructor(
    private val getCommentsUseCase: GetCommentsUseCase,
    private val getUserUseCase: GetUserUseCase,
    private val commentMapper: UiDomainCommentMapper,
    private val userMapper: UiDomainUserMapper
) : ViewModel() {

    sealed class CommentsViewState {
        data class Data(val comments: List<UIComment>) : CommentsViewState()
        data class Loading(val comments: List<UIComment> = emptyList()) : CommentsViewState()
        data class Error(val error: Throwable) : CommentsViewState()
    }

    sealed class UserViewState {
        data class Data(val user: UIUser) : UserViewState()
        data class Loading(val user: UIUser?) : UserViewState()
        data class Error(val error: Throwable) : UserViewState()
    }

    private val _commentsViewState = MutableLiveData<CommentsViewState>()
    val commentsViewState = _commentsViewState

    private val _userViewState = MutableLiveData<UserViewState>()
    val userViewState = _userViewState

    fun loadComments(postId: Long) {
        _commentsViewState.postValue(
            CommentsViewState.Loading(
                getCommentsViewStateData()
            )
        )
        getCommentsUseCase.execute(
            request = postId,
            onSuccess = { _commentsViewState.postValue(it.toCommentsDataViewState(postId)) },
            onError = { _commentsViewState.postValue(it.toCommentsErrorViewState()) }
        )
    }

    fun refreshComments(postId: Long) {
        getCommentsUseCase.dispose()
        loadComments(postId)
    }

    fun loadUser(userId: Long) {
        _userViewState.postValue(
            UserViewState.Loading(
                getUserViewStateData()
            )
        )
        getUserUseCase.execute(
            request = userId,
            onSuccess = { _userViewState.postValue(it.toUserDataViewState()) },
            onError = { _userViewState.postValue(it.toUserErrorViewState()) }
        )
    }

    fun refreshUser(userId: Long) {
        getUserUseCase.dispose()
        loadUser(userId)
    }

    private fun List<Comment>.toCommentsDataViewState(postId: Long) =
        CommentsViewState.Data(
            commentMapper.map(this)
        )

    private fun Throwable.toCommentsErrorViewState() =
        CommentsViewState.Error(
            this
        )

    private fun User.toUserDataViewState() =
        UserViewState.Data(
            userMapper.map(this)
        )

    private fun Throwable.toUserErrorViewState() =
        UserViewState.Error(
            this
        )

    private fun getCommentsViewStateData() =
        (_commentsViewState.value as? CommentsViewState.Data)?.comments ?: emptyList()

    private fun getUserViewStateData() =
        (_userViewState.value as? UserViewState.Data)?.user

    override fun onCleared() {
        super.onCleared()
        getCommentsUseCase.dispose()
    }
}