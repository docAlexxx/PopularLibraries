package com.example.popularlibraries.user

import com.example.popularlibraries.core.UsersScreen
import com.example.popularlibraries.main.MainView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserItemPresenter(
    private val router: Router
) : MvpPresenter<MainView>() {

    fun onBackPressed(): Boolean {
        router.backTo(UsersScreen)
        return true
    }
}