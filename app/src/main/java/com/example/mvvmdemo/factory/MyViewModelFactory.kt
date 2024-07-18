package com.example.mvvmdemo.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmdemo.repository.UsersRepository
import com.example.mvvmdemo.viewmodels.UsersViewModel

class MyViewModelFactory(private val usersRepository: UsersRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UsersViewModel(usersRepository) as T
    }

}