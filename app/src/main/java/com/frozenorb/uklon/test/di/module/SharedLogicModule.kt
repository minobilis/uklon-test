package com.frozenorb.uklon.test.di.module;

import com.frozenorb.uklon.test.domain.shared.di.qualifier.IO
import com.frozenorb.uklon.test.domain.shared.di.qualifier.UI
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Singleton

@Module
class SharedLogicModule {

        @Singleton
        @Provides
        @IO
        fun provideIOScheduler(): Scheduler = Schedulers.io()

        @Singleton
        @Provides
        @UI
        fun provideUIScheduler(): Scheduler = AndroidSchedulers.mainThread()

        @Provides
        fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()
}
