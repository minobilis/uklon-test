package com.frozenorb.uklon.test.domain.base

import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class SingleUseCase<Request, Response>(
    private var executionScheduler: Scheduler,
    private var responseScheduler: Scheduler,
    private var compositeDisposable: CompositeDisposable
) : Disposable {

    abstract fun build(request: Request): Single<Response>

    fun execute(
        request: Request,
        onSuccess: () -> Unit = {},
        onError: () -> Unit = {}
    ) {

        compositeDisposable.add(
            build(request)
                .subscribeOn(executionScheduler)
                .observeOn(responseScheduler)
                .subscribe(
                    { onSuccess() },
                    { onError() }
                )
        )
    }

    override fun dispose() {
        if (!isDisposed) compositeDisposable.dispose()
    }

    override fun isDisposed(): Boolean = compositeDisposable.isDisposed
}