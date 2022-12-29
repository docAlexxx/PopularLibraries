package com.example.popularlibraries.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.popularlibraries.CourseApp
import com.example.popularlibraries.UserAdapter
import com.example.popularlibraries.core.OnBackPressListener
import com.example.popularlibraries.core.UserItemScreen
import com.example.popularlibraries.databinding.FragmentUserListBinding
import com.example.popularlibraries.model.User
import com.example.popularlibraries.repo.UserRepoImpl
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(), UserView, OnBackPressListener {

    private lateinit var viewBinding: FragmentUserListBinding
    private val adapter = UserAdapter()
    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(UserRepoImpl(), CourseApp.instance.router)
    }

    companion object {
        fun getInstance(): UserFragment {
            return UserFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentUserListBinding.inflate(inflater, container, false).also {
            viewBinding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewBinding) {
            usersRv.layoutManager = LinearLayoutManager(requireContext())
            usersRv.adapter = adapter
        }
    }

    override fun initList(list: List<User>) {
        adapter.users = list
        adapter.setOnItemClickListener(object : UserAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val bundle = Bundle()
                bundle.putString("login", adapter.users[position].login)
                val fragment = UserItemFragment()
                fragment.arguments = bundle
                UserItemScreen.bundle = bundle
                presenter.onItemClick()
            }

        })
    }

    override fun onBackPressed() = presenter.onBackPressed()

}