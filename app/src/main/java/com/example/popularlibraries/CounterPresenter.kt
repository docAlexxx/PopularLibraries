package com.example.popularlibraries

import moxy.MvpPresenter

class CounterPresenter(private val model : CounterRepo): MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

    }

    fun onButtonOneClick() {
        viewState.setTextOne(model.nextItem(ITEM_ONE).toString())
    }

    fun onButtonTwoClick() {
        viewState.setTextTwo(model.nextItem(ITEM_TWO).toString())
    }

    fun onButtonThreeClick() {
        viewState.setTextThree(model.nextItem(ITEM_THREE).toString())
    }

}