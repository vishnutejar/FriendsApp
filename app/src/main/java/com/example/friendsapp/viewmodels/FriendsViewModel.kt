package com.example.friendsapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.friendsapp.RetrofitInstance
import com.example.friendsapp.models.Friends
import com.example.friendsapp.models.Result
import retrofit2.Call
import retrofit2.Response

class FriendsViewModel : ViewModel() {
    private var listOfFriends = MutableLiveData<List<Result>>()
    var selectedFriendsDetails = MutableLiveData<Result>()
    fun getFriendsList() {
        RetrofitInstance.api.getFriends().enqueue(object : retrofit2.Callback<Friends> {
            override fun onResponse(call: Call<Friends>, response: Response<Friends>) {
                listOfFriends.value = response.body()!!.results

            }

            override fun onFailure(call: Call<Friends>, t: Throwable) {

            }
        })
    }

    fun observeFriendsLiveData(): LiveData<List<Result>> {
        return listOfFriends
    }

    fun observeSelectedFriendDetailsLiveData(): LiveData<Result> {

        return selectedFriendsDetails
    }

}