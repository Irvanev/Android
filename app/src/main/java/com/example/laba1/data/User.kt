package com.example.laba1.data

import java.io.Serializable

data class User(
    val name: String,
    val email: String,
    val password: String
) : Serializable
