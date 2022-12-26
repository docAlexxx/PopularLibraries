package com.example.popularlibraries

class CounterPresenter(private val view: MainView) {

    val model = CounterModel()

    fun onButtonOneClick() {
        view.setTextOne(model.nextItem(ITEM_ONE).toString())
    }

    fun onButtonTwoClick() {
        view.setTextTwo(model.nextItem(ITEM_TWO).toString())
    }

    fun onButtonThreeClick() {
        view.setTextThree(model.nextItem(ITEM_THREE).toString())
    }

}