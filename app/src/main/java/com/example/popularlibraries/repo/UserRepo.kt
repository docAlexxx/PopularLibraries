package com.example.popularlibraries.repo

import com.example.popularlibraries.model.User

interface UserRepo {
    fun getUsers(): List<User>
}