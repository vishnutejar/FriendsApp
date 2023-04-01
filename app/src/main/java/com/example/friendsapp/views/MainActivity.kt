package com.example.friendsapp.views

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.friendsapp.R
import com.example.friendsapp.views.frgs.FriendListFrag

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val frg=FriendListFrag.newInstance()
        val fragrant= supportFragmentManager.beginTransaction()
        fragrant.add(R.id.container,frg)
        fragrant.commit()
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        onCreate(savedInstanceState)

    }
}