package com.example.friendsapp

import com.example.friendsapp.interfaces.IFriendsApis
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api : IFriendsApis by lazy {
        Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IFriendsApis::class.java)
    }
}