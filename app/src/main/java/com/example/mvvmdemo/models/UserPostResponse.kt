package com.example.mvvmdemo.models

import android.content.Intent

data class UserPostResponse(
    var name: String,
    var job: String,
    var id: Int,
    var createdAt: String
)
