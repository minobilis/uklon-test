package com.frozenorb.uklon.test.presentation.shared

import androidx.fragment.app.FragmentManager

interface Navigable {

    fun getFragmentContainerId(): Int

    fun acquireFragmentManager(): FragmentManager
}
