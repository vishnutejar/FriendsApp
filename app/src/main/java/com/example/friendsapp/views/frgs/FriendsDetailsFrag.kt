package com.example.friendsapp.views.frgs

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.friendsapp.databinding.FragFriendListBinding
import com.example.friendsapp.databinding.FragFriendsDetailsBinding
import com.example.friendsapp.viewmodels.FriendsViewModel

class FriendsDetailsFrag : Fragment() {
    private lateinit var binding: FragFriendsDetailsBinding
    lateinit var viewModel: FriendsViewModel
    var email: String? = null
    var fullName: String? = null
    var address: String? = null
    var phoneNumber: String? = null

    companion object {
        fun newInstance() = FriendsDetailsFrag()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getBundleArgValues()
        initSetContentView(inflater, container)
        initViewModel()
        initViewValues()
        return binding.root
    }

    private fun initViewValues() {
        binding.txtValueFullName.text = fullName
        binding.txtValueAddress.text = address
        binding.txtValueEmail.text = email
        binding.txtValuePhone.text = phoneNumber
        binding.txtValueEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL, email)
            intent.putExtra(Intent.EXTRA_SUBJECT, "Hello My Friend its me, ${fullName}")
            intent.putExtra(Intent.EXTRA_TEXT, "We are waiting from long time at following address ${address}")
            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent, "Select email"))
        }
    }

    private fun getBundleArgValues() {
        email = arguments?.getString("email")
        address = arguments?.getString("address")
        fullName = arguments?.getString("fullName")
        phoneNumber = arguments?.getString("phoneNumber")
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(requireActivity())[FriendsViewModel::class.java]
        viewModel.observeSelectedFriendDetailsLiveData().observe(viewLifecycleOwner) {
            Toast.makeText(context, it.email, Toast.LENGTH_SHORT).show()
        }
    }

    private fun initSetContentView(inflater: LayoutInflater, container: ViewGroup?) {
        binding = FragFriendsDetailsBinding.inflate(inflater, container, false)
    }
}

