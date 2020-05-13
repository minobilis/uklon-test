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
        onSuccess: (it: Response) -> Unit = {},
        onError: (it: Throwable) -> Unit = {}
    ) {

        compositeDisposable.add(
            build(request)
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