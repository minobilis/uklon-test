package com.frozenorb.uklon.test.domain.base

import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class EmptyRequestSingleUseCase<Response>(
    private var executionScheduler: Scheduler,
    private var responseScheduler: Scheduler,
    private var compositeDisposable: CompositeDisposable
) : Disposable {

    abstract fun build(): Single<Response>

    fun execute(
        onSuccess: (it: Response) -> Unit = {},
        onError: (it: Throwable) -> Unit = {}
    ) {

        compositeDisposable.add(
            build()
                .subscribeOn(executionScheduler)
                .observeOn(responseScheduler)
                .subscribe(
                    { onSuccess(it) },
                    { onError(it) }
                )
        )
    }

    override fun dispose() {
        if (!isDisposed) compositeDisposable.clear()
    }

    override fun isDisposed(): Boolean = compositeDisposable.isDisposed
}