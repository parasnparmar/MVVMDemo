package com.example.mvvmdemo.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmdemo.models.User
import com.example.mvvmdemo.models.UserPostModel
import com.example.mvvmdemo.repository.UsersRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.truncate

class UsersViewModel(private val usersRepository : UsersRepository): ViewModel(){

    val usersUpdatedAvailableLiveData = MutableLiveData<Boolean>()
    val users = ArrayList<User>()

    var pageNUmber: Int = 0
    fun fetchUsers(){
        CoroutineScope(Dispatchers.IO).launch {
            val users = usersRepository.fetchUsers(++pageNUmber)
            withContext(Dispatchers.Main){
                this@UsersViewModel.users.addAll(users)
                usersUpdatedAvailableLiveData.postValue(true)
            }

        }
    }
    var userPostedLiveData = MutableLiveData<Boolean>()
    fun addUser(userPostModel: UserPostModel){
        CoroutineScope(Dispatchers.IO).launch {
            val responsePostUser = usersRepository.addUser(userPostModel)
            Log.d("ADD USER",responsePostUser.toString())
            withContext(Dispatchers.Main){
                userPostedLiveData.postValue(true)
            }
        }
    }
}