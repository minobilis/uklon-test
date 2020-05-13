package com.frozenorb.uklon.test.di.module;

import com.frozenorb.uklon.test.presentation.activity.MainActivity
import com.frozenorb.uklon.test.domain.shared.di.scope.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivitiesModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [FragmentsModule::class])
    abstract fun contributeMainActivityInjector(): MainActivity
}