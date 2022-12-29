package com.example.popularlibraries.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User (
    val login: String
): Parcelable