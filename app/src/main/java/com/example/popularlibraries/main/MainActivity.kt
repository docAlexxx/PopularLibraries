package com.example.popularlibraries.main

import android.os.Bundle
import com.example.popularlibraries.CourseApp
import com.example.popularlibraries.R
import com.example.popularlibraries.core.OnBackPressListener
import com.example.popularlibraries.databinding.ActivityMainBinding
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    private val navigator = AppNavigator(this, R.id.containerMain)
    private lateinit var binding: ActivityMainBinding
    private val presenter by moxyPresenter { MainPresenter(CourseApp.instance.router) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        CourseApp.instance.navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        CourseApp.instance.navigationHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach { currentFragment ->
            if (currentFragment is OnBackPressListener && currentFragment.onBackPressed()) {
                return
            }
        }
        presenter.onBackPressed()
    }

}