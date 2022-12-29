package com.example.popularlibraries.core

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.popularlibraries.user.UserFragment
import com.example.popularlibraries.user.UserItemFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object UsersScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return UserFragment.getInstance()
    }
}

object UserItemScreen : FragmentScreen {
    lateinit var bundle: Bundle
    override fun createFragment(factory: FragmentFactory): Fragment {
        return UserItemFragment.getInstance(bundle)
    }
}