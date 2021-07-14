package com.picpay.desafio.android

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.picpay.desafio.android.entity.User

class UserListAdapter : ListAdapter<User, UserListIViewHolder>(DiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListIViewHolder {
        return UserListIViewHolder.inflate(parent)
    }

    override fun onBindViewHolder(holder: UserListIViewHolder, position: Int) {
        holder.bind(
            currentList[position]
        )
    }

    override fun getItemCount(): Int = currentList.size

    companion object DiffUtilCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: User, newItem: User) = oldItem == newItem
    }
}