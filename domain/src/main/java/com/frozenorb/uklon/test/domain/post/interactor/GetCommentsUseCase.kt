package com.frozenorb.uklon.test.domain.post.interactor

import com.frozenorb.uklon.test.domain.base.SingleUseCase
import com.frozenorb.uklon.test.domain.post.entity.Comment
import com.frozenorb.uklon.test.domain.post.gateway.CommentsRepository
import com.frozenorb.uklon.test.domain.shared.di.qualifier.IO
import com.frozenorb.uklon.test.domain.shared.di.qualifier.UI
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class GetCommentsUseCase @Inject constructor(
    @IO executionScheduler: Scheduler,
    @UI responseScheduler: Scheduler,
    compositeDisposable: CompositeDisposable,
    private val commentsRepository: CommentsRepository
) : SingleUseCase<Long, List<Comment>>(executionScheduler, responseScheduler, compositeDisposable) {

    override fun build(request: Long): Single<List<Comment>> =
        commentsRepository.getComments(request)
}