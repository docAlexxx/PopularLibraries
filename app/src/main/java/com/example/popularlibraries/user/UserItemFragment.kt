package com.example.popularlibraries.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.popularlibraries.CourseApp
import com.example.popularlibraries.core.OnBackPressListener
import com.example.popularlibraries.databinding.FragmentUserBinding
import com.example.popularlibraries.main.MainView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserItemFragment : MvpAppCompatFragment(), MainView, OnBackPressListener {

    private lateinit var viewBinding: FragmentUserBinding
    private val presenter: UserItemPresenter by moxyPresenter {
        UserItemPresenter(CourseApp.instance.router)
    }

    companion object {
        fun getInstance(bundle: Bundle): UserItemFragment {
            return UserItemFragment().also { it.arguments = bundle }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentUserBinding.inflate(inflater, container, false).also {
            viewBinding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = this.arguments
        val login = args?.get("login")
        with(viewBinding) {
            userTv.text = login.toString()
        }
    }

    override fun onBackPressed() = presenter.onBackPressed()

}