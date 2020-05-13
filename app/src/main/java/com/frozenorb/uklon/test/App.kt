package com.frozenorb.uklon.test

import android.app.Application
import com.frozenorb.uklon.test.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector : DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.create()
            .inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}