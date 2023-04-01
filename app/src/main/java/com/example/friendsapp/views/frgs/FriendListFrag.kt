package com.example.friendsapp.views.frgs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.friendsapp.R
import com.example.friendsapp.adapters.FriendsAdapter
import com.example.friendsapp.databinding.FragFriendListBinding
import com.example.friendsapp.interfaces.IOnItemClickFriendsRecyclerView
import com.example.friendsapp.models.Result
import com.example.friendsapp.viewmodels.FriendsViewModel

class FriendListFrag : Fragment(), IOnItemClickFriendsRecyclerView {
    private lateinit var binding: FragFriendListBinding
    private lateinit var viewModel: FriendsViewModel
    private lateinit var friendsAdapter: FriendsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initSetContentView(inflater, container)
        prepareFriendsList()
        initViewModel()
        return binding.root

    }

    private fun prepareFriendsList() {
        friendsAdapter = FriendsAdapter(this)
        binding.recyListFrds.apply {
            layoutManager = GridLayoutManager(this.context, 2)
            adapter = friendsAdapter
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[FriendsViewModel::class.java]
        viewModel.getFriendsList()
        viewModel.observeFriendsLiveData().observe(requireActivity()) { friendsList ->
            friendsAdapter.setFriendsList(friendsList)
        }
    }

    private fun initSetContentView(inflater: LayoutInflater, container: ViewGroup?) {
        binding = FragFriendListBinding.inflate(inflater, container, false)
    }

    override fun onSelectedFriendsDetails(frdsData: Result) {

        val bundle = Bundle()
        val  fullName="${frdsData.name.title} ${frdsData.name.first} ${frdsData.name.last}"
        val address="${frdsData.location.street.name},${frdsData.location.street.number}," +
                "${frdsData.location.city},${frdsData.location.state},${frdsData.location.postcode},${frdsData.location.country}"
        bundle.putString("fullName",fullName)
        bundle.putString("address",address)
        bundle.putString("email",frdsData.email)
        bundle.putString("phoneNumber",frdsData.phone)
        val frg = FriendsDetailsFrag.newInstance()
        frg.arguments=bundle
        val fragrant = parentFragmentManager.beginTransaction()
        frg.let { fragrant.replace(R.id.container, it) }
        fragrant.addToBackStack(null)
        fragrant.commit()
    }


    companion object {
        @JvmStatic
        fun newInstance() = FriendListFrag()
    }
}