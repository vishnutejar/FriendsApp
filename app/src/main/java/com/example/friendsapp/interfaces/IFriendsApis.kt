package com.example.friendsapp.interfaces;

import com.example.friendsapp.models.Friends
import retrofit2.Call
import retrofit2.http.GET

interface IFriendsApis{
    @GET("api")
     fun getFriends() :Call<Friends>
 }
