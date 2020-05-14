package com.frozenorb.uklon.test.di.component

import com.frozenorb.uklon.test.App
import com.frozenorb.uklon.test.data.posts.di.ApiModule
import com.frozenorb.uklon.test.data.posts.di.CacheModule
import com.frozenorb.uklon.test.di.module.ActivitiesModule
import com.frozenorb.uklon.test.di.module.AppModule
import com.frozenorb.uklon.test.di.module.SharedLogicModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    ApiModule::class,
    CacheModule::class,
    ActivitiesModule::class,
    SharedLogicModule::class]
)
interface AppComponent : AndroidInjector<DaggerApplication> {
    fun inject(app: App)
}