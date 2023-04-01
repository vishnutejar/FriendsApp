package com.example.friendsapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.friendsapp.R
import com.example.friendsapp.adapters.FriendsAdapter
import com.example.friendsapp.databinding.ActivityMainBinding
import com.example.friendsapp.interfaces.IOnItemClickFriendsRecyclerView
import com.example.friendsapp.models.Result
import com.example.friendsapp.viewmodels.FriendsViewModel
import com.example.friendsapp.views.frgs.FriendListFrag
import com.example.friendsapp.views.frgs.FriendsDetailsFrag

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    lateinit var viewModel:FriendsViewModel
    lateinit var friendsAdapter: FriendsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val frg=FriendListFrag.newInstance()
        val frgtra= supportFragmentManager.beginTransaction()
        frgtra.add(R.id.container,frg)
        frgtra.commit()
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        onCreate(savedInstanceState);

    }
}