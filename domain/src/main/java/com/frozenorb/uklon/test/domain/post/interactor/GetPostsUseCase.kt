package com.frozenorb.uklon.test.domain.post.interactor

import com.frozenorb.uklon.test.domain.base.EmptyRequestSingleUseCase
import com.frozenorb.uklon.test.domain.shared.di.qualifier.IO
import com.frozenorb.uklon.test.domain.shared.di.qualifier.UI
import com.frozenorb.uklon.test.domain.post.entity.Post
import com.frozenorb.uklon.test.domain.post.gateway.PostRepository
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    @IO executionScheduler: Scheduler,
    @UI responseScheduler: Scheduler,
    compositeDisposable: CompositeDisposable,
    private val postRepository: PostRepository
) : EmptyRequestSingleUseCase<List<Post>>(executionScheduler, responseScheduler, compositeDisposable) {

    override fun build(): Single<List<Post>> =
        postRepository.getPosts()
}