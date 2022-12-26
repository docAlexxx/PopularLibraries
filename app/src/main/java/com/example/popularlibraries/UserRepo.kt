package com.example.popularlibraries

interface UserRepo {
    fun getUsers(): List<User>
}