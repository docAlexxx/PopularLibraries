package com.example.popularlibraries

import moxy.MvpPresenter

class CounterPresenter(private val repo: UserRepo): MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initList(repo.getUsers())

    }

}