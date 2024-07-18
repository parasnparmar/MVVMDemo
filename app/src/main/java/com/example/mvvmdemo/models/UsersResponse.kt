package com.example.mvvmdemo.models

import com.google.gson.annotations.SerializedName

data class UsersResponse(
    @SerializedName("data")
    val users: ArrayList<User>
)
