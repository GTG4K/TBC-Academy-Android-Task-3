package com.example.tbcacademyandroidtask3.data

import java.io.Serializable

data class User(
    val email: String?,
    val username: String?,
    val firstName: String?,
    val lastName: String?,
    val age: Int
) : Serializable


