package com.example.friendsapp.models

data class Result(
    val gender: String,
    val name: Name,
    val location: Location,
    val email: String,
    val phone:String
)

data class Location(
    val country: String,
    val street: Street,
    val city: String,
    val state: String,
    val postcode: String
)

data class Street(val number: String, val name: String)
data class Name(val title: String, val first: String, val last: String)
