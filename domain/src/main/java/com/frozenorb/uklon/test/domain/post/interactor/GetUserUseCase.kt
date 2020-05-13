package com.frozenorb.uklon.test.domain.post.interactor

import com.frozenorb.uklon.test.domain.base.SingleUseCase
import com.frozenorb.uklon.test.domain.post.entity.User
import com.frozenorb.uklon.test.domain.post.gateway.UserRepository
import com.frozenorb.uklon.test.domain.shared.di.qualifier.IO
import com.frozenorb.uklon.test.domain.shared.di.qualifier.UI
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    @IO executionScheduler: Scheduler,
    @UI responseScheduler: Scheduler,
    compositeDisposable: CompositeDisposable,
    private val userRepository: UserRepository
) : SingleUseCase<Long, User>(executionScheduler, responseScheduler, compositeDisposable) {

    override fun build(request: Long): Single<User> =
        userRepository.getUser(request)
}