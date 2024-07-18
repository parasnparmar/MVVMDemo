package com.example.mvvmdemo.repository

import com.example.mvvmdemo.models.User
import com.example.mvvmdemo.models.UserPostModel
import com.example.mvvmdemo.models.UserPostResponse
import com.example.mvvmdemo.networks.UsersAPIServie

class UsersRepository(private val usersAPIServie: UsersAPIServie) {
    suspend fun fetchUsers(pageNumber: Int): ArrayList<User>{
    return usersAPIServie.fetchUsers(pageNumber).users
    }

    suspend fun addUser(userPostModel: UserPostModel): UserPostResponse{
        return usersAPIServie.addUsers(userPostModel)
    }
}