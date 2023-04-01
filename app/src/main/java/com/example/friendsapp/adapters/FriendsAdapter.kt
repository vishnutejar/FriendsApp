package com.example.friendsapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.friendsapp.databinding.ItemsFriendsBinding
import com.example.friendsapp.interfaces.IOnItemClickFriendsRecyclerView

class FriendsAdapter(
  var  listener: IOnItemClickFriendsRecyclerView
) : RecyclerView.Adapter<FriendsAdapter.ViewHolder>() {
    private var friendsList = ArrayList<com.example.friendsapp.models.Result>()
    fun setFriendsList(friendsList : List<com.example.friendsapp.models.Result>){
        this.friendsList = friendsList as ArrayList<com.example.friendsapp.models.Result>
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding : ItemsFriendsBinding) : RecyclerView.ViewHolder(binding.root)
    {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemsFriendsBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val friends=friendsList[position]
        holder.binding.txtFullName.text = "${friends.name.title} ${friends.name.first} ${friends.name.last}"
        holder.binding.txtCountryName.text = friends.location.country
        holder.binding.root.setOnClickListener {
            listener.onSelectedFriendsDetails(friends)
        }
    }
    override fun getItemCount(): Int {
        return friendsList.size
    }
}