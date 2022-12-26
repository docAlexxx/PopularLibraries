package com.example.popularlibraries.repo

import com.example.popularlibraries.model.User
import com.example.popularlibraries.repo.UserRepo

class UserRepoImpl: UserRepo {

    private val repositories = listOf(
        User("First User"),
        User("Second User"),
        User("Third User"),
        User("Fourth User"),
        User("Fifth User")
    )

    override fun getUsers(): List<User> {
        return repositories
    }

}