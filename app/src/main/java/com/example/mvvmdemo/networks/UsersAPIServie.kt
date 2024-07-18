package com.example.mvvmdemo.networks

import com.example.mvvmdemo.models.UserPostModel
import com.example.mvvmdemo.models.UserPostResponse
import com.example.mvvmdemo.models.UsersResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UsersAPIServie  {
    @GET("users")
    suspend fun fetchUsers(
        @Query("page")
    pageNumber : Int
    ): UsersResponse

    @POST("users")
    suspend fun addUsers(
        @Body userPostModel: UserPostModel
    ): UserPostResponse

    companion object{
        private var usersApiService : UsersAPIServie? = null
        fun getInstance(): UsersAPIServie{
            if(usersApiService == null){
                val retrofit = Retrofit.Builder().baseUrl("https://reqres.in/api")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                usersApiService = retrofit.create(UsersAPIServie::class.java)
            }
            return usersApiService!!
        }
    }

}