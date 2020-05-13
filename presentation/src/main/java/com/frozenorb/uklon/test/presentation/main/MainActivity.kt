package com.frozenorb.uklon.test.presentation.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.frozenorb.uklon.test.presentation.R
import com.frozenorb.uklon.test.presentation.shared.Navigable
import com.frozenorb.uklon.test.presentation.shared.Navigator
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


class MainActivity : AppCompatActivity(R.layout.main_activity), HasAndroidInjector, Navigable {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun getFragmentContainerId(): Int = R.id.fragment_container

    override fun acquireFragmentManager(): FragmentManager = supportFragmentManager

    private var navigator = Navigator(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        if (navigator.getTopFragment() == null) {
            navigator.goToPostList()
        }
    }
}
