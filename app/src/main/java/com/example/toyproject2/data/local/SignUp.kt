package com.example.toyproject2.data.local

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SignUp(
    val email: String,
    val password: String,
): Parcelable
