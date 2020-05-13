package com.frozenorb.uklon.test.di.module;

import android.content.Context
import com.frozenorb.uklon.test.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(private val app: App) {

    @Provides
    @Singleton
    fun provideContext(): Context =
        app.applicationContext
}